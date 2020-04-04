package io.mycat.builder;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mycat.builder.bean.AppModule;
import io.mycat.builder.bean.DynaListData;
import io.mycat.builder.bean.ErrorInfo;
import io.mycat.builder.generator.MyMenuItem;
import io.mycat.builder.generator.defautJavaWeb.MyAppGerneratorForJavaWeb;
import io.mycat.builder.generator.defautJavaWeb.views.DefaultCRUDPageView;
import io.mycat.builder.generator.view.DynaListRowView;
import io.mycat.builder.generator.view.MenuPageView;

public class MyAppGerneratorForJavaWebTest {
    Logger log = LoggerFactory.getLogger(MycatBuilerAppTest.class);

    @Test
    public void testCreateMenuView() throws Exception {
        MyAppGerneratorForJavaWeb app = new MyAppGerneratorForJavaWeb();
        // 添加默认公共模块
        AppModule comModule = new AppModule("common", "公共模块");
        AppModule shopModule = new AppModule("shop", "店铺模块");
        AppModule marketModule = new AppModule("market", "营销模块");
        app.addMoudle(comModule);
        app.addMoudle(shopModule);
        // 动态查询列表
        DynaListData shopLstData = new DynaListData();
        shopLstData.setName("ShopList");
        // shopLstData.setQueryfields(queryfields);
        // shopLstData.setSelectfields(selectfields);
        // shopLstData.setOrderbyFileds(orderbyFileds);

        app.addListData(shopLstData);

        DynaListData marketLstData = new DynaListData();
        marketLstData.setName("MarketList");
        // marketLstData.setQueryfields(queryfields);
        // marketLstData.setSelectfields(selectfields);
        // marketLstData.setOrderbyFileds(orderbyFileds);
        app.addListData(marketLstData);
        // 主菜单
        MenuPageView menuPageView = (MenuPageView) app
                .createNewView(app.findMenuPageViewTypes().iterator().next().getViewClass());
        app.setMainPage(menuPageView);

        menuPageView.setModule(comModule);
        menuPageView.setName("mainpage");
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setIcon("mdi-home-account");
        menuItem.setTitle("店铺管理");

        DynaListRowView shoppingPageView = (DynaListRowView) app.createNewView(DefaultCRUDPageView.class);
        shoppingPageView.setModule(shopModule);
        shoppingPageView.setName("shoplist");
        shoppingPageView.setListData(shopLstData);
        menuItem.setRouteView(shoppingPageView);
        menuPageView.addMenuItem(menuItem);

        menuItem = new MyMenuItem();
        menuItem.setIcon("mdi-account-plus");
        menuItem.setTitle("营销业绩");
        DynaListRowView marketListView = (DynaListRowView) app.createNewView(DefaultCRUDPageView.class);
        marketListView.setModule(marketModule);
        marketListView.setName("marketlist");
        marketListView.setListData(marketLstData);
        menuItem.setRouteView(marketListView);
        menuPageView.addMenuItem(menuItem);

        List<ErrorInfo> erros = app.checkDesign();
        erros.forEach(e -> {
            log.warn("find error msg {}", e.toString());
        });
        assertEquals(0, erros.size());
        app.generateApp();
    }

}
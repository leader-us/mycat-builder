package io.mycat.builder.generator.view;

import java.util.LinkedList;
import java.util.List;

import io.mycat.builder.bean.ErrorInfo;
import io.mycat.builder.generator.MyMenuItem;
import io.mycat.builder.generator.MyView;

/**
 * 菜单页面视图，程序主界面入口也是它
 * 
 * @author Leader us
 */
public abstract class MenuPageView extends MyView {
    // 主界面
    private List<MyMenuItem> menus = new LinkedList<>();

    public List<MyMenuItem> getMenus() {
        return menus;
    }

    public MenuPageView addMenuItem(MyMenuItem menu) {
        menus.add(menu);
        return this;
    }

    public void setMenus(List<MyMenuItem> menus) {
        this.menus = menus;
    }

    public List<ErrorInfo> checkDesign() {

        List<ErrorInfo> errs = super.checkDesign();
        menus.forEach(m -> {
            if (m.getRouteView() == null) {
                errs.add(new ErrorInfo(102, true, " MenuView " + getNameOrClsName() + " missing route view  "));
            }
        });
        return errs;
    }
}
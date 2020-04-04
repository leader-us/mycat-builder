package io.mycat.builder.generator.defautJavaWeb.views;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.mycat.builder.bean.MyParamSpec;
import io.mycat.builder.generator.Mytemplate;
import io.mycat.builder.generator.ViewMetaInfo;
import io.mycat.builder.generator.view.CRUDListPageView;

/**
 * 列表查询界面的对象表示
 * 
 * @author Leader us
 */
public class DefaultCRUDPageView extends CRUDListPageView {
    private String rowTitleExpress;
    private String rowDetailExpress;

    public static final ViewMetaInfo metaInfo;

    static {
        String templatePath = getTemplateRootPath(DefaultCRUDPageView.class) + "DefaultCRUDList.flt";
        List<String> demoPicFilePaths = new LinkedList<>();
        List<Mytemplate> templates = new LinkedList<>();
        templates.add(new Mytemplate("list", templatePath, "/web/src/components", ".vue"));

        Map<String, MyParamSpec> viewParams = new LinkedHashMap<>();
        metaInfo = new ViewMetaInfo(DefaultCRUDPageView.class, "默认列表视图", "自适应的翻页列表（非表格）视图", demoPicFilePaths, templates,
                viewParams);
    }

    public String getRowTitleExpress() {
        return rowTitleExpress;
    }

    public void setRowTitleExpress(String rowTitleExpress) {
        this.rowTitleExpress = rowTitleExpress;
    }

    public String getRowDetailExpress() {
        return rowDetailExpress;
    }

    public void setRowDetailExpress(String rowDetailExpress) {
        this.rowDetailExpress = rowDetailExpress;
    }

    @Override
    protected boolean needGenCode(Mytemplate curTemp) {
        // TODO Auto-generated method stub
        return true;
    }

}
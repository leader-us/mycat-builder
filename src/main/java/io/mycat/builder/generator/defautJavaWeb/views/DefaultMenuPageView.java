package io.mycat.builder.generator.defautJavaWeb.views;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.mycat.builder.bean.MyParamSpec;
import io.mycat.builder.generator.Mytemplate;
import io.mycat.builder.generator.ViewMetaInfo;
import io.mycat.builder.generator.view.MenuPageView;

/**
 * 主页面界面
 * 
 * @author Leader us
 */
public class DefaultMenuPageView extends MenuPageView {
    public static final ViewMetaInfo metaInfo;
    static {
        String templatePath = getTemplateRootPath(DefaultMenuPageView.class) + "DefaultMenu.ftl";
        List<String> demoPicFilePaths = new LinkedList<>();
        List<Mytemplate> templates = new LinkedList<>();
        templates.add(new Mytemplate("menu", templatePath, "/web/src/components", ".vue"));
        Map<String, MyParamSpec> viewParams = new LinkedHashMap<>();
        metaInfo = new ViewMetaInfo(DefaultMenuPageView.class, "默认菜单视图", "列表布局的菜单", demoPicFilePaths, templates,
                viewParams);
    }

    @Override
    protected boolean needGenCode(Mytemplate curTemp) {
        return true;
    }

}
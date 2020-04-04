package io.mycat.builder.generator;

import java.util.List;
import java.util.Map;

import io.mycat.builder.bean.MyParamSpec;

/**
 * 用户视图对象的元数据信息
 * 
 * @author Leader us
 */
public class ViewMetaInfo {
    private final Class<? extends MyView> viewClass;
    // 视图名称
    private final String name;

    private final String describe;
    // 示例图片的路径，用于给用户展示效果
    private final List<String> demoPicFilePaths;
    // view包括的模板文件
    private final List<Mytemplate> templates;
    // 用户应该输入的参数列表，建议开发者设置默认值
    private final Map<String, MyParamSpec> viewParams;

    public ViewMetaInfo(Class<? extends MyView> viewClass, String name, String describe, List<String> demoPicFilePaths,
            List<Mytemplate> templates, Map<String, MyParamSpec> viewParams) {
        this.viewClass = viewClass;
        this.name = name;
        this.describe = describe;
        this.demoPicFilePaths = demoPicFilePaths;
        this.templates = templates;
        this.viewParams = viewParams;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public List<String> getDemoPicFilePaths() {
        return demoPicFilePaths;
    }

    public List<Mytemplate> getTemplates() {
        return templates;
    }

    public Map<String, MyParamSpec> getViewParams() {
        return viewParams;
    }

    public Class<? extends MyView> getViewClass() {
        return viewClass;
    }

}

package io.mycat.builder.generator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.mycat.builder.bean.AppModule;
import io.mycat.builder.bean.ErrorInfo;

/**
 * 可导航的页面视图
 * 
 * @author Leader us
 */
public abstract class MyView {
    private static Logger log = LoggerFactory.getLogger(MyView.class);
    // View的名字，用于代码生成的目标文件名字一部分
    private String name;
    // 所属模块
    private AppModule module;
    private ViewMetaInfo viewMetaInfo;
    private Map<String, String> userParams;
    private MyAppGernerator app;

    public static String getTemplateRootPath(Class<?> cls) {
        String path = cls.getPackageName();
        return path.replace(".", "/") + "/templates/";
    }

    /**
     * 返回对应的ＵＲＬ地址，子类可以修改实现
     * 
     * @return
     */
    public String getLink() {

        return "/" + this.module.getName() + "/" + this.name;
    }

    protected Map<String, Object> prepareTemplateParams() {
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("app", app);
        templateParams.put("view", this);
        return templateParams;
    }

    /**
     * 生成源码(如果不满足需求，子类可覆盖方法，根据条件定制化渲染某些模板)
     */
    public void generateCode() {
        for (Mytemplate curTemp : this.viewMetaInfo.getTemplates()) {
            if (needGenCode(curTemp)) {
                log.info("create code for view {}", this.getNameOrClsName());
                try {
                    log.info("template path  {}", curTemp.getTemplateFile());
                    String content = IOUtils.toString(Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream(curTemp.getTemplateFile()), "UTF-8");
                    String javacontent = generateTemplate(content, prepareTemplateParams());
                    String codeFilePath = app.getSourceHomePath()
                            + StringUtils.replaceChars(curTemp.getTargetDir(), "/", File.separator) + File.separator
                            + getCodeFilePathFor(curTemp);
                    log.info("target file  {}", codeFilePath);

                    File file = new File(codeFilePath);
                    File parentDir = file.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    FileUtils.writeStringToFile(file, javacontent, false);
                } catch (Exception e) {

                    log.error("gencode error {}", e);
                }
            }
        }
    }

    public String getNameOrClsName() {
        return StringUtils.isEmpty(name) ? this.getClass().getCanonicalName() : name;
    }

    protected abstract boolean needGenCode(Mytemplate curTemp);

    protected String getCodeFilePathFor(Mytemplate curTemp) {

        return this.module.getName() + File.separator + name + curTemp.getTargetSufix() + curTemp.getTargetFileSufix();

    }

    protected String generateTemplate(String content, Map<String, Object> map) throws IOException, TemplateException {

        String id = UUID.randomUUID().toString();
        ((StringTemplateLoader) MyAppGernerator.freemarkerCfg.getTemplateLoader()).putTemplate(id, content);
        Template template = MyAppGernerator.freemarkerCfg.getTemplate(id);
        StringWriter writer = new StringWriter();
        template.process(map, writer);
        return writer.toString();
    }

    public ViewMetaInfo getViewMetaInfo() {
        return viewMetaInfo;
    }

    public void setViewMetaInfo(ViewMetaInfo viewMetaInfo) {
        this.viewMetaInfo = viewMetaInfo;
    }

    public Map<String, String> getUserParams() {
        return userParams;
    }

    public void setUserParams(Map<String, String> userParams) {
        this.userParams = userParams;
    }

    public MyAppGernerator getApp() {
        return app;
    }

    public void setApp(MyAppGernerator app) {
        this.app = app;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppModule getModule() {
        return module;
    }

    public void setModule(AppModule module) {
        this.module = module;
    }

    /**
     * 检查View的设计数据是否完备
     * 
     * @return
     */
    public List<ErrorInfo> checkDesign() {
        List<ErrorInfo> errs = new LinkedList<>();
        if (StringUtils.isEmpty(this.name)) {
            errs.add(new ErrorInfo(100, true, " View " + getNameOrClsName() + " 's name is empty '"));
        }
        if (this.module == null) {
            errs.add(new ErrorInfo(100, true, " View " + getNameOrClsName() + " 's no related module '"));
        }
        this.getViewMetaInfo().getViewParams().values().forEach(p -> {
            if (!p.isNullable()) {
                if (this.userParams.containsKey(p.getParamName())) {
                    errs.add(new ErrorInfo(101, true,
                            " View " + getNameOrClsName() + " missing requried param " + p.getParamName()));
                }
            }
        });
        return errs;
    }

}
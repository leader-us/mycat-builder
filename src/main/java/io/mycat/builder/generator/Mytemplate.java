package io.mycat.builder.generator;

/**
 * 渲染模板对象，根据参数完成源码生成过程
 * 
 * @author Leader us
 */
public class Mytemplate {
    // 模板文件名
    private String templateFile;
    // 目标文件根目录
    private String targetDir;
    // 目标文件后缀，如 xxxDao,xxxService，其中Dao,Service就是后缀
    private String targetSufix;
    // 生成的目标文件后缀名，如java ,js ,html ,vue
    private String targetFileSufix;

    public Mytemplate(String targetSufix, String templateFile, String targetDir, String targetFileSufix) {
        this.targetSufix = targetSufix;
        this.templateFile = templateFile;
        this.targetDir = targetDir;
        this.targetFileSufix = targetFileSufix;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    public String getTargetSufix() {
        return targetSufix;
    }

    public void setTargetSufix(String targetSufix) {
        this.targetSufix = targetSufix;
    }

    public String getTargetFileSufix() {
        return targetFileSufix;
    }

    public void setTargetFileSufix(String targetFileSufix) {
        this.targetFileSufix = targetFileSufix;
    }

}

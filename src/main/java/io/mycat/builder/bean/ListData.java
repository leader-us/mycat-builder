package io.mycat.builder.bean;

/**
 * 列表数据，可以是静态数据，也可以是从后端获取的列表数据（可能量大翻页）
 * 
 * @author leader us
 */
public abstract class ListData {

    protected String name;
    protected String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
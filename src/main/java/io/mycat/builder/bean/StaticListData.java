package io.mycat.builder.bean;

/**
 * 列表数据，静态的列表数据
 * 
 * @author leader us
 */
public class StaticListData extends ListData {

    // 完整的JSON数据，Build界面上录入
    private String jsonData;

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

}
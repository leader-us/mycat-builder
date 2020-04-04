package io.mycat.builder.generator.view;

import java.util.List;

import io.mycat.builder.bean.TableEntity;
import io.mycat.builder.generator.MyView;

/**
 * 表单录入界面的对象表示
 * 
 * @author Leader us
 */
public abstract class InputFormView extends MyView {

    private String saveDataURL;
    private String tableName;
    private List<TableEntity> inputFields;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TableEntity> getInputFields() {
        return inputFields;
    }

    public void setInputFields(List<TableEntity> inputFields) {
        this.inputFields = inputFields;
    }

    public String getSaveDataURL() {
        return saveDataURL;
    }

    public void setSaveDataURL(String saveDataURL) {
        this.saveDataURL = saveDataURL;
    }

}
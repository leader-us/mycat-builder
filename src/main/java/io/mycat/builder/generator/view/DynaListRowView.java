package io.mycat.builder.generator.view;

import java.util.List;

import io.mycat.builder.bean.ColumnEntity;
import io.mycat.builder.bean.DynaListData;
import io.mycat.builder.generator.MyView;

/**
 * 列表查询界面的对象表示
 * 
 * @author Leader us
 */
public abstract class DynaListRowView extends MyView {
    // 对应的列表数据
    private DynaListData listData;


    private  List<ColumnEntity> displayFields;

   

    public List<ColumnEntity> getDisplayFields() {
        return displayFields;
    }

    public void setDisplayFields(List<ColumnEntity> displayFields) {
        this.displayFields = displayFields;
    }

    public DynaListData getListData() {
        return listData;
    }

    public void setListData(DynaListData listData) {
        this.listData = listData;
    }
    

}
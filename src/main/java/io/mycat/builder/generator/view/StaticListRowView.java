package io.mycat.builder.generator.view;

import io.mycat.builder.bean.StaticListData;
import io.mycat.builder.generator.MyView;

/**
 * 静态列表展示界面的对象表示
 * 
 * @author Leader us
 */
public abstract class StaticListRowView extends MyView {
    // 对应的列表数据
    private StaticListData listData;

    public StaticListData getListData() {
        return listData;
    }

    public void setListData(StaticListData listData) {
        this.listData = listData;
    }

}
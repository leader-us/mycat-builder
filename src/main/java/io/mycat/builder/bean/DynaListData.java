package io.mycat.builder.bean;

import java.util.List;

/**
 * 动态列表数据，表示从数据库获取的列表数据，可能量大翻页
 * 
 * @author leader us
 */
public class DynaListData extends ListData {

    private List<ColumnEntity> queryfields;
    private List<ColumnEntity> selectfields;
    private List<OrderBy> orderbyFileds;
    private String havingClause;
    private String staticCondition;
    private boolean pageable=true;

    public List<ColumnEntity> getQueryfields() {
        return queryfields;
    }

    public void setQueryfields(List<ColumnEntity> queryfields) {
        this.queryfields = queryfields;
    }

    public boolean isPageable() {
        return pageable;
    }

    public void setPageable(boolean pageable) {
        this.pageable = pageable;
    }

    public List<OrderBy> getOrderbyFileds() {
        return orderbyFileds;
    }

    public void setOrderbyFileds(List<OrderBy> orderbyFileds) {
        this.orderbyFileds = orderbyFileds;
    }

    public String getHavingClause() {
        return havingClause;
    }

    public void setHavingClause(String havingClause) {
        this.havingClause = havingClause;
    }

    public String getStaticCondition() {
        return staticCondition;
    }

    public void setStaticCondition(String staticCondition) {
        this.staticCondition = staticCondition;
    }

    public List<ColumnEntity> getSelectfields() {
        return selectfields;
    }

    public void setSelectfields(List<ColumnEntity> selectfields) {
        this.selectfields = selectfields;
    }

}
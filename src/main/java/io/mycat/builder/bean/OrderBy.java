package io.mycat.builder.bean;

/**
 * 排序字段信息
 * 
 * @author leader
 */
public class OrderBy {

	private ColumnEntity col;
	private boolean ascending;

	public OrderBy(ColumnEntity col, boolean ascending) {
		this.col = col;
		this.ascending = ascending;
	}

	public ColumnEntity getCol() {
		return col;
	}

	public void setCol(ColumnEntity col) {
		this.col = col;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

}
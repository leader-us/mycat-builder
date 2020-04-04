package io.mycat.builder.bean;

import java.util.List;

/**
 * 索引对象
 * 
 * @author leader
 */
public class DBIndex {
	//索引字段
	private List<String> indexColumns;
	private String name;

	public List<String> getIndexColumns() {
		return indexColumns;
	}

	public void setIndexColumns(List<String> indexColumns) {
		this.indexColumns = indexColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
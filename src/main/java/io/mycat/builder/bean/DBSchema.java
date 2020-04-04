package io.mycat.builder.bean;

import java.util.List;

/**
 * 数据库对象
 * 
 * @author leader
 */
public class DBSchema {
	public static final int Dialet_MySQL = 0;
	public static final int Dialet_HSQLDBL = 1;

	private int dialetType = Dialet_MySQL;
	private List<TableEntity> tables;

	public int getDialetType() {
		return dialetType;
	}

	public void setDialetType(int dialetType) {
		this.dialetType = dialetType;
	}

	public List<TableEntity> getTables() {
		return tables;
	}

	public void setTables(List<TableEntity> tables) {
		this.tables = tables;
	}

}
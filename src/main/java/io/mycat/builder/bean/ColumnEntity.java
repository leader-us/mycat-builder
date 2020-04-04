package io.mycat.builder.bean;

/**
 * 列的属性
 *
 */
public class ColumnEntity {
	public static final int DISPLAY_Text = 0;
	public static final int DISPLAY_Label = 1;
	public static final int DISPLAY_TextArea = 2;
	public static final int DISPLAY_List = 3;
	public static final int DISPLAY_Image = 4;
	// 表名
	private String tableName;
	// 列名
	private String columnName;
	private String title;
	// 列名类型
	private String dataType;
	// 列的长度
	private Integer dataLength;
	// 是否允许为空
	private boolean nullable;
	// 列名备注
	private String comments;

	// 是否可编辑修改
	private boolean editable = true;

	private int displayType = DISPLAY_Text;

	// 属性名称(第一个字母大写)，如：user_name => UserName
	private String attrName;
	// 属性名称(第一个字母小写)，如：user_name => userName
	private String attrname;
	// 属性类型
	private String attrType;

	private String extra;
	private ERRelation er;

	private ColomnCheckRule checkRule;

	public ColumnEntity(String tableName, String columnName, String dataType, Integer dataLength, boolean nullable,
			String comments) {
		this.tableName = tableName;
		this.columnName = columnName;
		this.dataType = dataType;
		this.dataLength = dataLength;
		this.nullable = nullable;
		this.comments = comments;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAttrname() {
		return attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Integer getDataLength() {
		return dataLength;
	}

	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public ERRelation getEr() {
		return er;
	}

	public void setEr(ERRelation er) {
		this.er = er;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public int getDisplayType() {
		return displayType;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	public ColomnCheckRule getCheckRule() {
		return checkRule;
	}

	public void setCheckRule(ColomnCheckRule checkRule) {
		this.checkRule = checkRule;
	}

}

package io.mycat.builder.bean;

/**
 * 程序中的模块分类，每个模块拥有一些数据库表，相关视图都属于此模块
 * 
 * @author leader
 */
public class AppModule {

	private String name;
	private String describe;
	public AppModule(String name, String describe) {
		this.name = name;
		this.describe = describe;
	}
	
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
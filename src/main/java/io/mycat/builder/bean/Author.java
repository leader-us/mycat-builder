package io.mycat.builder.bean;

/**
 * MyAppStyle提供者的作者信息
 * 
 * @author leader
 */
public class Author {

	private String name;
	private String gitHome;
	private String email;
	private String describe;

	public Author(String name, String gitHome, String email, String describe) {
		this.name = name;
		this.gitHome = gitHome;
		this.email = email;
		this.describe = describe;
	}

	public String getGitHome() {
		return gitHome;
	}

	public void setGitHome(String gitHome) {
		this.gitHome = gitHome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
package io.mycat.builder.generator;

/**
 * 菜单项目
 * 
 * @author leader
 */
public class MyMenuItem {
	private String title;
	private String icon;
	private MyView routeView;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public MyView getRouteView() {
		return routeView;
	}

	public void setRouteView(MyView routeView) {
		this.routeView = routeView;
	}

}
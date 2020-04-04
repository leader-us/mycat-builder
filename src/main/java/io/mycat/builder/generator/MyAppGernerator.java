package io.mycat.builder.generator;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Version;
import io.mycat.builder.bean.AppModule;
import io.mycat.builder.bean.Author;
import io.mycat.builder.bean.DBSchema;
import io.mycat.builder.bean.ErrorInfo;
import io.mycat.builder.bean.ListData;
import io.mycat.builder.bean.MyParamSpec;
import io.mycat.builder.generator.view.MenuPageView;

/**
 * 目标应用生成器
 * 
 * @author leader
 */
public abstract class MyAppGernerator {
	public static final int App_Web = 0;
	public static final int App_Ios = 1;
	public static final int App_Andriod = 2;
	// Web系统，微信小程序，Android应用等,ID 唯一

	public final static Configuration freemarkerCfg;
	static {
		// Freemarker configuration object
		freemarkerCfg = new Configuration(new Version("2.3.0"));
		freemarkerCfg.setDefaultEncoding("UTF-8");
		StringTemplateLoader sTmpLoader = new StringTemplateLoader();
		freemarkerCfg.setTemplateLoader(sTmpLoader);
	}
	protected int appType = App_Web;
	// 数据库信息
	protected DBSchema myschema;
	// 主界面视图（入口）
	protected MenuPageView mainPage;
	// 目标系统的包名(如 com.mycomp.myapp)
	protected String packageName;

	// 模块列表
	protected List<AppModule> moudles = new LinkedList<>();

	// 动态列表数据
	protected Map<String, ListData> listDatas = new LinkedHashMap<>();;

	// 目标程序的编程语言，如果多种，则给出主要的一种，比如Web开发，主要语言为后端语言
	protected String language;
	protected String version;

	// 目标程序所采用的技术框架，包括前端框架，后端框架等，
	protected List<String> frameWorks = new LinkedList<>();
	// 用户应该输入的参数列表，建议开发者设置默认值
	protected Map<String, MyParamSpec> appParams = new LinkedHashMap<>();
	protected String describe;

	// 返回支持的View类型的元数据
	protected Map<String, ViewMetaInfo> supporedViewTypes = new LinkedHashMap<>();
	// 已经创建的View对象
	protected List<MyView> createdViews = new LinkedList<>();
	// 源码生成的目标目录
	protected String sourceHomePath;
	// 作者信息
	protected List<Author> authors = new LinkedList<>();;

	public MyAppGernerator() {
		this.sourceHomePath = System.getProperty("user.home");
	}

	/**
	 * 生成之前检查模型的的错误并返回，如果空则表示没有问题
	 * 
	 * @return
	 */
	public List<ErrorInfo> checkDesign() {

		List<ErrorInfo> errors = new LinkedList<>();

		this.createdViews.forEach(t -> {
			List<ErrorInfo> err = t.checkDesign();
			if (err != null && !err.isEmpty()) {
				errors.addAll(err);
			}

		});
		return errors;

	}

	/**
	 * 返回所有菜单视图的类别
	 * 
	 * @return
	 */
	public List<ViewMetaInfo> findMenuPageViewTypes() {
		List<ViewMetaInfo> result = new LinkedList<>();
		this.supporedViewTypes.values().forEach(t -> {
			if (MenuPageView.class.isAssignableFrom(t.getViewClass())) {
				result.add(t);
			}
		});
		return result;

	}

	/**
	 * 创建一个新的View页面对象
	 * 
	 * @param viewCls
	 * @return
	 * @throws Exception
	 */
	public MyView createNewView(Class<? extends MyView> viewCls) throws Exception {
		if (!this.supporedViewTypes.containsKey(viewCls.getSimpleName())) {
			throw new RuntimeException("not supported this view type " + viewCls);
		}
		MyView view = newMyViewInstance(viewCls);
		view.setApp(this);
		view.setViewMetaInfo(supporedViewTypes.get(viewCls.getSimpleName()));
		this.createdViews.add(view);
		return view;
	}

	/**
	 * 创建某类View实例
	 * 
	 * @param viewId
	 * @return MyView
	 */
	protected abstract MyView newMyViewInstance(Class<? extends MyView> viewCls) throws Exception;

	/**
	 * 生成源码，子类可覆盖，定制化生成
	 */
	public void generateApp() {
		for (MyView myView : this.createdViews) {
			myView.generateCode();
		}
	}

	public MyAppGernerator addFrameWork(String framework) {
		this.frameWorks.add(framework);
		return this;
	}

	public MyAppGernerator addAuthor(Author author) {
		this.authors.add(author);
		return this;
	}

	public MyAppGernerator addMyParamSpec(MyParamSpec paramSpec) {
		this.appParams.put(paramSpec.getParamName(), paramSpec);
		return this;
	}

	public MyAppGernerator addViewType(ViewMetaInfo viewInfo) {
		this.supporedViewTypes.put(viewInfo.getViewClass().getSimpleName(), viewInfo);
		return this;
	}

	public MyAppGernerator setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getLanguage() {
		return language;
	}

	public MyAppGernerator setLanguage(String language) {
		this.language = language;
		return this;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<String> getFrameWorks() {
		return frameWorks;
	}

	public MyAppGernerator setFrameWorks(List<String> frameWorks) {
		this.frameWorks = frameWorks;
		return this;
	}

	public void addMoudle(AppModule theModule) {
		this.moudles.add(theModule);
	}

	public List<AppModule> getMoudles() {
		return this.moudles;
	}

	public void addListData(ListData listData) {
		this.listDatas.put(listData.getName(), listData);
	}

	public String getVersion() {
		return version;
	}

	public String getSourceHomePath() {
		return sourceHomePath;
	}

	public void setSourceHomePath(String sourceHomePath) {
		this.sourceHomePath = sourceHomePath;
	}

	public Map<String, MyParamSpec> getAppParams() {
		return appParams;
	}

	public void setAppParams(Map<String, MyParamSpec> appParams) {
		this.appParams = appParams;
	}

	public Collection<ViewMetaInfo> getSupporedViewTypes() {
		return supporedViewTypes.values();
	}

	public List<MyView> getCreatedViews() {
		return createdViews;
	}

	public void setCreatedViews(List<MyView> createdViews) {
		this.createdViews = createdViews;
	}

	public int getAppType() {
		return appType;
	}

	public void setAppType(int appType) {
		this.appType = appType;
	}

	public DBSchema getMyschema() {
		return myschema;
	}

	public void setMyschema(DBSchema myschema) {
		this.myschema = myschema;
	}

	public MenuPageView getMainPage() {
		return mainPage;
	}

	public void setMainPage(MenuPageView mainPage) {
		this.mainPage = mainPage;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
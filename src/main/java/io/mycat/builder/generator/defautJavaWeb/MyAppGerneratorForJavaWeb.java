package io.mycat.builder.generator.defautJavaWeb;

import io.mycat.builder.bean.Author;
import io.mycat.builder.generator.MyAppGernerator;
import io.mycat.builder.generator.MyView;
import io.mycat.builder.generator.defautJavaWeb.views.DefaultCRUDPageView;
import io.mycat.builder.generator.defautJavaWeb.views.DefaultListPageView;
import io.mycat.builder.generator.defautJavaWeb.views.DefaultMenuPageView;

/**
 * 目标应用生成器，Java Web应用
 * 
 * @author leader
 */
public class MyAppGerneratorForJavaWeb extends MyAppGernerator {

	/**
	 * 返回必要的基本信息
	 */
	public MyAppGerneratorForJavaWeb() {
		this.setLanguage("Java").addFrameWork("Spring Boot").addFrameWork("VUE").setVersion("0.1")
				.addAuthor(new Author("Leader us", "https://github.com/leader-us", "719867650@qq.com", "Power "));

		addViewType(DefaultMenuPageView.metaInfo);
		addViewType(DefaultListPageView.metaInfo);
		addViewType(DefaultCRUDPageView.metaInfo);

	}

	@Override
	protected MyView newMyViewInstance(Class<? extends MyView> viewCls) throws Exception {
		MyView view = (MyView) viewCls.getDeclaredConstructors()[0].newInstance();
		return view;
	}

}
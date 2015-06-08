package com.demo.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.model.User;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.test.HelloController;

public class DemoConfig extends JFinalConfig {

	public void configConstant(Constants me) {
		me.setDevMode(false);
		me.setViewType(ViewType.JSP);
	}

	/**
	 * ����·��
	 */
	public void configRoute(Routes me) {
		me.add("/", HelloController.class, "/view");
	}

	/**
	 * ���ò��
	 */
	public void configPlugin(Plugins me) {
		// mysql 数据源
		C3p0Plugin dsMysql = new C3p0Plugin(
				"jdbc:mysql://127.0.0.1/jfinal_demo", "root", "123456");
		me.add(dsMysql);
		// mysql ActiveRecrodPlugin 实例，并指定configName为 mysql
		ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql", dsMysql);
		me.add(arpMysql);
		arpMysql.addMapping("user", User.class);
	}

	/**
	 * ����ȫ��������
	 */
	public void configInterceptor(Interceptors me) {

	}

	/**
	 * ���ô�����
	 */
	public void configHandler(Handlers me) {

	}
}

package com.jfinal.test;

import com.jfinal.core.Controller;
import com.jfinal.model.User;

public class HelloController extends Controller {

	public void index() {
		// renderText("HelloJfinal!");
		render("index.jsp");
	}

	public void login() {
		new User().set("id", 1).set("username", getPara("username"))
				.set("password", getPara("pwd")).save();
		// render("index.jsp");
		renderNull();

	}
}

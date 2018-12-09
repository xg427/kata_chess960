package com.github.sourcefranke.chess960.web.pages;

import org.apache.wicket.markup.html.WebPage;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
public class Chess960Page extends WebPage {

	private static final long serialVersionUID = 1L;

	public Chess960Page() {
		add(new Chess960Panel("960panel"));
	}
}

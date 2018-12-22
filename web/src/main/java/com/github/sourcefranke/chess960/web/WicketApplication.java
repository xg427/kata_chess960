package com.github.sourcefranke.chess960.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class WicketApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder()
               .sources(WicketApplication.class)
               .run(args);
	}
}
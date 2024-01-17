package com.example.Test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.h2.tools.Server;

import java.sql.SQLException;

@SpringBootApplication
public class Test1Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);

		startH2Console();
	}

	private static void startH2Console() {

		try {

			Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083").start();
			Server tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9093").start();
		}
		catch (SQLException e) {

			throw new RuntimeException("Failed to start H2 console", e);
		}
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
}
package ru.reiver.skel;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class App {
	
	public static String CONFIG_LOCATION = "ru.reiver.skel.config";
	
	public static void main(String[] args) throws Exception {
		
		WebAppContext context = new WebAppContext();
		context.setContextPath("/");
		context.addServlet(new ServletHolder("dispatcher", createDispatcherSerlet()), "/*");
		context.setResourceBase("webapp");
		
		Server server = new Server(8080);
		server.setHandler(context);

		server.start();
		server.join();
	}
	
	public static Servlet createDispatcherSerlet() {
		DispatcherServlet servlet = new DispatcherServlet();
		servlet.setContextClass(AnnotationConfigWebApplicationContext.class);
		servlet.setContextConfigLocation(CONFIG_LOCATION);
		return servlet;	
	}
}

package com.jieun.jsp;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ContextListenerEx
 */
@WebListener
public class ContextListenerEx implements ServletContextListener {
 	@Override
 	public void contextDestroyed(ServletContextEvent sce) {
 		// TODO Auto-generated method stub
 		ServletContextListener.super.contextDestroyed(sce);
 	
 		System.out.println("contextDestroyed");
 	}
	
 	public void contextInitialized(ServletContextEvent sce) {
 		// TODO Auto-generated method stub
 		ServletContextListener.super.contextInitialized(sce);
 	
 		System.out.println("contextInitialized");
 	}
}


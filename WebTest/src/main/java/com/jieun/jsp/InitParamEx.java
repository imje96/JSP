package com.jieun.jsp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Servlet implementation class HelloWorld
 */

@WebServlet(urlPatterns = {"/InitParamEx"}, initParams = {@WebInitParam(name = "dbId", value = "abcde"), @WebInitParam(name = "dbPwd", value = "123456789"), @WebInitParam(name = "dbSid", value = "orac")})

public class InitParamEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParamEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		
		String dbId = getServletContext().getInitParameter("dbId");
		String dbPwd = getServletContext().getInitParameter("dbPwd");
		String dbSid = getServletContext().getInitParameter("dbSid");
		String testId = getInitParameter("testId");
		System.out.println("dbId: " + dbId + "| dbPwd: " + dbPwd + "| dbSid: "+ dbSid);
		
		
//		response.getWriter().append("Served ast: ").append(request.getContextPath());
//		System.out.println("HelloWorld !!!");
//		
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter pw =response.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("dbId: " + dbId + "<br/>");
		pw.println("dbPwd: " + dbPwd +  "<br/>");
		pw.println("dbSid: " + dbSid +  "<br/>");
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		
      request.setCharacterEncoding("UTF-8");
      
      String name = request.getParameter("name");
      String id = request.getParameter("id");
      String passwd = request.getParameter("passwd");
      String[] hobby = request.getParameterValues("hobby");
      
      System.out.println("name : " + name + "| id : " + id + "| passwd : " + passwd);
      System.out.println("hobby : " + Arrays.toString(hobby));
      
      response.setContentType("text/html; charset-UTF-8");
      PrintWriter pw = response.getWriter();
      
      pw.println("<htmll>");
      pw.println("<head>");
      pw.println("</head>");
      pw.println("<body>");
      pw.println("이름 : " + name + "<br/>");
      pw.println("아이디 : " + id + "<br/>");
      pw.println("비밀번호 : " + passwd + "<br/>");
      pw.println("취미 : " + Arrays.toString(hobby) + "<br/>");
      pw.println("</body>");
      pw.println("</html>");
      
      pw.close();

//		doGet(request, response);
	}
	
	
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("init");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		System.out.println("destroy");
	}
	
	@PostConstruct
	private void postConstructor() {
		System.out.println("PostConstructor");
	}
	
	@PreDestroy
	private void preDestory() {
		System.out.println("PreDestroy");
	}

}

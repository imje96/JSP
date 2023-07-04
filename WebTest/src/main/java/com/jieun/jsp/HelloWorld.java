package com.jieun.jsp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Servlet implementation class HelloWorld
 */


public class HelloWorld extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served ast: ").append(request.getContextPath());
      System.out.println("HelloWorld !!!");
      
      response.setContentType("text/html");
      PrintWriter pw =response.getWriter();
      
      pw.println("<html>");
      pw.println("<head>");
      pw.println("</head>");
      pw.println("<body>");
      pw.println("<h1>get 방식으로 호출되었습니다. HelloWorld!!</hi>");
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

//      doGet(request, response);
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
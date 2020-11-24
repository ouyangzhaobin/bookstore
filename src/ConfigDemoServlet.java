/*
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfigDemoServlet extends HttpServlet{
    String servletName=null;
    ServletConfig config=null;
    String email=null;
    String telephone=null;

    public void init() {
        config = getServletConfig();
        servletName = config.getServletName();
        email = config.getInitParameter("email");
        telephone = config.getInitParameter("telephone");
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Servlet名称："+servletName+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone);
        out.println("</body></html>");
    }
}
*/

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet")
public class ConfigDemoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        //设置网页响应类型3
        response.setContentType("text/html");
        //实现具体操作
        PrintWriter out = response.getWriter();

        /*
         * 一
         */
        ServletConfig config = getServletConfig();
        String name = config.getServletName();
        String email = this.getInitParameter("email");
        String telephone = this.getInitParameter("telephone");

        out.println("<html><body");
        out.println("<br>");
        out.println("select名称："+name+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone+"<br>");

        /*
         * 二
         */
        //使用ServletContext读取全局初始化参数
        ServletContext context = this.getServletContext();
        String admin_email = context.getInitParameter("email");
        String admin_tel = context.getInitParameter("telephone");

        System.out.println("Email地址："+admin_email+"<br>");
        System.out.println("电话："+admin_tel+"<br>");

        //写入日志文件
        context.log(admin_email);
        context.log(admin_tel);
        out.println(context.getContextPath());
        out.println("</body></html>");
    }
}


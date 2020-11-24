

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet")
public class CountServlet extends HttpServlet {

    static int count;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        count++;

        out.println("<html>");
        out.println("<head><title>访问次数</title></head>");
        out.println("<body>");
        out.println("Servlet被访问的次数："+String.valueOf(count));
        out.println("</body></html>");
    }
}


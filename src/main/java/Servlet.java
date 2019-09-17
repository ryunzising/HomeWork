import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        Logger logger = Logger.getLogger(Servlet.class.getName());
        String name=request.getParameter("name");
        if(name.equals("Majima")){
            out.println("真岛吾郎");
            logger.info("Majima");
        }else {
            out.println("桐生一马");
            logger.info("Kiryu");}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        Logger logger = Logger.getLogger(Servlet.class.getName());
        String name=request.getParameter("name");
        if(name.equals("Majima")){
            out.println("真岛吾郎");
            logger.info("Majima");
        }else {
            out.println("桐生一马");
            logger.info("Kiryu");}
    }

    }


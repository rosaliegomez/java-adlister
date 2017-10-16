import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = "/sum")
public class sum extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        int a = 0, b = 0;
        a = Integer.parseInt(request.getParameter("num1"));
        b = Integer.parseInt(request.getParameter("num2"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3> Sum res: " + (a+b) + "</h3>");

        String name = request.getParameter("name");
        if(name != null){
            out.println("<h3> Hello " + name + "</h3>");
        }else out.println("<h3> Hello World </h3>");

        int counter = Integer.parseInt(request.getParameter("counter"));
        counter += 1;
        out.println("Page visited " + counter+ " times.");
    }
}

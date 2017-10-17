import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); // is output
        String name = request.getParameter("name");//is input
        if(name != null){
            out.println("<h3> Hello " + name + "</h3>");
        }else out.println("<h3> Hello World </h3>");

        int counter = Integer.parseInt(request.getParameter("counter"));
        counter += 1;
        out.println("Page visited " + counter+ " times.");
    }
}

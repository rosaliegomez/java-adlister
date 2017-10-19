import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Boolean.FALSE;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")

public class ViewProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//If the user is not logged in, then you redirect to the login.

    if (request.getSession().getAttribute("user")==null){
        response.sendRedirect("/login");
    }else {
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    }
}

package webapp;

import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by JonathanL on 21-03-2017.
 */
@WebServlet(name = "Servlet")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User userObject = new User();
        request.setAttribute("username",request.getParameter("loginname"));
        request.setAttribute("password",request.getParameter("password"));

        if(userObject.isValidUser(request.getParameter("loginname"),request.getParameter("password"))){

            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
        }

        else{
            request.setAttribute("errorMessage","invalid user and password. Try again.");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.print("login-name: " + request.getParameter("loginname")+" password: " + request.getParameter("password"));
    }
}

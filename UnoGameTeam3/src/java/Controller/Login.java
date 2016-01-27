package Controller;

import DAO.Logindao;
import Model.Player;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String u = request.getParameter("userid");

        String p = request.getParameter("password");

        Player pl = new Player();
        pl.setUserid(u);
        pl.setPassword(p);
        HttpSession session = request.getSession();
        session.setAttribute("user", pl);
        if (Logindao.validate(u, p)) {
            RequestDispatcher rd = request.getRequestDispatcher("loginhomepage.jsp");
            rd.forward(request, response);
        } else {
            out.print("Sorry username or password error");
            RequestDispatcher rd = request.getRequestDispatcher("loginpage.jsp");
            rd.include(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Connection conn = null;

        String driver = "com.mysql.jdbc.Driver";
        try {
            String u = request.getParameter("userid");
            String p = request.getParameter("password");
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unogame", "root", "password");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("insert into login(userid,password) values(?,?)");//try2 is the name of the table  
            pst.setString(1, u);
            pst.setString(2, p);
            int i = pst.executeUpdate();
            if (i != 0) {
                RequestDispatcher rd = request.getRequestDispatcher("loginpage.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("registration home page.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            pw.println(e);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

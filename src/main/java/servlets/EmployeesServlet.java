package servlets;

import dao.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = "/employees", loadOnStartup = 1)
public class EmployeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        request.setAttribute("Phone", JDBCUtils.getPhone(conn));
        request.setAttribute("Computer", JDBCUtils.getComputer(conn));
        request.setAttribute("TV", JDBCUtils.getTV(conn));
        JDBCUtils.getConnectionPool().checkIn(conn);

        String buttonPhone = request.getParameter("buttonPhone");
        System.out.println("Button is: " + buttonPhone);

        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       super.doPost(request, response);
    }
}

package servlets;

import dao.HibernateSessionFactory;
import dao.processing.Calculation;
import model.myDevices.Computer;
import model.myDevices.Phone;
import model.myDevices.TV;
import model.myDevices.TotalPower;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/employees", loadOnStartup = 1)
public class EmployeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Phone> queryPhone = builder.createQuery(Phone.class);
        Root<Phone> phoneRoot = queryPhone.from(Phone.class);
        queryPhone.select(phoneRoot);

        CriteriaQuery<Computer> queryComputer = builder.createQuery(Computer.class);
        Root<Computer> computerRoot = queryComputer.from(Computer.class);
        queryComputer.select(computerRoot);

        CriteriaQuery<TV> queryTV = builder.createQuery(TV.class);
        Root<TV> tvRoot = queryTV.from(TV.class);
        queryTV.select(tvRoot);

        CriteriaQuery<TotalPower> queryTotalPower = builder.createQuery(TotalPower.class);
        Root<TotalPower> TotalPowerRoot = queryTotalPower.from(TotalPower.class);
        queryTotalPower.select(TotalPowerRoot);

        session.getTransaction().commit();


        request.setAttribute("Phone", session.createQuery(queryPhone).getResultList());
        request.setAttribute("Computer", session.createQuery(queryComputer).getResultList());
        request.setAttribute("TV", session.createQuery(queryTV).getResultList());
        request.setAttribute("Result", session.createQuery(queryTotalPower).getResultList());
        session.close();

        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Button.action(request,response);
        Calculation.usedPower(request,response);

//        int min = Integer.parseInt(request.getParameter("min"));
//        int max = Integer.parseInt(request.getParameter("max"));
//        Search.mySearch(min,max,request,response);


    }
}

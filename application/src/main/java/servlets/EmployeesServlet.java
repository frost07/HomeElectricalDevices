package servlets;

import dao.HibernateSessionFactory;
import dao.processing.Calculation;
import model.myDevices.*;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

        List list = session.createQuery(queryPhone).getResultList();

        request.setAttribute("Phone", list);
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

        //Search.mySearch(min,max,request,response);

        int min = Integer.parseInt(request.getParameter("min"));
        int max = Integer.parseInt(request.getParameter("max"));

       // String id = request.getParameter("key");
        String id = "1";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();


        CriteriaQuery<MinMax> query = builder.createQuery(MinMax.class);
        Root<MinMax> Root = query.from(MinMax.class);
        Predicate condition = builder.equal(Root.get("id"), id);
        query.select(Root).where(condition);
        List<MinMax> required = session.createQuery(query).getResultList();

        if (required != null && required.size() > 0) {
            MinMax minmax = required.get(0);

            minmax.setMin(min);
            minmax.setMax(max);

            session.save(minmax);

//            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//            String json = ow.writeValueAsString(minmax);
//            response.getWriter().append(json);
        }
        session.getTransaction().commit();
        session.close();
        response.getWriter().close();

    }
}

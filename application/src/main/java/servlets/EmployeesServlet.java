package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.HibernateSessionFactory;
import model.myDevices.Computer;
import model.myDevices.Phone;
import model.myDevices.TV;
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

        session.getTransaction().commit();
        request.setAttribute("Phone", session.createQuery(queryPhone).getResultList());
        request.setAttribute("Computer", session.createQuery(queryComputer).getResultList());
        request.setAttribute("TV", session.createQuery(queryTV).getResultList());
        session.close();

        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("key");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
        Root<Phone> phoneRoot = query.from(Phone.class);
        Predicate condition = builder.equal(phoneRoot.get("id"), id);
        query.select(phoneRoot).where(condition);
        List<Phone> requiredPhone = session.createQuery(query).getResultList();


        if (requiredPhone != null && requiredPhone.size() > 0) {
            Phone phone = requiredPhone.get(0);
            int state =phone.getState();
            if (state==0) {
                phone.setState(1);
            }
            if (state == 1) {
                phone.setState(0);
            }
            session.save(phone);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(phone);
            response.getWriter().append(json);
        }

        session.getTransaction().commit();
        session.close();

        response.getWriter().close();
    }
}

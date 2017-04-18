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

        CriteriaBuilder builderPhone = session.getCriteriaBuilder();
        CriteriaQuery<Phone> queryPhone = builderPhone.createQuery(Phone.class);
        Root<Phone> phoneRoot = queryPhone.from(Phone.class);
        queryPhone.select(phoneRoot);
        //session.getTransaction().commit();
        //request.setAttribute("Phone", session.createQuery(queryPhone).getResultList());
        //session.close();

        CriteriaBuilder builderComputer = session.getCriteriaBuilder();
        CriteriaQuery<Computer> queryComputer = builderComputer.createQuery(Computer.class);
        Root<Computer> computerRoot = queryComputer.from(Computer.class);
        queryComputer.select(computerRoot);
        //session.getTransaction().commit();
        //request.setAttribute("Computer", session.createQuery(queryComputer).getResultList());
        //session.close();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TV> queryTV = builder.createQuery(TV.class);
        Root<TV> tvRoot = queryTV.from(TV.class);
        queryTV.select(tvRoot);

        session.getTransaction().commit();
        request.setAttribute("Phone", session.createQuery(queryPhone).getResultList());
        request.setAttribute("Computer", session.createQuery(queryComputer).getResultList());
        request.setAttribute("TV", session.createQuery(queryTV).getResultList());
        session.close();

        //Connection conn = JDBCUtils.getConnectionPool().checkOut();
//        request.setAttribute("Phone", JDBCUtils.getPhone(conn));
//        request.setAttribute("Computer", JDBCUtils.getComputer(conn));
//        request.setAttribute("TV", JDBCUtils.getTV(conn));
//        JDBCUtils.getConnectionPool().checkIn(conn);

       /* String buttonPhone = request.getParameter("buttonPhone");
        System.out.println("Button is: " + buttonPhone);*/

        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("key");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
        Root<Phone> phoneRoot = query.from(Phone.class);
        Predicate condition = builder.equal(phoneRoot.get("name"), name);
        query.select(phoneRoot).where(condition);
        List<Phone> requiredPhone = session.createQuery(query).getResultList();


        if (requiredPhone != null && requiredPhone.size() > 0) {
            Phone phone = requiredPhone.get(0);
            phone.setState(1);
            session.save(phone);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(phone);
            response.getWriter().append(json);
        }

        session.getTransaction().commit();
        session.close();

//        CriteriaUpdate criteriaUpdate = builder.createCriteriaUpdate(Employee.class);
//        Root<Employee> root = criteriaUpdate.from(Employee.class);
//        Predicate condition = builder.equal(root.get("name"),name);
//        criteriaUpdate.where(condition);
//        criteriaUpdate.set(root.get("salary"),"200");
//
//        int affected = session.createQuery(criteriaUpdate).executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//        if (affected > 0) {
//            response.getWriter().append("200");
//        } else {
//            response.sendError(500);
//        }

        response.getWriter().close();
// super.doPost(request, response);
    }
}

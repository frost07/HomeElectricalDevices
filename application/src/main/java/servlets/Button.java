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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by frost on 19.04.2017.
 */
public class Button {
    public static void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("key");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();


        CriteriaQuery<Phone> queryPhone = builder.createQuery(Phone.class);
        Root<Phone> phoneRoot = queryPhone.from(Phone.class);
        Predicate conditionPhone = builder.equal(phoneRoot.get("id"), id);
        queryPhone.select(phoneRoot).where(conditionPhone);
        List<Phone> requiredPhone = session.createQuery(queryPhone).getResultList();

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

        CriteriaQuery<Computer> queryComputer = builder.createQuery(Computer.class);
        Root<Computer> computerRoot = queryComputer.from(Computer.class);
        Predicate conditionComputer = builder.equal(computerRoot.get("id"), id);
        queryComputer.select(computerRoot).where(conditionComputer);
        List<Computer> requiredComputer = session.createQuery(queryComputer).getResultList();

        if (requiredComputer != null && requiredComputer.size() > 0) {
            Computer computer = requiredComputer.get(0);
            int state =computer.getState();
            if (state==0) {
                computer.setState(1);
            }
            if (state == 1) {
                computer.setState(0);
            }
            session.save(computer);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(computer);
            response.getWriter().append(json);
        }

        CriteriaQuery<TV> queryTV = builder.createQuery(TV.class);
        Root<TV> tvRoot = queryTV.from(TV.class);
        Predicate conditionTV = builder.equal(tvRoot.get("id"), id);
        queryTV.select(tvRoot).where(conditionTV);
        List<TV> requiredTV = session.createQuery(queryTV).getResultList();

        if (requiredTV != null && requiredTV.size() > 0) {
            TV tv = requiredTV.get(0);
            int state =tv.getState();
            if (state==0) {
                tv.setState(1);
            }
            if (state == 1) {
                tv.setState(0);
            }
            session.save(tv);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(tv);
            response.getWriter().append(json);
        }

        session.getTransaction().commit();
        session.close();
        response.getWriter().close();
}}

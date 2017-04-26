package dao.processing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.HibernateSessionFactory;
import model.myDevices.Computer;
import model.myDevices.Phone;
import model.myDevices.TV;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by frost on 13.03.2017.
 */
public class Search {

    public static void mySearch(int min, int max, HttpServletRequest request, HttpServletResponse response) throws IOException {
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

        List<Phone> listPhone = new ArrayList<>();
        List<Computer> listComputer = new ArrayList<>();
        List<TV> listTV = new ArrayList<>();

        for (Phone i : session.createQuery(queryPhone).getResultList()) {
            if (i.getPower() >= min && i.getPower() <= max) {
                listPhone.add(i);
            }
        }
        for (Computer i : session.createQuery(queryComputer).getResultList()) {
            if (i.getPower() >= min && i.getPower() <= max) {
                listComputer.add(i);
            }
        }
        for (TV i : session.createQuery(queryTV).getResultList()) {
            if (i.getPower() >= min && i.getPower() <= max) {
                listTV.add(i);
            }
        }
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonPhone = ow.writeValueAsString(listPhone);
        String jsonComputer = ow.writeValueAsString(listComputer);
        String jsonTV = ow.writeValueAsString(listTV);
        response.getWriter().append(jsonPhone);
        response.getWriter().append(jsonComputer);
        response.getWriter().append(jsonTV);

        session.close();
        response.getWriter().close();

        request.setAttribute("Phone", jsonPhone);
        request.setAttribute("Computer", jsonComputer);
        request.setAttribute("TV", jsonTV);

    }
}

package dao.processing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.HibernateSessionFactory;
import model.myDevices.*;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by frost on 13.03.2017.
 */
public class Calculation {
    public static void usedPower(HttpServletRequest request, HttpServletResponse response) throws IOException {

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

       int summPhone = 0;
       int summTV = 0;
       int summComputer = 0;

        for (Devices i : session.createQuery(queryPhone).getResultList()) {
            if (i.getState() == 1) {
                summPhone += i.getPower();
            }
        }
        for (Devices i : session.createQuery(queryComputer).getResultList()) {
            if (i.getState() == 1) {
                summComputer += i.getPower();
            }
        }
        for (Devices i : session.createQuery(queryTV).getResultList()) {
            if (i.getState() == 1) {
                summTV += i.getPower();
            }
        }
        int summ = summPhone + summComputer + summTV;

        //String id = request.getParameter("key");
        String id ="1";
        session.beginTransaction();
        CriteriaBuilder builderResult = session.getCriteriaBuilder();

        CriteriaQuery<TotalPower> query = builderResult.createQuery(TotalPower.class);
        Root<TotalPower> Root = query.from(TotalPower.class);
        Predicate condition = builderResult.equal(Root.get("id"), id);
        queryTV.select(tvRoot).where(condition);
        List<TotalPower> required = session.createQuery(query).getResultList();

        if (required!= null && required.size() > 0) {
            TotalPower totalPower = required.get(0);
            totalPower.setValue(summ);

            session.save(totalPower);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(totalPower);
            response.getWriter().append(json);
        }

        session.getTransaction().commit();
        session.close();
        response.getWriter().close();
    }
//    public static CriteriaQuery<x> myclass(CriteriaBuilder builder, x<T>){
//        CriteriaQuery<x> query = builder.createQuery(x.class);
//        Root<x> Root = query.from(x.class);
//        return query.select(Root);
    //}
}

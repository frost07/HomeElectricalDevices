package dao.processing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.HibernateSessionFactory;
import model.myDevices.Devices;
import model.myDevices.TotalPower;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by frost on 13.03.2017.
 */
public class Calculation {
    public static void usedPower(HttpServletResponse response) throws IOException {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

       int summPhone = 0;
       int summTV = 0;
       int summComputer = 0;

        for (Devices i : Comands.phoneList()) {
            if (i.getState() == 1) {
                summPhone += i.getPower();
            }
        }
        for (Devices i : Comands.computerList()) {
            if (i.getState() == 1) {
                summComputer += i.getPower();
            }
        }
        for (Devices i : Comands.tvList()) {
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
        query.select(Root).where(condition);
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

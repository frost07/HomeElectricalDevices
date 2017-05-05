package dao.processing;

import dao.HibernateSessionFactory;
import model.myDevices.Computer;
import model.myDevices.Phone;
import model.myDevices.TV;
import model.myDevices.TotalPower;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by frost on 28.04.2017.
 */
public class Comands {
    public static List<Phone> phoneList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Phone> queryPhone = builder.createQuery(Phone.class);
        Root<Phone> phoneRoot = queryPhone.from(Phone.class);
        queryPhone.select(phoneRoot);

        session.getTransaction().commit();
        List list = session.createQuery(queryPhone).getResultList();
        session.close();

        return list;
    }

    public static List<Computer> computerList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Computer> queryComputer = builder.createQuery(Computer.class);
        Root<Computer> computerRoot = queryComputer.from(Computer.class);
        queryComputer.select(computerRoot);

        session.getTransaction().commit();
        List list = session.createQuery(queryComputer).getResultList();
        session.close();

        return list;
    }

    public static List<TV> tvList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<TV> queryTV = builder.createQuery(TV.class);
        Root<TV> tvRoot = queryTV.from(TV.class);
        queryTV.select(tvRoot);

        session.getTransaction().commit();
        List list = session.createQuery(queryTV).getResultList();
        session.close();

        return list;
    }
    public static List<TotalPower> totalPowerList(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<TotalPower> queryTotalPower = builder.createQuery(TotalPower.class);
        Root<TotalPower> TotalPowerRoot = queryTotalPower.from(TotalPower.class);
        queryTotalPower.select(TotalPowerRoot);

        session.getTransaction().commit();
        List list = session.createQuery(queryTotalPower).getResultList();
        session.close();

        return list;
    }

}

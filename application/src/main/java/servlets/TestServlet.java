package servlets;

import dao.HibernateSessionFactory;
import model.myDevices.Computer;
import model.myDevices.MinMax;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/home_devices/test", loadOnStartup = 0)
public class TestServlet extends HttpServlet {
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

        List<Phone> listPhone = new ArrayList<>();
        List<Computer> listComputer = new ArrayList<>();
        List<TV> listTV = new ArrayList<>();

        CriteriaQuery<MinMax> query = builder.createQuery(MinMax.class);
        Root<MinMax> Root = query.from(MinMax.class);
        Predicate condition = builder.equal(Root.get("id"), "1");
        query.select(Root).where(condition);
        List<MinMax> required = session.createQuery(query).getResultList();

        int min = 0;
        int max = 0;
        if (required != null && required.size() > 0) {
            MinMax minmax = required.get(0);

            min=minmax.getMin();
            max=minmax.getMax();

            session.save(minmax);
        }

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

        session.close();

        request.setAttribute("Phone", listPhone);
        request.setAttribute("Computer", listComputer);
        request.setAttribute("TV", listTV);

        //Search.mySearch(request,response);

        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}
package servlets;

import dao.HibernateSessionFactory;
import dao.processing.Calculation;
import dao.processing.Comands;
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

        request.setAttribute("Phone", Comands.phoneList());
        request.setAttribute("Computer", Comands.computerList());
        request.setAttribute("TV", Comands.tvList());
        request.setAttribute("Result", Comands.totalPowerList());

        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String x = request.getParameter("type");

        if (x.equals("button")) {
            Button.action(request.getParameter("key"), response);
        }
        if (x.equals("resultPower")) {
            Calculation.usedPower(response);
        }
        if (x.equals("resultSearch")) {
            if (request.getParameter("min") != null || request.getParameter("max") != null) {
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
                //response.getWriter().close();
            }
        }


    }
}

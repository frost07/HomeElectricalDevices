package dao;

import MyDevices.Devices;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by dzna0914 on 3/24/2017.
 */
public class JDBCUtils {

    private static JDBCConnectionPool connectionPool;

    public static JDBCConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            Properties props = readProperties("jdbc.properties");
            connectionPool = new JDBCConnectionPool(
                    props.getProperty("jdbc.Driver"),
                    props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.user"),
                    props.getProperty("jdbc.password")
            );
        }

        return connectionPool;
    }

    private static Properties readProperties(String fileResourceName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = JDBCUtils.class.getClassLoader().getResourceAsStream(fileResourceName);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public static Collection<Devices> getEmployees(Connection conn) {
        List<Devices> list = new ArrayList<>();
        String sql = "select * from employees";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                String name = rs.getString("name");
                String size = rs.getString("size");
                String color = rs.getString("color");
                int power = rs.getInt("power");


                Devices employee = new Devices(name,size,color,power);
                employee.setName(name);
                employee.setSize(size);
                employee.setColor(color);
                employee.setPower(power);

                list.add(employee);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public static void insertEmployee(Connection conn, Devices employee) {
        String sql = "insert into employees(name,size,color,power) values (?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, employee.getName());
            pstm.setString(2, employee.getSize());
            pstm.setString(3, employee.getColor());
            pstm.setInt(4, employee.getPower());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

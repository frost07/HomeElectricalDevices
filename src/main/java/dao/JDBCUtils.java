package dao;

import MyDevices.Computer;
import MyDevices.Devices;
import MyDevices.Phone;
import MyDevices.TV;

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
                String type = rs.getString("type");
                String name = rs.getString("name");
                String size = rs.getString("size");
                String color = rs.getString("color");
                int power = rs.getInt("power");
                int feature = rs.getInt("feature");


                if (type.equals("Phone")) {
                    list.add(new Phone(type, name, size, color, power, feature));
                } else if (type.equals("TV")) {
                    list.add(new TV(type, name, size, color, power, feature));
                } else if (type.equals("Computer")) {
                    list.add(new Computer(type, name, size, color, power, feature));
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

for(Devices i : list){
    System.out.println(i.toString());
}
        return list;
    }

    public static void insertEmployee(Connection conn, Devices employee) {
        String sql = "insert into employees(type,name,size,color,power) values (?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, employee.getType());
            pstm.setString(2, employee.getName());
            pstm.setString(3, employee.getSize());
            pstm.setString(4, employee.getColor());
            pstm.setInt(5, employee.getPower());


            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

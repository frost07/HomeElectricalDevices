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

    public static Collection<Devices> getComputer(Connection conn) {
        List<Devices> list = new ArrayList<>();
        String sql = "SELECT * FROM computer";
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
                int sizeHDD = rs.getInt("sizeHDD");
                list.add(new Computer(type, name, size, color, power, sizeHDD));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Collection<Devices> getTV(Connection conn) {
        List<Devices> list = new ArrayList<>();
        String sql = "SELECT * FROM tv";
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
                int numberOfChannels = rs.getInt("numberOfChannels");
                list.add(new TV(type, name, size, color, power, numberOfChannels));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Collection<Devices> getPhone(Connection conn) {
        List<Devices> list = new ArrayList<>();
        String sql = "SELECT * FROM phone";
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
                int batteryLifeTime = rs.getInt("batteryLifeTime");
                list.add(new Phone(type, name, size, color, power, batteryLifeTime));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertEmployee(Connection conn, Devices employee) {
        String sql = "INSERT INTO employees(type,name,size,color,power) VALUES (?,?,?,?,?)";

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

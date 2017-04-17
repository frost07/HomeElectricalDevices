package dao;

import model.myDevices.Computer;
import model.myDevices.Devices;
import model.myDevices.Phone;
import model.myDevices.TV;

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
                int state = rs.getInt("state");
                list.add(new Computer(type, name, size, color, power, sizeHDD, state));
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
                int state = rs.getInt("state");
                list.add(new TV(type, name, size, color, power, numberOfChannels, state));

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
                int state = rs.getInt("state");
                list.add(new Phone(type, name, size, color, power, batteryLifeTime, state));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertPhone(Connection conn, Phone employee) {
        String sql = "INSERT INTO phone(type,name,size,color,power,batteryLifeTime,state) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, employee.getType());
            pstm.setString(2, employee.getName());
            pstm.setString(3, employee.getSize());
            pstm.setString(4, employee.getColor());
            pstm.setInt(5, employee.getPower());
            pstm.setInt(6, employee.getBatteryLifeTime());
            pstm.setInt(7, employee.getState());


            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void insertComputer(Connection conn, Computer employee) {
        String sql = "INSERT INTO computer(type,name,size,color,power,sizeHDD,state) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, employee.getType());
            pstm.setString(2, employee.getName());
            pstm.setString(3, employee.getSize());
            pstm.setString(4, employee.getColor());
            pstm.setInt(5, employee.getPower());
            pstm.setInt(6, employee.getSizeHDD());
            pstm.setInt(7, employee.getState());


            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void insertTV(Connection conn, TV employee) {
        String sql = "INSERT INTO tv(type,name,size,color,power,numberOfChannels,state) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, employee.getType());
            pstm.setString(2, employee.getName());
            pstm.setString(3, employee.getSize());
            pstm.setString(4, employee.getColor());
            pstm.setInt(5, employee.getPower());
            pstm.setInt(6, employee.getNumberOfChannels());
            pstm.setInt(7, employee.getState());


            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

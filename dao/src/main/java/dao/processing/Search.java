package dao.processing;

import dao.JDBCUtils;
import model.myDevices.Devices;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by frost on 13.03.2017.
 */
public class Search {

    public static void mySearch() throws IOException {
        System.out.println();
        System.out.println("введите пределы поиска");
        System.out.println("min =");
        int min = (new Scanner(System.in)).nextInt();
        System.out.println("max =");
        int max = (new Scanner(System.in)).nextInt();
        System.out.println();
        System.out.println("Найденные приборы");

        Connection conn = JDBCUtils.getConnectionPool().checkOut();

        List<Devices> list = new ArrayList<>();

        for (Devices i : JDBCUtils.getPhone(conn)) {
            if (i.getPower() >= min && i.getPower() <= max) {
                //System.out.println(i.toString());
                list.add(i);
                //WriteFileTXT.write("Search_Result.txt",i.toString());
            }
        }
        for (Devices i : JDBCUtils.getComputer(conn)) {
            if (i.getPower() >= min && i.getPower() <= max) {
                //System.out.println(i.toString());
                list.add(i);
                //WriteFileTXT.write("Search_Result.txt",i.toString());
            }
        }
        for (Devices i : JDBCUtils.getTV(conn)) {
            if (i.getPower() >= min && i.getPower() <= max) {
               // System.out.println(i.toString());
                list.add(i);
                //WriteFileTXT.write("Search_Result.txt",i.toString());
            }
        }
        for (Devices i : list) {

                System.out.println(i.toString());
        }

    }
}

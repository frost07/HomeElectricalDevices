package processing;

import myDevices.Devices;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


/**
 * Created by frost on 13.03.2017.
 */
public class Search {

    public static void mySearch(List<Devices> list) throws IOException {
        System.out.println();
        System.out.println("введите пределы поиска");
        System.out.println("min =");
        int min = (new Scanner(System.in)).nextInt();
        System.out.println("max =");
        int max = (new Scanner(System.in)).nextInt();
        System.out.println();
        System.out.println("Найденные приборы");


        for (Devices i : list) {
            if (i.getPower() >= min && i.getPower() <= max) {
                System.out.println(i.toString());
                WriteFileTXT.write("Search_Result.txt",i.toString());
            }
        }
    }
}

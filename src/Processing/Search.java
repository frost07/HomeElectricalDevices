package Processing;

import MyDevices.Devices;
import java.util.List;



/**
 * Created by frost on 13.03.2017.
 */
public class Search {

    public static void MySearch(List<Devices> list, int min, int max) {
        System.out.println();
        System.out.println("Найденные приборы");


        for (Devices i : list) {
            if (i.getPower() >= min && i.getPower() <= max) {
                System.out.println(i.toString());
            }
        }
    }
}

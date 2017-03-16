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


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPower() >= min && list.get(i).getPower() <= max) {
                System.out.println(list.get(i).getName() + " " +
                        list.get(i).getSize() + " " + list.get(i).getColor() + " " + list.get(i).getPower());
            }
        }
    }
}

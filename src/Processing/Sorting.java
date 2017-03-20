package Processing;


import MyDevices.Devices;

import java.util.*;

/**
 * Created by frost on 13.03.2017.
 */
public class Sorting {
    public static void MySort(List<Devices> list) {
        System.out.println();
        System.out.println("Отсортированные приборы");

        Comparator<Devices> comp = new Comparator<Devices>() {
            // Comparison for sorting
            public int compare(Devices one, Devices two) {

                if (one.getPower() < two.getPower()) {
                    return -1;
                } else if (one.getPower() > two.getPower()) {
                }
                return 0;
            }
        };
        // Sorting the list of objects

        Collections.sort(list, comp);

        for (Devices i : list) {
            System.out.println(i.toString());
        }
    }
}
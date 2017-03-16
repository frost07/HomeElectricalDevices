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
            // сравнение для сортировки по убыванию цены товара
            public int compare(Devices one, Devices two) {

                if (one.getPower() < two.getPower()) {

      /* текущее меньше полученного */
                    return -1;
                } else if (one.getPower() > two.getPower()) {
      /* текущее больше полученного */
                    return 1;
                }
    /* текущее равно полученному */
                return 0;
            }
        };
        // сортировка списка объектов

        Collections.sort(list, comp);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " " +
                    list.get(i).getSize() + " " + list.get(i).getColor() + " " + list.get(i).getPower());
        }
    }
}
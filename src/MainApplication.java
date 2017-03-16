import MyDevices.Computer;
import MyDevices.Devices;
import MyDevices.Phone;
import MyDevices.TV;
import Processing.Calculation;
import Processing.Search;
import Processing.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by frost on 12.03.2017.
 */
public class MainApplication {

    public static void main(String[] args) {

        List<Devices> list = new ArrayList<Devices>();
        list.add(new Phone("xiaomi", "big", "black", 3));
        list.add(new Phone("iphone", "small", "green", 2));
        list.add(new Phone("samsung", "big", "silver", 5));
        list.add(new TV("phillips", "big", "green", 10));
        list.add(new TV("samsung", "middle", "blue", 8));
        list.add( new TV("sony", "small", "silver", 6));
        list.add(new Computer("dell", "middle", "pink", 25));
        list.add(new Computer("asus", "middle", "black", 30));
        list.add(new Computer("lenovo", "small", "black", 12));
        list.get(0).on();
        list.get(4).on();
        list.get(7).on();

        Sorting.MySort(list);//сортировочка
        Calculation.UsedPower(list);//суммачка
        Search.MySearch(list,5,15);

    }
}

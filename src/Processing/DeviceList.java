package Processing;

import MyDevices.Computer;
import MyDevices.Devices;
import MyDevices.Phone;
import MyDevices.TV;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frost on 20.03.2017.
 */
public class DeviceList {
    public static List<Devices> getDeviceList() {
        List<Devices> list = new ArrayList<Devices>();
        list.add(new Phone("xiaomi", "big", "black", 3, 155));
        list.add(new Phone("iphone", "small", "green", 2, 256));
        list.add(new Phone("samsung", "big", "silver", 5, 178));
        list.add(new TV("phillips", "big", "green", 10,100));
        list.add(new TV("samsung", "middle", "blue", 8,100));
        list.add(new TV("sony", "small", "silver", 6,150));
        list.add(new Computer("dell", "middle", "pink", 25,256));
        list.add(new Computer("asus", "middle", "black", 30,512));
        list.add(new Computer("lenovo", "small", "black", 12,512));
        list.get(0).on();
        list.get(4).on();
        list.get(7).on();
        return list;
    }
}

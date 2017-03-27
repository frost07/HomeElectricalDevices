package Processing;

import MyDevices.Computer;
import MyDevices.Devices;
import MyDevices.Phone;
import MyDevices.TV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frost on 20.03.2017.
 */
public class DeviceList {
    public static List<Devices> getDeviceList() throws IOException {

        String fileName = "Devices.txt";
        InputStream in = DeviceList.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String arg = null;
        List<Devices> list = new ArrayList<Devices>();

        int i = 0;

        while ((arg = reader.readLine()) != null) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Phone")) {
                list.add(new Phone(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
            } else if (parts[0].equals("TV")) {
                list.add(new TV(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
            } else if (parts[0].equals("Computer")) {
                list.add(new Computer(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
            }
            i++;
        }

        list.get(0).on();
        list.get(4).on();
        list.get(7).on();
        return list;
    }
}

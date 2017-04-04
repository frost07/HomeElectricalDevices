package processing;

import myDevices.Devices;
import myDevices.Phone;
import myDevices.TV;
import myDevices.Computer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frost on 20.03.2017.
 */
public class DeviceList {
    public static List<Devices> getDeviceList() throws IOException {

        String fileName = "src/main/Devices.txt";
        List<Devices> list = new ArrayList<Devices>();

        int i = 0;
        for (String arg : ReadFileTXT.read(fileName)) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Phone")) {
                list.add(new Phone(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
            } else if (parts[0].equals("TV")) {
                list.add(new TV(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
            } else if (parts[0].equals("Computer")) {
                list.add(new Computer(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
            }
            i++;
        }
        list.get(0).on();
        list.get(4).on();
        list.get(7).on();
      return list;
    }
}

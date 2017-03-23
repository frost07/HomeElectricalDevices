package Processing;

import MyDevices.Devices;

import java.io.IOException;
import java.util.List;

/**
 * Created by frost on 13.03.2017.
 */
public class Calculation {
    public static void usedPower(List<Devices> list) throws IOException {
        System.out.println();
        System.out.println("рассчёт потребляемой мощности");
        int summ = 0;
        for (Devices i : list) {
            if (i.getState()) {
                summ += i.getPower();
            }
        }
        System.out.println("потребляемая мощность " + summ);

        WriteFileTXT.write("Power.txt", "потребляемая мощность " + Integer.toString(summ));
    }
}

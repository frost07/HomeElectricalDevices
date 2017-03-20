package Processing;

import MyDevices.Devices;

import java.io.IOException;
import java.util.List;

/**
 * Created by frost on 13.03.2017.
 */
public class Calculation {
    public static void UsedPower(List<Devices> list) throws IOException {
        System.out.println();
        System.out.println("рассчёт потребляемой мощности");
        int summ = 0;
        for (Devices i : list) {
            if (i.getState() == true) {
                summ += i.getPower();
            }
        }
        System.out.println("потребляемая мощность " + summ);

        WriteToTXT.write("Power.txt", "потребляемая мощность " + Integer.toString(summ));
    }
}

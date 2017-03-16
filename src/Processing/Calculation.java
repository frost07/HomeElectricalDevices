package Processing;

import MyDevices.Devices;

import java.util.List;

/**
 * Created by frost on 13.03.2017.
 */
public class Calculation {
    public static void UsedPower(List<Devices> list){
        System.out.println();
        System.out.println("рассчёт потребляемой мощности");
        int summ=0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getState()){summ+=list.get(i).getPower();}
        }
        System.out.println("потребляемая мощность " + summ);
    }
}

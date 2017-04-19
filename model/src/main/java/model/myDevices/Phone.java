package model.myDevices;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by frost on 13.03.2017.
 */
@Entity
@Table(name = "phone", schema = "employees", catalog = "")
public class Phone extends Devices {
    private int batteryLifeTime;
    //private String type = "Phone";


    public Phone(String type, String name, String size, String color, int power, int batteryLifeTime, int state) {
        super(type,name, size, color, power, state);
        //this.type = type;
        this.batteryLifeTime = batteryLifeTime;
    }

    public Phone() {
    }

    public String toString() {
        return super.toString() + " [Battery life time " + batteryLifeTime+"] ";
    }

    public int getBatteryLifeTime() {
        return batteryLifeTime;
    }

    public void setBatteryLifeTime(int batteryLifeTime) {
        this.batteryLifeTime = batteryLifeTime;
    }

}

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
    private String type = "Phone";

    public void setType(String type) {
        this.type = type;
    }

    public Phone(String type, String name, String size, String color, int power, int batteryLifeTime, int state) {
        super(name, size, color, power, state);
        this.type = type;
        this.batteryLifeTime = batteryLifeTime;
    }

    public String toString() {
        return type+super.toString() + " [Battery life time " + batteryLifeTime+"] ";
    }

    public int getBatteryLifeTime() {
        return batteryLifeTime;
    }

    public void setBatteryLifeTime(int batteryLifeTime) {
        this.batteryLifeTime = batteryLifeTime;
    }

}

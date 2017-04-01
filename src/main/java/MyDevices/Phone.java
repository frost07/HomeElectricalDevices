package MyDevices;

/**
 * Created by frost on 13.03.2017.
 */
public class Phone extends Devices {
    private int batteryLifeTime;
    private String type = "Phone";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Phone(String type, String name, String size, String color, int power, int batteryLifeTime) {
        super(name, size, color, power);
        this.type = type;
        this.batteryLifeTime = batteryLifeTime;
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

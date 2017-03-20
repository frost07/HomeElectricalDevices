package MyDevices;

/**
 * Created by frost on 13.03.2017.
 */
public class Phone extends Devices {
    private int batteryLifeTime;
    public Phone(String name, String size, String color, int power, int batteryLifeTime) {
        super(name, size, color, power);
        this.batteryLifeTime = batteryLifeTime;
    }
public String toString(){
        return super.toString()+" [Battery life time] " + batteryLifeTime;
}

    public int getBatteryLifeTime() {
        return batteryLifeTime;
    }

    public void setBatteryLifeTime(int batteryLifeTime) {
        this.batteryLifeTime = batteryLifeTime;
    }
    @Override
    public void DoSomething() {
        System.out.println("Пошли гудки");
    }
}

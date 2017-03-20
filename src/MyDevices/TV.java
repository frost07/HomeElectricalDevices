package MyDevices;

/**
 * Created by frost on 13.03.2017.
 */
public class TV extends Devices {
private int numberOfCchannels;
    public TV(String name, String size, String color, int power,int numberOfCchannels) {
        super(name, size, color, power);
        this.numberOfCchannels = numberOfCchannels;
    }

    public int getNumberOfCchannels() {
        return numberOfCchannels;
    }

    public void setNumberOfCchannels(int numberOfCchannels) {
        this.numberOfCchannels = numberOfCchannels;
    }

    public String toString() {
        return super.toString()+ " [number of channels] "+ numberOfCchannels;
    }

    @Override
    public void doSomething() {
        System.out.println("и снова показывает рекламу");
    }
}

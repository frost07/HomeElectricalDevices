package MyDevices;

/**
 * Created by frost on 13.03.2017.
 */
public class Computer extends Devices{
private int sizeHDD;
    public Computer(String name, String size, String color, int power,int sizeHDD) {
        super(name, size, color, power);
        this.sizeHDD = sizeHDD;
    }

    public int getSizeHDD() {
        return sizeHDD;
    }

    public void setSizeHDD(int sizeHDD) {
        this.sizeHDD = sizeHDD;
    }

    public String toString() {
        return super.toString() + " [size HDD] "+ sizeHDD;
    }
}

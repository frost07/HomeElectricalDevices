package myDevices;

/**
 * Created by frost on 13.03.2017.
 */
public class Computer extends Devices {
    private int sizeHDD;
    private String type = "Computer";
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Computer(String type, String name, String size, String color, int power, int sizeHDD) {
        super(name, size, color, power);
        this.type = type;
        this.sizeHDD = sizeHDD;
    }

    public int getSizeHDD() {
        return sizeHDD;
    }

    public void setSizeHDD(int sizeHDD) {
        this.sizeHDD = sizeHDD;
    }

    public String toString() {
        return super.toString() + " [size HDD " + sizeHDD + "] ";
    }
}

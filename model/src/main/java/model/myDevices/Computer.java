package model.myDevices;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by frost on 13.03.2017.
 */
@Entity
@Table(name = "computer", schema = "employees", catalog = "")
public class Computer extends Devices {
    private int sizeHDD;
    private String type = "Computer";


    public void setType(String type) {
        this.type = type;
    }

    public Computer(String type, String name, String size, String color, int power, int sizeHDD, int state) {
        super(name, size, color, power, state);
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
        return type + super.toString() + " [size HDD " + sizeHDD + "] ";
    }

}

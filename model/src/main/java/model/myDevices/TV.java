package model.myDevices;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by frost on 13.03.2017.
 */
@Entity
@Table(name = "tv", schema = "employees", catalog = "")
public class TV extends Devices {
    private int numberOfChannels;
    //private String type = "TV";


    public TV(String type, String name, String size, String color, int power, int numberOfChannels, int state) {
        super(type, name, size, color, power, state);
        //this.type = type;
        this.numberOfChannels = numberOfChannels;
    }

    public TV() {
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    public void setNumberOfChannels(int numberOfChannels) {
        this.numberOfChannels = numberOfChannels;
    }

    public String toString() {
        return super.toString() + " [number of channels " + numberOfChannels + "] ";
    }

}

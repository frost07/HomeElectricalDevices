package model.myDevices;


import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Created by frost on 13.03.2017.
 */

@MappedSuperclass
public abstract class Devices {
   private String name;
    private String size;
    private String color;
    private int power;

    private String type;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Devices(String name, String size, String color, int power, int state) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.power = power;
        this.state = state;
    }
    @Transient
    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getSize() {return size; }

    public String getColor() {
        return color;
    }

    public int getPower() {
        return power;
    }

    public String toString(){
        return " [name "+ name+"] [size "+size+"] [color "+ color+"] [power "+power+"]";
    }

    private String id;

@Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


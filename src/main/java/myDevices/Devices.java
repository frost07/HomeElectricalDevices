package myDevices;

import interfaces.Electronics;

/**
 * Created by frost on 13.03.2017.
 */
public abstract class Devices implements Electronics{
   private String name;
    private String size;
    private String color;
    private int power;
    private boolean activated=false;
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

    @Override
    public void on() {
        activated=true;
    }

    @Override
    public void off() {
        activated=false;
    }

    public String toString(){
        return " [name "+ name+"] [size "+size+"] [color "+ color+"] [power "+power+"]";
    }
}


package MyDevices;

import Interfaces.Electronics;

/**
 * Created by frost on 13.03.2017.
 */
public  class Devices implements Electronics{
   private String name;
    private String size;
    private String color;

    public String getType() {
        return type;
    }

    private int power;
    private boolean activated=false;
    private String type;

    public Devices(String name, String size, String color, int power) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.power = power;
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

    public boolean getState(){
        return activated;
    }

    public String toString(){
        return type + " [name "+ name+"] [size "+size+"] [color "+ color+"] [power "+power+"]";
    }
}


package MyDevices;

/**
 * Created by frost on 13.03.2017.
 */
public class Phone extends Devices {

    public Phone(String name, String size, String color, int power) {
        super(name, size, color, power);
    }

    /*@Override
    public void on() {
        System.out.println("Включился");
    }

    @Override
    public void off() {
        System.out.println("Выключился");
    }*/

    @Override
    public void DoSomething() {
        System.out.println("Пошли гудки");
    }
}

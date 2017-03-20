package MyDevices;

/**
 * Created by frost on 13.03.2017.
 */
public class TV extends Devices {

    public TV(String name, String size, String color, int power) {
        super(name, size, color, power);
    }

    public String toString() {
        return super.toString();
    }

    /*
        @Override
        public void on() {
            System.out.println("начал показывать");
        }

        @Override
        public void off() {
            System.out.println("потух");
        }
    */
    @Override
    public void DoSomething() {
        System.out.println("и снова показывает рекламу");
    }
}

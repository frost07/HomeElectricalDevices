import processing.Calculation;
import processing.Search;

/**
 * Created by frost on 05.04.2017.
 */
public class MainApplication {
    public static void main(String Arg[]) {
        try {
            Search.mySearch();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Calculation.usedPower();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

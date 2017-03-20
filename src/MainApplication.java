import Processing.*;

/**
 * Created by frost on 12.03.2017.
 */
public class MainApplication {

    public static void main(String[] args) {

        boolean caughtException = true;
        while (caughtException) {
            try {
                Menu.choice();
                caughtException = false;

            } catch (java.util.InputMismatchException e) {
                System.out.println("Введите число!");
            }
        }
    }
}


package javaa;

import javaa.Processing.Menu;
import java.io.IOException;

/**
 * Created by frost on 12.03.2017.
 */
public class MainApplication {

    public static void main(String[] args) throws IOException {

        boolean caughtException = true;
        while (caughtException) {
            try {
                Menu.choice();
                caughtException = false;


            } catch (java.util.InputMismatchException e) {
                System.out.println("Введите число!");
            }
        }//while
    }
}
package Processing;

import java.util.Scanner;

/**
 * Created by frost on 20.03.2017.
 */
public class Menu {
    public static void choice() {
        System.out.println("1-сортировка, 2-сумма, 3-поиск, 0-выход");
        boolean notExit = true;
        while (notExit) {
            Scanner scanner = new Scanner(System.in);
            int point = scanner.nextInt();

            switch (point) {
                case 1:
                    Sorting.MySort(DeviceList.getDeviceList());
                    break;
                case 2:
                    Calculation.UsedPower(DeviceList.getDeviceList());
                    break;
                case 3:
                    boolean caughtException = true;
                    while (caughtException) {
                    try {
                        Search.MySearch(DeviceList.getDeviceList());
                        caughtException = false;

                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Вводите числа");
                    }
                }//while
                    break;
                case 0:
                    notExit = false;
                    break;
                default:
                    System.out.println("Введите 1, 2 или 3 для меню и 0 для выхода");
            } // switch
        } // while
    }
}

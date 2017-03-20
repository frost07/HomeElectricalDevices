import Processing.Calculation;
import Processing.DeviceList;
import Processing.Search;
import Processing.Sorting;

/**
 * Created by frost on 12.03.2017.
 */
public class MainApplication {

    public static void main(String[] args) {

        Sorting.MySort(DeviceList.getDeviceList());//сортировочка
        Calculation.UsedPower(DeviceList.getDeviceList());//суммачка
        Search.MySearch(DeviceList.getDeviceList(),5,15);


    }
}

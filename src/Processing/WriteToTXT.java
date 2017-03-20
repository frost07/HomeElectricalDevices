package Processing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by frost on 20.03.2017.
 */
public class WriteToTXT {
    public static void write(String nameFile, String arg) throws IOException {

            PrintWriter writer = new PrintWriter(new FileWriter(nameFile, true));
            writer.println(arg);
            writer.close();

    }
}

package Processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by frost on 20.03.2017.
 */
public class ReadFileTXT {
    public static List<String> read(String name) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(name));
        return list;
    }
}

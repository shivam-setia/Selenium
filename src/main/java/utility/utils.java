package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utils {
    public Object fetchDataFromProperty(String key) throws IOException {
        FileInputStream fis = new FileInputStream("./Config/config.properties");
        Properties property = new Properties();
        property.load(fis);
        return property.get(key);
    }
}

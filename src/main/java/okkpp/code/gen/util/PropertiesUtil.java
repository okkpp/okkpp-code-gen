package okkpp.code.gen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties loadInDefaultResourcesPath(String filename) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(PathKit.getDefaultResourcesPath()+filename)));
        return properties;
    }
}

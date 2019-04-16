package okkpp.code.gen;

import freemarker.template.TemplateException;
import okkpp.code.gen.model.ModelGenerator;
import okkpp.code.gen.util.PathKit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class GenMain {

    public static void main(String[] args) throws SQLException, IOException, TemplateException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(PathKit.getDefaultResourcesPath()+"model.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelGenerator generator = new ModelGenerator(properties);
        generator.generateToFile();
    }
}

package okkpp.code.gen;

import freemarker.template.TemplateException;
import okkpp.code.gen.expand.ExModelGenerator;
import okkpp.code.gen.expand.ExServiceGenerator;
import okkpp.code.gen.expand.ExServiceImplGenerator;
import okkpp.code.gen.util.PropertiesUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class GenMain {

    public static void main(String[] args) throws SQLException, IOException, TemplateException {
        Properties base = PropertiesUtil.loadInDefaultResourcesPath("base.properties");
        ExModelGenerator mg = new ExModelGenerator(base, "model.ftl");
        mg.generateToFile();
        ExServiceGenerator sg = new ExServiceGenerator(base, "service.ftl");
        sg.generateToFile();
        ExServiceImplGenerator sgi = new ExServiceImplGenerator(base, "serviceimpl.ftl");
        sgi.generateToFile();
    }
}

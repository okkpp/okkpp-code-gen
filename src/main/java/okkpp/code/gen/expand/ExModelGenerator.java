package okkpp.code.gen.expand;

import okkpp.code.gen.BaseModelGenerator;

import java.sql.SQLException;
import java.util.Properties;

public class ExModelGenerator extends BaseModelGenerator {
    public ExModelGenerator(Properties base, String template) throws SQLException {
        this(base);
        super.template = template;
    }
    public ExModelGenerator(Properties base) throws SQLException {
        super(base);
        init(PropertiesMakeUp.getModel(base));
    }
}

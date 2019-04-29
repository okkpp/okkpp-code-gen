package okkpp.code.gen.expand;

import okkpp.code.gen.BaseGenerator;

import java.util.Properties;

public class ExServiceGenerator extends BaseGenerator {
    public ExServiceGenerator(Properties base, String template) {
        this(base);
        super.template = template;
    }
    public ExServiceGenerator(Properties base) {
        super(base);
        init(PropertiesMakeUp.getService(base));
    }
}

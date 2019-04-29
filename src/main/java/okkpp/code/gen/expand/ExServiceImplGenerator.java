package okkpp.code.gen.expand;

import okkpp.code.gen.BaseGenerator;

import java.util.Properties;

public class ExServiceImplGenerator extends BaseGenerator {
    public ExServiceImplGenerator(Properties base, String template) {
        this(base);
        super.template = template;
    }
    public ExServiceImplGenerator(Properties base) {
        super(base);
        init(PropertiesMakeUp.getServiceImpl(base));
    }
}

package okkpp.code.gen.model;

import freemarker.template.TemplateException;
import okkpp.code.gen.BaseGenerator;
import okkpp.code.gen.database.Colunm;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ModelGenerator extends BaseGenerator {

    public void setColumns(List<Colunm> columns) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("columns", columns);
        super.setData(data);
    }

    public void setFields(List<Field> fields){
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("fields", fields);
        super.setData(data);
    }

    public static void main(String[] args) throws IOException, TemplateException {

        ModelGenerator modelGenerator = new ModelGenerator();
        modelGenerator.config("test.ftl", "okkpp.code.gen", "Test");
        modelGenerator.setFields(Arrays.asList(new Field("name","String"), new Field("number", "Integer")));
        modelGenerator.generate(modelGenerator.getFileWriter());
    }
}

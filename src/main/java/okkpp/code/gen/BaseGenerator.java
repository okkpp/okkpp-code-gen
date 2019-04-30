package okkpp.code.gen;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import okkpp.code.gen.template.TemplateFactory;
import okkpp.code.gen.util.PathKit;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseGenerator {

    protected String template;
    protected String targetPackage;
    protected String className;
    protected Map<String, Object> data = new HashMap<String, Object>();

    public BaseGenerator(Properties properties){
        init(properties);
    }

    protected void init(Properties properties){
        this.template = properties.getProperty("template");
        this.targetPackage = properties.getProperty("targetPackage");
        this.className = properties.getProperty("className");
        data.putAll((Map)properties);
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void addData(Map<String, Object> data){
        this.data.putAll(data);
    }

    @Deprecated
    public void setData(Map<String, Object> data){
        this.data.putAll(data);
    }

    public void generateToFile() throws IOException, TemplateException {
        generate(getFileWriter());
    }

    public void generate(Writer out) throws IOException, TemplateException {
        Template template = TemplateFactory.me().getTemplate(this.template);
        template.process(data, out);
    }

    public Writer getFileWriter() throws FileNotFoundException {
        String rootPath = PathKit.getDefaultRootPath();
        String targetPath = rootPath+"/src/main/java/"+targetPackage.replace(".", "/");
        File dir = new File(targetPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String target = targetPath+"/"+className+".java";
        File file = new File(target);
        return new OutputStreamWriter(new FileOutputStream(file));
    }

}

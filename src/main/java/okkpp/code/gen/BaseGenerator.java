package okkpp.code.gen;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import okkpp.code.gen.template.TemplateFactory;
import okkpp.code.gen.util.PathKit;

import java.io.*;
import java.util.Map;

public class BaseGenerator {

    protected String template;
    protected String targetPackage;
    protected String className;
    protected Map<String, Object> data;

    public void config(String template, String targetPackage, String className) {
        this.template = template;
        this.targetPackage = targetPackage;
        this.className = className;
    }

    public void setData(Map<String, Object> data){
        data.put("package", targetPackage);
        data.put("className", className);
        this.data = data;
    }

    public void generate(Writer out) throws IOException, TemplateException {
        Template template = TemplateFactory.me().getTemplate(this.template);
        template.process(data, out);
    }

    public Writer getFileWriter() throws FileNotFoundException {
        String rootPath = PathKit.getRootPath();
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

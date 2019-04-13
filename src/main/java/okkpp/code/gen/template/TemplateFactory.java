package okkpp.code.gen.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import okkpp.code.gen.util.PathKit;

import java.io.File;
import java.io.IOException;

public class TemplateFactory {

    private static TemplateFactory singleton= null;
    public static TemplateFactory me(){
        if(null == singleton){
            singleton = new TemplateFactory();
        }
        return singleton;
    }
    private static String PATH = "src/main/resources";
    private static Configuration cfg = null;

    public void init(){
        try {
            cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setDirectoryForTemplateLoading(new File(PathKit.getRootPath()+"/"+PATH));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Configuration getCfg(){
        if(null == cfg){
            init();
        }
        return cfg;
    }

    public Template getTemplate(String name){
        Template template = null;
        try {
            template = getCfg().getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }

}

package okkpp.code.gen.expand;

import java.util.Properties;

public class PropertiesMakeUp {
    public static Properties getModel(Properties base){
        base.setProperty("targetPackage", base.getProperty("basePackage")+"."+base.getProperty("entityPackage", "entity"));
        base.setProperty("className", base.getProperty("entityName")+base.getProperty("entitySuffix", "Entity"));
        return base;
    }

    public static Properties getService(Properties base){
        base.setProperty("targetPackage", base.getProperty("basePackage")+"."+base.getProperty("servicePackage", "service"));
        base.setProperty("className", base.getProperty("entityName")+base.getProperty("serviceSuffix", "Service"));

        base.setProperty("entityPackage", base.getProperty("basePackage")+"."+base.getProperty("entityPackage", "entity"));
        base.setProperty("Entity", base.getProperty("entityName")+base.getProperty("entitySuffix", "Entity"));
        return base;
    }

    public static Properties getServiceImpl(Properties base) {
        base.setProperty("servicePackage", base.getProperty("basePackage")+"."+base.getProperty("servicePackage", "service"));
        base.setProperty("Service", base.getProperty("entityName")+base.getProperty("serviceSuffix", "Service"));

        base.setProperty("targetPackage", base.getProperty("basePackage")+"."+base.getProperty("serviceimplPackage", "service.impl"));
        base.setProperty("className", base.getProperty("Service")+"Impl");
        return base;
    }
}

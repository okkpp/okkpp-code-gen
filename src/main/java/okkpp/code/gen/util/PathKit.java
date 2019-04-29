package okkpp.code.gen.util;

import java.io.File;

public class PathKit {

    private static String rootPath;
    private static String defaultRootPath;

    public static String getRootPath(){
        if (StringUtil.isEmpty(rootPath)) {
            rootPath = detectRootPath();
        }
        return rootPath;
    }

    private static String detectRootPath() {
        try {
            String path = PathKit.class.getResource("/").toURI().getPath();
            return new File(path).getParentFile().getParentFile().getCanonicalPath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserDir(){
        return System.getProperty("user.dir");
    }

    public static String getDefaultRootPath() {
        if (StringUtil.isEmpty(defaultRootPath)) {
            defaultRootPath = getUserDir();
        }
        return defaultRootPath;
    }

    public static void setDefaultRootPath(String defaultRootPath) {
        PathKit.defaultRootPath = defaultRootPath;
    }

    public static String getDefaultResourcesPath(){
        return getDefaultRootPath()+"/src/main/resources/";
    }
}

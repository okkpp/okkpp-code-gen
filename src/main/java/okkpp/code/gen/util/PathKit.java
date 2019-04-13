package okkpp.code.gen.util;

import java.io.File;

public class PathKit {

    private static String webRootPath;

    public static String getRootPath(){
        if (webRootPath == null) {
            webRootPath = detectRootPath();
        }
        return webRootPath;
    }

    private static String detectRootPath() {
        try {
            String path = PathKit.class.getResource("/").toURI().getPath();
            return new File(path).getParentFile().getParentFile().getCanonicalPath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package okkpp.code.gen;

import okkpp.code.gen.database.Colunm;
import okkpp.code.gen.database.DbKit;
import okkpp.code.gen.util.PathKit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseModelGenerator extends BaseGenerator {

    /**
     * 将数据库配置文件加载到system
     */
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(PathKit.getDefaultResourcesPath()+"jdbc.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.getProperties().putAll(properties);
    }

    public BaseModelGenerator(Properties properties) throws SQLException {
        super(properties);
        setColumns(DbKit.me().showColumns(properties.getProperty("tableName")));
    }

    public void setColumns(List<Colunm> columns) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("columns", columns);
        super.addData(data);
    }
}

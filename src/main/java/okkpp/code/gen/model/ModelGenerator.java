package okkpp.code.gen.model;

import okkpp.code.gen.BaseGenerator;
import okkpp.code.gen.database.Colunm;
import okkpp.code.gen.database.DbKit;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class ModelGenerator extends BaseGenerator {

    public ModelGenerator(Properties properties) throws SQLException {
        super(properties);
        setColumns(DbKit.me().showColumns(properties.getProperty("tableName")));
    }

    public void setColumns(List<Colunm> columns) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("columns", columns);
        super.setData(data);
    }
}

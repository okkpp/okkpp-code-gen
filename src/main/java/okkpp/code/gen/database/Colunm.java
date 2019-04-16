package okkpp.code.gen.database;

import okkpp.code.gen.util.StringUtil;

public class Colunm {

    private String field;
    private String name;
    private String camelField;
    private String type;
    private String comment;
    private boolean nullable;
    private boolean isPriKey;

    public Colunm(String field, String type, String comment, boolean nullable, boolean isPriKey) {
        this.field = field;
        this.name = StringUtil.toCamelCase(field);
        this.camelField = StringUtil.toCamelCase(field);
        this.type = TypeConvert.convert(type);
        this.comment = comment;
        this.nullable = nullable;
        this.isPriKey = isPriKey;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCamelField() {
        return camelField;
    }

    public void setCamelField(String camelField) {
        this.camelField = camelField;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isPriKey() {
        return isPriKey;
    }

    public void setPriKey(boolean priKey) {
        isPriKey = priKey;
    }

    @Override
    public String toString() {
        return "Colunm{" +
                "field='" + field + '\'' +
                ", name='" + name + '\'' +
                ", camelField='" + camelField + '\'' +
                ", type='" + type + '\'' +
                ", comment='" + comment + '\'' +
                ", nullable=" + nullable +
                ", isPriKey=" + isPriKey +
                '}';
    }
}

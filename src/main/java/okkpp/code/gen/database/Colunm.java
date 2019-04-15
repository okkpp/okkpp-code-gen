package okkpp.code.gen.database;

public class Colunm {

    private String field;
    private String type;
    private boolean nullable;
    private boolean isPriKey;

    public Colunm(String field, String type, boolean nullable, boolean isPriKey) {
        this.field = field;
        this.type = type;
        this.nullable = nullable;
        this.isPriKey = isPriKey;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", type='" + type + '\'' +
                ", nullable=" + nullable +
                ", isPriKey=" + isPriKey +
                '}';
    }
}

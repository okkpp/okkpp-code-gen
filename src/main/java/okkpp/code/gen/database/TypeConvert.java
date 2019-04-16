package okkpp.code.gen.database;

public class TypeConvert {
    public static String convert(String type){
        for(Type t : Type.values()){
            if(type.toLowerCase().contains(t.name().toLowerCase())){
                return t.getType();
            }
        }
        return "notFound";
    }
    enum Type{
        INT("Integer"),
        BIGINT("Long"),
        DECIMAL("java.math.BigDecimal"),
        BIT("boolean"),
        CHAR("String"),
        VARCHAR("String"),
        TEXT("String"),
        DATETIME("java.util.Date"),
        TIMESTAMP("String");

        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

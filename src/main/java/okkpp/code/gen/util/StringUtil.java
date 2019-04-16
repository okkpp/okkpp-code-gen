package okkpp.code.gen.util;

public class StringUtil {

    public static boolean isEmpty(String source){
        return null==source||source.equals("");
    }

    public static String toCamelCase(String source){
        if(isEmpty(source)){
            return source;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)=='_'){
                if(++i<source.length()){
                    sb.append(Character.toUpperCase(source.charAt(i)));
                }
            }else{
                sb.append(Character.toLowerCase(source.charAt(i)));
            }
        }
        return sb.toString();
    }

}

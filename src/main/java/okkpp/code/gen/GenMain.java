package okkpp.code.gen;

import okkpp.code.gen.database.DbKit;

public class GenMain {

    public static void main(String[] args) {
        DbKit dbKit = new DbKit();
        dbKit.init();
    }
}

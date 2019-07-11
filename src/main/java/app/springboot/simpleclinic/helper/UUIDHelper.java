package app.springboot.simpleclinic.helper;

import java.util.Date;

public class UUIDHelper {

    public static String getGeneratedID(){
        return String.valueOf((long) new Date().getTime());
    }
}

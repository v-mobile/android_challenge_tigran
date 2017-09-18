package volo.tigranhovhannisyan.testapp.utils;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class StringUtils {
    public static String capitalizeFirstLetter(String input){
        if(input.length() > 0){
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
        return input;
    }
}

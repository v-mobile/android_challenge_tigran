package volo.tigranhovhannisyan.testapp.models;

import volo.tigranhovhannisyan.testapp.utils.StringUtils;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class Person {

    public static final String FIRST_NAME_KEY = "first_name";
    public static final String LAST_NAME_KEY = "last_name";

    String firstName;

    String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFormattedFullName(){
        return String.format("%s, %s",
                StringUtils.capitalizeFirstLetter(lastName),
                    StringUtils.capitalizeFirstLetter(firstName));
    }
}

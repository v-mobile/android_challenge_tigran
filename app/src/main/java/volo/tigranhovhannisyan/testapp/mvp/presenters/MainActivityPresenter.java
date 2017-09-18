package volo.tigranhovhannisyan.testapp.mvp.presenters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import volo.tigranhovhannisyan.testapp.models.Person;
import volo.tigranhovhannisyan.testapp.mvp.presenters.core.MvpPresenter;
import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.MainActivityView;
import volo.tigranhovhannisyan.testapp.utils.JsonUtils;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class MainActivityPresenter extends MvpPresenter<MainActivityView> {
    List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        if (persons.isEmpty()) {
            persons = getLocalPersonsList();
        }
        return persons;
    }

    public void addPerson(Person person){
        this.persons.add(person);
    }

    private List<Person> getLocalPersonsList(){
        List<Person> persons = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(JsonUtils.loadJSONFromAssets("jsons/persons"));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String firstName = obj.getString(Person.FIRST_NAME_KEY);
                String lastName = obj.getString(Person.LAST_NAME_KEY);
                persons.add(new Person(firstName, lastName));
            }
        } catch (JSONException ex){
            ex.printStackTrace();
        }
        return persons;
    }
}

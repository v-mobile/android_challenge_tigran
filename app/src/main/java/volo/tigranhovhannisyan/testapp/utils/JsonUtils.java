package volo.tigranhovhannisyan.testapp.utils;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import volo.tigranhovhannisyan.testapp.App;
import volo.tigranhovhannisyan.testapp.models.Person;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class JsonUtils {
    public static String loadJSONFromAssets(String jsonName) {
        String json;
        try {
            InputStream is = App.getInstance().getAssets().open(jsonName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

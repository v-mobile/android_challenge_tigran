package volo.tigranhovhannisyan.testapp;

import android.app.Application;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class App extends Application {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}

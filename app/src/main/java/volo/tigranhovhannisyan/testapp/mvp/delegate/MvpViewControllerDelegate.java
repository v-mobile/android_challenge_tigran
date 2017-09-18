package volo.tigranhovhannisyan.testapp.mvp.delegate;


import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpView;

/**
 * Created by Robert on 17.09.2017.
 */

public interface MvpViewControllerDelegate<V extends MvpView> {
    void onCreate();

    void onStart(V mvpView);

    void onStop();
}

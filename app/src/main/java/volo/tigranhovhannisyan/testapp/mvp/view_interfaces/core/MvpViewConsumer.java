package volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public interface MvpViewConsumer<V> {
    void postToView(V mvpView);
}

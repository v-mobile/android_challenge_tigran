package volo.tigranhovhannisyan.testapp.mvp.view_interfaces;

import volo.tigranhovhannisyan.testapp.models.Person;
import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpView;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public interface MainActivityView extends MvpView {
    void onPersonAdded(Person person);
}

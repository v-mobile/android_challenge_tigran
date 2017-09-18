package volo.tigranhovhannisyan.testapp.mvp.presenters.core;

import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpView;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public interface PresenterProvider<V extends MvpView, P extends Presenter<V>> {
    P getPresenter();
}

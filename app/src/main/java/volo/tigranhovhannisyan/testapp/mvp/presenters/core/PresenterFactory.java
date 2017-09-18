package volo.tigranhovhannisyan.testapp.mvp.presenters.core;

import android.support.annotation.NonNull;

import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpView;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public interface PresenterFactory<V extends MvpView,P extends Presenter<V>> {
    /**
     * Called inside {@link PresenterLoader#onForceLoad()}
     * @return Non null presenter
     */
    @NonNull
    P createPresenter();
}

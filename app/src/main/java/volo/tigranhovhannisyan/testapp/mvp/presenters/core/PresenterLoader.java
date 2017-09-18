package volo.tigranhovhannisyan.testapp.mvp.presenters.core;

import android.content.Context;
import android.support.v4.content.Loader;

import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpView;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class PresenterLoader<V extends MvpView, P extends Presenter<V>, F extends PresenterFactory<V, P>> extends Loader<P> {
    private PresenterFactory<V, P> presenterFactory;
    private P presenter;

    public PresenterLoader(PresenterFactory<V, P> presenterFactory, Context context) {
        super(context);
        this.presenterFactory = presenterFactory;
    }


    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (presenter == null) {
            // create presenter
            forceLoad();
        } else {
            // presenter is already crated
            deliverResult(presenter);
        }
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        presenter = presenterFactory.createPresenter();
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        super.onReset();
        presenter.onDestroy();
        presenter = null;
    }
}

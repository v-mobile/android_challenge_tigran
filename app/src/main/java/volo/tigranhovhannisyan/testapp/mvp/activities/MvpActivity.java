package volo.tigranhovhannisyan.testapp.mvp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import volo.tigranhovhannisyan.testapp.mvp.delegate.MvpViewControllerDelegateImpl;
import volo.tigranhovhannisyan.testapp.mvp.presenters.core.Presenter;
import volo.tigranhovhannisyan.testapp.mvp.presenters.core.PresenterFactory;
import volo.tigranhovhannisyan.testapp.mvp.presenters.core.PresenterProvider;
import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpView;


public abstract class MvpActivity<V extends MvpView, P extends Presenter<V>> extends AppCompatActivity implements PresenterFactory<V, P>,
        MvpView,
        PresenterProvider<V, P> {

    private MvpViewControllerDelegateImpl<V, P> viewControllerDelegate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewControllerDelegate = new MvpViewControllerDelegateImpl<>(this, getSupportLoaderManager(), this);
        viewControllerDelegate.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //noinspection unchecked
        viewControllerDelegate.onStart((V) this);
    }

    @Override
    protected void onStop() {
        viewControllerDelegate.onStop();
        super.onStop();
    }

    @Override
    public P getPresenter() {
        return viewControllerDelegate.getPresenter();
    }
}

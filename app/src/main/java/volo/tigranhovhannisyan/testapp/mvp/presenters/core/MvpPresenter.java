package volo.tigranhovhannisyan.testapp.mvp.presenters.core;
import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpView;
import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.core.MvpViewConsumer;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class MvpPresenter<V extends MvpView> implements Presenter<V> {
    private V view;

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
    }

    protected final void post(MvpViewConsumer<V> consumer) {
        if (view != null) {
            consumer.postToView(view);
        }
    }
}

package volo.tigranhovhannisyan.testapp.adapters.view_holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    Context context;
    T item;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.context = itemView.getContext();
    }

    public abstract void bind(T item, int position);

}

package volo.tigranhovhannisyan.testapp.adapters;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import volo.tigranhovhannisyan.testapp.adapters.view_holders.BaseViewHolder;
import volo.tigranhovhannisyan.testapp.models.Person;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public abstract class BaseListAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {
    List<T> items;

    public BaseListAdapter(){ items = new ArrayList<>(); }

    public BaseListAdapter(List<T> items) {
        this.items = items;
    }

    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return getItemViewHolder(inflater.inflate(getItemLayoutRes(), parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        holder.bind(items.get(position), position);
    }

    protected abstract @LayoutRes int getItemLayoutRes();

    protected abstract BaseViewHolder<T> getItemViewHolder(View itemView);

    public void setItems(List<T> items){
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(T item){
        items.add(item);
        notifyItemInserted(items.size());
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public boolean isEmpty(){
        return getItemCount() == 0;
    }

}

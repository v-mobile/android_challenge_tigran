package volo.tigranhovhannisyan.testapp.adapters;

import android.view.View;

import java.util.List;

import volo.tigranhovhannisyan.testapp.R;
import volo.tigranhovhannisyan.testapp.adapters.view_holders.BaseViewHolder;
import volo.tigranhovhannisyan.testapp.adapters.view_holders.PersonViewHolder;
import volo.tigranhovhannisyan.testapp.models.Person;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class PersonAdapter extends BaseListAdapter<Person>{
    @Override
    protected int getItemLayoutRes() {
        return R.layout.item_person;
    }

    @Override
    protected BaseViewHolder<Person> getItemViewHolder(View itemView) {
        return new PersonViewHolder(itemView);
    }
}

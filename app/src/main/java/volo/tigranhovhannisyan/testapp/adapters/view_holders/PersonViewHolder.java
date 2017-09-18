package volo.tigranhovhannisyan.testapp.adapters.view_holders;

import android.view.View;
import android.widget.TextView;

import volo.tigranhovhannisyan.testapp.R;
import volo.tigranhovhannisyan.testapp.models.Person;
import volo.tigranhovhannisyan.testapp.utils.StringUtils;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class PersonViewHolder extends BaseViewHolder<Person> {

    TextView fullNameTv;

    public PersonViewHolder(View itemView) {
        super(itemView);

        fullNameTv = (TextView) itemView.findViewById(R.id.full_name_tv);
    }

    @Override
    public void bind(Person item, int position) {
        fullNameTv.setText(item.getFormattedFullName());
    }
}

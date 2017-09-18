package volo.tigranhovhannisyan.testapp.mvp.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import volo.tigranhovhannisyan.testapp.R;
import volo.tigranhovhannisyan.testapp.mvp.activities.MainActivity;
import volo.tigranhovhannisyan.testapp.models.Person;
import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.MainActivityView;
import volo.tigranhovhannisyan.testapp.utils.ViewUtils;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class AddPersonFragment extends DialogFragment {
    public static final String TAG = "volo.tigranhovhannisyan.testapp.mvp.fragments.AddPersonFragment";

    Context context;
    MainActivityView callback;

    TextInputLayout firstNameIpl;
    TextInputLayout lastNameIpl;
    Button cancelBtn;
    Button addBtn;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        if(context instanceof MainActivity){
            callback = (MainActivityView) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_add_person, null);

        initViews(view);
        return createAlertDialog(view);
    }

    private void initViews(View rootView){
        firstNameIpl = (TextInputLayout) rootView.findViewById(R.id.first_name_ipl);
        lastNameIpl = (TextInputLayout) rootView.findViewById(R.id.last_name_ipl);
        cancelBtn = (Button) rootView.findViewById(R.id.dialog_cancel_btn);
        addBtn = (Button) rootView.findViewById(R.id.dialog_add_btn);

        ViewUtils.setIplTextChangeListener(firstNameIpl);
        ViewUtils.setIplTextChangeListener(lastNameIpl);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(canContinue()){
                    Person person = new Person(ViewUtils.getIplText(firstNameIpl), ViewUtils.getIplText(lastNameIpl));
                    if(callback != null){
                        callback.onPersonAdded(person);
                        dismiss();
                    }
                }
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private AlertDialog createAlertDialog(View view) {
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }

    private boolean canContinue() {
        String errorText = context.getString(R.string.required_field);
        return !ViewUtils.checkIplEmptyInput(errorText, firstNameIpl) &
                !ViewUtils.checkIplEmptyInput(errorText, lastNameIpl);
    }
}

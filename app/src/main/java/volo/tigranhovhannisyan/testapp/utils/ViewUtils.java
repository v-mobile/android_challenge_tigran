package volo.tigranhovhannisyan.testapp.utils;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

import volo.tigranhovhannisyan.testapp.R;

/**
 * Created by tigran.hovhannisyan on 18.09.2017.
 */

public class ViewUtils {
    public static boolean checkIplEmptyInput(String errorMessage, TextInputLayout ipl){
        if(ipl.getEditText().getText().toString().isEmpty()) {
            ipl.setErrorEnabled(true);
            ipl.setError(errorMessage);
            return true;
        }
        return false;
    }

    public static String getIplText(TextInputLayout ipl){
        return ipl.getEditText().getText().toString();
    }

    public static void setIplTextChangeListener(final TextInputLayout ipl){
        ipl.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(ipl.isErrorEnabled()) {
                    ipl.setError(null);
                    ipl.setErrorEnabled(false);
                }
            }
        });
    }

}

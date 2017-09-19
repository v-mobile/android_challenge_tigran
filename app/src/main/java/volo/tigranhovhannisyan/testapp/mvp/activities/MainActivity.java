package volo.tigranhovhannisyan.testapp.mvp.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import volo.tigranhovhannisyan.testapp.R;
import volo.tigranhovhannisyan.testapp.adapters.PersonAdapter;
import volo.tigranhovhannisyan.testapp.mvp.fragments.AddPersonFragment;
import volo.tigranhovhannisyan.testapp.models.Person;
import volo.tigranhovhannisyan.testapp.mvp.presenters.MainActivityPresenter;
import volo.tigranhovhannisyan.testapp.mvp.view_interfaces.MainActivityView;

public class MainActivity extends MvpActivity<MainActivityView, MainActivityPresenter> implements MainActivityView {

    RecyclerView personRv;
    FloatingActionButton addFab;

    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        personAdapter = new PersonAdapter();
        personRv.setAdapter(personAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(personAdapter.isEmpty()){
            personAdapter.setItems(getPresenter().getPersons());
        }
    }

    private void initViews(){
        personRv = (RecyclerView) findViewById(R.id.person_rv);
        addFab = (FloatingActionButton) findViewById(R.id.add_person_fab);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogFragment();
            }
        });
    }

    @Override
    public void onPersonAdded(Person person) {
        getPresenter().addPerson(person);
        personAdapter.addItem(person);
        personRv.smoothScrollToPosition(personAdapter.getItemCount() - 1);
    }

    public void showDialogFragment(){
        new AddPersonFragment().show(getSupportFragmentManager(), AddPersonFragment.TAG);
    }

    @NonNull
    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenter();
    }
}

package com.ovent.views.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ovent.domain.User;
import com.ovent.R;
import com.ovent.presenters.UserPresenter;
import com.ovent.utils.Intents;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public final class SignupFragment extends BaseFragment {
    public static String TAG = "##SignupFragment##";

    public static SignupFragment newInstance(){
        return new SignupFragment();
    }
    public SignupFragment() {
        // Required empty public constructor
    }
    private UserPresenter mUserPresenter;

    @Bind(R.id.phone)
    EditText mPhone;
    @Bind(R.id.password)
    EditText mPassword;
    @Bind(R.id.name)
    EditText mName;

    @Bind(R.id.signup)
    Button mSignup;
    @OnClick(R.id.signup)
    void signup(){

        register();
    }

    @OnClick(R.id.back)
    void back(){
        getActivity().finish();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this, view);
        mUserPresenter = new UserPresenter();
        return view;
    }

    private void register(){
        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(),"","Signing in..");
        progressDialog.setCancelable(false);
        mUserPresenter.signUp(mName.getText().toString(), mPhone.getText().toString(), mPassword.getText().toString(), new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                progressDialog.dismiss();
            }

            @Override
            public void onNext(User user) {
                progressDialog.dismiss();
                startActivity(Intents.getHomeIntent());
                getActivity().finish();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUserPresenter.destroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mUserPresenter.pause();
    }
}

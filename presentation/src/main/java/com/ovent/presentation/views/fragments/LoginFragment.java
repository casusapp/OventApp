package com.ovent.presentation.views.fragments;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ovent.domain.User;
import com.ovent.presentation.R;
import com.ovent.presentation.presenters.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends BaseFragment {

    public static String TAG = "##LoginFragment##";
    private LoginPresenter mLoginPresenter;

    public LoginFragment() {
    }

    public static LoginFragment GetInstance() {
        return new LoginFragment();
    }

    @Bind(R.id.phone)
    EditText mPhoneNumber;
    @Bind(R.id.password)
    EditText mPassword;
    @Bind(R.id.login)
    Button mLogin;

    @OnClick(R.id.login)
    void login(){
        doLogin();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        mLoginPresenter = new LoginPresenter();

        return view;
    }

    private void doLogin(){
        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "", "Logging in..");
        progressDialog.setCancelable(false);
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.loginUserByEmail(new User(mPhoneNumber.getText().toString().trim(),
                mPassword.getText().toString().trim()), new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
           //     showErrorDialog(e);
                progressDialog.dismiss();
            }

            @Override
            public void onNext(User user) {
                Log.d(TAG, " Login Success " + user.toString());
                Toast.makeText(getActivity(),"welcome!! your mobile number is: "+user.getPhoneNumber(),Toast.LENGTH_SHORT).show();
               /* mLoginPresenter.saveUserLocally(user, new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(User user) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(),"welcome!! your mobile number is: "+user.getPhoneNumber(),Toast.LENGTH_SHORT).show();
                        startActivity(Intents.getHomeIntent());
                        getActivity().overridePendingTransition(R.anim.in_right,
                                R.anim.out_left);
                        getActivity().finish();
                    }
                });*/
            }
        });

    }
}
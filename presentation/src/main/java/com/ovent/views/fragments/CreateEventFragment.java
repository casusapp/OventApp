package com.ovent.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.android.ex.chips.BaseRecipientAdapter;
import com.android.ex.chips.RecipientEditTextView;
import com.android.ex.chips.recipientchip.DrawableRecipientChip;
import com.ovent.R;
import com.ovent.utils.Intents;
import com.ovent.views.activities.CreateEvent;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public final class CreateEventFragment extends BaseFragment {
    public static String TAG = "##CreateEventFragment##";

    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.save)
    TextView mSave;
    @Bind(R.id.name)
    EditText mName;
    @Bind(R.id.description)
    EditText mDescription;
    @Bind(R.id.add_note)
    EditText mAddNote;

    @Bind(R.id.category)
    EditText mCategory;

    @OnClick(R.id.back)
    void back() {

        getActivity().finish();
    }

    @Bind(R.id.toggle)
    SwitchCompat mToggle;
    @Bind(R.id.event_type)
    TextView mEventType;
    @Bind(R.id.invite_people)
    RecipientEditTextView mInvitePeopleFromContacts;
    @Bind(R.id.add)
    Button mAdd;

    @Bind(R.id.multicomplete)
    MultiAutoCompleteTextView mAutoComplete;


    public CreateEventFragment() {
        // Required empty public constructor
    }

    public static CreateEventFragment newInstance() {
        return new CreateEventFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_create_event, container, false);
        ButterKnife.bind(this, view);
        attachListeners();
        mInvitePeopleFromContacts.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mInvitePeopleFromContacts.setAdapter(new BaseRecipientAdapter(BaseRecipientAdapter.QUERY_TYPE_PHONE, getActivity()));
        return view;
    }

    private void attachListeners() {
            
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mTitle.setText(mName.getText());
                Log.d(TAG, editable.toString());
            }
        });

        mToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    mEventType.setText("Private");
                } else {
                    mEventType.setText("Public");
                }
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"auto complete text :"+ mAutoComplete.getText());
                saveEvent();
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Intents.getContactsListIntent());

            }
        });

    }

    private void saveEvent(){
        DrawableRecipientChip[] chips = mInvitePeopleFromContacts.getSortedRecipients();
        Log.d(TAG,"size of chip view :"+chips.toString());
    }

}

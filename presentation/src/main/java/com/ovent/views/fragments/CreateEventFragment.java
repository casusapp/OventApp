package com.ovent.views.fragments;


import android.app.TimePickerDialog;
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
import com.wdullaer.materialdatetimepicker.date.DatePickerController;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.sql.StatementEvent;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public final class CreateEventFragment extends BaseFragment {
    public static String TAG = "##CreateEventFragment##";
    private static String DATE_FORMAT = "dd-MMM-yyyy";
    private static String TIME_FORMAT = "HH:mm a";
    private boolean mIsStartDate;
    private boolean mIsStartTime;

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
    @Bind(R.id.start_date)
    TextView mStartDate;
    @Bind(R.id.start_time)
    TextView mStartTime;
    @Bind(R.id.end_date)
    TextView mEndDate;
    @Bind(R.id.end_time)
    TextView mEndTime;

    @OnClick(R.id.start_date)
    void startDateDialog(){
        showDatePickerDialog(true);
    }

    @OnClick(R.id.end_date)
    void endDateDialog(){
        showDatePickerDialog(false);
    }

    @OnClick(R.id.start_time)
    void startTimeDialog(){
        showTimePickerDialog(true);
    }

    @OnClick(R.id.end_time)
    void endTimeDialog(){
        showTimePickerDialog(false);
    }

   private DatePickerDialog.OnDateSetListener mDateSetListener;
    private com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener mTimeSetListener;

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
        setDate();
        mInvitePeopleFromContacts.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mInvitePeopleFromContacts.setAdapter(new BaseRecipientAdapter(BaseRecipientAdapter.QUERY_TYPE_PHONE, getActivity()));
        Log.d(TAG, "" + mInvitePeopleFromContacts.getAdapter().getCount());
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

                saveEvent();
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Intents.getContactsListIntent());

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

            }
        };

        mTimeSetListener = new com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener(){

            @Override
            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

            }
        };
    }

    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        //date format is:  "Date-Month-Year Hour:Minutes am/pm"
        //Date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
        String currentDate = dateFormat.format(calendar.getTime());
        String currentTime = timeFormat.format(calendar.getTime());
        //Day of Name in full form like,"Saturday", or if you need the first three characters you have to put "EEE" in the date format and your result will be "Sat".
        SimpleDateFormat formatter_ = new SimpleDateFormat("EEEE");
        Date date = new Date();
        String dayName = formatter_.format(date);
        // mStartDate.setText("" + dayName + " " + currentDate + "");
        mStartDate.setText("" + dayName + " " + currentDate);
        mStartTime.setText("" + currentTime);


        calendar.add(Calendar.DATE, 1);
        String nextDate = dateFormat.format(calendar.getTime());
        String nextDay = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        mEndDate.setText("" + nextDay + " " + nextDate);
        mEndTime.setText("" + currentTime);

    }

    private void showDatePickerDialog(final boolean isStartDate){
        mIsStartDate = isStartDate;
        DatePickerDialog datePickerDialog = new DatePickerDialog();
        datePickerDialog.setOnDateSetListener(mDateSetListener);
        datePickerDialog.show(getActivity().getFragmentManager(),"Datepickerdialog");
    }

    private void showTimePickerDialog(final boolean isstartTime){
        mIsStartTime = isstartTime;
        com.wdullaer.materialdatetimepicker.time.TimePickerDialog timePickerDialog = new com.wdullaer.materialdatetimepicker.time.TimePickerDialog();
        timePickerDialog.setOnTimeSetListener(mTimeSetListener);
        timePickerDialog.show(getActivity().getFragmentManager(),"Timepickerdialog");
    }

    private void saveEvent() {
        DrawableRecipientChip[] chips = mInvitePeopleFromContacts.getSortedRecipients();
        for (int i = 0; i < chips.length; i++) {
            Log.d(TAG, "" + chips[i].getEntry().getContactId());
        }
    }
}

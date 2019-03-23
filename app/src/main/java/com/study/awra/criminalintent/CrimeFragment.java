package com.study.awra.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CrimeFragment extends Fragment {
    Crime crime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crime=new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_crime,container,false);
        EditText editText=view.findViewById(R.id.tv_title);
        Button button =view.findViewById(R.id.bt_detail);
        CheckBox checkBox =view.findViewById(R.id.cb_solved);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                crime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setText(new SimpleDateFormat(getString(R.string.data_format), Locale.getDefault()).format(crime.getDate()));
        checkBox.setChecked(crime.isSolved());
        return view;
    }
}

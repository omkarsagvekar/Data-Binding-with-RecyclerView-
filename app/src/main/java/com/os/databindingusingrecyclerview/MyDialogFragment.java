package com.os.databindingusingrecyclerview;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

public class MyDialogFragment extends androidx.fragment.app.DialogFragment {
    View view;
    String name, sirName, age;
    public MyDialogFragment() {
        // Required empty public constructor
    }

    // Factory method to create a new instance with data
    public static MyDialogFragment newInstance(String name, String sirName, String age){
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle arg = new Bundle();
        arg.putString("name", name);
        arg.putString("sirName", sirName);
        arg.putString("age", age);
        myDialogFragment.setArguments(arg);
        return myDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.my_dialog_fragment, container, false);
        getDialog().getWindow().setDimAmount(0.8f);
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        getDialog().getWindow().setGravity(Gravity.CENTER);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        if (getArguments() != null){
            name = getArguments().getString("name");
            sirName = getArguments().getString("sirName");
            age = getArguments().getString("age");
        }

        Button btnOkay = view.findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        return view;
    }

    public interface OnDialogDismissListener {
        void onDialogDismissed(String name, String sirName, String age);
    }
    private OnDialogDismissListener dismissListener;

    public void setOnDialogDismissListener(OnDialogDismissListener listener) {
        this.dismissListener = listener;
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);

        // Notify listener on dismiss
        if (dismissListener != null) {
            dismissListener.onDialogDismissed(name, sirName, age);
        }
    }
}
package com.example.si_area;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link si#newInstance} factory method to
 * create an instance of this fragment.
 */
public class si extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public si() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment si.
     */
    // TODO: Rename and change types and number of parameters
    public static si newInstance(String param1, String param2) {
        si fragment = new si();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_si, container, false);
        EditText p = v. findViewById(R.id.principle);
        EditText r = v. findViewById(R.id.rate);
        EditText t = v. findViewById(R.id.time);
        TextView interest = v. findViewById(R.id.interest);
        Button calc = v. findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int principle, time, rate, Interest;
                principle= Integer.parseInt(p.getText().toString());
                time= Integer.parseInt(t.getText().toString());
                rate= Integer.parseInt(r.getText().toString());
                Interest= (principle*time*rate)/100;
                interest.setText("Interest: "+Interest);
            }
        });


        return  v;
    }
}
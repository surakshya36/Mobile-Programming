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
 * Use the {@link area#newInstance} factory method to
 * create an instance of this fragment.
 */
public class area extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public area() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment area.
     */
    // TODO: Rename and change types and number of parameters
    public static area newInstance(String param1, String param2) {
        area fragment = new area();
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
        View v = inflater.inflate(R.layout.fragment_area, container, false);
        EditText base = v.findViewById(R.id.base);
        EditText height = v.findViewById(R.id.height);
        TextView area = v.findViewById(R.id.area);
        Button calc = v.findViewById(R.id.calc1);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b, h , a;
                b = Integer.parseInt(base.getText().toString());
                h = Integer.parseInt(height.getText().toString());
                a = (b*h)/2;
                area.setText("Area: " +a);

            }
        });
        return  v;
    }
}
package com.example.datatransfer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link entry#newInstance} factory method to
 * create an instance of this fragment.
 */
public class entry extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public entry() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment entry.
     */
    // TODO: Rename and change types and number of parameters
    public static entry newInstance(String param1, String param2) {
        entry fragment = new entry();
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
        View v = inflater.inflate(R.layout.fragment_entry, container, false);
        EditText name = v.findViewById(R.id.name);
        EditText age = v.findViewById(R.id.age);
        EditText add = v.findViewById(R.id.add);
        Button sub = v.findViewById(R.id.sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n, a, ad;
                n = name.getText().toString();
                a = age.getText().toString();
                ad = add.getText().toString();
                Bundle b = new Bundle();
                b.putString("name", n);
                b.putString("age", a);
                b.putString("add", ad);
                display dis = new display();
                dis.setArguments(b);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction tran = manager.beginTransaction();
                tran.replace(R.id.frag, dis);
                tran.addToBackStack(null);
                tran.commit();
            }
        });
        return v;
    }
}
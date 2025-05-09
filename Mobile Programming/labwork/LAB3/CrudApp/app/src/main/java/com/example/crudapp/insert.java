package com.example.crudapp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
public class insert extends Fragment {
    EditText etName, etRoll;
    Button save,back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_insert, container, false);
        etName = v.findViewById(R.id.etName);
        etRoll = v.findViewById(R.id.etRoll);
        save = v.findViewById(R.id.save);
        back = v.findViewById(R.id.back);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return v;
    }
    private void insertData() {
        String name = etName.getText().toString().trim();
        String roll = etRoll.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(getContext(), "Enter name please", Toast.LENGTH_SHORT).show();
            return;
        } else if (roll.isEmpty()) {
            Toast.makeText(getContext(), "Enter roll no please", Toast.LENGTH_SHORT).show();
            return;
        } else {
            String url = "http://192.168.0.101/students/insert.php";
            StringRequest request = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("Data Inserted")) {
                                Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (error instanceof NoConnectionError) {
                                Toast.makeText(getContext(), "No network connection", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("name", name);
                    params.put("roll", roll);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
            requestQueue.add(request);
        }
    }
}
package com.example.crudapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Update extends Fragment {
    private EditText etName, etRoll;
    private String studentId;
    public static Update newInstance(Student student) {
        Update fragment = new Update();
        Bundle args = new Bundle();
        args.putString("id", student.getId());
        args.putString("name", student.getName());
        args.putString("roll", student.getRoll());
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_update, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.etName);
        etRoll = view.findViewById(R.id.etRoll);
        Button btnUpdate = view.findViewById(R.id.update);
        Button btnBack = view.findViewById(R.id.back);
        if (getArguments() != null) {
            studentId = getArguments().getString("id");
            etName.setText(getArguments().getString("name"));
            etRoll.setText(getArguments().getString("roll"));
        }
        btnUpdate.setOnClickListener(v -> updateStudent());
        btnBack.setOnClickListener(v -> requireActivity().onBackPressed());
    }
    private void updateStudent() {
        String name = etName.getText().toString().trim();
        String roll = etRoll.getText().toString().trim();
        if (name.isEmpty() || roll.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        new UpdateTask().execute(studentId, name, roll);
    }
    private class UpdateTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL("http://192.168.0.101/students/update.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("id", params[0]);
                jsonParam.put("name", params[1]);
                jsonParam.put("roll", params[2]);
                OutputStream os = conn.getOutputStream();
                os.write(jsonParam.toString().getBytes(StandardCharsets.UTF_8));
                os.close();
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Parse JSON response
                    String response = new java.util.Scanner(conn.getInputStream()).useDelimiter("\\A").next();
                    JSONObject jsonResponse = new JSONObject(response);
                    return jsonResponse.getString("status");
                }
                return "error";
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }
        @Override
        protected void onPostExecute(String result) {
            if ("success".equals(result)) {
                Toast.makeText(getContext(), "Update successful", Toast.LENGTH_SHORT).show();
                requireActivity().onBackPressed();
            } else {
                Toast.makeText(getContext(), "Update failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
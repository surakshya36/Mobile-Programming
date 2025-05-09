package com.example.crudapp;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class display extends Fragment {
    ListView listView;
    MyAdapter adapter;
    ArrayList<Student> studentArrayList = new ArrayList<>();
    String fetchUrl = "http://192.168.0.101/students/fetch.php";
    String deleteUrl = "http://192.168.0.101/students/delete.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        listView = view.findViewById(R.id.list);
        adapter = new MyAdapter(requireContext(), studentArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            showStudentDetailsDialog(studentArrayList.get(position));
        });
        registerForContextMenu(listView);
        fetchData();
        return view;
    }
    private void fetchData() {
        new FetchDataTask().execute();
    }
    private void showStudentDetailsDialog(Student student) {
        new AlertDialog.Builder(getContext())
                .setTitle("Student Details")
                .setMessage("ID: " + student.getId() + "\nName: " + student.getName() + "\nRoll: " + student.getRoll())
                .setPositiveButton("OK", null)
                .show();
    }
    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.list) {
            requireActivity().getMenuInflater().inflate(R.menu.main2, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (!isVisible()) return false;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Student student = studentArrayList.get(info.position);
        if (item.getItemId() == R.id.menu_update) {
            Update updateFragment = new Update();
            Bundle args = new Bundle();
            args.putString("id", student.getId());
            args.putString("name", student.getName());
            args.putString("roll", student.getRoll());
            updateFragment.setArguments(args);
            FragmentManager manager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frag, updateFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        } else if (item.getItemId() == R.id.menu_delete) {
            confirmDelete(student.getId());
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
    private void confirmDelete(String studentId) {
        new AlertDialog.Builder(getContext())
                .setTitle("Delete Student")
                .setMessage("Are you sure you want to delete this student?")
                .setPositiveButton("Delete", (dialog, which) -> deleteStudent(studentId))
                .setNegativeButton("Cancel", null)
                .show();
    }
    private void deleteStudent(String studentId) {
        new DeleteTask().execute(studentId);
    }
    private class FetchDataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(fetchUrl).openConnection();
                InputStream is = conn.getInputStream();
                Scanner scanner = new Scanner(is).useDelimiter("\\A");
                return scanner.hasNext() ? scanner.next() : "";
            } catch (Exception e) {
                return null;
            }
        }
        @Override
        protected void onPostExecute(String result) {
            if (result == null) {
                Toast.makeText(getContext(), "Fetch failed", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                studentArrayList.clear();
                JSONArray array = new JSONArray(result);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    studentArrayList.add(new Student(
                            obj.getString("id"),
                            obj.getString("name"),
                            obj.getString("roll")
                    ));
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                Toast.makeText(getContext(), "Data parse error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class DeleteTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... ids) {
            try {
                URL url = new URL(deleteUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                String postData = "id=" + ids[0];
                OutputStream os = conn.getOutputStream();
                os.write(postData.getBytes());
                os.flush();
                os.close();

                return conn.getResponseCode() == 200;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                Toast.makeText(getContext(), "Deleted successfully", Toast.LENGTH_SHORT).show();
                fetchData();
            } else {
                Toast.makeText(getContext(), "Delete failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

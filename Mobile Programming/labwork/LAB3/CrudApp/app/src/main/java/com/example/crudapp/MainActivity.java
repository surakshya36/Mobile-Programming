package com.example.crudapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.insert) {
            insert s = new insert();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction tran = manager.beginTransaction();
            tran.replace(R.id.frag, s);
            tran.addToBackStack(null);
            tran.commit();
        } else if (item.getItemId() == R.id.display) {
            display d = new display();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction tran = manager.beginTransaction();
            tran.replace(R.id.frag, d);
            tran.addToBackStack(null);
            tran.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.si_area;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
        if (item.getItemId() == R.id.si) {
            si s = new si();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction tran = manager.beginTransaction();
            tran.replace(R.id.frag, s);
            tran.commit();
        } else if (item.getItemId() == R.id.area) {
            area p = new area();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction tran = manager.beginTransaction();
            tran.replace(R.id.frag, p);
            tran.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}

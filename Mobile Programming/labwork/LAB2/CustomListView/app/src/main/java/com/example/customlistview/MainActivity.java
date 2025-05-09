package com.example.customlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        list = findViewById(R.id.list);
        String[] names ={"Computer", "Mobile", "Tablet", "Smart Tv", "Iphone"};
        String[] prices = {"40000","50000","450000","125000","450000"};
        int[] imgs = {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground};
        MyAdapter adapter = new MyAdapter(this, names, prices, imgs);
        list.setAdapter(adapter);
    }
    }

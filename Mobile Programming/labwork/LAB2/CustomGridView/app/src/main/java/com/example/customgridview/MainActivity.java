package com.example.customgridview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        grid = findViewById(R.id.grid);

        String[] names = {"Computer", "Mobile", "Tablet", "Smart Tv", "Iphone"};
        String[] prices = {"40000", "50000", "450000", "125000", "450000"};
        int[] imgs = {
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground
        };

        MyAdapter adapter = new MyAdapter(this, names, prices, imgs);
        grid.setAdapter(adapter);
    }
}
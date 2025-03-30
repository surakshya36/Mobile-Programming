package com.example.employeeentry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Display extends AppCompatActivity {
    TextView res_name, res_age, res_dep, res_sal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        res_name = findViewById(R.id.res_name);
        res_age = findViewById(R.id.res_age);
        res_dep = findViewById(R.id.res_dep);
        res_sal = findViewById(R.id.res_sal);

        Intent data = getIntent();
        String n = data.getStringExtra("name");
        String a = data.getStringExtra("age");
        String d = data.getStringExtra("dep");
        String s = data.getStringExtra("sal"); // Now correctly retrieved as String

        res_name.setText("Name : " + n);
        res_age.setText("Age : " + a);
        res_dep.setText("Department : " + d);
        res_sal.setText("Salary : " + s);
    }
}
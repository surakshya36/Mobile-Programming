package com.example.employeeentry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Entry extends AppCompatActivity {
    EditText name, age, sal, dep;
   Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        dep = findViewById(R.id.dep);
        sal = findViewById(R.id.sal);
        sub = findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String a = age.getText().toString();
                String d = dep.getText().toString();
                String s = sal.getText().toString();
                Intent i = new Intent(Entry.this, Display.class);
                i.putExtra("name", n);
                i.putExtra("age", a);
                i.putExtra("dep", d);
                i.putExtra("sal", s);
                startActivity(i);
            }
       });
    }
}

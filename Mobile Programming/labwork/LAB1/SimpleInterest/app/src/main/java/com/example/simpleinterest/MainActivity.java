package com.example.simpleinterest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText p, t, r;
    Button calc;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        p = findViewById(R.id.p);
        t = findViewById(R.id.t);
        r = findViewById(R.id.r);
        res = findViewById(R.id.res);
        calc = findViewById((R.id.calc));
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int principle, time, rate, interest;
                principle = Integer.parseInt(p.getText().toString());
                time = Integer.parseInt(t.getText().toString());
                rate = Integer.parseInt(r.getText().toString());
                interest= (principle*time*rate)/100;
                res.setText("Interest: "+interest);

            }
        });


    }
}
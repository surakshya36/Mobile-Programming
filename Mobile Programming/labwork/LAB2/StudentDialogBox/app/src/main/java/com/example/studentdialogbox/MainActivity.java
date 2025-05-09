package com.example.studentdialogbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView r_name, r_roll, r_ds, r_mp, r_aj, r_ae, r_np, result, grade;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        r_name = findViewById(R.id.r_name);
        r_roll = findViewById(R.id.r_roll);
        r_ds = findViewById(R.id.r_ds);
        r_mp = findViewById(R.id.r_mp);
        r_aj = findViewById(R.id.r_aj);
        r_ae = findViewById(R.id.r_ae);
        r_np = findViewById(R.id.r_np);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);
        grade = findViewById(R.id.grade);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
            }
        });
    }
    public void showdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Student Results");
        builder.setCancelable(true);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.student, null);
        EditText name = v.findViewById(R.id.name);
        EditText roll = v.findViewById(R.id.roll);
        EditText ds = v.findViewById(R.id.ds);
        EditText mp = v.findViewById(R.id.mp);
        EditText aj = v.findViewById(R.id.aj);
        EditText ae = v.findViewById(R.id.ae);
        EditText np = v.findViewById(R.id.np);
        Button save = v.findViewById(R.id.save);
        builder.setView(v);
        AlertDialog dialog = builder.create();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_name.setText("Student Name: " +name.getText().toString());
                r_roll.setText("Roll No: " +roll.getText().toString());
                r_ds.setText("Marks in DS: "+ds.getText().toString());
                r_mp.setText("Marks in MP: " +mp.getText().toString());
                r_aj.setText("Marks in AJ: "+aj.getText().toString());
                r_ae.setText("Marks in AE: " +ae.getText().toString());
                r_np.setText("Marks in NP: "+np.getText().toString());

                double mds = Double.parseDouble(ds.getText().toString());
                double mmp = Double.parseDouble(mp.getText().toString());
                double maj = Double.parseDouble(aj.getText().toString());
                double mae = Double.parseDouble(ae.getText().toString());
                double mnp = Double.parseDouble(np.getText().toString());
                if (mds>=40 && mmp>=40 && maj>=40 && mae >=40 && mnp>=40){
                    result.setText("Result: Pass");
                    double average = (mds + mmp + maj + mae + mnp) / 5.0;
                    if (average >= 80) {
                        grade.setText("Grade: A");
                    } else if (average >= 60) {
                        grade.setText("Grade: B");
                    } else {
                        grade.setText("Grade: C");
                    }
                }
                else {
                    result.setText("Result: Fail");
                    grade.setText("Grade: F");
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}

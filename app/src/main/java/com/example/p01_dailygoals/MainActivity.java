package com.example.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnDone;
    EditText etReflect;
    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDone = findViewById(R.id.buttonDone);
        etReflect = findViewById(R.id.editText);
        rg1 = findViewById(R.id.Rg1);
        rg2 = findViewById(R.id.Rg2);
        rg3 = findViewById(R.id.Rg3);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                RadioButton rb1 = findViewById(selectedButtonId1);
                RadioButton rb2 = findViewById(selectedButtonId2);
                RadioButton rb3 = findViewById(selectedButtonId3);

                String reflect = etReflect.getText().toString();
                String b1 = rb1.getText().toString();
                String b2 = rb2.getText().toString();
                String b3 = rb3.getText().toString();

                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("a1",b1);
                i.putExtra("a2",b2);
                i.putExtra("a3",b3);
                i.putExtra("a4",reflect);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        RadioGroup rg = findViewById(R.id.Rg1);
        RadioGroup r1g = findViewById(R.id.Rg2);
        RadioGroup r2g = findViewById(R.id.Rg3);

        rg.check(0);
        r1g.check(0);
        r2g.check(0);

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        int selectedButtonId1 = rg1.getCheckedRadioButtonId();
        int selectedButtonId2 = rg2.getCheckedRadioButtonId();
        int selectedButtonId3 = rg3.getCheckedRadioButtonId();
        String reflect = etReflect.getText().toString();
        prefEdit.putInt("q1",selectedButtonId1);
        prefEdit.putInt("q2",selectedButtonId2);
        prefEdit.putInt("q3",selectedButtonId3);
        prefEdit.putString("q4",reflect);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String reflect = prefs.getString("q4", "");
        etReflect.setText(reflect);

        int rg1 = prefs.getInt("q1",0);
        int rg2 = prefs.getInt("q2",0);
        int rg3 = prefs.getInt("q3",0);

        RadioGroup rg = findViewById(R.id.Rg1);
        RadioGroup r1g = findViewById(R.id.Rg2);
        RadioGroup r2g = findViewById(R.id.Rg3);

        rg.check(rg1);
        r1g.check(rg2);
        r2g.check(rg3);

    }
}

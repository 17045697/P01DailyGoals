package com.example.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView q1;
    TextView q2;
    TextView q3;
    TextView q4;
    Button btnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        q1 = findViewById(R.id.textViewq1);
        q2 = findViewById(R.id.textViewq2);
        q3 = findViewById(R.id.textViewq3);
        q4 = findViewById(R.id.textViewq4);
        btnClose = findViewById(R.id.buttonClose);

        Intent i = getIntent();
        String a1 = i.getStringExtra("a1");
        String a2 = i.getStringExtra("a2");
        String a3 = i.getStringExtra("a3");
        String a4 = i.getStringExtra("a4");

        q1.setText("Read up on materials before class: " + a1);
        q2.setText("Arrive on time so as not to miss important part of the lesson: "+a2);
        q3.setText("Attempt the problem myself: "+ a3);
        q4.setText("My personal reflection today: "+ a4);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}

package com.example.artifact_app_collection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle data = getIntent().getBundleExtra("data");
        String name1 = data.getString("name");
        String name2 = data.getString("email");
        String name3 = data.getString("username");
        String name4 = data.getString("password");

        t1=findViewById(R.id.text1);
        t2=findViewById(R.id.text2);
        t3=findViewById(R.id.text3);
        t4=findViewById(R.id.text4);
        b1=findViewById(R.id.button);
        t1.setText(name1);
        t2.setText(name2);
        t3.setText(name3);
        t4.setText(name4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, loginpage.class);

                startActivity(intent);

            }
        });
            }

    }

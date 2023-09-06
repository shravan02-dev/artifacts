package com.example.artifact_app_collection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView k,h;
    ImageView p,l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k = findViewById(R.id.item1);
        h= findViewById(R.id.item4);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyAdapter.class);
                startActivity(intent);
            }
        });
        p = findViewById(R.id.item2);

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, add_items.class);
                startActivity(intent);

            }
        });
        l = findViewById(R.id.item3);

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Delete.class);
                startActivity(intent);

            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = getIntent().getBundleExtra("data");
                Intent intent = new Intent(MainActivity.this, profile.class);
                intent.putExtra("data", data);
                startActivity(intent);

            }
        });
    }
}
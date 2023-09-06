package com.example.artifact_app_collection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Delete extends AppCompatActivity {
    private EditText itemIdEditText;
    private Button deleteButton;
    private DatabaseReference itemsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);




                itemIdEditText = findViewById(R.id.itemIdEditText);
                deleteButton = findViewById(R.id.deleteButton);
                itemsRef = FirebaseDatabase.getInstance().getReference("items");

                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String itemId = itemIdEditText.getText().toString().trim();

                        if (itemId.isEmpty()) {
                            Toast.makeText(Delete.this, "Please enter an item ID", Toast.LENGTH_SHORT).show();
                        } else {
                            deleteItem(itemId);
                        }
                    }
                });
            }

            private void deleteItem(String itemId) {
                DatabaseReference itemRef = itemsRef.child(itemId);
                itemRef.removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Delete.this, "Item deleted successfully", Toast.LENGTH_SHORT).show();
                                itemIdEditText.setText("");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Delete.this, "Failed to delete item", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }

package com.example.artifact_app_collection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class add_items extends AppCompatActivity {
    EditText ide,Name,Description,Address,Price;
    ImageView imageView;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    StorageReference storage;
    Uri imageuri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        ide = findViewById(R.id.item_id);
        Name = findViewById(R.id.item_name);
        Description = findViewById(R.id.item_address);
        Address = findViewById(R.id.item_description);
        Price = findViewById(R.id.item_price);
        imageView = findViewById(R.id.item6);
        signupButton = findViewById(R.id.signup_button);
        storage = FirebaseStorage.getInstance().getReference();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("items");


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, 2);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageuri != null){
                    uploadToFirebase(imageuri);
                }else{
                    Toast.makeText(add_items.this, "Please Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 2 && resultCode == RESULT_OK && data != null) {

                imageuri = data.getData();
                imageView.setImageURI(imageuri);
            }
        }
    private void uploadToFirebase(Uri uri){

        final StorageReference fileRef = storage.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String id = ide.getText().toString();
                        String name = Name.getText().toString();
                        String description = Description.getText().toString();
                        String address = Address.getText().toString();
                        String price = Price.getText().toString();
                       Model model = new Model(id,name,description,address,price,uri.toString());
                        reference.child(id).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(add_items.this, "successfully added", Toast.LENGTH_SHORT).show();
                            }

                        });

                        Toast.makeText(add_items.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.baseline_add_a_photo_24);
                        ide.setText("");
                        Name.setText("");
                        Description.setText("");
                        Address.setText("");
                        Price.setText("");
                    }
                });

            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(add_items.this, "Uploading Failed !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtension(Uri mUri){

        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));

    }


}



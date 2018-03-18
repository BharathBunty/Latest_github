package com.example.sharath.usersystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef = db.getReference();
    DatabaseReference userRef = myRef.child("Users");

    EditText username, name, email;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= findViewById(R.id.username);
        name  = findViewById(R.id.name);
        email = findViewById(R.id.email);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myUsername = username.getText().toString().trim();
                String myName = name.getText().toString().trim();
                String myEmail = email.getText().toString().trim();

                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("UserName", myUsername);
                userMap.put("Name", myName);
                userMap.put("Email", myEmail);

                userRef.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                      if (task.isSuccessful()){
                          Toast.makeText(MainActivity.this, "Sucessfully uploaded", Toast.LENGTH_SHORT).show();
                      } else {
                          Toast.makeText(MainActivity.this, "Fail to upload", Toast.LENGTH_SHORT).show();
                      }
                    }
                });
            }
        });



    }
}

package com.example.a314_debugging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private EditText usermail,password,confirmpassword;
private Button signup;
private TextView signin;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usermail = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        confirmpassword = findViewById(R.id.editText3);
        signup = findViewById(R.id.button);
        signin = findViewById(R.id.textView);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth=FirebaseAuth.getInstance();
                String mail=usermail.getText().toString();
                String pwd=password.getText().toString();
                String cpwd=confirmpassword.getText().toString();
                if (TextUtils.isEmpty(mail)){
                    usermail.setError("Enter Email");
                }
                if (TextUtils.isEmpty(pwd)){
                    password.setError("Enter Valid Password");
                }
                if (pwd.length()>=10){
                    password.setError("Enter Password less than 10 characters");
                }
                if (TextUtils.isEmpty(cpwd)){
                    confirmpassword.setError("Confrim Password should not be empty");
                }
                firebaseAuth.createUserWithEmailAndPassword(mail,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"User Created",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Registration Failed",Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(login);
            }
        });
    }
}

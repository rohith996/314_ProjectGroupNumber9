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
    FirebaseAuth mfirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mfirebaseAuth=FirebaseAuth.getInstance();
        usermail = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        confirmpassword = findViewById(R.id.editText3);
        signup = findViewById(R.id.button);
        signin = findViewById(R.id.textView);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail=usermail.getText().toString();
                String pwd=password.getText().toString();
                String cpwd=confirmpassword.getText().toString();
                if (mail.isEmpty()){
                    usermail.setError("Enter Email");
                    usermail.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Enter Valid Password");
                    password.requestFocus();
                }
                else if (!cpwd.equals(pwd)){
                    confirmpassword.setError("Password does not match");
                    confirmpassword.requestFocus();
                }
                else if (mail.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else if(!(mail.isEmpty() && pwd.isEmpty())) {
                    mfirebaseAuth.createUserWithEmailAndPassword(mail, pwd).addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "User Created", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
                else {
                    Toast.makeText(MainActivity.this,"Error occurred",Toast.LENGTH_LONG).show();
                }
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

package com.example.cn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {
    private String email = "";
    private String password = "";
    private FirebaseAuth mAuth;
    DatabaseReference mdatabase;


    private EditText tv1, tv2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        mdatabase = FirebaseDatabase.getInstance().getReference();

        tv1 = (EditText) findViewById(R.id.tv1);
        tv2 = (EditText) findViewById(R.id.tv2);
        checkCurrentUser();
    }

    public void checkCurrentUser() {
        // [START check_current_user]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(login.this, MainActivity.class);
            startActivity(i);
            finish();
            Toast.makeText(login.this, "usuario registrado", Toast.LENGTH_SHORT).show();
        } else {

            // No user is signed in
        }
        // [END check_current_user]
    }


    public void  btnuno(View view){
        email = tv1.getText().toString();
        password = tv2.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            loginuswer();


        } else {
            //   StyleableToast.makeText(login.this,"complete los compos",R.style.exampleToast).show();
            Toast.makeText(login.this, "complete los campos", Toast.LENGTH_SHORT).show();
        }



    }
    public void loginuswer(){

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(login.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(login.this, "contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void reg(View view){
        startActivity(new Intent(login.this,resgistro.class));
        finish();
    }
    public void reset(View view){
        startActivity(new Intent(login.this,recuperar.class));
        finish();
    }

}
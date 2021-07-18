package com.example.cn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class recuperar extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnResetPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);


        edtEmail = (EditText) findViewById(R.id.et5);
        btnResetPassword = (Button) findViewById(R.id.butom);


        mAuth = FirebaseAuth.getInstance();

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.setLanguageCode("es");
                String email = edtEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mAuth.setLanguageCode("es");
                    Toast.makeText(getApplicationContext(), "¡Introduce tu correo electrónico!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.sendPasswordResetEmail(email)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    mAuth.setLanguageCode("es");
                                    startActivity(new Intent(recuperar.this, login.class));
                                    finish();
                                    edtEmail.setText("");
                                    Toast.makeText(recuperar.this, "te enviamos enlase en tu correo!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(recuperar.this, "El correo no esta registrado", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });


    }
}

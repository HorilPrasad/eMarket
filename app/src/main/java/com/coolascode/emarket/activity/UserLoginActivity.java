package com.coolascode.emarket.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.coolascode.emarket.R;

public class UserLoginActivity extends AppCompatActivity {

    TextInputEditText userLoginEmail, userLoginPass;
    FirebaseAuth mAuth;
    Button loginBtn;
    TextView forgetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        userLoginEmail = findViewById(R.id.login_email_edit_text);
        userLoginPass = findViewById(R.id.login_password_edit_text);
        loginBtn = findViewById(R.id.login_btn);
        mAuth = FirebaseAuth.getInstance();
        forgetPass = findViewById(R.id.forget_password);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserLoginActivity.this, ForgetPasswordActivity.class);

                startActivity(i);

                // close this activity


            }
        });
    }

    public void SignBtn(View view) {

        Intent i = new Intent(UserLoginActivity.this, UserSignUpActivity.class);

        startActivity(i);

    }

    private void login() {
        String email = userLoginEmail.getText().toString();
        String password = userLoginPass.getText().toString();

        if (email.isEmpty()) {
            userLoginEmail.setError("Email can't be Empty!");
            userLoginEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userLoginEmail.setError("Invalid Email!");
            userLoginEmail.requestFocus();
        } else if (password.isEmpty()) {
            userLoginPass.setError("Password can't be Empty!");
            userLoginPass.requestFocus();
        } else {

//            loading();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
//                                loading.dismiss();
//                                currentUser = mAuth.getCurrentUser();\
                                Toast.makeText(UserLoginActivity.this, "Authentication Successfull",
                                        Toast.LENGTH_SHORT).show();
                                sentToMainActivity();
                            } else {
                                // If sign in fails, display a message to the user.
//                                loading.dismiss();
                                Toast.makeText(UserLoginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                                // ...
                            }

                            // ...
                        }
                    });
        }
    }

    private void sentToMainActivity() {
        Intent i = new Intent(UserLoginActivity.this, MainActivity.class);
        startActivity(i);
    }
}
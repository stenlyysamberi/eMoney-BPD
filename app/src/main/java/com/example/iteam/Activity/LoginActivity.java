package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iteam.MainActivity;
import com.example.iteam.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    private TextView login;
    CardView cardlogin;
    EditText email,password;
   LoadingDialog loadingDialog;
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         loadingDialog = new LoadingDialog(LoginActivity.this);

        cardlogin = findViewById(R.id.card_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);


        login = findViewById(R.id.login_google);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginGoogle();
            }
        });

       cardlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String mail = email.getText().toString();
               String psw  = password.getText().toString();

               loadingDialog.loadingAlert();
               if (mail.isEmpty()){
                   Toast.makeText(getApplicationContext(), "mail empty", Toast.LENGTH_SHORT).show();
                   loadingDialog.dismissDialog();
               }else if(psw.isEmpty()){
                   Toast.makeText(getApplicationContext(), "password empty", Toast.LENGTH_SHORT).show();
                   loadingDialog.dismissDialog();
               }else if(mail.isEmpty() && psw.isEmpty()){
                   Toast.makeText(getApplicationContext(), "mail & password empty", Toast.LENGTH_SHORT).show();
                   loadingDialog.dismissDialog();
               }else{
                   loginEmail(mail,psw);
               }
           }
       });

    }

    private void LoginGoogle() {
        loadingDialog.loadingAlert();
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }
    @Override    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
            loadingDialog.dismissDialog();
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {
            final GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            if (!account.getId().equals("")&&!account.getId().equals(null)){

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "nama" + account.getPhotoUrl() , Toast.LENGTH_SHORT).show();
                startActivity(i);
                finish();
            }else{
                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();            }
        } catch (ApiException e) {
            Log.d("error", ""+e);
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();        }
    }


    private void loginEmail(String email, String Password){

        if (email.equals("admin") && Password.equals("admin")){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            loadingDialog.dismissDialog();
        }else{
            Toast.makeText(getApplicationContext(), "invalid login", Toast.LENGTH_SHORT).show();
            loadingDialog.dismissDialog();
        }
    }

    public void login(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        finish();
    }
}
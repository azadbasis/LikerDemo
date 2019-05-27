package com.liker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainLog extends AppCompatActivity {
    EditText editEmail, editPassword, editName;
    Button btnSignIn, btnRegister;

    String URL= "http://10.0.2.2/test_android/index.php";



    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlog);

        editEmail=(EditText)findViewById(R.id.editEmail);
        editName=(EditText)findViewById(R.id.editName);
        editPassword=(EditText)findViewById(R.id.editPassword);

        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainLog.this, "sign in", Toast.LENGTH_SHORT).show();
              //  AttemptLogin attemptLogin= new AttemptLogin();
             //   attemptLogin.execute(editName.getText().toString(),editPassword.getText().toString(),"");
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i==0)
                {
                    i=1;
                    editEmail.setVisibility(View.VISIBLE);
                    btnSignIn.setVisibility(View.GONE);
                    btnRegister.setText("CREATE ACCOUNT");
                    Toast.makeText(MainLog.this, "create account", Toast.LENGTH_SHORT).show();
                }
                else{

                    btnRegister.setText("REGISTER");
                    editEmail.setVisibility(View.GONE);
                    btnSignIn.setVisibility(View.VISIBLE);
                    i=0;
                    Toast.makeText(MainLog.this, "Register", Toast.LENGTH_SHORT).show();
                   // AttemptLogin attemptLogin= new AttemptLogin();
//                    attemptLogin.execute(editName.getText().toString(),editPassword.getText().toString(),editEmail.getText().toString());

                }

            }
        });


    }



}
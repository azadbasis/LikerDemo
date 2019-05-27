package com.liker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;


public class ViewFlipp extends AppCompatActivity {


    private ViewFlipper viewFlipper;

    //Login form views
    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        if (checkAuthentication()) {
            displayDashboard();
        } else {
            displayLoginForm();
        }
    }

    private boolean checkAuthentication() {
        //Logic here to check if there's a user that's already logged in
        return true;
    }

    public void displayDashboard() {
        if (viewFlipper.getDisplayedChild() != 0) {
            viewFlipper.setDisplayedChild(0);
        }
        //Any other steps to initialize the dashboard can be written here
    }

    private void displayLoginForm() {
        viewFlipper.setDisplayedChild(1);

        usernameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Force the keyboard to be hidden when the button is pressed
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(
                        getCurrentFocus().getWindowToken(), 0);

                //One request at a time
                disableLoginButton();

                //You may have to try/catch this if you're submitting using
                //http request with the values entered in the inputs
                //(and do it in an asynchronous task)
                submitAndProcessAuthenticationRequest();
            }
        });
    }

    private void disableLoginButton() {
        loginButton.setClickable(false);
    }

    private void submitAndProcessAuthenticationRequest() {
        // Authentication request submission logic here,
        // probably create AsyncTask that handles the submission/response
        // and display the dashboard if successful.

        //For now, just display the dashboard.
        displayDashboard();
    }

    public void enableLoginButton(){
        loginButton.setClickable(true);
    }
}
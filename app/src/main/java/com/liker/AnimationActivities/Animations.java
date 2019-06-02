package com.liker.AnimationActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liker.MainActivity;
import com.liker.R;

public class Animations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
    }

    public void openActivity2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
     //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}

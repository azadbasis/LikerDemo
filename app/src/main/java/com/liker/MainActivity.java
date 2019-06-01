package com.liker;



import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.view_flipp);
        TextView textView = new TextView(this);
        textView.setText("Dynamically added TextView");
        textView.setGravity(Gravity.CENTER);

        viewFlipper.addView(textView);

        //viewFlipper.setFlipInterval(2000);
        //viewFlipper.startFlipping();
    }

    public void previousView(View v) {
        viewFlipper.setInAnimation(this, R.anim.slideinright);
        viewFlipper.setOutAnimation(this, R.anim.slideoutleft);
        viewFlipper.showPrevious();
    }

    public void nextView(View v) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showNext();
    }

    public void openActivity3(View view) {
        Intent intent = new Intent(this, ScreenTest.class);
        startActivity(intent);
    }

   /* @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }*/
}
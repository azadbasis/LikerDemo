package com.liker;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.liker.model.Data;
import com.liker.model.Resend;
import com.liker.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenTest extends AppCompatActivity implements ExampleBottomSheetDialog.BottomSheetListener{
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bottom);

        mTextView = findViewById(R.id.text_view_button_clicked);

        Button buttonOpenBottomSheet = findViewById(R.id.button_open_bottom_sheet);
        buttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleBottomSheetDialog bottomSheet = new ExampleBottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });
    }

    public void goNetwork(View view) {

        MyWebservice webService =
                MyWebservice.retrofit.create(MyWebservice.class);
      Call<Resend> call= webService.dataItems("28802");
        sendRequest(call);
    }

    private void sendRequest(Call<Resend> call) {
        call.enqueue(new Callback<Resend>() {
            @Override
            public void onResponse(Call<Resend> call, Response<Resend> response) {
                Resend message = response.body();
                String d=message.getMessage();
                Log.d("Message",d);

                ExampleBottomSheetDialog bottomSheet = ExampleBottomSheetDialog.newInstance(message);

                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            }

            @Override
            public void onFailure(Call<Resend> call, Throwable t) {

            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        mTextView.setText(text);
    }
}

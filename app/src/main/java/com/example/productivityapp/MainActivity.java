package com.example.productivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.text1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(30000, 1000){

                    @Override
                    public void onTick(long millisUntilFinish) {
                       textView.setText(String.valueOf(counter));
                       counter++;
                    }

                    @Override
                    public void onFinish() {
                        textView.setText("FINISH!!");
                    }
                }.start();
            }
        });



        /*TextView firstText;
        Button firstButton;

        firstText = (TextView) findViewById(R.id.my_text_view);
        firstButton = (Button) findViewById(R.id.button);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstText.setText("Hi Matthew");
            }
        });*/


    }
}
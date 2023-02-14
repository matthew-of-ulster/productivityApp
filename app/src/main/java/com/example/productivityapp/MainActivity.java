package com.example.productivityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    Button button;
    TextView textView;

    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.text1);
        progress = (ProgressBar) findViewById(R.id.timerProgress1);
        progress.setProgress(100);
        counter = 5;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(5000, 1000){

                    @Override
                    public void onTick(long millisUntilFinish) {
                       textView.setText(String.valueOf(counter));
                       progress.setProgress(counter*20);
                       counter--;

                    }

                    @Override
                    public void onFinish() {
                        textView.setText("FINISH!!");
                        createNotification(view);
                        progress.setProgress(0);
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
    public void createNotification(View view) {

        Intent i = new Intent(this, NotificationBroadcast.class);
        sendBroadcast(i);
    }
}


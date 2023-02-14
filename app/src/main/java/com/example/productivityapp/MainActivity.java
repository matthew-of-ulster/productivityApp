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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    TextView textView;
    EditText timer1Et;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer1Et = (EditText) findViewById(R.id.timerEditText);
        textView = (TextView) findViewById(R.id.text1);
        progress = (ProgressBar) findViewById(R.id.timerProgress1);
        progress.setProgress(100);
        //int counterMax = 5;

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counterMax = 5;
                String input = String.valueOf(timer1Et.getText());

                if(!input.equals("")) {
                    counterMax = Integer.parseInt(String.valueOf(timer1Et.getText()));
                }
                progress.setProgress(100);
                counter = counterMax;
                int finalCounterMax = counterMax;
                new CountDownTimer(finalCounterMax*1000, 1000){

                    @Override
                    public void onTick(long millisUntilFinish) {
                       textView.setText(String.valueOf(counter));
                       progress.setProgress(counter*(100/ finalCounterMax));
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
    }
    public void createNotification(View view) {

        Intent i = new Intent(this, NotificationBroadcast.class);
        sendBroadcast(i);
    }
}


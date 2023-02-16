package com.example.productivityapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimerFragment extends Fragment {

    public int counter;
    TextView textView;
    EditText timer1Et;
    ProgressBar progress;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TimerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimerFragment newInstance(String param1, String param2) {
        TimerFragment fragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        TextView middleText;
        middleText= (TextView) view.findViewById(R.id.text1);
        middleText.setText("Nice");

        timer1Et = (EditText) view.findViewById(R.id.timerEditText);
        textView = (TextView) view.findViewById(R.id.text1);
        progress = (ProgressBar) view.findViewById(R.id.timerProgress1);
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
                        //createNotification(view);
                        progress.setProgress(0);
                    }
                }.start();
            }
        });



        return view;
    }
    /*
    public void createNotification(View view) {

        Intent i = new Intent(this, NotificationBroadcast.class);
        sendBroadcast(i);
    }
     */
}
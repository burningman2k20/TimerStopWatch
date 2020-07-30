package com.example.timerstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.os.CountDownTimer;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Chronometer timer;
    long total = (1000 * 60) * 10;
    //EditText timer;
    //CountDownTimer myCountDownTimer;
    Button startBtn, pauseBtn, resetBtn;
    Button startTimerBtn, pauseTimerBtn, resetTimerBtn;
    long stopTime = 0, stopTimer = 0;
    //MyCountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer)findViewById(R.id.chronometer);
        startBtn = (Button)findViewById(R.id.startBtn);
        pauseBtn = (Button)findViewById(R.id.pauseBtn);
        resetBtn = (Button)findViewById(R.id.resetBtn);

        timer = (Chronometer)findViewById(R.id.txtTimer);
        startTimerBtn = (Button)findViewById(R.id.startTimerBtn);
        pauseTimerBtn = (Button)findViewById(R.id.pauseTimerBtn);
        resetTimerBtn = (Button)findViewById(R.id.resetTimerBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime() + stopTime);
                chronometer.start();
                startBtn.setVisibility(View.GONE);
                resetBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.VISIBLE);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                stopTime = 0;
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

        startTimerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setBase(total + SystemClock.elapsedRealtime());

                timer.start();
                timer.setCountDown(true);
                //timer.setBase(SystemClock.elapsedRealtime() + stopTimer);
                /*myCountDownTimer = new MyCountDownTimer(120000, 1000);
                myCountDownTimer.start();
                //String timeStr = "01:00";
                //timer.setBase(convertToDate(timeStr));
                //timer.start();
                //timer.setText(String.format("%.2d:%.2d",myCountDownTimer.minutes, myCountDownTimer.seconds));
                timer.setText(myCountDownTimer.progress);
*/
                /*myCountDownTimer = new CountDownTimer(
                        6000, 1000) {
                    //@Override
                    public void onTick(long millisUntilFinished) {

                        int time = (int) millisUntilFinished;
                        int seconds = time / 1000 % 60;
                        int minutes = (time / (1000 * 60)) % 60;
                        timer.setText(twoDigitString(minutes)  + " min: "+ twoDigitString(seconds)+ " sec");
                    }
                    private String twoDigitString(long number) {
                        if (number == 0) {
                            return "00";
                        } else if (number / 10 == 0) {
                            return "0" + number;
                        }
                        return String.valueOf(number);
                    }
                    //@Override
                    public void onFinish() {
                        timer.setText("00:00");
                    }
                };
             */   startTimerBtn.setVisibility(View.GONE);
                resetTimerBtn.setVisibility(View.VISIBLE);
                //pauseTimerBtn.setVisibility(View.VISIBLE);
            }
        });

        pauseTimerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stopTimer1 = timer.getBase() - SystemClock.elapsedRealtime();
                timer.stop();
                startTimerBtn.setVisibility(View.VISIBLE);
                //pauseTimerBtn.setVisibility(View.GONE);
            }
        });

        resetTimerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timer.setBase(SystemClock.elapsedRealtime());
                //stopTimer = 0;
                timer.stop();
                //myCountDownTimer.cancel();

                startTimerBtn.setVisibility(View.VISIBLE);
                //pauseTimerBtn.setVisibility(View.GONE);
                resetTimerBtn.setVisibility(View.GONE);
            }
        });
    }

    private long convertToDate(String str)
    {
        try
        {
            DateFormat mDateTimeFormat = new SimpleDateFormat("HH:MM");

            Date date = mDateTimeFormat.parse(str);
        } catch (java.text.ParseException e)
        {
            e.printStackTrace();
        }
        return SystemClock.currentThreadTimeMillis();//.elapsedRealtime();
    }
}
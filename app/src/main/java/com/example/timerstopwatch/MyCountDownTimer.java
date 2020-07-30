/*
package com.example.timerstopwatch;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

public class MyCountDownTimer extends CountDownTimer {

        public String progress;
        long prog;
        long minutes = 10;
        long seconds = 00;
        String FORMAT = "%02d:%02d:%02d";

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            prog = millisInFuture;
            this.progress = String.format("%d:%d",minutes, seconds);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int time = (int) millisUntilFinished;
            int seconds = time / 1000 % 60;
            int minutes = (time / (1000 * 60)) % 60;
            timer.setText(twoDigitString(minutes)  + " min: "+ twoDigitString(seconds)+ " sec");
            seconds -= 1;
            //this.progress = String.format("%d",millisUntilFinished);
//            this.progress = "" + String.format(FORMAT,
//                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
//                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
//                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
//                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
//                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            */
/*long progress = (int) (millisUntilFinished/1000);
            minutes = TimeUnit.MILLISECONDS.toMinutes(progress);
            seconds = TimeUnit.MILLISECONDS.toSeconds(progress);
            seconds -= 1;

            if (seconds < 0){
                seconds = 60;
                minutes -= 1;
            }

            if (minutes < 0 && seconds == 0) {
                this.cancel();
            }

            this.progress = String.format("%.2d:%.2d",minutes, seconds);*//*

                    //progress.toString();

            //progressBar.setProgress(progressBar.getMax()-progress);
        }

    private String twoDigitString(long number) {
        if (number == 0) {
            return "00";
        } else if (number / 10 == 0) {
            return "0" + number;
        }
        return String.valueOf(number);
    }
        @Override
        public void onFinish() {
            // finish();
        }

}
*/

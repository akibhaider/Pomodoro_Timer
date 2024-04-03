package org.example.lab07_210041222;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    @FXML
    public Label LabelText;
    @FXML
    private TextField minute_Text;
    @FXML
    private TextField second_Text;
    @FXML
    public Button play_pause_button;
    @FXML
    private Button reset_button;

    int minute;
    int second;
    public int timer_id;
    boolean is_play;
    boolean cnt;

    Timer timer;
    TimerTask task;

    @FXML
    public void initialize_pomodoro_timer() {
        LabelText.setText("Pomodoro Timer");
        timer_id=0;
        is_play=true;
        minute_Text.setText("0");
        second_Text.setText("10");
        minute = 0;
        second = 10;
        play_pause_button.setText("⏸️");
    }
    @FXML
    public void initialize_shortBreak_timer() {
        LabelText.setText("Short Break Timer");
        timer_id=1;
        is_play=true;
        minute_Text.setText("0");
        second_Text.setText("5");
        minute = 0;
        second = 5;
        play_pause_button.setText("⏸️");
    }
    @FXML
    public void initialize_longBreak_timer() {
        LabelText.setText("Long Break Timer");
        timer_id=2;
        is_play=true;
        minute_Text.setText("0");
        second_Text.setText("15");
        minute = 0;
        second = 15;
        play_pause_button.setText("⏸️");
    }
    @FXML
    public void Select_Pomodoro_timer() {
        initialize_pomodoro_timer();
        StartTimer();
    }
    @FXML
    public void Select_Sbreak_timer() {
        initialize_shortBreak_timer();
        StartTimer();
    }

    @FXML
    public void Select_Lbreak_timer() {
        initialize_longBreak_timer();
        StartTimer();
    }
    @FXML
    public void StartTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if (second == 0) {
                    if (minute == 0) {
                        timer.cancel();
                        // Session Completed
//                        if(timer_id==0){
//                            Select_Sbreak_timer();
//                        }else if(timer_id==1){
//                            Select_Pomodoro_timer();
//                        }
                        return;
                    }
                    second = 59;
                    minute--;
                } else {
                    second--;
                }
                minute_Text.setText(String.valueOf(minute));
                second_Text.setText(String.valueOf(second));
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
    @FXML
    public void play_pause_button_clicked() {
        if(is_play) {
            is_play=false;
            timer.cancel();
            play_pause_button.setText("▶️");
        }else{
            is_play=true;
            StartTimer();
            play_pause_button.setText("⏸️");
        }
    }
    @FXML
    public void reset_button_clicked() {
        if(timer_id==0){
            initialize_pomodoro_timer();
        }else if(timer_id==1){
            initialize_shortBreak_timer();
        } else if (timer_id==2) {
            initialize_longBreak_timer();
        }
        StartTimer();
    }
}
//       if (cnt){
//        if(timer_id==0){
//        LabelText.setText("Short Break Timer");
//Select_Sbreak_timer();
//            }else if(timer_id==1){
//        LabelText.setText("Pomodoro Timer");
//Select_Pomodoro_timer();
//            }
//                    }
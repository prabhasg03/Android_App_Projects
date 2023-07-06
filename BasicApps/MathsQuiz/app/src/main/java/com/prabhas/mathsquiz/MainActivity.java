package com.prabhas.mathsquiz;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity{
    Random random = new Random();
    Button bt0, bt1, bt2, bt3;
    CountDownTimer cdt;
    String op="";
    TextView questionTextView;
    TextView scoretv;
    TextView answ;
    TextView timer;
    Button pa;
    int cai, score, noq;
    ArrayList<Integer> ans = new ArrayList<>();
    int a, b, t, sol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        questionTextView = findViewById(R.id.questiontv);
        scoretv = findViewById(R.id.scoretv);
        answ = findViewById(R.id.anstv);
        timer = findViewById(R.id.timertv);
        pa = findViewById(R.id.playagainbt);
    }

    public void onStart(View view) {
        Toast.makeText(this, "Quiz started!", Toast.LENGTH_SHORT).show();
        ConstraintLayout main = findViewById(R.id.main);
        ConstraintLayout quiz = findViewById(R.id.quiz);
        main.setVisibility(View.INVISIBLE);
        quiz.setVisibility(View.VISIBLE);
        getNewQuestion();
        score = 0;
        noq = 0;
        setScore();
        answ.setText("");
    }

    public void exit(View view) {
        finish();
    }

    public void onOptionsClick(View view) {
        if (Integer.toString(cai).equals(view.getTag().toString())) {
            score++;
            answ.setVisibility(View.VISIBLE);
            answ.setText("Correct!");
            noq++;
        } else {
            noq++;
            answ.setVisibility(View.VISIBLE);
            answ.setText("Wrong!");
        }
        setScore();
        getNewQuestion();
    }

    public void onPlayAgain(View view) {
        getNewQuestion();
        pa.setVisibility(View.INVISIBLE);
        LinearLayout le=findViewById(R.id.qbox);
        le.setVisibility(View.VISIBLE);
    }

    private void setScore() {
        scoretv.setText(score + "/" + noq);
    }

    private void getNewQuestion() {
        a = random.nextInt(100);
        b = random.nextInt(100);
        cai = random.nextInt(4);
        t = random.nextInt(4);
        switch (t) {
            case 0:
                questionTextView.setText(a + "+" + b + " = ?");
                sol = a + b;
                op="+";
                break;
            case 1:
                questionTextView.setText(a + "-" + b + " = ?");
                sol = a - b;
                op="-";
                break;
            case 2:
                questionTextView.setText(a + "x" + b + " = ?");
                sol = a * b;op="*";
                break;
            case 3:
                questionTextView.setText(a + "÷" + b + " = ?");
                sol = a / b;op="/";
                break;
            default:
                break;
        }
        ans.clear(); // Clear the ArrayList before adding new answer choices
        for (int i = 0; i < 4; i++) {
            if (i == cai) {
                ans.add(cai,sol);
            } else {
                int wa = random.nextInt(Integer.max(a + b, a * b));
                while (wa == a + b) {
                    wa = random.nextInt(Integer.max(a + b, a * b));
                }
                ans.add(i,wa);
            }
        }
        bt0.setText(Integer.toString(ans.get(0)));
        bt1.setText(Integer.toString(ans.get(1)));
        bt2.setText(Integer.toString(ans.get(2)));
        bt3.setText(Integer.toString(ans.get(3)));
        setTimer();
    }

    private void setTimer(){
        if(cdt!=null){
            cdt.cancel();}
            cdt=new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long l) {
                    timer.setText("Time left: " + l / 1000 + "s");
                }

                @Override
                public void onFinish() {
                    timer.setText("Timeout:");
                    pa.setVisibility(View.VISIBLE);
                    answ.setText(Integer.toString(a)+op+Integer.toString(b)+"="+Integer.toString(sol));
                    LinearLayout le=findViewById(R.id.qbox);
                    le.setVisibility(View.INVISIBLE);
                    cancel();
                }
            }.start();
        }
    }

package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Example2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView scoreBoard;
    private Button increaseScore,decreaseScore;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);
        scoreBoard = findViewById(R.id.scoreBoard);
        increaseScore = findViewById(R.id.increaseScore);
        decreaseScore = findViewById(R.id.decreaseScore);

        if (LastScore()!=0){
            score = LastScore();
            scoreBoard.setText("Score : "+score);
        }


        increaseScore.setOnClickListener(this);
        decreaseScore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.increaseScore){

            score+=10;
            scoreBoard.setText("Score : "+score);
            saveScore(score);

        } else if (v.getId()==R.id.decreaseScore) {
            if (score>=10){

                score-=10;
                scoreBoard.setText("Score : "+score);
                saveScore(score);
            }
        }

    }

    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore", score);
        editor.apply();
    }

    public int LastScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("lastScore", 0);
    }


}
package com.example.dineshbalajivenkataraman.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView history = (TextView) findViewById(R.id.history_quiz);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quizName = "History Quiz";
                Intent his = new Intent(HomePageActivity.this, com.example.dineshbalajivenkataraman.views.MultipleChoice.class);
                his.putExtra("Integer Position", 0);
                his.putExtra("Quiz Name", "History Quiz");
                startActivity(his);
            }
        });
        TextView computer = (TextView) findViewById(R.id.computer_quiz);
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comp = new Intent(HomePageActivity.this, com.example.dineshbalajivenkataraman.views.MultipleChoice.class);
                comp.putExtra("Integer Position", 1);
                comp.putExtra("Quiz Name", "Computer Quiz");
                startActivity(comp);
            }
        });
        TextView science = (TextView) findViewById(R.id.science_quiz);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent science = new Intent(HomePageActivity.this, com.example.dineshbalajivenkataraman.views.MultipleChoice.class);
                science.putExtra("Integer Position", 2);
                science.putExtra("Quiz Name", "Science Quiz");
                startActivity(science);
            }
        });
    }
}

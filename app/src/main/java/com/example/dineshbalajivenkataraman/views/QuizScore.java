package com.example.dineshbalajivenkataraman.views;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dineshbalajivenkataraman.quizapp.R;
import static android.R.attr.value;

public class QuizScore extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);
        final Intent intent = getIntent();
        int position = intent.getIntExtra("Integer Position", value);
        final String QuizName = intent.getStringExtra("Quiz Name");
        Log.i("QuizScore", "----------Position---------->"+position);
        Log.i("QuizScore", "--------Quiz Name------------>"+QuizName);
        applyColor(QuizName);
        displayScore(position, QuizName);
        Button submit = (Button)findViewById(R.id.homePage);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intents = new Intent(QuizScore.this,com.example.dineshbalajivenkataraman.quizapp.HomePageActivity.class);
                startActivity(intents);
            }
        });
    }
    public void displayScore(int i, String Qname)
    {
        TextView toptitle = (TextView)findViewById(R.id.yourScoreText);
        TextView score = (TextView)findViewById(R.id.totalScore);

        if(Qname.equals("Science Quiz"))
        {
            toptitle.setText("Your Science Quiz Score");
            Intent scienc = getIntent();
            int sci_scr = scienc.getIntExtra("Science Correct Answer", -1);
            score.setText(Integer.toString(sci_scr) +"/4");
            Toast.makeText(QuizScore.this, "Correct Answers: " + Integer.toString(sci_scr) +"/4",Toast.LENGTH_LONG).show();
        }
       else if(Qname.equals("History Quiz")) {
            toptitle.setText("Your History Quiz Score");
            Intent his = getIntent();
            int his_scr = his.getIntExtra("History Correct Answer", -1);
            score.setText(Integer.toString(his_scr)+"/4");
            Toast.makeText(QuizScore.this, "Correct Answers: " + Integer.toString(his_scr)+"/4",Toast.LENGTH_LONG).show();
        }
        else
        {
            toptitle.setText("Your Computer Quiz Score");
            Intent comp = getIntent();
            int comp_scr = comp.getIntExtra("Computer Correct Answer", -1);
            score.setText(Integer.toString(comp_scr)+"/4");
            Toast.makeText(QuizScore.this, "Correct Answers: " + Integer.toString(comp_scr)+"/4",Toast.LENGTH_LONG).show();
        }
    }
    public void applyColor(String qName) {
        if (qName.equals("History Quiz")) {
            getSupportActionBar().setTitle("History Quiz");
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#E57373"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#E53935"));
        } else if (qName.equals("Computer Quiz")) {
            getSupportActionBar().setTitle("Computer Quiz");
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#64B5F6"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2196F3"));
        }
        if (qName.equals("Science Quiz")) {
            getSupportActionBar().setTitle("Science Quiz");
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#009688"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#00695C"));
        }
    }
}

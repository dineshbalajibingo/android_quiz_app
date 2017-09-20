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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dineshbalajivenkataraman.com.example.dineshbalajivenkataraman.classes.MultipleChoiceQuizData;
import com.example.dineshbalajivenkataraman.quizapp.R;

import java.util.ArrayList;

import static android.R.attr.value;

public class MultipleChoice extends AppCompatActivity {
    ArrayList<MultipleChoiceQuizData> qz;
    public static int history_correct_answer = 0;
    public static int computer_correct_answer = 0;
    public static int science_correct_answer = 0;
    public static int selectId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);
        qz = new ArrayList<>();
        qz.add(new MultipleChoiceQuizData("Q 1/4 Who was the first Western explorer to reach China?", "Magellan", "Cook", "Marco Polo", "Sir Dake"));
        qz.add(new MultipleChoiceQuizData("Q 1/4 ISP stands for", "Internet Service Provider", "International Service Provider", "Internet Service Presenter", "None of the above"));
        qz.add(new MultipleChoiceQuizData("Q 1/4 What is the closest planet to the Sun?", "Mercury", "Saturn", "Pluto", "Jupiter"));
        Intent intent = getIntent();
        int position = intent.getIntExtra("Integer Position", value);
        final String QuizName = intent.getStringExtra("Quiz Name");
        Log.i("MultipleChoice", "Position " + position);
        Log.i("MultipleChoice", "Quiz Name " + QuizName);
        applyColor(QuizName);
        displayQA(position, qz, QuizName);
    }
    public void displayQA(final int i, final ArrayList<MultipleChoiceQuizData> qz, final String Qname) {
        RadioGroup rg;
        String question = qz.get(i).getQuestion();
        TextView quest = (TextView) findViewById(R.id.question);
        quest.setText(question);
        String chOne = qz.get(i).getChoice_one();
        TextView choice_one = (TextView) findViewById(R.id.questOne);
        choice_one.setText(chOne);
        String chTwo = qz.get(i).getChoice_two();
        TextView choice_two = (TextView) findViewById(R.id.questTwo);
        choice_two.setText(chTwo);
        String chThree = qz.get(i).getChoice_three();
        TextView choice_three = (TextView) findViewById(R.id.questThree);
        choice_three.setText(chThree);
        String chFour = qz.get(i).getChoice_four();
        TextView choice_four = (TextView) findViewById(R.id.questFour);
        choice_four.setText(chFour);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                selectId = checkedId;
                switch (checkedId) {
                    case R.id.questOne:
                        if (Qname.equals("Science Quiz")) {
                            science_correct_answer += 1;
                            qz.get(i).setScience_score(science_correct_answer);
                        }
                        break;
                    case R.id.questTwo:
                        if (Qname.equals("Computer Quiz")) {
                            computer_correct_answer += 1;
                            Log.i("MultipleChoice", "Computer Correct Answer" + computer_correct_answer);
                            qz.get(i).setComputer_score(computer_correct_answer);
                        }
                        break;
                    case R.id.questThree:
                        if (Qname.equals("History Quiz")) {
                            history_correct_answer += 1;
                            Log.i("MultipleChoice", "History Correct Answer" + history_correct_answer);
                            qz.get(i).setHistory_score(history_correct_answer);
                        }
                        break;
                    case R.id.questFour:
                        break;
                }
            }
        });

        clickNext(Qname, rg, i);
    }
    public void clickNext(final String Qname, final RadioGroup rgroup, final int index) {
        Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (rgroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select an Answer", Toast.LENGTH_LONG).show();
                } else {
                    if (Qname.equals("History Quiz")) {
                        Intent his = new Intent(MultipleChoice.this, com.example.dineshbalajivenkataraman.views.CheckBoxDisplay.class);
                        his.putExtra("History Correct Answer", qz.get(index).getHistory_score());
                        his.putExtra("Integer Position", 0);
                        Log.i("MultipleChoice", "Value score from Setter for History Quiz" + qz.get(index).getHistory_score());
                        his.putExtra("Quiz Name", "History Quiz");
                        startActivity(his);
                    }
                    else if (Qname.equals("Computer Quiz")) {
                        Intent comp = new Intent(MultipleChoice.this, com.example.dineshbalajivenkataraman.views.CheckBoxDisplay.class);
                        comp.putExtra("Computer Correct Answer", qz.get(index).getComputer_score());
                        comp.putExtra("Integer Position", 1);
                        Log.i("MultipleChoice", "Value score from Setter for Computer Quiz" + qz.get(index).getComputer_score());
                        comp.putExtra("Quiz Name", "Computer Quiz");
                        startActivity(comp);
                    }
                    else if (Qname.equals("Science Quiz")) {
                        Intent scienc = new Intent(MultipleChoice.this, com.example.dineshbalajivenkataraman.views.CheckBoxDisplay.class);
                        scienc.putExtra("Science Correct Answer", qz.get(index).getScience_score());
                        scienc.putExtra("Integer Position", 2);
                        Log.i("MultipleChoice", "Value score from Setter for Science Quiz" + qz.get(index).getScience_score());
                        scienc.putExtra("Quiz Name", "Science Quiz");
                        startActivity(scienc);
                    }
                }
            }
        });
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

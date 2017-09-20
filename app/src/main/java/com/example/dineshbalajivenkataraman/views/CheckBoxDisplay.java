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
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dineshbalajivenkataraman.com.example.dineshbalajivenkataraman.classes.MultipleChoiceQuizData;
import com.example.dineshbalajivenkataraman.quizapp.R;

import java.util.ArrayList;

import static android.R.attr.value;

public class CheckBoxDisplay extends AppCompatActivity {
    CheckBox optionOne, optionTwo,optionThree,optionFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_display);
        ArrayList<MultipleChoiceQuizData> checkboxQuiz;
            checkboxQuiz= new ArrayList<>();
            checkboxQuiz.add(new MultipleChoiceQuizData("Q 2/4 What are the Countries that has colonies in US before 1850 ? ?", "China", "India", "England", "Spain"));
            checkboxQuiz.add(new MultipleChoiceQuizData("Q 2/4 Founders of Google", "Larry Page", "Steve wozniak", "Sergey Brin", "None of the above"));
            checkboxQuiz.add(new MultipleChoiceQuizData("Q 2/4 Select the areas which Einstein made significant contribution", "Theory of Relativity", "Theory of Light", "Artifical Intelligence", "Optic Fibre"));
            Intent intent = getIntent();
            int position = intent.getIntExtra("Integer Position", value);
            final String QuizName = intent.getStringExtra("Quiz Name");
            Log.i("CheckBox", "----------1. Position---------->"+position);
            Log.i("CheckBox", "--------2. Quiz Name------------>"+QuizName);
            applyColor(QuizName);
            displaycheckQA(position, checkboxQuiz, QuizName);
        }
    public void displaycheckQA(final int i, final ArrayList<MultipleChoiceQuizData> checkboxQuiz, final String Qname)
    {
        String question_checkbox = checkboxQuiz.get(i).getQuestion();
        TextView quest = (TextView) findViewById(R.id.quest_checkbox);
        quest.setText(question_checkbox);
        String chOne_checkbox = checkboxQuiz.get(i).getChoice_one();
        TextView choice_one = (TextView) findViewById(R.id.checkBox_option_1);
        choice_one.setText(chOne_checkbox);
        String chTwo_checkbox = checkboxQuiz.get(i).getChoice_two();
        TextView choice_two = (TextView) findViewById(R.id.checkBox_option_2);
        choice_two.setText(chTwo_checkbox);
        String chThree_checkbox = checkboxQuiz.get(i).getChoice_three();
        TextView choice_three = (TextView) findViewById(R.id.checkBox_option_3);
        choice_three.setText(chThree_checkbox);
        String chFour_checkbox = checkboxQuiz.get(i).getChoice_four();
        TextView choice_four = (TextView) findViewById(R.id.checkBox_option_4);
        choice_four.setText(chFour_checkbox);
        optionOne = (CheckBox)findViewById(R.id.checkBox_option_1);
        optionTwo=(CheckBox)findViewById(R.id.checkBox_option_2);
        optionThree = (CheckBox)findViewById(R.id.checkBox_option_3);
        optionFour=(CheckBox)findViewById(R.id.checkBox_option_4);
        checkAnswer(Qname,checkboxQuiz,i);
    }
    public void checkAnswer(final String Qzname, final ArrayList<MultipleChoiceQuizData> ckScr, final int indexQuiz)
    {
        Button nxtButton = (Button) findViewById(R.id.button);
        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(optionOne.isChecked() || optionTwo.isChecked() || optionTwo.isChecked() || optionFour.isChecked()))
                {
                    Toast.makeText(getApplicationContext(), "Please select an Answer", Toast.LENGTH_LONG).show();
                }
                else {

                    if (Qzname.equals("History Quiz")) {
                        Intent his = getIntent();
                        int his_scr = his.getIntExtra("History Correct Answer", -1);
                        ckScr.get(indexQuiz).setHistory_score(his_scr);
                        Log.i("CheckBoxDisplay", "----------5. History Score in Check Box---------->" + his_scr);

                        if (optionThree.isChecked() && optionFour.isChecked() && !optionOne.isChecked() && !optionTwo.isChecked()) {
                            his_scr = his_scr + 1;
                            ckScr.get(indexQuiz).setHistory_score(his_scr);
                            Log.i("CheckBoxDisplay", "----------6. New History Score From Check Box--------->" + his_scr);
                        }
                        his = new Intent(CheckBoxDisplay.this, com.example.dineshbalajivenkataraman.views.Images.class);
                        his.putExtra("History Correct Answer", ckScr.get(indexQuiz).getHistory_score());
                        his.putExtra("Integer Position",0);
                        Log.i("MultipleChoice", "----------Value score from Setter for History Quiz---------->" + ckScr.get(indexQuiz).getHistory_score());
                        his.putExtra("Quiz Name", "History Quiz");
                        startActivity(his);
                    }
                    if (Qzname.equals("Computer Quiz")) {
                        Intent comp = getIntent();
                        int comp_scr = comp.getIntExtra("Computer Correct Answer", -1);
                        ckScr.get(indexQuiz).setComputer_score(comp_scr);
                        Log.i("CheckBoxDisplay", "----------7. Science Score in Check Box---------->" + comp_scr);

                        if ( optionOne.isChecked()&& optionThree.isChecked() && !optionTwo.isChecked() && !optionFour.isChecked()) {
                            comp_scr = comp_scr + 1;
                            ckScr.get(indexQuiz).setComputer_score(comp_scr);
                            Log.i("CheckBoxDisplay", "----------8. New Computer Score From Check Box--------->" + comp_scr);
                        }
                        comp = new Intent(CheckBoxDisplay.this, com.example.dineshbalajivenkataraman.views.Images.class);
                        comp.putExtra("Computer Correct Answer", ckScr.get(indexQuiz).getComputer_score());
                        comp.putExtra("Integer Position", 1);
                        Log.i("MultipleChoice", "----------Value score from Setter for Computer Quiz---------->" + ckScr.get(indexQuiz).getComputer_score());
                        comp.putExtra("Quiz Name", "Computer Quiz");
                        startActivity(comp);
                    }
                    if (Qzname.equals("Science Quiz")) {
                        Intent scienc = getIntent();
                        int sci_scr = scienc.getIntExtra("Science Correct Answer", -1);
                        ckScr.get(indexQuiz).setScience_score(sci_scr);
                        Log.i("CheckBoxDisplay", "----------3. Science Score in Check Box---------->" + sci_scr);

                        if (optionOne.isChecked() && optionTwo.isChecked() && !optionThree.isChecked() && !optionFour.isChecked()) {
                            sci_scr = sci_scr + 1;
                            ckScr.get(indexQuiz).setScience_score(sci_scr);
                            Log.i("CheckBoxDisplay", "----------4. New Science Score From Check Box--------->" + sci_scr);
                        }
                        scienc = new Intent(CheckBoxDisplay.this, com.example.dineshbalajivenkataraman.views.Images.class);
                        scienc.putExtra("Science Correct Answer", ckScr.get(indexQuiz).getScience_score());
                        scienc.putExtra("Integer Position",2);
                        Log.i("MultipleChoice", "----------Value score from Setter for Science Quiz---------->" + ckScr.get(indexQuiz).getScience_score());
                        scienc.putExtra("Quiz Name", "Science Quiz");
                        startActivity(scienc);
                    }
                }
            }
        });
    }
    public void applyColor(String qName)
    {
        if(qName.equals("History Quiz")) {
            getSupportActionBar().setTitle("History Quiz");
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#E57373"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#E53935"));
        }
        else if(qName.equals("Computer Quiz"))
        {
            getSupportActionBar().setTitle("Computer Quiz");
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#64B5F6"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2196F3"));
        }
        if(qName.equals("Science Quiz"))
        {
            getSupportActionBar().setTitle("Science Quiz");
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#009688"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#00695C"));
        }
    }
}
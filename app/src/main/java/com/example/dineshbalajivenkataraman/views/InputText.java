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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dineshbalajivenkataraman.com.example.dineshbalajivenkataraman.classes.MultipleChoiceQuizData;
import com.example.dineshbalajivenkataraman.quizapp.R;
import java.util.ArrayList;
import static android.R.attr.value;

public class InputText extends AppCompatActivity {
    ArrayList<MultipleChoiceQuizData> quizDat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_text);
        quizDat = new ArrayList<>();
        quizDat.add(new MultipleChoiceQuizData("Q 4/4 Who is credited with suggesting the word \"hello\" be used when answering the telephone ?"));
        quizDat.add(new MultipleChoiceQuizData("Q 4/4 When referring to computer memory, what does that acronym RAM stand for?"));
        quizDat.add(new MultipleChoiceQuizData("Q 4/4 Who came up with the theories of General and Special relativity ?"));
        Intent intent = getIntent();
        int position = intent.getIntExtra("Integer Position", value);
        final String QuizName = intent.getStringExtra("Quiz Name");
        Log.i("InputText", "----------Position---------->" + position);
        Log.i("InputText", "--------Quiz Name------------>" + QuizName);
        applyColor(QuizName);
        displayQA(position, quizDat, QuizName);
    }
    public void displayQA(final int i, final ArrayList<MultipleChoiceQuizData> qz, final String Qname) {

        String question = qz.get(i).getQuestion();
        TextView quest = (TextView) findViewById(R.id.inputQuestion);
        quest.setText(question);
        submitAnswer(Qname, i, qz);
    }
    public void submitAnswer(final String Qname, final int index, final ArrayList<MultipleChoiceQuizData> qz) {
        final EditText answerInp = (EditText) findViewById(R.id.answer);
        final String ans = answerInp.getText().toString().trim();
        Log.i("InputText", "-------User Entered Text is------->" + ans);
        Button submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerInp.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Answer", Toast.LENGTH_SHORT).show();
                } else {
                    if (Qname.equals("Science Quiz")) {
                        Intent scienc = getIntent();
                        int sci_scr = scienc.getIntExtra("Science Correct Answer", -1);
                        qz.get(index).setScience_score(sci_scr);
                        Log.i("InputText", "----------3. Science Score in Input Text---------->" + sci_scr);
                        if (answerInp.getText().toString().equalsIgnoreCase("Albert Einstein")) {
                            sci_scr = sci_scr + 1;
                            qz.get(index).setScience_score(sci_scr);
                            Log.i("InputText", "----------4. New Science Score From Input correct Ans--------->" + sci_scr);
                        } else {
                            sci_scr = sci_scr + 0;
                            qz.get(index).setScience_score(sci_scr);
                            Log.i("InputText", "----------Wrong Ans Input Text--------->" + sci_scr);
                        }
                        scienc = new Intent(InputText.this, com.example.dineshbalajivenkataraman.views.QuizScore.class);
                        scienc.putExtra("Science Correct Answer", qz.get(index).getScience_score());
                        scienc.putExtra("Integer Position", 2);
                        Log.i("InputText", "----------Value score from Setter for Science Quiz---------->" + qz.get(index).getScience_score());
                        scienc.putExtra("Quiz Name", "Science Quiz");
                        startActivity(scienc);
                    }
                    if (Qname.equals("History Quiz")) {
                        Intent his = getIntent();
                        int his_scr = his.getIntExtra("History Correct Answer", -1);
                        qz.get(index).setHistory_score(his_scr);
                        Log.i("InputText", "----------5. History Score in Images---------->" + his_scr);
                        if (answerInp.getText().toString().equalsIgnoreCase("Thomas Edison")) {
                            his_scr = his_scr + 1;
                            qz.get(index).setHistory_score(his_scr);
                            Log.i("InputText", "----------6. New History Score in Images--------->" + his_scr);
                        } else {
                            his_scr = his_scr + 0;
                            qz.get(index).setHistory_score(his_scr);
                            Log.i("CheckBoxDisplay", "----------Wrong Ans Input Text--------->" + his_scr);
                        }
                        his = new Intent(InputText.this, com.example.dineshbalajivenkataraman.views.QuizScore.class);
                        his.putExtra("History Correct Answer", qz.get(index).getHistory_score());
                        his.putExtra("Integer Position", 0);
                        Log.i("InputText", "----------Value score from Setter for History Quiz---------->" + qz.get(index).getHistory_score());
                        his.putExtra("Quiz Name", "History Quiz");
                        startActivity(his);
                    }
                    if (Qname.equals("Computer Quiz")) {
                        Intent comp = getIntent();
                        int comp_scr = comp.getIntExtra("Computer Correct Answer", -1);
                        qz.get(index).setComputer_score(comp_scr);
                        Log.i("InputText", "----------7. Science Score in Images--------->" + comp_scr);
                        if (answerInp.getText().toString().equalsIgnoreCase("Random Access Memory")) {
                            comp_scr = comp_scr + 1;
                            qz.get(index).setComputer_score(comp_scr);
                            Log.i("InputText", "----------8. New Computer Score From Images--------->" + comp_scr);
                        } else {
                            comp_scr = comp_scr + 0;
                            qz.get(index).setComputer_score(comp_scr);
                            Log.i("InputText", "----------8. New Computer Score From Images--------->" + comp_scr);
                        }
                        comp = new Intent(InputText.this, com.example.dineshbalajivenkataraman.views.QuizScore.class);
                        comp.putExtra("Computer Correct Answer", qz.get(index).getComputer_score());
                        comp.putExtra("Integer Position", 1);
                        Log.i("InputText", "----------Value score from Setter for Computer Quiz---------->" + qz.get(index).getComputer_score());
                        comp.putExtra("Quiz Name", "Computer Quiz");
                        startActivity(comp);
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

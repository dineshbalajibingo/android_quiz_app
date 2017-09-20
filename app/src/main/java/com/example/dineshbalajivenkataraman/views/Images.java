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
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dineshbalajivenkataraman.com.example.dineshbalajivenkataraman.classes.MultipleChoiceQuizData;
import com.example.dineshbalajivenkataraman.quizapp.R;
import java.util.ArrayList;
import static android.R.attr.value;
public class Images extends AppCompatActivity {
    ArrayList<MultipleChoiceQuizData> quizData;
    public static int selectId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        quizData = new ArrayList<>();
        quizData = new ArrayList<>();
        quizData.add(new MultipleChoiceQuizData(R.drawable.charlie, "Q 3/4 Identify this famous personality", "Richard Pyror", "Robin Williams", "Charlie Chaplin", "Bill Hicks"));
        quizData.add(new MultipleChoiceQuizData(R.drawable.dennis, "Q 3/4 Identify this famous personality (Clue: Father of c and unix)", "James Gosling", "Bjarne Stroustrup", "Rasmus Lerdorf", "Dennis Ritchie"));
        quizData.add(new MultipleChoiceQuizData(R.drawable.tesla, "Q 3/4 Identify this famous personality", "Nikola Tesla", "Alessandro Volta", "Heinrich Hertz", "Thomas Edison"));
        Intent intent = getIntent();
        int position = intent.getIntExtra("Integer Position", value);
        final String QuizName = intent.getStringExtra("Quiz Name");
        Log.i("MultipleChoice", "----------Position---------->" + position);
        Log.i("MultipleChoice", "--------Quiz Name------------>" + QuizName);
        applyColor(QuizName);
        displayQA(position, quizData, QuizName);
    }
    public void displayQA(final int i, final ArrayList<MultipleChoiceQuizData> qz, final String Qname) {
        ImageView imageRes = (ImageView) findViewById(R.id.imageHolder);
        if (Qname.equals("Science Quiz")) {
            imageRes.setImageResource(R.drawable.tesla);
        } else if (Qname.equals("Computer Quiz")) {
            imageRes.setImageResource(R.drawable.dennis);
        } else {
            imageRes.setImageResource(R.drawable.charlie);
        }
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
                            Intent scienc = getIntent();
                            int sci_scr = scienc.getIntExtra("Science Correct Answer", -1);
                            qz.get(i).setScience_score(sci_scr);
                            Log.i("CheckBoxDisplay", "----------3. Science Score in Images---------->" + sci_scr);
                            sci_scr = sci_scr + 1;
                            qz.get(i).setScience_score(sci_scr);
                            Log.i("CheckBoxDisplay", "----------4. New Science Score From Images--------->" + sci_scr);
                        }
                        break;

                    case R.id.questTwo:
                        break;

                    case R.id.questThree:
                        if (Qname.equals("History Quiz")) {
                            Intent his = getIntent();
                            int his_scr = his.getIntExtra("History Correct Answer", -1);
                            qz.get(i).setHistory_score(his_scr);
                            Log.i("CheckBoxDisplay", "----------5. History Score in Images---------->" + his_scr);
                            his_scr = his_scr + 1;
                            qz.get(i).setHistory_score(his_scr);
                            Log.i("CheckBoxDisplay", "----------6. New History Score in Images--------->" + his_scr);
                        }
                        break;
                    case R.id.questFour:
                        if (Qname.equals("Computer Quiz")) {
                            Intent comp = getIntent();
                            int comp_scr = comp.getIntExtra("Computer Correct Answer", -1);
                            qz.get(i).setComputer_score(comp_scr);
                            Log.i("CheckBoxDisplay", "----------7. Science Score in Images--------->" + comp_scr);
                            comp_scr = comp_scr + 1;
                            qz.get(i).setComputer_score(comp_scr);
                            Log.i("CheckBoxDisplay", "----------8. New Computer Score From Images--------->" + comp_scr);
                        }
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
                        Intent his = new Intent(Images.this, com.example.dineshbalajivenkataraman.views.InputText.class);
                        his.putExtra("History Correct Answer", quizData.get(index).getHistory_score());
                        his.putExtra("Integer Position", 0);
                        Log.i("MultipleChoice", "----------Value score from Setter for History Quiz---------->" + quizData.get(index).getHistory_score());
                        his.putExtra("Quiz Name", "History Quiz");
                        startActivity(his);
                    } else if (Qname.equals("Computer Quiz")) {
                        Intent comp = new Intent(Images.this, com.example.dineshbalajivenkataraman.views.InputText.class);
                        comp.putExtra("Computer Correct Answer", quizData.get(index).getComputer_score());
                        comp.putExtra("Integer Position", 1);
                        Log.i("MultipleChoice", "----------Value score from Setter for Computer Quiz---------->" + quizData.get(index).getComputer_score());
                        comp.putExtra("Quiz Name", "Computer Quiz");
                        startActivity(comp);
                    } else if (Qname.equals("Science Quiz")) {
                        Intent scienc = new Intent(Images.this, com.example.dineshbalajivenkataraman.views.InputText.class);
                        scienc.putExtra("Science Correct Answer", quizData.get(index).getScience_score());
                        scienc.putExtra("Integer Position", 2);
                        Log.i("MultipleChoice", "----------Value score from Setter for Science Quiz---------->" + quizData.get(index).getScience_score());
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

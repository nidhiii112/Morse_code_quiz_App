package com.example.project;

import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.animation.Animator;
import android.content.res.ColorStateList;
import android.graphics.Color;

import android.os.Bundle;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private TextView question , noIndicator;
    private FloatingActionButton bookmark_btn;
    private LinearLayout optionsContainer;
    private Button nextBtn;
    private int count = 0;
    private List<QuestionModel> list;
    private int position = 0;
    private int Score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.no_indicator);
        bookmark_btn = findViewById(R.id.bookmark_button);
        optionsContainer = findViewById(R.id.options_container);
        nextBtn = findViewById(R.id.next_button);


        list = new ArrayList<>();
        list.add(new QuestionModel("What is the capital of india?","Delhi","Mumbai","Kolkata","Prayagraj","Delhi"));
        list.add(new QuestionModel("Question2","a","b","c","d","b"));
        list.add(new QuestionModel("Question3","a","b","c","d","a"));
        list.add(new QuestionModel("Question4","a","b","c","d","c"));
        list.add(new QuestionModel("Question5","a","b","c","d","d"));
        list.add(new QuestionModel("Question6","a","b","c","d","a"));
        list.add(new QuestionModel("Question7","a","b","c","d","b"));
        list.add(new QuestionModel("Question8","a","b","c","d","a"));
        list.add(new QuestionModel("Question9","a","b","c","d","d"));
        list.add(new QuestionModel("Question10","a","b","c","d","c"));




        for (int i = 0;i<4; i++){
            optionsContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckAnswer((Button) v);
                }
            });
        }


        playAnim(question,0,list.get(position).getQuestion());
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextBtn.setEnabled(false);
                nextBtn.setAlpha(0.7f);
                enableopton(true);

                if (position < list.size() - 1) {
                    position++;


                }
                count = 0;

                playAnim(question, 0, list.get(position).getQuestion());
            }
        });
        if (!list.isEmpty()) {
            setNextQuestion();
        }
    }

    private void setNextQuestion() {
        count = 0;
        playAnim(question, 0, list.get(position).getQuestion());
    }


    private void playAnim(View view , int value , final String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).
                setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {
                        if (value == 0 && count < 4) {
                            String option = "";
                            switch (count) {
                                case 0:
                                    option = list.get(position).getOptionA();
                                    break;
                                case 1:
                                    option = list.get(position).getOptionB();
                                    break;
                                case 2:
                                    option = list.get(position).getOptionC();
                                    break;
                                case 3:
                                    option = list.get(position).getOptionD();
                                    break;
                            }
                                playAnim(optionsContainer.getChildAt(count), 0, option);
                                count++;
                            }
                        }


                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {
                        if (value==0){
                            try {
                                ((TextView)view).setText(data);
                                noIndicator.setText(position+1+"/"+list.size());
                            }catch (ClassCastException ex){
                                ((Button)view).setText(data);
                            }
                           view.setTag(data);
                            playAnim(view,1,data);
                        }

                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });
    }
        private void CheckAnswer(Button selectedOption){
        enableopton(false);
        nextBtn.setEnabled(true);
        nextBtn.setAlpha(1);
        if (selectedOption.getText().toString().equals(list.get(position).getCorrectANS())){
            //correct
            Score++;
            //For green button when ans is correct
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
        }else {
            //incorrect
            //red color for incorrect option
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
            //now to show right option
            Button correctoption = (Button) optionsContainer.findViewWithTag(list.get(position).getCorrectANS());
            correctoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
        }
    }
    private void enableopton(boolean enable){
        for (int i=0; i<4; i++){
            optionsContainer.getChildAt(i).setEnabled(enable);
            if (enable){
                optionsContainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));

            }
        }

    }

}
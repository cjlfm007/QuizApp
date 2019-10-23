package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    TextView scoreView;
    ImageView imgView;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2 ;
    RadioGroup radioGroup3;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize all ui elements status
        score = 0;
        scoreView = findViewById(R.id.result_area);
        imgView = findViewById(R.id.result_img);
        radioGroup1 = findViewById(R.id.radiogroup1);
        radioGroup2 = findViewById(R.id.radiogroup2);
        radioGroup3 = findViewById(R.id.radiogroup3);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        submitBtn = findViewById(R.id.submit_btn);

    }
    public void reset(View view){
        // reset all elements status
        score = 0;
        scoreView.setText("");
        imgView.setImageResource(R.drawable.think);
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
        for (int i = 0; i < radioGroup1.getChildCount(); i++) {
            radioGroup1.getChildAt(i).setEnabled(true);
        }
        for (int i = 0; i < radioGroup2.getChildCount(); i++) {
            radioGroup2.getChildAt(i).setEnabled(true);
        }
        for (int i = 0; i < radioGroup3.getChildCount(); i++) {
            radioGroup3.getChildAt(i).setEnabled(true);
        }
        submitBtn.setEnabled(true);
    }
    //This is the submit onCreate Method
    public void submit(View view){
        if (checkBox1.isChecked() && checkBox3.isChecked()){
            score += 1;
        }
        if (radioGroup1.getCheckedRadioButtonId() == R.id.correct1){
            score += 1;
        }
        if (radioGroup2.getCheckedRadioButtonId() == R.id.correct2){
            score += 1;
        }
        if (radioGroup3.getCheckedRadioButtonId() == R.id.correct3){
            score += 1;
        }
        // If answer 3 or more question we will show pass image
        if (score >= 3){
            imgView.setImageResource(R.drawable.pass);
        }
        else{
            imgView.setImageResource(R.drawable.failed);
        }
        float rate = (float) score / (float) 4;
        scoreView.setText("Scoring \n" +
                "You scored " + score + "/4 = " + rate * 100 + "%");

        // once calculate score, just inactive all element besides reset button
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
        for (int i = 0; i < radioGroup1.getChildCount(); i++) {
            radioGroup1.getChildAt(i).setEnabled(false);
        }
        for (int i = 0; i < radioGroup2.getChildCount(); i++) {
            radioGroup2.getChildAt(i).setEnabled(false);
        }
        for (int i = 0; i < radioGroup3.getChildCount(); i++) {
            radioGroup3.getChildAt(i).setEnabled(false);
        }
        submitBtn.setEnabled(false);
    }
}

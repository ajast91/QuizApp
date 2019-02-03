package com.example.android.theoceansquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    RadioButton radioButtonA4Q1;
    RadioButton radioButtonA1Q2;
    RadioButton radioButtonA3Q5;
    CheckBox checkBoxA1Q3;
    CheckBox checkBoxA2Q3;
    CheckBox checkBoxA3Q3;
    CheckBox checkBoxA4Q3;
    EditText editTextAQ4;
    EditText editTextAQ6;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonA4Q1 = findViewById(R.id.radio_button_4_q_1);
        radioButtonA1Q2 = findViewById(R.id.radio_button_1_q_2);
        radioButtonA3Q5 = findViewById(R.id.radio_button_3_q_5);
        checkBoxA1Q3 = findViewById(R.id.checkbox_1_q_3);
        checkBoxA2Q3 = findViewById(R.id.checkbox_2_q_3);
        checkBoxA3Q3 = findViewById(R.id.checkbox_3_q_3);
        checkBoxA4Q3 = findViewById(R.id.checkbox_4_q_3);
        editTextAQ4 = findViewById(R.id.fill_answer_q_4);
        editTextAQ6 = findViewById(R.id.fill_answer_q_6);
        editTextName = findViewById(R.id.fill_name);
    }

    /**
     * This method is used to check the answers of the quiz
     */

    public void submitAnswers(View v) {

        score = 0;

        if (radioButtonA4Q1.isChecked()) {
            score += 1;
        }

        if (radioButtonA1Q2.isChecked()) {
            score += 1;
        }

        if (radioButtonA3Q5.isChecked()) {
            score += 1;
        }

        if ((checkBoxA1Q3.isChecked()) && (checkBoxA2Q3.isChecked()) && (checkBoxA3Q3.isChecked()) && (checkBoxA4Q3.isChecked())) {
            score += 0;
        }

        if ( (!checkBoxA1Q3.isChecked()) && (checkBoxA2Q3.isChecked()) && (checkBoxA3Q3.isChecked()) && (!checkBoxA4Q3.isChecked())) {
            score += 1;
        }

        String answerq4 = editTextAQ4.getText().toString().trim();
        if (answerq4.equals("Mariana Trench")) {
            score += 1;}

        String answerq6 = editTextAQ6.getText().toString().trim();
        if (answerq6.equals("Pacific Ocean")) {
            score += 1;
        }

        String name = editTextName.getText().toString();

        if (score == 6)

            Toast.makeText(this, "Congrats, " + name + " you scored " + score + " points out of 6! You rule!", Toast.LENGTH_LONG).show();

        else

            Toast.makeText(this, "Whoops! " + name + " you scored only " + score + " point(s) out of 6! Don't worry and try again!", Toast.LENGTH_LONG).show();
    }

    /**
     * This method is used to reset the app.
     */

    public void reset(View v) {
        score = 0;
        RadioGroup radioGroup = findViewById(R.id.radio_group_q_1);
        radioGroup.clearCheck();

        radioGroup = findViewById(R.id.radio_group_q_2);
        radioGroup.clearCheck();

        CheckBox checkBox = findViewById(R.id.checkbox_1_q_3);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.checkbox_2_q_3);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.checkbox_3_q_3);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.checkbox_4_q_3);
        checkBox.setChecked(false);

        EditText editText = findViewById(R.id.fill_answer_q_4);
        editText.setText("");

        radioGroup = findViewById(R.id.radio_group_q_5);
        radioGroup.clearCheck();

        editText = findViewById(R.id.fill_answer_q_6);
        editText.setText("");

        editText = findViewById(R.id.fill_name);
        editText.setText("");
    }
}

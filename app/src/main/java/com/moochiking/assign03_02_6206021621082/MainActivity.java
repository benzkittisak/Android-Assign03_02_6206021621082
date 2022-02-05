package com.moochiking.assign03_02_6206021621082;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText midScore , finalScore , homeworkScore;
    private Button btnCal;
    private TextView totalScoreText ,gradeText;

    private final String totalString = "คะแนนรวม : ";
    private final String gradeString = "เกรดที่ได้ : ";

    int convertMidScoreToInt , convertFinalScoreToInt, convertHomeworkScoreToInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        midScore = (EditText) findViewById(R.id.midScore);
        finalScore = (EditText) findViewById(R.id.finalScore);
        homeworkScore = (EditText) findViewById(R.id.homeworkScore);

        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);

        totalScoreText = (TextView) findViewById(R.id.totalScoreText);
        gradeText = (TextView) findViewById(R.id.gradeText);


    }


    @Override
    public void onClick(View v) {
        
        if(midScore.getText().toString().equals("")) {
            Toast.makeText(this, "ยังไม่ได้ป้อนคะแนนกลางภาค", Toast.LENGTH_SHORT).show();
            return;
        } else {
            convertMidScoreToInt = Integer.parseInt(midScore.getText().toString());
            if(convertMidScoreToInt > 30){
                Toast.makeText(this,"กรุณาป้อนคะแนนกลางภาคไม่เกิน 30" , Toast.LENGTH_SHORT).show();
                return;
            }
        }

        if(finalScore.getText().toString().equals("")) {
            Toast.makeText(this, "ยังไม่ได้ป้อนคะแนนปลายภาค", Toast.LENGTH_SHORT).show();
            return;
        } else {
            convertFinalScoreToInt = Integer.parseInt(finalScore.getText().toString());
            if(convertFinalScoreToInt > 40){
                Toast.makeText(this,"กรุณาป้อนคะแนนปลายภาคไม่เกิน 40" , Toast.LENGTH_SHORT).show();
                return;
            }
        }

        if(homeworkScore.getText().toString().equals("")) {
            Toast.makeText(this, "ยังไม่ได้ป้อนคะแนนการบ้าน", Toast.LENGTH_SHORT).show();
            return;
        }  else {
            convertHomeworkScoreToInt = Integer.parseInt(homeworkScore.getText().toString());
            if(convertHomeworkScoreToInt > 30){
                Toast.makeText(this,"กรุณาป้อนคะแนนการบ้านไม่เกิน 30" , Toast.LENGTH_SHORT).show();
                return;
            }
        }

        calGrade();

    }

    public void calGrade(){
        int totalScore = convertMidScoreToInt + convertFinalScoreToInt + convertHomeworkScoreToInt;
        String grade;
        totalScoreText.setText(totalString + totalScore);
        if(totalScore >= 80){
            grade = "A";
        }
        else if (totalScore >= 75){
            grade = "B+";
        }
        else if (totalScore >= 70){
            grade = "B";
        }
        else if (totalScore >= 65){
            grade = "C+";
        }
        else if (totalScore >= 60){
            grade = "C";
        }
        else if (totalScore >= 55){
            grade = "D+";
        }
        else if (totalScore >= 50){
            grade = "D";
        }
        else grade= "F";

        gradeText.setText(gradeString + grade);
    }
}
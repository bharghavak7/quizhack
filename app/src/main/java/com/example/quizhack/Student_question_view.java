package com.example.quizhack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Student_question_view extends AppCompatActivity {
    TextView t1;
    DatabaseReference firebasereference;
    RadioGroup Rgroup;
    RadioButton options, roption1, roption2, roption3, roption4;
    Button push;
    String ans;
    long ll;
    String cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_question_view);
        Rgroup = findViewById(R.id.Rgroup);
        roption1 = findViewById(R.id.ROption1);
        roption2 = findViewById(R.id.ROption2);
        roption3 = findViewById(R.id.ROption3);
        roption4 = findViewById(R.id.ROption4);
        push=findViewById(R.id.push);

        t1 = findViewById(R.id.Questiondisplay);

        firebasereference = FirebaseDatabase.getInstance().getReference("Questions").child("ghvg");
        firebasereference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long countquestions = snapshot.getChildrenCount();
                ll = countquestions - 1;
                Toast.makeText(Student_question_view.this, "total "+ ll, Toast.LENGTH_SHORT).show();
                cv = String.valueOf(ll);

                t1.setText(snapshot.child(cv).child("Question").getValue().toString());
                roption1.setText(snapshot.child(cv).child("Option1").getValue().toString());
                roption2.setText(snapshot.child(cv).child("Option2").getValue().toString());
                roption3.setText(snapshot.child(cv).child("Option3").getValue().toString());
                roption4.setText(snapshot.child(cv).child("Option4").getValue().toString());
                 ans = snapshot.child(cv).child("Ans").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void OnclickButton(View v) {
        int Selectradio = Rgroup.getCheckedRadioButtonId();
        options = findViewById(Selectradio);
        if (Selectradio == -1) {
            Toast.makeText(Student_question_view.this, "Error! Not Selected Options", Toast.LENGTH_SHORT).show();
        } else if (ans.trim().toString().equals(options.getText().toString())) {

            Toast.makeText(Student_question_view.this, "correct", Toast.LENGTH_SHORT).show();
            ll--;
            cv = String.valueOf(ll);
            if (ll != 0) {
                QuestionDisplay();
            }
            else {
                Toast.makeText(Student_question_view.this, "Quiz is Finish ", Toast.LENGTH_SHORT).show();
            }
        }
            else {
                Toast.makeText(Student_question_view.this, "wrong answer", Toast.LENGTH_SHORT).show();
            }

    }


    private void QuestionDisplay() {


        firebasereference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (ll==1){
                    push.setText("Finish");
                }
                Toast.makeText(Student_question_view.this, cv, Toast.LENGTH_SHORT).show();

                t1.setText(snapshot.child(cv).child("Question").getValue().toString());
                roption1.setText(snapshot.child(cv).child("Option1").getValue().toString());
                roption2.setText(snapshot.child(cv).child("Option2").getValue().toString());
                roption3.setText(snapshot.child(cv).child("Option3").getValue().toString());
                roption4.setText(snapshot.child(cv).child("Option4").getValue().toString());
                ans = snapshot.child(cv).child("Ans").getValue().toString();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}



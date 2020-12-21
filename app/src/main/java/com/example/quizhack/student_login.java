package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class student_login extends AppCompatActivity {
EditText student_code,class_code;
Button loginbtn;
DatabaseReference firebasereference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        student_code=findViewById(R.id.stu_code);
        class_code=findViewById(R.id.clas_code);
        loginbtn=findViewById(R.id.loginbtn);
      //  FirebaseDatabase.getInstance().setPersistenceEnabled(true);

     //  firebasereference= FirebaseDatabase.getInstance().getReference("Questions");
       // firebasereference.keepSynced(true);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  String clas_code=class_code.getText().toString();
           //    if (firebasereference.orderByKey().equals(clas_code)){     }
                Intent intent=new Intent(student_login.this,Student_question_view.class);
                startActivity(intent);

            }
        });
    }
}
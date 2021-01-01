package com.example.quizhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.quizhack.adminlogin.firebaseDatabaseglobal;

public class Add_Questions extends AppCompatActivity {

    private DatabaseReference firebasedatabase;
    private FirebaseDatabase firebaseinstance;
    private String Questions;
    int breaksnap=0;
     long slno=1;
     long bh;
    TextView sl;
    String QNo;
    EditText question,option1,option2,option3,option4,ans;
    Button nextqs,addquestion;
    AppCompatSpinner select_category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__questions);

       firebasedatabase=firebaseDatabaseglobal.child("Questions").child(Categorydailog.secreate);
       firebasedatabase.child("Timings").child("Time").setValue(Categorydailog.timer);

        question=(EditText)findViewById(R.id.question);
        option1=(EditText)findViewById(R.id.option1);
        option2=(EditText)findViewById(R.id.option2);
        option3=(EditText)findViewById(R.id.option3);
        option4=(EditText)findViewById(R.id.option4);
        ans=(EditText)findViewById(R.id.answer);

        Categorydailog.catagorieslist.add(0,"Select Category");
        sl = (TextView) this.<View>findViewById(R.id.qslno);
        firebasedatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                slno =snapshot.getChildrenCount();
                QNo=String.valueOf(slno);
                sl.setText(QNo);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        nextqs=(Button)findViewById(R.id.nextqst);
        addquestion=(Button)findViewById(R.id.addqst);



         select_category = (AppCompatSpinner)findViewById(R.id.select_catrgory);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Categorydailog.catagorieslist);
        select_category.setAdapter(arrayAdapter);

        nextqs.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Add_Questions.this,Main_Menu.class);
        startActivity(intent);
    }
});

        addquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question.getText().toString().trim().length()==0)
                {
                    Toast.makeText(Add_Questions.this,"Enter Question",Toast.LENGTH_SHORT).show();

                }else if(option1.getText().toString().trim().length()==0){
                    Toast.makeText(Add_Questions.this,"Enter a option1",Toast.LENGTH_SHORT).show();
                    }
                else if(option2.getText().toString().trim().length()==0)
                {
                    Toast.makeText(Add_Questions.this,"Enter Option2",Toast.LENGTH_SHORT).show();
                    }
                else if(option3.getText().toString().trim().length()==0){
                    Toast.makeText(Add_Questions.this,"Enter option3",Toast.LENGTH_SHORT).show();
                }
                else if (option4.getText().toString().trim().length()==0){
                    Toast.makeText(Add_Questions.this,"Enter Option4",Toast.LENGTH_SHORT).show();
                }else if(ans.getText().toString().trim().length()==0){
                    Toast.makeText(Add_Questions.this,"Enter Answer",Toast.LENGTH_SHORT).show();
                }else if(select_category.getSelectedItem().toString().trim().length()==0)
                {
                    Toast.makeText(Add_Questions.this,"Select category",Toast.LENGTH_SHORT).show();
                }else {
                    String spin = select_category.getSelectedItem().toString();
                    String ques = question.getText().toString();
                    String opti1 = option1.getText().toString();
                    String opti2 = option2.getText().toString();
                    String opti3 = option3.getText().toString();
                    String opti4 = option4.getText().toString();
                    String an = ans.getText().toString();


                    if (an.contentEquals(opti1) || an.contentEquals(opti2) || an.contentEquals(opti3) || an.contentEquals(opti4))
                    {
                        if (TextUtils.isEmpty(Questions)) {
                           // DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Questions");
                            breaksnap=0;
                            firebasedatabase.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    slno =snapshot.getChildrenCount();
                                    if(breaksnap==0) {
                                        createQuestion(ques, opti1, opti2, opti3, opti4, an, spin);
                                        QNo = String.valueOf(slno);
                                        sl.setText(QNo);
                                        question.getText().clear();
                                        option1.getText().clear();
                                        option2.getText().clear();
                                        option3.getText().clear();
                                        option4.getText().clear();
                                        ans.getText().clear();
                                    }


                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });





                           //if(Time_Code.addid==true) {
                              // Toast.makeText(Add_Questions.this, "Tested okey", Toast.LENGTH_SHORT).show();
                                //adminlogin.firebaseDatabaseemail.child("Email").child(adminlogin.mail).child(Categorydailog.secreate);
                                //Time_Code.addid=false;
                            //}
                            Toast.makeText(Add_Questions.this, "Question Added", Toast.LENGTH_SHORT).show();
                        }
                }else{
                        Toast.makeText(Add_Questions.this, "Answer not matched any one of Options ", Toast.LENGTH_SHORT).show();
                    }

 

                }

    }
});
    }

    private void createQuestion(String ques, String opti1, String opti2, String opti3, String opti4, String an, String spin) {
        if (TextUtils.isEmpty(Questions)){


            Questions=QNo;


            firebasedatabase.child(Questions).child("Question").setValue(ques);
            firebasedatabase.child(Questions).child("Option1").setValue(opti1);
            firebasedatabase.child(Questions).child("Option2").setValue(opti2);
            firebasedatabase.child(Questions).child("Option3").setValue(opti3);
            firebasedatabase.child(Questions).child("Option4").setValue(opti4);
            firebasedatabase.child(Questions).child("Ans").setValue(an);
            firebasedatabase.child(Questions).child("Category").setValue(spin);
            Questions="";
            slno++;
            breaksnap=1;
        }


    }
}
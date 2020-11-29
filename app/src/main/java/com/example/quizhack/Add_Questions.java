package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_Questions extends AppCompatActivity {

     int  slno=1;
    TextView sl;
    EditText question,option1,option2,option3,option4,ans;
    Button nextqs,addquestion;
    AppCompatSpinner select_category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__questions);

        question=(EditText)findViewById(R.id.question);
        option1=(EditText)findViewById(R.id.option1);
        option2=(EditText)findViewById(R.id.option2);
        option4=(EditText)findViewById(R.id.option3);
        ans=(EditText)findViewById(R.id.answer);

        Categorydailog.catagorieslist.add(0,"Select Category");
        sl = (TextView) this.<View>findViewById(R.id.qslno);
        nextqs=(Button)findViewById(R.id.nextqst);
        addquestion=(Button)findViewById(R.id.addqst);
        sl.setText("slno");


         select_category = (AppCompatSpinner)findViewById(R.id.select_catrgory);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Categorydailog.catagorieslist);
        select_category.setAdapter(arrayAdapter);

nextqs.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Add_Questions.this,Time_Code.class);
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
                }else if(select_category.getSelectedItem().toString().isEmpty())
                {
                    Toast.makeText(Add_Questions.this,"Select category",Toast.LENGTH_SHORT).show();
                }else {
                    String spin = select_category.getSelectedItem().toString();

                    Toast.makeText(Add_Questions.this, spin, Toast.LENGTH_SHORT).show();
                }

    }
});
    }
}
package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Menu extends AppCompatActivity {
Button setqstion,viewqstion,deleteqstion,rsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);
        setqstion=(Button)findViewById(R.id.setquestions);
        viewqstion=(Button)findViewById(R.id.viewquestions);
        deleteqstion=(Button)findViewById(R.id.delete);
        rsult=(Button)findViewById(R.id.result);
        setqstion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main_Menu.this,Category.class);
                startActivity(intent);

            }
        });
    }
}
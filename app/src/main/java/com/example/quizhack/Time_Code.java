package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Time_Code extends AppCompatActivity {
 Button complete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__code);

        complete=(Button)findViewById(R.id.finish);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Time_Code.this,Main_Menu.class);
                startActivity(intent);
            }
        });
    }
}
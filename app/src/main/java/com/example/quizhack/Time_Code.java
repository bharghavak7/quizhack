package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Time_Code extends AppCompatActivity {
 Button nextcat;
 EditText secreate_code,time;
DatabaseReference firebasedatabase;

 public static  boolean addid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__code);
        Toast.makeText(Time_Code.this,adminlogin.mail, Toast.LENGTH_SHORT).show();
        secreate_code=(EditText)findViewById(R.id.code);
        time=(EditText)findViewById(R.id.time1);

        nextcat=(Button)findViewById(R.id.timenext);
        nextcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secreate_code.getText().toString().trim().length()!=0) {
                    if (time.getText().toString().trim().length() != 0) {
                        Categorydailog.secreate = secreate_code.getText().toString();
                        Categorydailog.timer = time.getText().toString();

                           firebasedatabase= adminlogin.firebaseDatabaseglobal.child("Email").child(adminlogin.mail);
                            String mai= firebasedatabase.push().getKey();
                                firebasedatabase.child(mai).setValue(Categorydailog.secreate);

                        Intent intent = new Intent(Time_Code.this, Category.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Time_Code.this, "Error! Enter Time", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Time_Code.this, "Error! Enter Code", Toast.LENGTH_SHORT).show();
                }


                }

        });
    }
}
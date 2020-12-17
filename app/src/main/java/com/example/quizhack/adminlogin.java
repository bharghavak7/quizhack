package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adminlogin extends AppCompatActivity {
Button btnnxt;
EditText Email;
public static DatabaseReference firebaseDatabaseglobal;
FirebaseDatabase firebaseglobal;
public static String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
      //  FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseDatabaseglobal=FirebaseDatabase.getInstance().getReference();
        firebaseDatabaseglobal.keepSynced(true);
        Email=(EditText)findViewById(R.id.email);
        btnnxt=(Button)findViewById(R.id.admin_next);
        btnnxt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (Email.getText().toString().trim().length()==0)
        {

            Toast.makeText(adminlogin.this,"Error! Enter Email address",Toast.LENGTH_SHORT).show();
        }else{
            mail=Email.getText().toString();



          firebaseDatabaseglobal.child("Email").child(mail);


            Intent intent=new Intent(adminlogin.this,Main_Menu.class);
            startActivity(intent);
        }

    }
});


    }
}
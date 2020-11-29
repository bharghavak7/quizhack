package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity  {
    Button viewcategory,nextquestion,addcategory;
    LinearLayout layout;
    TextView slno;
    EditText category_name;
    EditText Category1;
    int n=0;
    int lop=1;
    String sln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        Category1=(EditText)findViewById(R.id.input_Category);
        //layout=findViewById(R.id.layoutlist);
        //Categorydailog.catagorieslist.add("Select Category");
        // Categorydailog.catagorieslist.add("code");
        //Categorydailog.catagorieslist.add("Mental ability");

       // Category1 = (EditText) findViewById(R.id.category_name);
        nextquestion = (Button) findViewById(R.id.category_next);
        nextquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Add_Questions.class);
                startActivity(intent);
            }
        });


        addcategory = (Button) findViewById(R.id.add_category);
        addcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (Category1.getText().toString().trim().length() == 0) {
                    Toast.makeText(Category.this, "Error! Enter category name", Toast.LENGTH_LONG).show();
                }else if(Categorydailog.catagorieslist.contains(Category1.getText().toString()))

               {
                   Toast.makeText(Category.this, "Override! "+Category1.getText().toString()+" Is exist", Toast.LENGTH_SHORT).show();
                   }
               else {
                    Categorydailog.catagorieslist.add(Category1.getText().toString());
                    Toast.makeText(Category.this, Category1.getText().toString(), Toast.LENGTH_SHORT).show();
                    Category1.getText().clear();
                }




            }
        });

        viewcategory=(Button)findViewById(R.id.View_category);
        viewcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Categorydailog.catagorieslist.toString().length()==0)
                {
                    Toast.makeText(Category.this,"List is Empty",Toast.LENGTH_LONG).show();
                }else{

                openDialog();}
            }
        });
    }
    public void openDialog(){
        Categorydailog dialog=new Categorydailog();
        dialog.show(getSupportFragmentManager(),"Example Dialog");
    }







}
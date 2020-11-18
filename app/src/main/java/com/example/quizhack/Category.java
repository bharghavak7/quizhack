package com.example.quizhack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Category extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layoutList;
    Button addqst;
    int n=0;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        layoutList=(LinearLayout)findViewById(R.id.layout_list);
        addqst=(Button)findViewById(R.id.button_add);
        addqst.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        n=n+1;
        val=String.valueOf(n);
        addView();

    }

    private void addView() {
        final View categorylist = getLayoutInflater().inflate(R.layout.category_resource,null,false);
        TextView slno=(TextView)categorylist.findViewById(R.id.slno);


        slno.setText(val);
        EditText category_name=(EditText)categorylist.findViewById(R.id.category_name);
        layoutList.addView(categorylist);

    }




}
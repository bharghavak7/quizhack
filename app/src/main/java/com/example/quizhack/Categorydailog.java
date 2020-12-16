package com.example.quizhack;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class Categorydailog extends AppCompatDialogFragment {
    public static  List<String> catagorieslist= new ArrayList<>();
     public static String secreate,timer,mail;

    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Category List");

                builder.setMessage(catagorieslist.toString());

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return  builder.create();
    }


}

package com.example.adminreliablehometution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class other extends AppCompatActivity {
   private List<String> noteList11 ;


   private  StudentList dialog;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);



        editText = findViewById(R.id.student_name);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //noteList12 = noteList11;
                noteList11 = new ArrayList<>();
                noteList11.add("Balaram");
                noteList11.add("Goggo");
                noteList11.add("rithm");
                noteList11.add("sanju");
                noteList11.add("akshat");
                 dialog = new StudentList(noteList11);
                dialog.show(getSupportFragmentManager(), "");


            }
        });
    }
    public void showNote(int position) {

        editText.setText(noteList11.get(position));
        dialog.dismiss();
    }
}
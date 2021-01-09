package com.example.adminreliablehometution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class other extends AppCompatActivity {
   private List<String> noteList11 ;


   private  StudentList dialog;
    private EditText editText;
    private TeacherListDialog teacherListDialog;
    private EditText teacher;
    private FirebaseFirestore firebaseFirestore;
    private Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);



        editText = findViewById(R.id.student_name);
        teacher = findViewById(R.id.teacher_name);
        firebaseFirestore = FirebaseFirestore.getInstance();
        confirm = findViewById(R.id.button_confirm);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //noteList12 = noteList11;
                noteList11 = new ArrayList<>();
                firebaseFirestore.collection("STUDENT").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                      if(task.isSuccessful()) {
                          for (QueryDocumentSnapshot document : task.getResult()) {
                              Map<String, Object> b=document.getData();
                              Object c = b.get("name");
                              noteList11.add((String)c);
                             // Toast.makeText(other.this,"size"+noteList11.size(),Toast.LENGTH_SHORT).show();

                              //Toast.makeText(other.this,"size"+(String)c,Toast.LENGTH_SHORT).show();
                          }
                          dialog = new StudentList(noteList11);
                          dialog.show(getSupportFragmentManager(), "");
                      }
                      else {
                          Toast.makeText(other.this,"failed to retrive data",Toast.LENGTH_SHORT).show();
                      }
                    }
                });



            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteList11 = new ArrayList<>();
                firebaseFirestore.collection("TEACHER").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> b=document.getData();
                                Object c = b.get("name");
                                noteList11.add((String)c);
                                // Toast.makeText(other.this,"size"+noteList11.size(),Toast.LENGTH_SHORT).show();

                                //Toast.makeText(other.this,"size"+(String)c,Toast.LENGTH_SHORT).show();
                            }
                            teacherListDialog = new TeacherListDialog(noteList11);
                            teacherListDialog.show(getSupportFragmentManager(), "");
                        }
                        else {
                            Toast.makeText(other.this,"failed to retrive data",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference documentReference = firebaseFirestore.collection("STUDENT_TEACHER_TIMETABLE").document();
                Map<String, Object> user = new HashMap<>();
                user.put("student", editText.getText().toString());
                user.put("teacher", teacher.getText().toString());
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(other.this,"added successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(other.this,MainActivity.class));
                    }
                });
            }
        });
    }
    public void showNote(int position,int y) {
         if(y == 1) {
             editText.setText(noteList11.get(position));
             dialog.dismiss();
         }
        else {
             teacher.setText(noteList11.get(position));
             teacherListDialog.dismiss();
         }
    }
}
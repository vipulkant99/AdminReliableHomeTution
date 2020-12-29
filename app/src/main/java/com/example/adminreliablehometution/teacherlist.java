package com.example.adminreliablehometution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Queue;

public class teacherlist extends AppCompatActivity {

     RecyclerView recveiw;
     teacheradapter adapter;
     private FirebaseFirestore firebaseFirestore;
     private RecyclerView mFirestoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherlist);
       recveiw = (RecyclerView) findViewById(R.id.t_regview);
        recveiw.setLayoutManager(new LinearLayoutManager(this ));

        firebaseFirestore = FirebaseFirestore.getInstance();
       // mFirestoreList = findViewById(R.id.t_regview);

        Query query = firebaseFirestore.collection("TEACHER");
        FirestoreRecyclerOptions<TeacherModel> options = new FirestoreRecyclerOptions.Builder<TeacherModel>()
                .setQuery(query, TeacherModel.class)
                .build();

        adapter=new teacheradapter(options);
        recveiw.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
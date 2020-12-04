package com.example.adminreliablehometution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class allNames extends AppCompatActivity {

    private TextView nameType;
    private RecyclerView myRecyclerView;
    private FirebaseAuth fAuth;
    private String userId;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = firebaseFirestore.collection("Hi");
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_names);
        nameType = findViewById(R.id.nameType);
        myRecyclerView = findViewById(R.id.myRecyclerView);
        /*fAuth = FirebaseAuth.getInstance();
        userId = fAuth.getCurrentUser().getUid();*/
        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        Query query = collectionReference.orderBy("priority",Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Information> options = new FirestoreRecyclerOptions.Builder<Information>()
                .setQuery(query,Information.class).build();

        adapter = new Adapter(options);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(adapter);


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
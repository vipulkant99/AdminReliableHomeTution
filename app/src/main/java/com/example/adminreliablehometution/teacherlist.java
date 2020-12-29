package com.example.adminreliablehometution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.Queue;

public class teacherlist extends AppCompatActivity {

     RecyclerView recveiw;
     private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherlist);
       recveiw = (RecyclerView) findViewById(R.id.t_regview);
        recveiw.setLayoutManager(new LinearLayoutManager(this ));

        firebaseFirestore = FirebaseFirestore.getInstance();
       // mFirestoreList = findViewById(R.id.t_regview);

    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        CircularImageView img;
        TextView name , email , phn;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (CircularImageView) itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.nametext);
            email = (TextView)itemView.findViewById(R.id.emailt);
            phn = (TextView)itemView.findViewById(R.id.phnt);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Query query = firebaseFirestore.collection("TEACHER");
        FirestoreRecyclerOptions<TeacherModel> options = new FirestoreRecyclerOptions.Builder<TeacherModel>()
                .setQuery(query, TeacherModel.class)
                .build();

        FirestoreRecyclerAdapter<TeacherModel, myviewholder> mAdapter = new FirestoreRecyclerAdapter<TeacherModel, myviewholder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull TeacherModel model) {
                        holder.name.setText(model.getName());
                        holder.email.setText(model.getMail());
                        holder.phn.setText(model.getPhoneNo());
                        Log.i("finame", ""+ model.getName());
                        Log.i("fimail", ""+ model.getMail());
                        Log.i("fiphone", ""+ model.getPhoneNo());
                        Log.i("fiposition", String.valueOf(position));
                    }// database open krna

                    @NonNull
                    @Override
                    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow , parent , false);
                        return new myviewholder(view);
                    }
                };

        recveiw.setAdapter(mAdapter);
        mAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        //mAdapter.stopListening();
    }


  // search view


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu_t, menu);

        MenuItem item = menu .findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s) 
    {
        firebaseFirestore = FirebaseFirestore.getInstance();
        Query query = firebaseFirestore.collection("TEACHER").orderBy("name").startAt(s).endAt(s + "\uf8ff");
        FirestoreRecyclerOptions<TeacherModel> options = new FirestoreRecyclerOptions.Builder<TeacherModel>()
                .setQuery(query, TeacherModel.class)
                .build();
        //mAdapter =new teacheradapter(options);
        //mAdapter.startListening();
        //recveiw.setAdapter(mAdapter);
    }
}
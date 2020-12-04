package com.example.adminreliablehometution;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Adapter extends FirestoreRecyclerAdapter<Information, Adapter.nameHolder> {

    public Adapter(@NonNull FirestoreRecyclerOptions<Information> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull nameHolder holder, int position, @NonNull Information model) {
        holder.myName.setText(model.getMyName());
        Log.e("hi",model.getMyName());
    }

    @NonNull
    @Override
    public nameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_card,parent,false);
        return new nameHolder(v);
    }

    class nameHolder extends RecyclerView.ViewHolder{
        TextView myName;

        public nameHolder(@NonNull View itemView) {
            super(itemView);
            myName = itemView.findViewById(R.id.myName);
        }
    }
}

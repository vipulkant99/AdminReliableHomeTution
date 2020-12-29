package com.example.adminreliablehometution;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

public class teacheradapter extends FirestoreRecyclerAdapter<TeacherModel , teacheradapter.myviewholder>
{
    public teacheradapter(@NonNull FirestoreRecyclerOptions<TeacherModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull TeacherModel model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getMemail());
        holder.phn.setText(model.getMphn());

      //  holder.name.setText(model.getName());
         //Glide.with(holder.img.getContext()).load(TeacherModel.getPurl()).into(holder.img);
     //   Glide.with(holder.img.getContext()).load(TeacherModel.getPurl()).into(holder.img);
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow , parent , false);
        return new myviewholder(view);
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
}
   
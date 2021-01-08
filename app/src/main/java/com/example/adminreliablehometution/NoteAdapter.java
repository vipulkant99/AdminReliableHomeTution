package com.example.adminreliablehometution;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.ListItemHolder> implements Filterable {

    private List<String> mNoteList;
    private List<String> mNoteListAll;
    private other mother;
    public NoteAdapter(other mainActivity,
                       List<String> noteList) {

        mother = mainActivity;
        mNoteList = noteList;
        mNoteListAll = new ArrayList<>(noteList);
    }
    @NonNull
    @Override
    public NoteAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_student, parent, false);

        return new ListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ListItemHolder holder, int position) {
        //Note note = mNoteList.get(position);
        holder.mTitle.setText(mNoteList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }
    public class ListItemHolder extends
            RecyclerView.ViewHolder
            implements View.OnClickListener {

        public TextView mTitle;
        public ListItemHolder(View view) {
            super(view);
            mTitle = (TextView)
                    view.findViewById(R.id.textView_studentname);

            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mother.showNote(getAdapterPosition());
            StudentList studentList = new StudentList();
            //studentList.finish();
        }
    }
    @Override
    public Filter getFilter() {
        return filter;
    }
   Filter filter = new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
       List<String> filteredList = new ArrayList<>();

       if(constraint.toString().isEmpty()) {
           filteredList.addAll(mNoteListAll);
       } else {
           for (String name:mNoteListAll) {
               if(name.toLowerCase().contains(constraint.toString().toLowerCase())) {
                   filteredList.add(name);
               }
           }
       }
       FilterResults filterResults = new FilterResults();
       filterResults.values = filteredList;
       return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
          mNoteList.clear();
          mNoteList.addAll((Collection<? extends String>) results.values);
          notifyDataSetChanged();
    }
};

}

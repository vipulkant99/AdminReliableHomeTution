package com.example.adminreliablehometution;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeacherListDialog extends DialogFragment {
    private NoteAdapter mAdapter;
    private List<String> noteList;

    public TeacherListDialog(List<String> mList) {
        noteList = mList;
    }
    public TeacherListDialog() {

    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =
                getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.recyclerview_student, null);
        final RecyclerView recyclerView = dialogView.findViewById(R.id.student_list);

        final SearchView searchView = dialogView.findViewById(R.id.student_search);

        builder.setView(dialogView);
        mAdapter = new NoteAdapter((other) getActivity(), noteList,0);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager((other) getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration((other) getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return builder.create();
    }
}

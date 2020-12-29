package com.example.adminreliablehometution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class SelectType extends AppCompatActivity {

    private MaterialCardView teacherCardView;
    private MaterialCardView studentCardView;
    private MaterialCardView parentCardView;
    private MaterialCardView otherCardView;

    private Animation animation1;
    private Animation animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);

        teacherCardView = findViewById(R.id.teacherCardView);
        studentCardView = findViewById(R.id.studentCardView);
        parentCardView = findViewById(R.id.parentCardView);
        otherCardView = findViewById(R.id.otherCardview);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.from_left);
        teacherCardView.setAnimation(animation1);

        animation2 = AnimationUtils.loadAnimation(this,R.anim.from_right);
        studentCardView.setAnimation(animation2);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.from_left);
        parentCardView.setAnimation(animation1);

        animation2 = AnimationUtils.loadAnimation(this , R.anim.from_right);
        otherCardView.setAnimation(animation2);

        teacherCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectType.this, teacherlist.class));
            }
        });
        studentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectType.this , teacherlist.class));
            }
        });
        parentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectType.this , teacherlist.class));
            }
        });
        otherCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectType.this , teacherlist.class));
            }
        });


    }
}
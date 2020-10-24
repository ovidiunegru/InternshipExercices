package com.example.internshipexercices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class RecyclerView extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ImageView imageView= (ImageView)findViewById(R.id.image_recycle);
        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);

    }
}
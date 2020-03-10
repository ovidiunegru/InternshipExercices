package com.example.internshipexercices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String COUNTER_BUNDLE="numberOfClicks";
    private int incrementValue=0;

    private TextView incrementTextView;
    private Button incrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Happy to be born");
        InitViews();



        if(savedInstanceState!=null) {
            incrementValue = savedInstanceState.getInt(COUNTER_BUNDLE);
            incrementTextView.setText(incrementValue + "");
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_BUNDLE,incrementValue);

    }

    private void InitViews(){
        incrementTextView=findViewById(R.id.tv_counter);
        incrementButton=findViewById(R.id.bt_increment);

        incrementTextView.setText(incrementValue+" ");

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementValue++;
                incrementTextView.setText(String.valueOf(incrementValue));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart: I exist, but you cannot see me");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: preparing final UI for you master");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: you can see me, but you cannot interact with me");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Packing up to leave");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Bye Bye");
    }
}

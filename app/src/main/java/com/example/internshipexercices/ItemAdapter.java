package com.example.internshipexercices;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import  androidx.recyclerview.widget.RecyclerView;

import com.example.internshipexercices.model.Item;

import java.util.ArrayList;

public class ItemAdapter {

    private ArrayList<Item> items;

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private AppCompatImageView image;
        private AppCompatTextView title;
        private AppCompatTextView subtitle;
        private AppCompatCheckBox checkBox;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

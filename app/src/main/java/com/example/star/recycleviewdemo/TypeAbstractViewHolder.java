package com.example.star.recycleviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel model);
}

package com.example.star.recycleviewdemo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TypeOneViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;
    public TextView name;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        avatar = itemView.findViewById(R.id.avatar);
    }

    @Override
    public void bindHolder(DataModel model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
    }
}

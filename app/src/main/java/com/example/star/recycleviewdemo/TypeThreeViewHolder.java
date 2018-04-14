package com.example.star.recycleviewdemo;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TypeThreeViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        avatar = itemView.findViewById(R.id.avatar);
        contentImage = itemView.findViewById(R.id.contentImage);

    }

    @Override
    public void bindHolder(DataModel model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
        contentImage.setBackgroundResource(model.contentColor);
    }
}

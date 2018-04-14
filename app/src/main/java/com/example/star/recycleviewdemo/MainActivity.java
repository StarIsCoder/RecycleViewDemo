package com.example.star.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DemoAdpater mDemoAdpater;
    int colors[] = {android.R.color.holo_blue_bright,
            android.R.color.holo_orange_light,
            android.R.color.holo_green_light};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_demo);
        Log.d("wangshenxing", "onCreate :" + this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        mDemoAdpater = new DemoAdpater(this);
        initData();
        mRecyclerView.setAdapter(mDemoAdpater);

    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int type = (int) ((Math.random() * 3) + 1);
            DataModel dataModel = new DataModel();
            dataModel.avatarColor = colors[type - 1];
            dataModel.type = type;
            dataModel.name = "name :" + i;
            dataModel.content = "content :" + i;
            dataModel.contentColor = colors[(type + 1) % 3];
            list.add(dataModel);
        }
        mDemoAdpater.addList(list);
    }
}

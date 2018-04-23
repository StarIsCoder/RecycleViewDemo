package com.example.star.recycleviewdemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

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
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //                LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //spanCount为分母，返回值为分子
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if (type == 3) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(layoutManager);

        mDemoAdpater = new DemoAdpater(this);
        initData();

        mRecyclerView.setAdapter(mDemoAdpater);
        //添加分割线
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int size = layoutParams.getSpanSize();
                int index = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (size != layoutManager.getSpanCount()) {
                    if (index == 1) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });

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

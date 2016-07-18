package com.tacademy.samplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerMultiActivity extends AppCompatActivity {

    RecyclerView listView;
    GroupAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_multi);
        listView = (RecyclerView)findViewById(R.id.rv_list);
        mAdapter = new GroupAdapter();
        listView.setAdapter(mAdapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        listView.setLayoutManager(manager);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5 ; j++) {
                mAdapter.put("group" + i , "child:"+i+","+j);
            }
        }
    }
}

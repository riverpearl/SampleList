package com.tacademy.samplelist;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tacademy.samplelist.data.Person;

import java.util.Random;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView listView;
    RecyclerPersonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        listView = (RecyclerView)findViewById(R.id.rv_list);
        mAdapter = new RecyclerPersonAdapter();
        listView.setAdapter(mAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        listView.setLayoutManager(manager);

        initData();
    }

    int[] resIds = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3,R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7};

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Person p = new Person();
            p.setName("name " + i);
            p.setAge(20 + r.nextInt(30));
            p.setPhoto(ContextCompat.getDrawable(this, resIds[i % resIds.length]));
            mAdapter.add(p);
        }
    }
}

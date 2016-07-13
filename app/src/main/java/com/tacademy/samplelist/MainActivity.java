package com.tacademy.samplelist;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tacademy.samplelist.data.Person;
import com.tacademy.samplelist.widget.PersonView;

/*
 * < Compound Widget 만드는 법 >
 * 1. data 클래스 만들기
 * 2. widget 클래스 만들어 layout을 inflate 해주기f
 * 3. 다른 activity에 만들어둔 layout을 CustomView로 추가하기
 * 4. CustomView를 추가한 Activity 클래스에서 data 전달
 */

public class MainActivity extends AppCompatActivity {

    PersonView personView;
    ImageView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoView = (ImageView)findViewById(R.id.image_bigphoto);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoView.setVisibility(View.GONE);
            }
        });

        personView = (PersonView)findViewById(R.id.view_person);
        personView.setOnImageClickListenr(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, Person person) {
                photoView.setImageDrawable(person.getPhoto());
                photoView.setVisibility(View.VISIBLE);
            }
        });

        initData();
    }

    private void initData() {
        Drawable photo = ContextCompat.getDrawable(this, R.drawable.sample_0);
        Person p = new Person("kjj", 25, photo);
        personView.setPerson(p);
    }
}

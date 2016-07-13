package com.tacademy.samplelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tacademy.samplelist.R;
import com.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonView extends FrameLayout {
    public PersonView(Context context) {
        super(context);
        init();
        //this(context, null); //위 두 줄을 이런 식으로 써도 된다.
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private ImageView photoView;
    private TextView nameView, ageView;

    public void init() {
        inflate(getContext(), R.layout.view_person, this);
        //view를 생성하는데, 내가 루트이고 parent이다. -> 그리라고 하면 child까지 그려주게 돼서 view_person이 보여짐
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
    }

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        photoView.setImageDrawable(person.getPhoto());
        nameView.setText(person.getName());
        ageView.setText("" + person.getAge());
    }
}

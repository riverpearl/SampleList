package com.tacademy.samplelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tacademy.samplelist.R;
import com.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonView extends RelativeLayout {
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

    public interface  OnImageClickListener {
        public void onImageClick(PersonView view, Person person);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListenr(OnImageClickListener mListener) {
        this.mListener = mListener;
    }

    public void init() {
        inflate(getContext(), R.layout.view_person, this);
        //view를 생성하는데, 내가 루트이고 parent이다. -> 그리라고 하면 child까지 그려주게 돼서 view_person이 보여짐
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);

        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null)
                    mListener.onImageClick(PersonView.this, person);
            }
        });

        //TypedArray는 꼭 메모리를 반납해줘야 함.
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

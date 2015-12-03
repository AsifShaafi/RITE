package com.russellitneng.rite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ServiceDetails extends AppCompatActivity {

    TextView tv;
    ImageView imageView;
    String title, note;
    String dis;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);


        setContentView(R.layout.service_details);

        title = getIntent().getStringExtra("title");
        dis = getIntent().getStringExtra("dis");
        id = getIntent().getIntExtra("img", 0);
        note = getIntent().getStringExtra("note");

        tv = (TextView) findViewById(R.id.detail_title);
        tv.setText(title);

        imageView = (ImageView) findViewById(R.id.details_imageView);
        imageView.setImageResource(id);

        tv = (TextView) findViewById(R.id.detail_text);
        tv.setText(dis);

        tv = (TextView) findViewById(R.id.note_text);
        tv.setText(note);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

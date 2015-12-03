package com.russellitneng.rite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.russellitneng.rite.Data.Services;
import com.russellitneng.rite.Data.ServicesData;

import java.util.List;

public class ServiceList extends AppCompatActivity {

    protected List<Services> servicesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        setContentView(R.layout.service_list_layout);

        servicesList = ServicesData.getServicesList();

        ArrayAdapter<Services> servicesArrayAdapter =
                new ServiceListAdapter(this,R.layout.list_text,servicesList);

        final ListView serviceListView = (ListView) findViewById(R.id.listView);
        serviceListView.setAdapter(servicesArrayAdapter);

        serviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Services services = servicesList.get(position);

                Intent intent = new Intent(ServiceList.this,ServiceDetails.class);
                intent.putExtra("title",services.getTitle());
                intent.putExtra("img",services.getImgId());
                intent.putExtra("dis",services.getDis());
                intent.putExtra("note",services.getNote());

                startActivity(intent);
            }
        });
    }


    public class ServiceListAdapter extends ArrayAdapter<Services>{

        protected Context context;
        protected List<Services> objects;

        public ServiceListAdapter(Context context, int resource, List<Services> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Services services = objects.get(position);

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            View v = layoutInflater.inflate(R.layout.list_text,null);

            ImageView imageView = (ImageView) v.findViewById(R.id.list_img);

            imageView.setImageResource(services.getImgId());

            TextView textView = (TextView) v.findViewById(R.id.list_text);
            textView.setText(services.toString());

            return v;
        }
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

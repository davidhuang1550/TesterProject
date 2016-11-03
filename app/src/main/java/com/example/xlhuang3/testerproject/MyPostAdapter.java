package com.example.xlhuang3.testerproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xlhuang3 on 11/3/2016.
 */
public class MyPostAdapter extends BaseAdapter{

    private ArrayList<Post> posts;
    private Context context;
    MyPostAdapter(MainActivity mainActivity, ArrayList<Post> p){
        posts=p;
        context=mainActivity;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View row;
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.postlist,null);
        TextView tView = (TextView)row.findViewById(R.id.PostT);
        tView.setText(posts.get(i).getTitle());
        row.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),postview.class);
                intent.putExtra("Post",posts.get(i));
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                }

            }
        });
        return row;

    }
}

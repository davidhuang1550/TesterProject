package com.example.xlhuang3.testerproject;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth= FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        posts =new ArrayList<Post>();
        databaseReference.child("Sub").child("Soccer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot s: dataSnapshot.getChildren()){
                    Post p= s.getValue(Post.class);
                    p.setKey(s.getKey());

                    posts.add(p);


                    DataSnapshot s2 = s.child("Comments");
                    ArrayList<Comment> comments = new ArrayList<Comment>();
                    for(DataSnapshot s3 : s2.getChildren()) {
                        comments.add(s3.getValue(Comment.class));
                    }

                    p.setComments(comments);


                 //   Log.i("HI",p.getTitle());
                    //Log.i("BYE",p.getComments().get(0).getCommentDesc());

                }
                ListView listView = (ListView)findViewById(R.id.postview);
                MyPostAdapter adapter = new MyPostAdapter(MainActivity.this,posts);
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}

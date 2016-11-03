package com.example.xlhuang3.testerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class postview extends AppCompatActivity {
    private TextView Title;
    private TextView Description;
    private Button yes;
    private Button No;
    Post post;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    Button Search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postview);
        Intent intent = getIntent();
        post = (Post)intent.getSerializableExtra("Post_Object");

        Title= (TextView)findViewById(R.id.PostTitle);
        Description= (TextView)findViewById(R.id.PostDesc);
        Title.setText( post.getTitle());
        Description.setText(post.getDescription());
        yes = (Button)findViewById(R.id.yes);
        No = (Button)findViewById(R.id.no);

     /*   Search = (Button)findViewById(R.id.searchButton);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().add(R.id.searchView,new SearchFragment()).commit();

            }
        });
*/


        firebaseAuth= FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post.IncYes();
                databaseReference.child("Sub").child("Soccer").child(post.getKey()).setValue(post);

            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post.IncNo();
                databaseReference.child("Sub").child("Soccer").child(post.getKey()).setValue(post);
            }
        });



    }
}

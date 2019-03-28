package com.example.pas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddM extends AppCompatActivity {
    TextView textView10,textView11,textView12,textView13,textView15,textView14;
    EditText name,type;
    Button Done;
    FirebaseDatabase database;
    DatabaseReference ref;
    Manager m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addm);
        Toolbar toolbar = findViewById(R.id.toolbar);

        textView10=(TextView)findViewById(R.id.textView10);
        textView11=(TextView)findViewById(R.id.textView11);
        textView12=(TextView)findViewById(R.id.textView12);
        textView13=(TextView)findViewById(R.id.textView13);
        textView15=(TextView)findViewById(R.id.textView15);
        textView14=(TextView)findViewById(R.id.textView14);
        name=(EditText)findViewById(R.id.addtreat);
        type=(EditText)findViewById(R.id.typetreat);
        Done=(Button)findViewById(R.id.Done);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Manager");
        m=new Manager();
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void getValues(){
        m.setName(name.getText().toString());
        m.setType(type.getText().toString());
    }
    public void Done(View view){

        Intent i = new Intent(this,MMTime.class);
        startActivity(i);
        finish();



       ref.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               getValues();
            ref.child("medicine").setValue(m);
               Toast.makeText(AddM.this," تمت الاضافة" ,Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }


}

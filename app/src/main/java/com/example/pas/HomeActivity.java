package com.example.pas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private Button LiveV, MCall, information, Settings;
    private TextView Pname, H, T;
    private ImageView Pphoto;
    private TableLayout MList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
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
    //Live Vedio
    public void LiveVedio(View V){
        Intent i = new Intent(this, LiveVedio.class);
        startActivity(i);
        finish();
    }
    //make call
    public void MCall(View V){
        Intent i = new Intent(this, MCall.class);
        startActivity(i);
        finish();
    }
    //information
    public void information(View V){
        Intent i = new Intent(this, information.class);
        startActivity(i);
        finish();
    }
    //Settings
    public void Settings(View V){
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
        finish();
    }

}

package com.shalu.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView textView = (TextView) findViewById(R.id.tv_joke);
        if(getIntent()!=null && getIntent().hasExtra(Intent.EXTRA_TEXT)){
            textView.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}

package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.Callback{

    public ProgressBar pb_loadingIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb_loadingIndicator = (ProgressBar) findViewById(R.id.progressBar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        pb_loadingIndicator.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onFinished(String result) {
        pb_loadingIndicator.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(MainActivity.this, com.shalu.jokedisplay.MainActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, result);
        startActivity(intent);
    }
}

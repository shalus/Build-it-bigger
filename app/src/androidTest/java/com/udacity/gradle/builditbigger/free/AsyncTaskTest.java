package com.udacity.gradle.builditbigger.free;

import android.support.test.runner.AndroidJUnit4;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    @Test
    public void testGetJoke(){
        final EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.Callback() {
            @Override
            public void onFinished(String result){}
        });
        asyncTask.execute();
        String result = null;
        try {
            result = asyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(result.length() > 0);
    }
}
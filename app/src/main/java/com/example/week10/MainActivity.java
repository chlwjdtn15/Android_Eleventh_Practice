package com.example.week10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void taskA(View view) {


     MyTask task = new MyTask();

     Thread thread = new Thread(task);

        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                action();
            }
        }).start();
        
    }

    private void action() {
        try {
            Thread.sleep(3000);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });*/

        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });
    }


    class MyTask implements Runnable {

        @Override
        public void run() {



            //action();


        }
    }
}
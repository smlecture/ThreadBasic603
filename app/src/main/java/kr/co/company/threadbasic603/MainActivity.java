package kr.co.company.threadbasic603;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    WorkerThread wt;
    boolean running = true;

    String TAG = "THREAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class WorkerThread extends Thread {
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(TAG, "Thread time=" + i);
            }
        }
    }
/*    @Override
    public void onStart() {
        super.onStart();
        running = true;
        wt = new WorkerThread();
        wt.start();
        Log.v(TAG, "Now I am in onStart");
    }*/
    @Override
    protected void onStart() {
        super.onStart();

        running = true;
        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (i = 0; i < 20 && running; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    Log.v(TAG, "Runnable time=" + i);
                }
            }
        });
        wr.start();
        Log.v(TAG, "Now I am in onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG, "Now I am in onStop");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "Now I am in onPause");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "Now I am in onResume");
    }
}
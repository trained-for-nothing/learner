package com.manuver.learner;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static String reply;
    public static final String REPLY = "REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void replyMain(View view) {
        Log.d(LOG_TAG, "replyMain");
        Button btn = (Button) view;
        reply = btn.getText().toString();
        Log.d(LOG_TAG, reply);
        Intent replyIntent = new Intent(getApplicationContext(), MainActivity.class);
        replyIntent.putExtra(REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}

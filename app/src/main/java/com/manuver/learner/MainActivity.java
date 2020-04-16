package com.manuver.learner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private  static int counter = 1;
    private  TextView textView1;
    private  TextView textView2;
    private  TextView textView3;
    private  TextView textView4;
    private  TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence("textView1", textView1.getText());
        outState.putCharSequence("textView2", textView2.getText());
        outState.putCharSequence("textView3", textView3.getText());
        outState.putCharSequence("textView4", textView4.getText());
        outState.putCharSequence("textView5", textView5.getText());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView1.setText(savedInstanceState.getString("textView1"));
        textView2.setText(savedInstanceState.getString("textView2"));
        textView3.setText(savedInstanceState.getString("textView3"));
        textView4.setText(savedInstanceState.getString("textView4"));
        textView5.setText(savedInstanceState.getString("textView5"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "onActivityResult");
        if(TEXT_REQUEST == requestCode){
            if(resultCode == RESULT_OK){
                String reply;
                reply = data.getStringExtra(SecondActivity.REPLY);
                counter = (counter%6);
                if(counter == 0)
                    counter = 1;
                switch (counter){
                    case 1: textView1.setText(reply); break;
                    case 2: textView2.setText(reply); break;
                    case 3: textView3.setText(reply); break;
                    case 4: textView4.setText(reply); break;
                    case 5: textView5.setText(reply); break;
                }
                counter++;
            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

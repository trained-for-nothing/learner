package com.manuver.learner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLy";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView = findViewById(R.id.text_message);
        textView.setText(message);
        editText = findViewById(R.id.editText_sencond);

    }

    public void returnReply(View view) {
        String mReply = editText.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, mReply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}

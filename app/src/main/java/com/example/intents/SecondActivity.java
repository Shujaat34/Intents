package com.example.intents;

import android.arch.core.executor.TaskExecutor;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView1 , textView2;
    private EditText edtreply;
    static final String SecondActivity_MSG = "MSG2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView1 = findViewById(R.id.txtview1);
        textView2 = findViewById(R.id.txtview2);
        edtreply = findViewById(R.id.edtreply);

        Intent i = getIntent();
        String data = i.getStringExtra(MainActivity.MSG_From_MainActivity);
        if(data != null){
            textView1.setText("Text Received");
            textView2.setText(data);
        }
        else{
            textView1.setText("No Msg");
        }

    }


    public void onReply(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(SecondActivity_MSG, edtreply.getText().toString());
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}

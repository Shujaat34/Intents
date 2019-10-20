package com.example.intents;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonSend;
    private TextView textView;

    static final int Request_Code = 1;
    static final String MSG_From_MainActivity = "MSG1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.txt1);
        buttonSend = findViewById(R.id.buttonSend);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra(MSG_From_MainActivity,editText.getText().toString());
                startActivityForResult(i,Request_Code);
                editText.setText("");
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Request_Code &&  resultCode == RESULT_OK){
           String msg =  data.getStringExtra(SecondActivity.SecondActivity_MSG);
            textView.setText("Msg Received \n"+msg);
        }
    }
}

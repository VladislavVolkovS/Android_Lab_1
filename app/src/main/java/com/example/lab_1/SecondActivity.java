package com.example.lab_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SecondActivity extends Activity {

    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        goBack = (Button) findViewById(R.id.back_button);
        String backgroundColor = getIntent().getStringExtra("color");
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.second_activity);
        layout.setBackgroundColor(Color.parseColor(backgroundColor));
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

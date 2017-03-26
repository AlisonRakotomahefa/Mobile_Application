package com.example.aliso.finalproject_alisonrakotomahefa.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aliso.finalproject_alisonrakotomahefa.R;

public class MainActivity extends AppCompatActivity {
    EditText eText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = (EditText) findViewById(R.id.edittext);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                VideosActivity.start(MainActivity.this, eText.getText().toString());
            }
        });

    }
}
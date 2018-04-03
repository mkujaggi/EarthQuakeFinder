package com.crackeddish.firstlook.firstlook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button hiButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);
        hiButton=(Button) findViewById(R.id.HiButton);
        hiButton.setText(R.string.button_name);
        //hiButton.setTextColor(Color.BLUE);
    }
}

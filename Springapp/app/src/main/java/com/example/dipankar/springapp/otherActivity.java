
package com.example.dipankar.springapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class otherActivity extends AppCompatActivity {

    private String Output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        String outPut = null;
        TextView tv = (TextView) findViewById(R.id.tv);
        Uri uri = getIntent().getData();
        Bundle extras = getIntent().getExtras();
        Output = uri.toString();
        if(extras != null)
        {
            outPut = outPut + " From : "+extras.get("FROM");
        }
    }
}


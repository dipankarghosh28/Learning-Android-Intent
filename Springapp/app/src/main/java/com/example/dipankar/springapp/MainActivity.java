package com.example.dipankar.springapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//Declare all buttons .... ImageView
    /*
    implements View.OnClickListener
    */
    //
    Button takePic;
    Button toastButton;
    Button LocationButton;
    Button ShowButton;
    Button ViewButton;
    Button DisplayButton;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findviewbyid lets get the handle to the widget
        //findViewById("R.id.wewewe")
        takePic = (Button) findViewById(R.id.dialButton);
        toastButton = (Button) findViewById(R.id.toastButton);
        LocationButton = (Button) findViewById(R.id.LocationButton);
        ShowButton = (Button) findViewById(R.id.ShowButton);
        ViewButton =  (Button) findViewById(R.id.ViewButton);
        DisplayButton = (Button) findViewById(R.id.DisplayButton);
        takePic.setOnClickListener(this);
        toastButton.setOnClickListener(this);
        LocationButton.setOnClickListener(this);
        ShowButton.setOnClickListener(this);
        ViewButton.setOnClickListener(this);
        DisplayButton.setOnClickListener(this);
        //talks directly to onClick, set onClickListener...

}

    @Override
    public void onClick(View v) {
// we can see all the buttons here..
        switch(v.getId()){
            case R.id.dialButton:
                DialButton();
                break;
            case R.id.toastButton:
                Toast();
                break;
            case R.id.LocationButton:
                ShowLocation();
                break;
            case R.id.ShowButton:
                ShowPage();
                break;
            case R.id.ViewButton:
                ViewIntent();
                break;
            case R.id.DisplayButton:
                viaPackageManager();
                break;
        }
    }

    private void DialButton(){
    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));
    //remote app ACTION_DIAL
    //unifrom resource identifier -- parsing
    startActivity(intent);
    }

    private void Toast(){
     //   Toast.makeText(this,"You clicked on Toast Button", Toast.LENGTH_SHORT).show();
        //Use Toast
       Intent intent = new Intent("intent.otherActivity");
        startActivity(intent);
        //DummyActivity...

    }

    private void ShowLocation()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mystreamer:"));
        startActivity(intent); // need to call it.. cannot work on it's own

        //ACTION_VIEW,ACTION_DIAL
        //standalone activity
    }
    //TEACH ABOUT PACKAGE MANAGER,LAYOUTS
    //HOW EXACTLY MEDIA WORKS
    private void ShowPage()
    {
       Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.marlabs.com"));
       startActivity(intent);
    }
    private void ViewIntent(){
     Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mystreamer:"+"Play Song my.mp3"));
     intent.putExtra("FROM","\nWorking from system");
     startActivity(intent);

    }

    private void viaPackageManager(){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("intent.DummyActivity"));
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY); //Resolve info
        boolean isIntentsafe = activities.size() > 0;
        if(isIntentsafe)
        {
            startActivity(intent);
            Toast.makeText(this,"Activity present in your device ",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this,"Activity not present in your device ",Toast.LENGTH_SHORT).show();
        }
        startActivity(intent);
    }
}


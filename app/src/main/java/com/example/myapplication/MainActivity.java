package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editext);
    }
    public void sendEmail(View v){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String[] array = {"email@gmail.com","password"};
        i.putExtra(Intent.EXTRA_EMAIL, array);
        i.putExtra(Intent.EXTRA_SUBJECT, "This is a subject");
        String message = editText.getText().toString();
        i.putExtra(Intent.EXTRA_TEXT, message);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    public void openBrowser(View v){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.google.com"));
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
}

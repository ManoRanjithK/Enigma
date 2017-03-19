package com.engima.mapps.enigma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.util.Log;

public class GamePage2 extends AppCompatActivity {
String num1,num2,num3,num4,num5,num6,num7,num8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page2);
        Bundle extras = getIntent().getExtras();
         if(extras!=null)
        num1 = extras.getString("C1");
        if(extras!=null)
            num2 =extras.getString("C2");
        if(extras!=null)
        num3 =extras.getString("C3");
        if(extras!=null)
        num4 =extras.getString("C4");
        Log.d("mytag","hh"+ num1 +"ll");

    }
    public void gotogame(View view)
    {
        EditText n5 = (EditText)findViewById(R.id.n5);
        EditText n6 = (EditText)findViewById(R.id.n6);
        EditText n7 =(EditText)findViewById(R.id.n7);
        EditText n8 =(EditText)findViewById(R.id.n8);
        num5 = n5.getText().toString();
        num6=n6.getText().toString();

        num7=n7.getText().toString();
        num8=n8.getText().toString();
        Intent mynew=new Intent(this,game.class);
        mynew.putExtra("f1",num1);
        mynew.putExtra("f2",num2);
        mynew.putExtra("f3",num3);
        mynew.putExtra("f4",num4);
        mynew.putExtra("f5",num5);
        mynew.putExtra("f6",num6);
        mynew.putExtra("f7",num7);
        mynew.putExtra("f8",num8);
        startActivity(mynew);
    }
}

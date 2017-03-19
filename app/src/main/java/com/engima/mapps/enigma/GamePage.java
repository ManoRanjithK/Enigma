package com.engima.mapps.enigma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class GamePage extends AppCompatActivity {
String num1,num2,num3,num4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

    }

        public void gotogamepage2(View view)
    {
        EditText c1 = (EditText) findViewById(R.id.n1);
        EditText c2 = (EditText) findViewById(R.id.n2);
        EditText c3 = (EditText) findViewById(R.id.n3);
        EditText c4 = (EditText) findViewById(R.id.n4);
        num1 = c1.getText().toString();
        num2 = c2.getText().toString();
        num3 = c3.getText().toString();
        num4 = c4.getText().toString();
        Intent my =new Intent(this,GamePage2.class);
        Bundle extras = new Bundle();
        extras.putString("C1",num1);
        extras.putString("C2",num2);
        extras.putString("C3",num3);
        extras.putString("C4",num4);
        my.putExtras(extras);
        startActivity(my);
    }

}

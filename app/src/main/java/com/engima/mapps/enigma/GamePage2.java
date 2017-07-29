package com.engima.mapps.enigma;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.util.Log;

public class GamePage2 extends AppCompatActivity {
String num1,num2,num3,num4,num5,num6,num7,num8;
    EditText n5;
    EditText n6;
    EditText n7;
    EditText n8;

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
        n5 = (EditText)findViewById(R.id.n5);
        n6 = (EditText)findViewById(R.id.n6);
        n7 =(EditText)findViewById(R.id.n7);
        n8 =(EditText)findViewById(R.id.n8);

        n5.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = n5.getText().length();

                if (textlength1 >= 1) {
                    n6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });
        n6.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = n6.getText().length();

                if (textlength1 >= 1) {
                    n7.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        }); n7.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = n7.getText().length();

                if (textlength1 >= 1) {
                    n8.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });
    }
    public void gotogame(View view)
    {
        num5 = n5.getText().toString();
        num6=n6.getText().toString();

        num7=n7.getText().toString();
        num8=n8.getText().toString();
        if(((num5.equals(num6))||(num5.equals(num7))||(num5.equals(num8)))||
                ((num6.equals(num8))||(num6.equals(num7))||(num6.equals(num5)))||
                ((num7.equals(num8))||(num7.equals(num5))||(num7.equals(num6)))||
                ((num8.equals(num6))||(num8.equals(num5))||(num8.equals(num7))))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Oops");
            builder.setMessage("Please enter a 4 digit non-repeating number without any 0 in it");
            builder.setPositiveButton("Try Again",null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        else
            {
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
    }}
}

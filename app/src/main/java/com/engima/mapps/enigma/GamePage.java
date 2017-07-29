package com.engima.mapps.enigma;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.text.Editable;
import android.widget.EditText;

public class GamePage extends AppCompatActivity {
String num1,num2,num3,num4;
    EditText c1;
    EditText c2;
    EditText c3;
    EditText c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        c1 = (EditText) findViewById(R.id.n1);
        c2 = (EditText) findViewById(R.id.n2);
        c3 = (EditText) findViewById(R.id.n3);
        c4 = (EditText) findViewById(R.id.n4);
        c1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = c1.getText().length();

                if (textlength1 >= 0) {
                    c2.requestFocus();
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
        c2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = c2.getText().length();

                if (textlength1 >= 0) {
                    c3.requestFocus();
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
        c3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = c3.getText().length();

                if (textlength1 >= 0) {
                    c4.requestFocus();
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

        public void gotogamepage2(View view)
        {
            StringBuilder sb=new StringBuilder();
            num1 = c1.getText().toString();
            num2 = c2.getText().toString();
            num3 = c3.getText().toString();
            num4 = c4.getText().toString();
        if(((num1.equals(num2))||(num1.equals(num3))||(num1.equals(num4)))||
                                ((num2.equals(num4))||(num2.equals(num3))||(num2.equals(num1)))||
                                        ((num3.equals(num4))||(num3.equals(num1))||(num3.equals(num2)))||
                                            ((num4.equals(num2))||(num4.equals(num1))||(num4.equals(num3))))
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

}

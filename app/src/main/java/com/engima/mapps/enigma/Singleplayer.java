package com.engima.mapps.enigma;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import org.w3c.dom.Text;


public class Singleplayer extends AppCompatActivity {
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    String p1,p2,p3,p4;
    String ran1,ran2,ran3,ran4;
    TextView Player;
    int[] drawNum= new int[5];
    int MAX;
    int pe,pm,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        MAX=4;
        for (i=1;i<=MAX;i++)
        {   while(drawNum[1]==0)
            drawNum[1] = (int)(Math.random()*9)+1;

            while ((drawNum[2] == drawNum[1])||(drawNum[2]==0))
            {
                drawNum[2] = (int)(Math.random()*9)+1;
            }
            while (((drawNum[3] == drawNum[1]) || (drawNum[3] == drawNum[2])||(drawNum[3]==0) ))
            {
                drawNum[3] = (int)(Math.random()*9)+1;
            }
            while (((drawNum[4] == drawNum[1]) || (drawNum[4] == drawNum[2]) || (drawNum[4] == drawNum[3])||(drawNum[4]==0) ))
            {
                drawNum[4] = (int)(Math.random()*9)+1;
            }
            }
        ran1=String.valueOf((int)drawNum[1]);
        ran2=String.valueOf((int)drawNum[2]);
        ran3=String.valueOf((int)drawNum[3]);
        ran4=String.valueOf((int)drawNum[4]);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
         Toast.makeText(getApplicationContext(), "Computer has fixed a four digit number. Start guessing it", Toast.LENGTH_LONG).show();
        e1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = e1.getText().length();

                if (textlength1 >= 1) {
                    e2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });
        e2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = e2.getText().length();

                if (textlength1 >= 1) {
                    e3.requestFocus();
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
        e3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = e3.getText().length();

                if (textlength1 >= 1) {
                    e4.requestFocus();
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
        e4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = e4.getText().length();

                if (textlength1 >= 1) {
                    e1.requestFocus();
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


public void spcmp(View view)
        
{
    pe=0;
    pm=0;

    TextView Player = (TextView) findViewById(R.id.dispplay);
    /*String text2 ="<br>"+ran1 + ran2 +ran3 + ran4+"="+"<font color ='blue'>"+Integer.toString(pe)+"</font>:"+Integer.toString(pm);
    Spanned txt2=Html.fromHtml(text2);
    Player.append(txt2);*/

        p1=e1.getText().toString();
        p2=e2.getText().toString();
        p3=e3.getText().toString();
        p4=e4.getText().toString();

       if(((p1.equals(p2))||(p1.equals(p3))||(p1.equals(p4)))||
                ((p2.equals(p4))||(p2.equals(p3))||(p2.equals(p1)))||
                ((p3.equals(p4))||(p3.equals(p1))||(p3.equals(p2)))||
                ((p4.equals(p2))||(p4.equals(p1))||(p4.equals(p3)))) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Oops");
                builder.setMessage("Please enter a 4 digit non-repeating number to guess");

                builder.setPositiveButton("Try again", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id) {
                        e1.getText().clear();
                        e2.getText().clear();
                        e3.getText().clear();
                        e4.getText().clear();
                    }
                });
         AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
             else
                 {
                e1.getText().clear();
                e2.getText().clear();
                e3.getText().clear();
                e4.getText().clear();
             }

                       if (p1.equals(ran1)) {
                                          pm++;
                                      } else if (p1.equals(ran2) || p1.equals(ran3) || p1.equals(ran4))
                                          pe++;
                                      if (p2.equals(ran2))
                                          pm++;
                                      else if (p2.equals(ran1) || p2.equals(ran3) || p2.equals(ran4))
                                          pe++;
                                      if (p3.equals(ran3))
                                          pm++;
                                      else if (p3.equals(ran2) || p3.equals(ran1) || p3.equals(ran4))
                                          pe++;
                                      if (p4.equals(ran4))
                                          pm++;
                                      else if (p4.equals(ran2) || p4.equals(ran3) || p4.equals(ran1))
                                          pe++;

                                                       String text1 ="<br>"+p1 + p2 + p3 + p4+"="+"<font color ='blue'>"+Integer.toString(pe)+"</font>:"+Integer.toString(pm);
                                                       // player2.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
                                                       Spanned txt1=Html.fromHtml(text1);
                                                       Player.append(txt1);
}
    }




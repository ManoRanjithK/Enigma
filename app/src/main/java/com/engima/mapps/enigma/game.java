package com.engima.mapps.enigma;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.content.*;

import static com.engima.mapps.enigma.R.id.player1;
import static java.security.AccessController.getContext;
import static java.sql.Types.NULL;

public class game extends AppCompatActivity {
String num1,num2,num3,num4,num5,num6,num7,num8,num9;
    String ans1,ans2,ans3,ans4;
    EditText t1,t2,t3,t4;
    int count=0;
    public int p1m,p1e,p2m,p2e=0;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
            num1 =extras.getString("f1");
        if(extras!=null)
            num2=extras.getString("f2");
        if(extras!=null)
            num3=extras.getString("f3");
        if(extras!=null)
        num4=extras.getString("f4");
        if(extras!=null)
        num5=extras.getString("f5");
        if(extras!=null)
        num6=extras.getString("f6");
        if(extras!=null)
        num7=extras.getString("f7");
        if(extras!=null)
        num8=extras.getString("f8");
        t1 = (EditText) findViewById(R.id.s1);
        t2 = (EditText) findViewById(R.id.s2);
        t3 = (EditText) findViewById(R.id.s3);
        t4 = (EditText) findViewById(R.id.s4);
        t1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = t1.getText().length();

                if (textlength1 >= 1) {
                    t2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });
        t2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = t2.getText().length();

                if (textlength1 >= 1) {
                    t3.requestFocus();
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
        t3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = t3.getText().length();

                if (textlength1 >= 1) {
                    t4.requestFocus();
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
        t4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = t4.getText().length();

                if (textlength1 >= 1) {
                    t1.requestFocus();
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

    public void onclick(View view)
    {


            ans1 = t1.getText().toString();
            ans2 = t2.getText().toString();
            ans3 = t3.getText().toString();
            ans4 = t4.getText().toString();
        if(((ans1.equals(ans2))||(ans1.equals(ans3))||(ans1.equals(ans4)))||
                ((ans2.equals(ans4))||(ans2.equals(ans3))||(ans2.equals(ans1)))||
                ((ans3.equals(ans4))||(ans3.equals(ans1))||(ans3.equals(ans2)))||
                ((ans4.equals(ans2))||(ans4.equals(ans1))||(ans4.equals(ans3)))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Oops");
            builder.setMessage("Please enter a 4 digit non-repeating number to guess");
            builder.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    t1.getText().clear();
                    t2.getText().clear();
                    t3.getText().clear();
                    t4.getText().clear();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else{
            t1.getText().clear();
            t2.getText().clear();
            t3.getText().clear();
            t4.getText().clear();
            getzero();
            countinc();

            if (count % 2 == 1) {
                Log.d("mytag", ans1 + num5);
                if (ans1.equals(num5)) {
                    p1m++;
                } else if (ans1.equals(num6) || ans1.equals(num7) || ans1.equals(num8))
                    p1e++;
                if (ans2.equals(num6))
                    p1m++;
                else if (ans2.equals(num5) || ans2.equals(num7) || ans2.equals(num8))
                    p1e++;
                if (ans3.equals(num7))
                    p1m++;
                else if (ans3.equals(num6) || ans3.equals(num5) || ans3.equals(num8))
                    p1e++;
                if (ans4.equals(num8))
                    p1m++;
                else if (ans4.equals(num6) || ans4.equals(num7) || ans4.equals(num5))
                    p1e++;
                TextView Player1 = (TextView) findViewById(player1);
                String text1 ="<br>"+ans1 + ans2 + ans3 + ans4+"="+"<font color ='blue'>"+Integer.toString(p1e)+"</font>:"+Integer.toString(p1m);
                // player2.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
                Spanned txt1=Html.fromHtml(text1);
                Player1.append(txt1);

                //Player1.append("\n" + ans1 + ans2 + ans3 + ans4 + " " + p1m + ":" + p1e);
            } else if (count % 2 == 0) {
                if (ans1.equals(num1)) {
                    p2m++;
                } else if (ans1.equals(num2) || ans1.equals(num3) || ans1.equals(num4))
                    p2e++;
                if (ans2.equals(num2))
                    p2m++;
                else if (ans2.equals(num1) || ans2.equals(num3) || ans2.equals(num4))
                    p2e++;
                if (ans3.equals(num3))
                    p2m++;
                else if (ans3.equals(num2) || ans3.equals(num1) || ans3.equals(num4))
                    p2e++;
                if (ans4.equals(num4))
                    p2m++;
                else if (ans4.equals(num2) || ans4.equals(num3) || ans4.equals(num1))
                    p2e++;
                TextView player2 = (TextView) findViewById(R.id.player2);
                String text ="<br>"+ans1 + ans2 + ans3 + ans4+"="+"<font color ='blue'>"+Integer.toString(p2e)+"</font>:"+Integer.toString(p2m);
               // player2.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
                Spanned txt=Html.fromHtml(text);
                player2.append(txt);

                //player2.append("\n" + ans1 + ans2 + ans3 + ans4 + " " + p2m + " :" + p2e);
            }
        if((p1m==4)||(p2m==4)) {
            if (p1m == 4)
                result = "Player 1 Won";
            else
                result = "Player 2 Won";
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Congratulations!");
            builder.setMessage(result + " the match.Would you like to play again ? Thanks for trying mano's app ");
            builder.setPositiveButton("Play Again",new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int Button) {

                    Intent i = new Intent(game.this, MainActivity.class);
                    startActivity(i);
                }
            });


            builder.setNegativeButton("Exit",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                   // finish();
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    // Finish activity
                    //System.exit(0);

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        } }
    public void countinc(){
        count++;
    }
public void getzero(){ p1m=0;
p1e=0;
p2e=0;
p2m=0;}}



package com.engima.mapps.enigma;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import static com.engima.mapps.enigma.R.id.player1;
import static java.sql.Types.NULL;

public class game extends AppCompatActivity {
String num1,num2,num3,num4,num5,num6,num7,num8,num9;
    String ans1,ans2,ans3,ans4;
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

    }

    public void onclick(View view)
    {

            EditText t1 = (EditText) findViewById(R.id.s1);
            EditText t2 = (EditText) findViewById(R.id.s2);
            EditText t3 = (EditText) findViewById(R.id.s3);
            EditText t4 = (EditText) findViewById(R.id.s4);
            ans1 = t1.getText().toString();
            ans2 = t2.getText().toString();
            ans3 = t3.getText().toString();
            ans4 = t4.getText().toString();
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
                else if (ans4.equals(num6) || ans4.equals(num7) || ans4.equals(num8))
                    p1e++;
                TextView Player1 = (TextView) findViewById(player1);
                Player1.append("\n" + ans1 + ans2 + ans3 + ans4 + " " + p1m + ":" + p1e);
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
                else if (ans4.equals(num2) || ans4.equals(num3) || ans4.equals(num4))
                    p2e++;
                TextView player2 = (TextView) findViewById(R.id.player2);
                player2.append("\n" + ans1 + ans2 + ans3 + ans4 + " " + p2m + ":" + p2e);
            }
        if((p1m==4)||(p2m==4)) {
            if (p1m == 4)
                result = "Player 1 Won";
            else
                result = "Player 2 Won";
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Congratulations!");
            builder.setMessage(result + " the match.Would you like to play again ? Thanks for trying mano's app ");
            builder.setPositiveButton("Play Again",null);


            builder.setNegativeButton("Exit",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Finish activity
                    System.exit(0);

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        }
    public void countinc(){
        count++;
    }
public void getzero(){ p1m=0;
p1e=0;
p2e=0;
p2m=0;}}

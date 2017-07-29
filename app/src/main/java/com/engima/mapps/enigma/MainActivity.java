package com.engima.mapps.enigma;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mtoggle;
    private Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar =(Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mtoolbar);

        mDrawerlayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        mtoggle= new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotogamepage(View view)
    {
     Intent m =new Intent (this,GamePage.class);
        startActivity(m);
    }
    public void gotosingleplayer(View view)
    {
        Intent m =new Intent (this,Singleplayer.class);
        startActivity(m);
    }
}

package com.example.pagernew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{
    TabLayout tab;
    ViewPager viewPager;
    LinearLayout linearrecent;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearrecent=findViewById(R.id.linearrecent);
        linearrecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Recent.class);
                startActivity(intent);
            }
        });

        tab=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewpager);
       bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Toolbar toolbar=findViewById(R.id.toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#08103C"));

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);






        ViewPagerMessengerAdapter adapter=new ViewPagerMessengerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);





    }




}
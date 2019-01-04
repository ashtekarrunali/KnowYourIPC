package com.mytodo.pc.todonew.activity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activity.Activity.IntroActivity;

public class KnowURIPC extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView setting1=(ImageView)findViewById(R.id.setting);
        setting1.setVisibility(View.GONE);

        ImageView help1=(ImageView)findViewById(R.id.help);
        help1.setVisibility(View.GONE);


        ImageView fav=(ImageView)findViewById(R.id.star1);
        fav.setVisibility(View.GONE);

        ImageView star=(ImageView)findViewById(R.id.star);
        star.setVisibility(View.GONE);

/*
        ImageView search1=(ImageView)findViewById(R.id.search);
        search1.setVisibility(View.GONE);*/


        ImageView aboutUs=(ImageView)findViewById(R.id.aboutUs);
        aboutUs.setVisibility(View.GONE);

    Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        setTitle("KnowUR IPC ");

    }



  public void Enterbtnclick(View view){

        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
        finish();
    }

}

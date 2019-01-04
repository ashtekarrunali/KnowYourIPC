    package com.mytodo.pc.todonew.activity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activity.Activity.ChooseLanguageActivity;
import com.mytodo.pc.todonew.activity.Adapter.Adapter;
import com.mytodo.pc.todonew.activity.com.mytodo.pc.todonew.model.Intro;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {


  RecyclerView recyclerView;
    Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Intro> intros;
    private Object view;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       setTitle("KnowUR IPC");

       recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        List<Intro> intros = new ArrayList<>();

        //intros.add();
        Intro intro1 = new Intro();
        // intro0.setDescription("Favorites");
        intro1.setIcon(R.drawable.help);
        intros.add(intro1);


        Intro intro2 = new Intro();
        intro2.setDescription("Tap to see the list of section within the title.");
       // intro2.setIcon(R.drawable.screen1);
        intro2.setIcon(R.drawable.screen1_5);
        intros.add(intro2);


        Intro intro3 = new Intro();
        intro3.setDescription("Tap to see the content within the section");
        //intro3.setIcon(R.drawable.screen2);
        intro3.setIcon(R.drawable.touch5);
        intros.add(intro3);


        Intro intro4 = new Intro();
        intro4.setDescription("Section detail.");
        intro4.setIcon(R.drawable.screen3_5);
        intros.add(intro4);

        Intro intro5 = new Intro();
        intro5.setDescription("Language Setting");
        intro5.setIcon(R.drawable.setting);
        intros.add(intro5);


        Intro intro6=new Intro();
        intro6.setDescription("About us.");
        intro6.setIcon(R.drawable.info);
        intros.add(intro6);


        Intro intro7 = new Intro();
        intro7.setDescription("Help");
        intro7.setIcon(R.drawable.help);
        intros.add(intro7);


        Intro intro8 = new Intro();
        intro8.setDescription("Search within the application");
        intro8.setIcon(R.drawable.search);
        intros.add(intro8);

        Intro intro9 = new Intro();
        intro9.setDescription("Favorites.");
        intro9.setIcon(R.drawable.btn_star_big_off);
        intros.add(intro9);

        Intro intro10 = new Intro();
        intro10.setDescription("Use device back button to go back to the previous screen.");
        intro10.setIcon(R.drawable.arrowback5);
        intros.add(intro10);

        Intro intro11 = new Intro();
        intro11.setDescription("Click Refresh button to get the updated content/version.");
        intro11.setIcon(R.drawable.refresh_normal);
        intros.add(intro11);

        adapter = new Adapter(this, intros);
        recyclerView.setAdapter(adapter);
    }


 public void cancel(View view) {
  Intent intent = new Intent(this, ChooseLanguageActivity.class);
  startActivity(intent);
  finish();
 }
}



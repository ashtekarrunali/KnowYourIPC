package com.mytodo.pc.todonew.activity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activity.Activity.AboutUsActivity;
import com.mytodo.pc.todonew.activity.Activity.ChooseLanguageActivity;

import org.json.JSONArray;

public class DescriptionActivity extends AppCompatActivity {

    private TextView menuItemE;
    private TextView menuItemF;
    private JSONArray menuItemJsonArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ImageView star=(ImageView)findViewById(R.id.star);



        ImageView setting1 = (ImageView) findViewById(R.id.setting);
        //  setting.setVisibility(View.GONE);

        ImageView help1 = (ImageView) findViewById(R.id.help);
        help1.setVisibility(View.GONE);


        ImageView fav = (ImageView) findViewById(R.id.star1);
          fav.setVisibility(View.GONE);
/*
        ImageView search1 = (ImageView) findViewById(R.id.search);
        search1.setVisibility(View.GONE);*/

        ImageView info2 = (ImageView) findViewById(R.id.aboutUs);
        // info2.setVisibility(View.GONE);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("KnowUR IPC ");

        TextView menuItemE = (TextView) findViewById(R.id.menu_item_e);
        TextView menuItemF = (TextView) findViewById(R.id.menu_item_f);
        Intent intent = getIntent();
        String str = (String) intent.getStringExtra("itemE");
        String str1 = (String) intent.getStringExtra("itemF");
         Log.e("-->",str);
        menuItemE.setText(str);
        menuItemF.setText(str1);

    /*   Bundle b = getIntent().getExtras();
        String str=b.getString("E");*/

    }
    public void info5(View view){
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
        finish();
    }
    public void setting5(View view) {
        Intent intent = new Intent(this, ChooseLanguageActivity.class);
        startActivity(intent);
        finish();
    }
}

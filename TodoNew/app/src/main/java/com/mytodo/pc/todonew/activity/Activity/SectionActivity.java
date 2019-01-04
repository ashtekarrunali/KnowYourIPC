package com.mytodo.pc.todonew.activity.Activity;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activity.Activity.AboutUsActivity;
import com.mytodo.pc.todonew.activity.Adapter.SectionAdapter;
import com.mytodo.pc.todonew.activity.Activity.ChooseLanguageActivity;
import com.mytodo.pc.todonew.activityInterface.ItemClickListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SectionActivity extends AppCompatActivity  implements ItemClickListener {


    SectionAdapter sectionAdapter;
    RecyclerView.LayoutManager layoutManager;
    public List<String> mSection = new ArrayList<String>();

    public RecyclerView mRecyclerView;
    JSONArray menuItemJsonArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);


        ImageView setting1 = (ImageView) findViewById(R.id.setting);
        //  setting.setVisibility(View.GONE);

        ImageView help1 = (ImageView) findViewById(R.id.help);
        help1.setVisibility(View.GONE);


        ImageView fav = (ImageView) findViewById(R.id.star1);
        fav.setVisibility(View.GONE);

//        ImageView search1 = (ImageView) findViewById(R.id.search);
        // search1.setVisibility(View.GONE);

        ImageView star = (ImageView) findViewById(R.id.star);
        star.setVisibility(View.GONE);

        ImageView info2 = (ImageView) findViewById(R.id.info);
        // info2.setVisibility(View.GONE);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("KnowUR IPC ");


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);


        try {


            String str = getIntent().getStringExtra("itemA");// geting the string from intent
            Log.e("s2nd-->", str);//json string of D


            // convert string into json array


            //if get succ converted
            JSONObject jsonObj = new JSONObject(str);


            // Getting JSON Array node
            JSONArray contacts = jsonObj.getJSONArray("D");
            for (int i = 0; i < contacts.length(); i++) {

                JSONObject c = contacts.getJSONObject(i);

                //  String title = c.getString("title");
                String e = c.getString("E");
                String f = c.getString("F");
                // Log.d("", "contacts(i) ");

                //  Log.e("s3rd-->",title);
                Log.e("s3rd-->", e);
                Log.e("s3rd-->", f);


            }
            sectionAdapter = new SectionAdapter(this, contacts);
            mRecyclerView.setAdapter(sectionAdapter);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onClick(View view, int position) {

   /*     mSection.add("E");
        mSection.add("F");
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putStringArrayListExtra("E", (ArrayList<String>) mSection);
        intent.putStringArrayListExtra("F", (ArrayList<String>) mSection);
        startActivity(intent);*/


    }

    public void info5(View view) {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
        finish();
    }

    public void setting5(View view) {
        Intent intent = new Intent(this, ChooseLanguageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //  mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}


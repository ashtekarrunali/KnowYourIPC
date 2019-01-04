package com.mytodo.pc.todonew.activity.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
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

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activity.Adapter.ChapterAdapter;
import com.mytodo.pc.todonew.activity.Activity.ChooseLanguageActivity;
import com.mytodo.pc.todonew.activity.com.mytodo.pc.todonew.model.Chapters;
import com.mytodo.pc.todonew.activityInterface.ItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ChaptersActivity extends AppCompatActivity implements ItemClickListener {


    ChapterAdapter chapterAdapter;
    //  RecyclerView.LayoutManager layoutManager;
    List<Chapters> mchapters = new ArrayList<Chapters>();
    public RecyclerView mRecyclerView;
    JSONArray menuItemJsonArray;
    String name;
    JSONObject searchObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

       // ImageView search1 = (ImageView) findViewById(R.id.search);
        //  search.setVisibility(View.GONE);

        ImageView setting1 = (ImageView) findViewById(R.id.setting);
        //  setting.setVisibility(View.GONE);

        ImageView star1 = (ImageView) findViewById(R.id.star1);
        // star1.setVisibility(View.GONE);

        ImageView help1 = (ImageView) findViewById(R.id.help);
        help1.setVisibility(View.GONE);


        ImageView info2 = (ImageView) findViewById(R.id.aboutUs);
        info2.setVisibility(View.GONE);

        ImageView star=(ImageView)findViewById(R.id.star);
        star.setVisibility(View.GONE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("KnowUR IPC ");


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        String jsonDataString = null;
        try {
            jsonDataString = readJsonDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            menuItemJsonArray = new JSONArray(jsonDataString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < menuItemJsonArray.length(); i++) {


            try {
                JSONObject jsonObject = menuItemJsonArray.getJSONObject(i);
             /*   String title = jsonObject.getString("title");
                String E = jsonObject.getString("E");
                String f = jsonObject.getString("F");*/


               // Log.d("", "menuItemJsonArray(i)");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        chapterAdapter = new ChapterAdapter(this, menuItemJsonArray);
        mRecyclerView.setAdapter(chapterAdapter);
    }



    private String readJsonDataFromFile() throws IOException {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();
        try {
            String jsonDataString = null;
            switch (ChooseLanguageActivity.selectlang) {
                case 0:
                    inputStream = getResources().openRawResource(R.raw.book);
                    break;
                case 1:
                    inputStream = getResources().openRawResource(R.raw.hindi);
                    break;
                case 2:
                    inputStream = getResources().openRawResource(R.raw.marathi);
                    break;
            }
            //inputStream = getResources().openRawResource(R.raw.hindi);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonDataString = bufferedReader.readLine()) != null) {
                builder.append(jsonDataString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }

    @Override
    public void onClick(View view, int position) {


        try {
            JSONObject j = new JSONObject("D");
            Log.e("-->", j.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setting5(View view) {
        Intent intent = new Intent(this, ChooseLanguageActivity.class);
        startActivity(intent);
        finish();
    }

    public void search5(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);

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



                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}



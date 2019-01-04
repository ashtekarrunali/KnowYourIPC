package com.mytodo.pc.todonew.activity.Activity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mytodo.pc.todonew.R;

public class SearchActivity extends AppCompatActivity {

MaterialSearchView materialSearchView;
String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageView setting1 = (ImageView) findViewById(R.id.setting);
        setting1.setVisibility(View.GONE);

        ImageView help1 = (ImageView) findViewById(R.id.help);
        help1.setVisibility(View.GONE);


        ImageView fav = (ImageView) findViewById(R.id.star1);
        fav.setVisibility(View.GONE);

      /*  ImageView search1 = (ImageView) findViewById(R.id.search);
        search1.setVisibility(View.GONE);*/

        ImageView info5 = (ImageView) findViewById(R.id.aboutUs);
        info5.setVisibility(View.GONE);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("KnowUR IPC ");
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


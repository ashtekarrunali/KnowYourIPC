package com.mytodo.pc.todonew.activity.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytodo.pc.todonew.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ChooseLanguageActivity extends AppCompatActivity {

    public static InputStream inputStream;
    ImageView backicon;
    ImageView foricon;
    Button bt_lang;
    TextView lang;
    public static int selectlang;
    String json_GetString;
    ProgressDialog dialog;
    String json_url="http://mobicloudtechnologies.com/knowUrIPC/marathi.json";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading..");




        ImageView setting1 = (ImageView) findViewById(R.id.setting);
        setting1.setVisibility(View.GONE);

        ImageView help1 = (ImageView) findViewById(R.id.help);
        //   help.setVisibility(View.GONE);


        ImageView fav = (ImageView) findViewById(R.id.star1);
        fav.setVisibility(View.GONE);

       /* ImageView search1 = (ImageView) findViewById(R.id.search);
        search1.setVisibility(View.GONE);*/

        ImageView info2 = (ImageView) findViewById(R.id.aboutUs);

        ImageView star=(ImageView)findViewById(R.id.star);
        star.setVisibility(View.GONE);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("KnowUR IPC ");



        lang = (TextView) findViewById(R.id.lang);
        bt_lang = (Button) findViewById(R.id.bt_lang);
        backicon = (ImageView) findViewById(R.id.backicon);
        foricon = (ImageView) findViewById(R.id.foricon);

        bt_lang.setText(TempLang[selectlang]);
        lang.setText(TempLang1[selectlang]);

    }

    public String [] TempLang = {"ENGLISH", "हिंदी", "मराठी"};
    public String [] TempLang1= {"CHOOSE LANGUAGE","भाषा चुनें","भाषा निवडा"};


    public void backward(View view) {

        if (selectlang >0) {

            selectlang = selectlang - 1;

        }else{selectlang=2;

        }


        bt_lang.setText(TempLang[selectlang]);
        lang.setText(TempLang1[selectlang]);

    }

    public void forward(View view) {
        if (selectlang < 2) {

            selectlang = selectlang + 1;
        }else
            selectlang=0;

        bt_lang.setText(TempLang[selectlang]);
        lang.setText(TempLang1[selectlang]);

    }


    public String btEnter(View view) {


        URL url = null;
        try {
            url = new URL(json_url);
        HttpURLConnection httpURLConnection = null;
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            while ((json_GetString = bufferedReader.readLine()) != null) {
                stringBuffer.append(json_GetString + "\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuffer.toString().trim();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Intent intent = new Intent(this, ChaptersActivity.class);
        startActivity(intent);
        finish();

        return null;
    }



    public void que5(View view) {
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
        finish();
    }

    public void info5(View view) {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
        finish();
    }
}




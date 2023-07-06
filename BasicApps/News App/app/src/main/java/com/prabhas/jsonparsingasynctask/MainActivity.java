package com.prabhas.jsonparsingasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> titlesList;
    public void onGetLatestNewsClick(View view){
        DownloadNewsTask downloadNewsTask=new DownloadNewsTask();
        downloadNewsTask.execute("https://newsdata.io/api/1/news?apikey=pub_25774959106516f6fe31b57f7479a617926b9&language=en");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  DownloadNewsTask downloadNewsTask=new DownloadNewsTask();
    //    downloadNewsTask.execute("https://newsdata.io/api/1/news?apikey=pub_25774959106516f6fe31b57f7479a617926b9&language=en");
        titlesList=new ArrayList<>();
    }
    public class DownloadNewsTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String result="";
            URL url;
            HttpURLConnection httpURLConnection;
            try {
                url=new URL(strings[0]);
                httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                int data=inputStreamReader.read();
                while(data!=-1){
                    char ch=(char)data;
                    result+=ch;
                    data=inputStreamReader.read();
                }
               return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            try {
                JSONObject jsonObject=new JSONObject(s);
                String status=jsonObject.getString("status");
                String totalResults=jsonObject.getString("totalResults");
                String results=jsonObject.getString("results");
                JSONArray resultArray=new JSONArray(results);
                Log.i("result Status:",status);
                Log.i("result total:",totalResults);
                for(int i=0;i<resultArray.length();i++){
                    JSONObject jsonPart=resultArray.getJSONObject(i);
                    titlesList.add(jsonPart.getString("title"));
                    Log.i("Result Title:",jsonPart.getString("title"));
                    Log.i("Result Image",jsonPart.getString("image_url"));
                }
                calllistActivity();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        private void calllistActivity(){
            Intent intent=new Intent(MainActivity.this, NewsListActivity.class);
            intent.putExtra("data",titlesList);
            startActivity(intent);
        }
    }
}
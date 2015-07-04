package com.example.macieksm.screen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void takescreen(View view)throws Exception{
  View v=getWindow().getDecorView().getRootView();
  v.setDrawingCacheEnabled(true);
  Bitmap bitmap=Bitmap.createBitmap(v.getDrawingCache());
  v.setDrawingCacheEnabled(false);
  try {
      FileOutputStream fos = new FileOutputStream(new File(Environment
              .getExternalStorageDirectory().toString(), "SCREEN.jpeg"));
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
      fos.flush();
      fos.close();
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  } catch (IOException e) {
      e.printStackTrace();
  }
  Intent i=new Intent(MainActivity.this,MainActivity2.class);
  startActivity(i);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

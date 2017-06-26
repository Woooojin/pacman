package org.androidtown.pacman;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Finish extends AppCompatActivity {
    ImageView imageView01;
    Bitmap fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fin);
        imageView01 = (ImageView) findViewById(R.id.imageView01);
        fin = BitmapFactory.decodeResource(getResources(),R.drawable.fin);
        imageView01.setImageBitmap(fin);
        imageView01.getLayoutParams().width = 1080;
        imageView01.getLayoutParams().height = 1776;
    }
}

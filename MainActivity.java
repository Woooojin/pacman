package org.androidtown.pacman;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Bitmap home;
    ImageView imageView01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        int width = 1080;
        int height = 1776;
        int cx = width/2;
        int cy = height/2;
        //Bitmap home = BitmapFactory.decodeResource(getResources(),R.drawable.home);
        //home = Bitmap.createScaledBitmap(home,width,height,true);
        imageView01 = (ImageView) findViewById(R.id.imageView01);
        Resources res = getResources();
        home = BitmapFactory.decodeResource(getResources(),R.drawable.home11);
        imageView01.setImageBitmap(home);
        imageView01.getLayoutParams().width = 1080;
        imageView01.getLayoutParams().height = 1776;
        Button btnCreatePopup = (Button) findViewById(R.id.b);
    }
    public void onButton1clicked(View v) {
        Toast.makeText(getApplicationContext(), "시작 버튼이 눌렸어요",Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(getApplicationContext(), newActivity.class);
        startActivity(myIntent);
    }
}

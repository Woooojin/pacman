package org.androidtown.pacman;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class newActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
        }
    class MyView extends View {
        int width, height;
        int cx,cy;
        int rw,rh;
        int x,y;
        int sx,sy;
        float x1,x2,y1,y2;
        Bitmap pacman, home;

        public MyView (Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
            cx = width/2;
            cy = height/2;
            home = BitmapFactory.decodeResource(context.getResources(), R.drawable.map1);
            home = Bitmap.createScaledBitmap(home,width,height,true);
            pacman = BitmapFactory.decodeResource(context.getResources(),R.drawable.pac);
            pacman = Bitmap.createScaledBitmap(pacman,80,80,true);
            rw = pacman.getWidth()/2;
            rh = pacman.getHeight()/2;
        }
        public void onDraw(Canvas canvas){
            canvas.drawBitmap(home,0,0,null);
            canvas.drawBitmap(pacman,155,80,null);

        }
    }
}

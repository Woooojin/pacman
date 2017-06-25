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


/*
package org.androidtown.pacman;

import android.content.*;
import android.graphics.*;
import android.support.v7.widget.SearchView;
import android.view.*;
import android.view.SurfaceHolder.Callback;
import android.util.*;

abstract class newActivity extends SearchView implements Callback {
    GameThread mThread;
    SurfaceHolder mHolder;

    public newActivity(Context context, AttributeSet attrs){
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        mHolder=holder;
        mThread= new GameThread(holder, context);
        setFocusable(true);
    }

    protected abstract SurfaceHolder getHolder();

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        mThread.start();
    }


    @Override
    public void surfaceChange(SurfaceHolder arg0, int format, int width, int height){}

    class GameThread extends Thread{
        SurfaceHolder mHolder;

        int width, height, x, y, dw, dh, sx, sy, x1, y1;
        Bitmap map,pac;

        public GameThread(SurfaceHolder holder, Context context){
            mHolder = holder;
            Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight()-50;

            map = BitmapFactory.decodeResource(context.getResources(), R.drawable.map);
            map = Bitmap.createScaledBitmap(map,width,height,true);
            pac = BitmapFactory.decodeResource(context.getResources(),R.drawable.pac);
            pac = Bitmap.createScaledBitmap(pac,50,50,true);
            x=100;
            y=150;
            sx=3;
            sy=3;
            dw = pac.getWidth()/2;
            dh = pac.getHeight()/2;
        }

        public void pac_m(){
            x+=sx;
            y+=sy;
        }
        public void run() {
            Canvas canvas = null;
            while (true) {
                canvas = mHolder.lockCanvas();
                try {
                    synchronized (mHolder) {
                        pac_m();
                        canvas.drawBitmap(map, 0, 0, null);
                        canvas.drawBitmap(pac, 100, 150, null);
                    }
                } finally {
                    if (canvas != null)
                        mHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            mThread.x1 = (int) event.getX();
            mThread.y1 = (int) event.getY();
        }
        if(event.getAction()==MotionEvent.ACTION_UP){
            int x2 = (int) event.getX();
            int y2 = (int) event.getY();
            mThread.sx = (x2 - mThread.x1)/10;
            mThread.sy = (x2 - mThread.y1)/10;
        }
        return true;
    }
    public  void surfaceDestroyed(SurfaceHolder arg0){
        boolean done = true;
        while (done){
            try {
                mThread.join();
                done = false;
            }catch (InterruptedException e){
            }
        }
    }
}*/
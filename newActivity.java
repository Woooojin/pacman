package org.androidtown.pacman;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.MotionEvent;
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
        int pac_w=55,pac_h=80,p11=200,p12=100;
        int x=-1,y=-1;
        int right=0,left=0,up=0,down=0;
        Bitmap pacman, home,p2;

        public MyView (Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
            home = BitmapFactory.decodeResource(context.getResources(), R.drawable.map1);
            home = Bitmap.createScaledBitmap(home,width,height,true);
            pacman = BitmapFactory.decodeResource(context.getResources(),R.drawable.pac);
            pacman = Bitmap.createScaledBitmap(pacman,80,80,true);

            mHandler.sendEmptyMessageDelayed(0,50);
        }
        public void onDraw(Canvas canvas){
            getPacLocation();
            canvas.drawBitmap(home,0,0,null);
            canvas.drawBitmap(pacman,pac_w,pac_h,null);


        }
        private void getPacLocation(){
            if(up==1) pac_h-=10;
            else if(down==1) pac_h+=10;
            else if(right==1) pac_w+=10;
            else if(left==1) pac_w-=10;
        }
        Handler mHandler = new Handler(){
            public void handleMessage(Message msg){
                invalidate();
                mHandler.sendEmptyMessageDelayed(0,50);
            }
        };
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN){

                x = (int) event.getX();
                y = (int) event.getY();

                if(x>pac_w){
                    if(y>pac_h){
                        if(x-pac_w>y-pac_h){
                            up = 0;
                            down = 0;
                            right = 1;
                            left = 0;
                        }
                        else{
                            up = 0;
                            down = 1;
                            right = 0;
                            left = 0;
                        }
                    }
                    else if(y<pac_h){
                        if(x-pac_w>pac_h-y){
                            up = 0;
                            down = 0;
                            right = 1;
                            left = 0;
                        }
                        else{
                            up = 1;
                            down = 0;
                            right = 0;
                            left = 0;
                        }
                    }
                }else if(x<pac_w){
                    if(y>pac_h){
                        if(pac_w-x>y-pac_h){
                            up = 0;
                            down = 0;
                            right = 0;
                            left = 1;
                        }
                        else {
                            up = 0;
                            down = 1;
                            right = 0;
                            left = 0;
                        }
                    }
                    else if(y<pac_h){
                        if(pac_w-x>pac_h-y) {
                            up = 0;
                            down = 0;
                            right = 0;
                            left = 1;
                        }
                        else {
                            up = 1;
                            down = 0;
                            right = 0;
                            left = 0;
                        }
                    }
                }
            }

            invalidate();

            return true;
        }

    }
}

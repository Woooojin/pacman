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
        Bitmap pacman, home,eat;


        public MyView (Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
            home = BitmapFactory.decodeResource(context.getResources(), R.drawable.map1);
            home = Bitmap.createScaledBitmap(home,width,height,true);
            pacman = BitmapFactory.decodeResource(context.getResources(),R.drawable.pac);
            pacman = Bitmap.createScaledBitmap(pacman,80,80,true);
            eat = BitmapFactory.decodeResource(context.getResources(),R.drawable.eat);
            eat = Bitmap.createScaledBitmap(eat,80,80,true);
            mHandler.sendEmptyMessageDelayed(0,10);
        }
        public void onDraw(Canvas canvas){
            getPacLocation();
            canvas.drawBitmap(home,0,0,null);
            canvas.drawBitmap(eat,130,80,null);
            canvas.drawBitmap(eat,200,80,null);
            canvas.drawBitmap(eat,270,80,null);
            canvas.drawBitmap(eat,340,80,null);
            canvas.drawBitmap(eat,410,80,null);
            canvas.drawBitmap(eat,590,80,null);
            canvas.drawBitmap(eat,660,80,null);
            canvas.drawBitmap(eat,730,80,null);
            canvas.drawBitmap(eat,800,80,null);
            canvas.drawBitmap(eat,875,80,null);
            canvas.drawBitmap(eat,950,80,null);

            canvas.drawBitmap(eat,60,170,null);
            canvas.drawBitmap(eat,410,170,null);
            canvas.drawBitmap(eat,590,170,null);
            canvas.drawBitmap(eat,950,170,null);

            canvas.drawBitmap(eat,60,270,null);
            canvas.drawBitmap(eat,130,270,null);
            canvas.drawBitmap(eat,200,270,null);
            canvas.drawBitmap(eat,270,270,null);
            canvas.drawBitmap(eat,340,270,null);
            canvas.drawBitmap(eat,410,270,null);
            canvas.drawBitmap(eat,500,270,null);
            canvas.drawBitmap(eat,590,270,null);
            canvas.drawBitmap(eat,660,270,null);
            canvas.drawBitmap(eat,730,270,null);
            canvas.drawBitmap(eat,800,270,null);
            canvas.drawBitmap(eat,875,270,null);
            canvas.drawBitmap(eat,950,270,null);

            canvas.drawBitmap(eat,60,350,null);
            canvas.drawBitmap(eat,950,350,null);

            canvas.drawBitmap(eat,60,435,null);
            canvas.drawBitmap(eat,130,435,null);
            canvas.drawBitmap(eat,200,435,null);
            canvas.drawBitmap(eat,270,435,null);
            canvas.drawBitmap(eat,340,435,null);
            canvas.drawBitmap(eat,410,435,null);
            canvas.drawBitmap(eat,590,435,null);
            canvas.drawBitmap(eat,660,435,null);
            canvas.drawBitmap(eat,730,435,null);
            canvas.drawBitmap(eat,800,435,null);
            canvas.drawBitmap(eat,875,435,null);
            canvas.drawBitmap(eat,950,435,null);

            canvas.drawBitmap(eat,340,560,null);
            canvas.drawBitmap(eat,410,560,null);
            canvas.drawBitmap(eat,500,560,null);
            canvas.drawBitmap(eat,590,560,null);
            canvas.drawBitmap(eat,660,560,null);

            canvas.drawBitmap(eat,310,670,null);
            canvas.drawBitmap(eat,710,670,null);

            canvas.drawBitmap(eat,310,780,null);
            canvas.drawBitmap(eat,710,780,null);

            canvas.drawBitmap(eat,310,890,null);
            canvas.drawBitmap(eat,710,890,null);

            canvas.drawBitmap(eat,60,1000,null);
            canvas.drawBitmap(eat,130,1000,null);
            canvas.drawBitmap(eat,200,1000,null);
            canvas.drawBitmap(eat,270,1000,null);
            canvas.drawBitmap(eat,340,1000,null);
            canvas.drawBitmap(eat,410,1000,null);
            canvas.drawBitmap(eat,500,1000,null);
            canvas.drawBitmap(eat,590,1000,null);
            canvas.drawBitmap(eat,660,1000,null);
            canvas.drawBitmap(eat,730,1000,null);
            canvas.drawBitmap(eat,800,1000,null);
            canvas.drawBitmap(eat,875,1000,null);
            canvas.drawBitmap(eat,950,1000,null);

            canvas.drawBitmap(eat,60,1080,null);
            canvas.drawBitmap(eat,950,1080,null);

            canvas.drawBitmap(eat,60,1170,null);
            canvas.drawBitmap(eat,130,1170,null);
            canvas.drawBitmap(eat,200,1170,null);
            canvas.drawBitmap(eat,270,1170,null);
            canvas.drawBitmap(eat,340,1170,null);
            canvas.drawBitmap(eat,410,1170,null);
            canvas.drawBitmap(eat,590,1170,null);
            canvas.drawBitmap(eat,660,1170,null);
            canvas.drawBitmap(eat,730,1170,null);
            canvas.drawBitmap(eat,800,1170,null);
            canvas.drawBitmap(eat,875,1170,null);
            canvas.drawBitmap(eat,950,1170,null);

            canvas.drawBitmap(eat,60,1260,null);
            canvas.drawBitmap(eat,410,1260,null);
            canvas.drawBitmap(eat,590,1260,null);
            canvas.drawBitmap(eat,950,1260,null);

            canvas.drawBitmap(eat,60,1350,null);
            canvas.drawBitmap(eat,130,1350,null);
            canvas.drawBitmap(eat,200,1350,null);
            canvas.drawBitmap(eat,270,1350,null);
            canvas.drawBitmap(eat,340,1350,null);
            canvas.drawBitmap(eat,410,1350,null);
            canvas.drawBitmap(eat,500,1350,null);
            canvas.drawBitmap(eat,590,1350,null);
            canvas.drawBitmap(eat,660,1350,null);
            canvas.drawBitmap(eat,730,1350,null);
            canvas.drawBitmap(eat,800,1350,null);
            canvas.drawBitmap(eat,875,1350,null);
            canvas.drawBitmap(eat,950,1350,null);

            canvas.drawBitmap(pacman,pac_w,pac_h,null);

        }
        private void getPacLocation(){
            if(up==1) {
                if(pac_h<=80)  pac_h= pac_h;
                else if (pac_h==270&&pac_w>60&&pac_w<420) pac_h=pac_h;
                else if(pac_h==270&&pac_w>590&&pac_w<940) pac_h=pac_h ;
                else if(pac_h==435&&pac_w>60&&pac_w<940) pac_h=pac_h;
                else if(pac_h==270&&pac_w>420&&pac_w<590) pac_h=pac_h;
                else if(pac_h==560&&pac_w>420&&pac_w<590) pac_h=pac_h;
                else if(pac_h==1350&&pac_w>420&&pac_w<590) pac_h=pac_h;
                else if(pac_h==1000&&pac_w>310) pac_h=pac_h;
                else if(pac_h==1000&&pac_w<710) pac_h=pac_h;
                else if(pac_h==1000&&pac_w<310&&pac_w>710) pac_h=pac_h;
                else if(pac_h==1170&&pac_w>60&&pac_w<940) pac_h=pac_h;
                else if(pac_h==1350&&pac_w>60&&pac_w<420) pac_h=pac_h;
                else if(pac_h==1350&&pac_w>590&&pac_w<940) pac_h=pac_h;
                else pac_h-=5;
            }
            else if(down==1) {
                if(pac_h>=1350)  pac_h= pac_h;
                else if (pac_h==80&&pac_w>60&&pac_w<420) pac_h=pac_h;
                else if(pac_h==80&&pac_w>590&&pac_w<940) pac_h=pac_h ;
                else if(pac_h==270&&pac_w>60&&pac_w<940) pac_h=pac_h;
                else if(pac_h==435&&pac_w<310) pac_h=pac_h;
                else if(pac_h==435&&pac_w>710) pac_h=pac_h;
                else if(pac_h==560&&pac_w>310&&pac_w<710) pac_h=pac_h;
                else if(pac_h==1000&&pac_w>60&&pac_w<940) pac_h=pac_h;
                else if(pac_h==1170&&pac_w>60&&pac_w<420) pac_h=pac_h;
                else if(pac_h==11700&&pac_w>590&&pac_w<940) pac_h=pac_h;
                else pac_h+=5;
            }
            else if(right==1) {
                if(pac_w>=940)  pac_h= pac_h;
                else if (pac_w==60&&pac_h>80&&pac_h<270) pac_h=pac_h;
                else if (pac_w==420&&pac_h<270) pac_h=pac_h;
                else if (pac_w==590&&pac_h>80&&pac_h<270) pac_h=pac_h;
                else if (pac_w==60&&pac_h>270&&pac_h<435) pac_h=pac_h;
                else if(pac_w==420&&pac_h>270&&pac_h<560) pac_h=pac_h ;
                else if(pac_w==310&&pac_h>560&&pac_h<1000) pac_h=pac_h;
                else if(pac_w==710&&pac_h>435&&pac_h<1000) pac_h=pac_h;
                else if(pac_w==60&&pac_h>1000&&pac_h<1170) pac_h=pac_h;
                else if(pac_w==420&&pac_h>1000&&pac_h<1350) pac_h=pac_h;
                else if(pac_w==60&&pac_h>1170&&pac_h<1350) pac_h=pac_h;
                else if(pac_w==590&&pac_h>1170&&pac_h<1350) pac_h=pac_h;
                else pac_w+=5;
            }
            else if(left==1) {
                if(pac_w<=60) pac_h= pac_h;
                else if (pac_w==420&&pac_h>80&&pac_h<270) pac_h=pac_h;
                else if (pac_w==590&&pac_h<270) pac_h=pac_h;
                else if (pac_w==940&&pac_h>80&&pac_h<270) pac_h=pac_h;
                else if (pac_w==940&&pac_h>270&&pac_h<435) pac_h=pac_h;
                else if(pac_w==590&&pac_h>270&&pac_h<560) pac_h=pac_h ;
                else if(pac_w==710&&pac_h>560&&pac_h<1000) pac_h=pac_h;
                else if(pac_w==310&&pac_h>435&&pac_h<1000) pac_h=pac_h;
                else if(pac_w==940&&pac_h>1000&&pac_h<1170) pac_h=pac_h;
                else if(pac_w==590&&pac_h>1000&&pac_h<1350) pac_h=pac_h;
                else if(pac_w==420&&pac_h>1170&&pac_h<1350) pac_h=pac_h;
                else if(pac_w==940&&pac_h>1170&&pac_h<1350) pac_h=pac_h;
                else pac_w-=5;
            }
        }
        Handler mHandler = new Handler(){
            public void handleMessage(Message msg){
                invalidate();
                mHandler.sendEmptyMessageDelayed(0,10);
            }
        };
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                x = (int) event.getX();
                y = (int) event.getY();
                findDirection();
            }
            invalidate();
            return true;
        }

        public void findDirection(){

            if(x>pac_w){
                if(y>pac_h){
                    if(x-pac_w>y-pac_h){
                        up = 0;down = 0;right = 1;left = 0;
                    }else{
                        up = 0;down = 1;right = 0;left = 0;
                    }
                }else if(y<pac_h){
                    if(x-pac_w>pac_h-y){
                        up = 0;down = 0;right = 1;left = 0;
                    }else{
                        up = 1;down = 0;right = 0;left = 0;
                    }
                }
            }else if(x<pac_w){
                if(y>pac_h){
                    if(pac_w-x>y-pac_h){
                        up = 0;down = 0;right = 0;left = 1;
                    }else {
                        up = 0;down = 1;right = 0;left = 0;
                    }
                }else if(y<pac_h){
                    if(pac_w-x>pac_h-y) {
                        up = 0;down = 0;right = 0;left = 1;
                    }else {
                        up = 1;down = 0;right = 0;left = 0;
                    }
                }
            }
        }

    }
}

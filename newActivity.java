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
        int pac_w=55,pac_h=80;
        int x=-1,y=-1;
        Bitmap pacman, home;

        public MyView (Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
            home = BitmapFactory.decodeResource(context.getResources(), R.drawable.map1);
            home = Bitmap.createScaledBitmap(home,width,height,true);
            pacman = BitmapFactory.decodeResource(context.getResources(),R.drawable.pac);
            pacman = Bitmap.createScaledBitmap(pacman,80,80,true);
            mHandler.sendEmptyMessageDelayed(0,100);
        }
        public void onDraw(Canvas canvas){
            getPacLocation();
            canvas.drawBitmap(home,0,0,null);
            canvas.drawBitmap(pacman,pac_w,pac_h,null);

        }
        private void getPacLocation(){
            if(x!=-1&&y!=-1){
                if(x>pac_w){
                    pac_w+=10;
                }else if(x<pac_w){
                    pac_w -= 10;
                }else if(y>pac_h){
                    pac_h+=10;
                }else if(y<pac_h){
                    pac_h -= 10;
                }
            }
        }
        Handler mHandler = new Handler(){
            public void handleMessage(Message msg){
                invalidate();
                mHandler.sendEmptyMessageDelayed(0,100);
            }
        };
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN){

                x = (int) event.getX();
                y = (int) event.getY();

                if(x>pac_w){
                    pac_w+=10;
                }else if(x<pac_w){
                    pac_w -= 10;
                }else if(y>pac_h){
                    pac_h+=10;
                }else if(y<pac_h){
                    pac_h -= 10;
                }
            }

            invalidate();

            return true;
        }

    }
}

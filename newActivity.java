package org.androidtown.pacman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import java.util.TreeMap;

public class newActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    public TreeMap <Integer, Eat> eat = new TreeMap <Integer, Eat>();
    public int score=0,life=3;
    class Eat{
        public int x,y;
        public Bitmap img_eat;
        public Eat(int x,int y){
            this.x=x;this.y=y;
            img_eat = BitmapFactory.decodeResource(getResources(),R.drawable.eat);
            img_eat = Bitmap.createScaledBitmap(img_eat,80,80,true);
        }

    }
    class Location{
        public int x,y;
    }
    class MyView extends View {
        int width, height;
        int pac_w=55,pac_h=80,mon_w=500,mon_h=700;
        int x=-1,y=-1;
        boolean p_r,p_l,p_u,p_d;
        boolean m1_r,m1_l,m1_u,m1_d;
        Bitmap pacman, home,mon;
        boolean[] b = new boolean[98];


        public MyView (Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
            home = BitmapFactory.decodeResource(context.getResources(), R.drawable.map1);
            home = Bitmap.createScaledBitmap(home,width,height,true);
            pacman = BitmapFactory.decodeResource(context.getResources(),R.drawable.pac);
            pacman = Bitmap.createScaledBitmap(pacman,80,80,true);
            mon = BitmapFactory.decodeResource(context.getResources(),R.drawable.mon1);
            mon = Bitmap.createScaledBitmap(mon,90,90,true);
            mHandler.sendEmptyMessageDelayed(0,1);
            eatInit();
        }
        public void onDraw(Canvas canvas){
            Location pacLocation = new Location();
            Location monLocation = new Location();
            canvas.drawBitmap(home,0,0,null);
            for(Eat a : eat.values()){
                canvas.drawBitmap(a.img_eat,a.x,a.y,null);
            }
            remEat();
            pacLocation = getLocation(pac_w,pac_h,p_r,p_l,p_u,p_d);
            pac_w = pacLocation.x;
            pac_h = pacLocation.y;
            moveMonster();
            monLocation = getLocation(mon_w,mon_h,m1_r,m1_l,m1_u,m1_d);
            mon_w = monLocation.x;
            mon_h = monLocation.y;
            if(mon_w==pac_w && mon_h==pac_h){

            }

            canvas.drawBitmap(pacman,pac_w,pac_h,null);
            canvas.drawBitmap(mon,mon_w,mon_h,null);

            if(score==97){
                Intent fin = new Intent(getApplicationContext(), Finish.class);
                startActivity(fin);
            }
        }
        public void remEat(){
            for( TreeMap.Entry<Integer, Eat> i : eat.entrySet() ){
                if(pac_w==i.getValue().x && pac_h==i.getValue().y && b[i.getKey()]==false){
                    eat.remove(i.getKey());
                    score++;
                    break;
                }
            }
        }
        public void moveMonster(){
            if(score>5){
                m1_u=true;

            }
        }
        public Location getLocation(int x, int y, boolean r,boolean l,boolean u,boolean d){
            Location location = new Location();

            if(u==true) {
                if(y<=80)  y=y;
                else if (y==270&&x>60&&x<420) y=y;
                else if(y==270&&x>590&&x<940) y=y;
                else if(y==435&&x>60&&x<940) y=y;
                else if(y==270&&x>420&&x<590) y=y;
                else if(y==560&&x>420&&x<590) y=y;
                else if(y==1350&&x>420&&x<590) y=y;
                else if(y==1000&&x>310) y=y;
                else if(y==1000&&x<710) y=y;
                else if(y==1000&&x<310&&x>710) y=y;
                else if(y==1170&&x>60&&x<940) y=y;
                else if(y==1350&&x>60&&x<420) y=y;
                else if(y==1350&&x>590&&x<940) y=y;
                else y-=5;
            }
            else if(d==true) {
                if(y>=1350) y=y;
                else if (y==80&&pac_w>60&&pac_w<420) y=y;
                else if(y==80&&pac_w>590&&pac_w<940) y=y;
                else if(y==270&&pac_w>60&&pac_w<940) y=y;
                else if(y==435&&pac_w<310) y=y;
                else if(y==435&&pac_w>710) y=y;
                else if(y==560&&pac_w>310&&pac_w<710) y=y;
                else if(y==1000&&pac_w>60&&pac_w<940) y=y;
                else if(y==1170&&pac_w>60&&pac_w<420) y=y;
                else if(y==11700&&pac_w>590&&pac_w<940) y=y;
                else y+=5;
            }
            else if(r==true) {
                if(x>=940) x=x;
                else if (x==60&&y>80&&y<270)  x=x;
                else if (x==420&&y<270) x=x;
                else if (x==590&&y>80&&y<270)  x=x;
                else if (x==60&&y>270&&y<435)  x=x;
                else if(x==420&&y>270&&y<560)  x=x;
                else if(x==310&&y>560&&y<1000) x=x;
                else if(x==710&&y>435&&y<1000) x=x;
                else if(x==60&&y>1000&&y<1170) x=x;
                else if(x==420&&y>1000&&y<1350) x=x;
                else if(x==60&&y>1170&&y<1350) x=x;
                else if(x==590&&y>1170&&y<1350) x=x;
                else x+=5;
            }
            else if(l==true) {
                if(x<=60) x=x;
                else if (x==420&&y>80&&y<270) x=x;
                else if (x==590&&y<270) x=x;
                else if (x==940&&y>80&&y<270) x=x;
                else if (x==940&&y>270&&y<435) x=x;
                else if(x==590&&y>270&&y<560) x=x;
                else if(x==710&&y>560&&y<1000) x=x;
                else if(x==310&&y>435&&y<1000) x=x;
                else if(x==940&&y>1000&&y<1170) x=x;
                else if(x==590&&y>1000&&y<1350) x=x;
                else if(x==420&&y>1170&&y<1350) x=x;
                else if(x==940&&y>1170&&y<1350) x=x;
                else x-=5;
            }
            location.x=x;
            location.y=y;
            return location;
        }
        Handler mHandler = new Handler(){
            public void handleMessage(Message msg){
                invalidate();
                mHandler.sendEmptyMessageDelayed(0,1);
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

        public boolean canGo(boolean r,boolean l,boolean u,boolean d){
            int x=pac_w,y=pac_h;
            Location loc = new Location();
            loc.x=getLocation(x,y,r,l,u,d).x;
            loc.y=getLocation(x,y,r,l,u,d).y;
            if(x==loc.x && y==loc.y) return false;
            else return true;
        }

        public void findDirection(){
            if(x>pac_w){
                if(y>pac_h){
                    if(x-pac_w>y-pac_h){
                        if(canGo(true,false,false,false)==true) {
                            p_r = true;
                            p_l = false;
                            p_u = false;
                            p_d = false;
                        }
                    }else {
                        if (canGo(false, false, false, true)==true) {
                            p_r = false;
                            p_l = false;
                            p_u = false;
                            p_d = true;
                        }
                    }
                }else if(y<pac_h){
                    if(x-pac_w>pac_h-y) {
                        if (canGo(true, false, false, false)==true) {
                            p_r = true;
                            p_l = false;
                            p_u = false;
                            p_d = false;
                        }
                    }else {
                        if (canGo(false, false, true, false)==true) {
                            p_r = false;
                            p_l = false;
                            p_u = true;
                            p_d = false;
                        }
                    }
                }
            }else if(x<pac_w){
                if(y>pac_h){
                    if(pac_w-x>y-pac_h) {
                        if (canGo(false, true, false, false)==true) {
                            p_r = false;
                            p_l = true;
                            p_u = false;
                            p_d = false;
                        }
                    }else {
                        if (canGo(false, false, false, true)==true) {
                            p_r = false;
                            p_l = false;
                            p_u = false;
                            p_d = true;
                        }
                    }
                }else if(y<pac_h){
                    if(pac_w-x>pac_h-y) {
                        if (canGo(false, true, false, false)==true) {
                            p_r = false;
                            p_l = true;
                            p_u = false;
                            p_d = false;
                        }
                    }else {
                        if (canGo(false, false, true, false)==true) {
                            p_r = false;
                            p_l = false;
                            p_u = true;
                            p_d = false;
                        }
                    }
                }
            }
        }
        public void eatInit(){
            eat.put(1,new Eat(130,80));
            eat.put(2,new Eat(200,80));
            eat.put(3,new Eat(270,80));
            eat.put(4,new Eat(340,80));
            eat.put(5,new Eat(420,80));
            eat.put(6,new Eat(590,80));
            eat.put(7,new Eat(660,80));
            eat.put(8,new Eat(730,80));
            eat.put(9,new Eat(800,80));
            eat.put(10,new Eat(870,80));
            eat.put(11,new Eat(940,80));

            eat.put(12,new Eat(60,170));
            eat.put(13,new Eat(420,170));
            eat.put(14,new Eat(590,170));
            eat.put(15,new Eat(940,170));

            eat.put(16,new Eat(60,270));
            eat.put(17,new Eat(130,270));
            eat.put(18,new Eat(200,270));
            eat.put(19,new Eat(270,270));
            eat.put(20,new Eat(340,270));
            eat.put(21,new Eat(420,270));
            eat.put(22,new Eat(500,270));
            eat.put(23,new Eat(590,270));
            eat.put(24,new Eat(660,270));
            eat.put(25,new Eat(730,270));
            eat.put(26,new Eat(800,270));
            eat.put(27,new Eat(870,270));
            eat.put(28,new Eat(940,270));

            eat.put(29,new Eat(60,350));
            eat.put(30,new Eat(940,350));


            eat.put(31,new Eat(60,435));
            eat.put(32,new Eat(130,435));
            eat.put(33,new Eat(200,435));
            eat.put(34,new Eat(270,435));
            eat.put(35,new Eat(340,435));
            eat.put(36,new Eat(420,435));
            eat.put(37,new Eat(590,435));
            eat.put(38,new Eat(660,435));
            eat.put(39,new Eat(730,435));
            eat.put(40,new Eat(800,435));
            eat.put(41,new Eat(870,435));
            eat.put(42,new Eat(940,435));


            eat.put(43,new Eat(340,560));
            eat.put(44,new Eat(420,560));
            eat.put(45,new Eat(500,560));
            eat.put(46,new Eat(590,560));
            eat.put(47,new Eat(660,560));

            eat.put(48,new Eat(310,670));
            eat.put(49,new Eat(710,670));

            eat.put(50,new Eat(310,780));
            eat.put(51,new Eat(710,780));


            eat.put(52,new Eat(310,890));
            eat.put(53,new Eat(710,890));


            eat.put(54,new Eat(60,1000));
            eat.put(55,new Eat(130,1000));
            eat.put(56,new Eat(200,1000));
            eat.put(57,new Eat(270,1000));
            eat.put(58,new Eat(340,1000));
            eat.put(59,new Eat(420,1000));
            eat.put(60,new Eat(500,1000));
            eat.put(61,new Eat(590,1000));
            eat.put(62,new Eat(660,1000));
            eat.put(63,new Eat(730,1000));
            eat.put(64,new Eat(800,1000));
            eat.put(65,new Eat(870,1000));
            eat.put(66,new Eat(940,1000));


            eat.put(67,new Eat(60,1080));
            eat.put(68,new Eat(940,1080));


            eat.put(69,new Eat(60,1170));
            eat.put(70,new Eat(130,1170));
            eat.put(71,new Eat(200,1170));
            eat.put(72,new Eat(270,1170));
            eat.put(73,new Eat(340,1170));
            eat.put(74,new Eat(420,1170));
            eat.put(75,new Eat(590,1170));
            eat.put(76,new Eat(660,1170));
            eat.put(77,new Eat(730,1170));
            eat.put(78,new Eat(800,1170));
            eat.put(79,new Eat(870,1170));
            eat.put(80,new Eat(940,1170));

            eat.put(81,new Eat(60,1260));
            eat.put(82,new Eat(420,1260));
            eat.put(83,new Eat(590,1260));
            eat.put(84,new Eat(940,1260));

            eat.put(85,new Eat(60,1350));
            eat.put(86,new Eat(130,1350));
            eat.put(87,new Eat(200,1350));
            eat.put(88,new Eat(270,1350));
            eat.put(89,new Eat(340,1350));
            eat.put(90,new Eat(420,1350));
            eat.put(91,new Eat(500,1350));
            eat.put(92,new Eat(590,1350));
            eat.put(93,new Eat(660,1350));
            eat.put(94,new Eat(730,1350));
            eat.put(95,new Eat(800,1350));
            eat.put(96,new Eat(870,1350));
            eat.put(97,new Eat(940,1350));

        }

    }
}

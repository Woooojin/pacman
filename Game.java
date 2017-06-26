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

import static org.androidtown.pacman.R.drawable.p;

public class Game extends Activity {

    public int score=0,life=3;
    public TreeMap <Integer, Eat> eat = new TreeMap <Integer, Eat>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    class Eat{
        public int x,y;
        public Bitmap img_eat;
        public Eat(int x,int y){
            this.x=x;this.y=y;
            img_eat = BitmapFactory.decodeResource(getResources(),R.drawable.eat);
            img_eat = Bitmap.createScaledBitmap(img_eat,80,80,true);
        }
    }
    class MyView extends View {
        int width, height;
        int x,y;
        boolean[] b = new boolean[98];
        Bitmap home, pacmanDead,fin;
        Pacman pac = new Pacman();
        Monster1 mon1 = new Monster1();
        Monster2 mon2 = new Monster2();

        public MyView (Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
            init();
            mHandler.sendEmptyMessageDelayed(0,1);
            eatInit();
        }
        public void onDraw(Canvas canvas){
            canvas.drawBitmap(home,0,0,null);

            if((mon1.w == pac.w && mon1.h==pac.h)||(mon1.w+50 > pac.w && mon1.w-50< pac.w && mon1.h +50 >pac.h&& mon1.h-50<pac.h)){
                for(Eat a : eat.values()){
                    canvas.drawBitmap(a.img_eat,a.x,a.y,null);
                }
                canvas.drawBitmap(mon2.image,mon2.w,mon2.h,null);
                canvas.drawBitmap(pacmanDead,pac.w,pac.h,null);

                canvas.drawBitmap(fin,0,0,null);
            }else if((mon2.w==pac.w && mon2.h==pac.h)||(mon2.w+50 > pac.w && mon2.w-50< pac.w && mon2.h +50 >pac.h&& mon2.h-50<pac.h)){
                for(Eat a : eat.values()){
                    canvas.drawBitmap(a.img_eat,a.x,a.y,null);
                }
                canvas.drawBitmap(mon1.image,mon1.w,mon1.h,null);
                canvas.drawBitmap(pacmanDead,pac.w,pac.h,null);

                canvas.drawBitmap(fin,0,0,null);

            }else {
                for (Eat a : eat.values()) {
                    canvas.drawBitmap(a.img_eat, a.x, a.y, null);
                }
                remEat();
                pac.w = pac.getLocation(pac.w, pac.h, pac.r, pac.l, pac.u, pac.d).x;
                pac.h = pac.getLocation(pac.w, pac.h, pac.r, pac.l, pac.u, pac.d).y;
                mon1.moveMonster();
                mon1.w = mon1.getLocation(mon1.w, mon1.h, mon1.r, mon1.l, mon1.u, mon1.d).x;
                mon1.h = mon1.getLocation(mon1.w, mon1.h, mon1.r, mon1.l, mon1.u, mon1.d).y;
                mon2.moveMonster(pac.w, pac.h);
                mon2.w = mon2.getLocation(mon2.w, mon2.h, mon2.r, mon2.l, mon2.u, mon2.d).x;
                mon2.h = mon2.getLocation(mon2.w, mon2.h, mon2.r, mon2.l, mon2.u, mon2.d).y;

                canvas.drawBitmap(mon1.image, mon1.w, mon1.h, null);
                canvas.drawBitmap(mon2.image, mon2.w, mon2.h, null);
                canvas.drawBitmap(pac.image, pac.w, pac.h, null);
            }
            if(score==97){
                Intent fin = new Intent(getApplicationContext(), Finish.class);
                startActivity(fin);
            }
        }
        public void remEat(){
            for( TreeMap.Entry<Integer, Eat> i : eat.entrySet() ){
                if(pac.w==i.getValue().x && pac.h==i.getValue().y && b[i.getKey()]==false){
                    eat.remove(i.getKey());
                    score++;
                    break;
                }
            }
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
        public void findDirection(){
            if(x>pac.w){
                if(y>pac.h){
                    if(x-pac.w>y-pac.h){
                        if(pac.canGo(pac.w,pac.h,true,false,false,false)==true) {
                            pac.r = true;
                            pac.l = false;
                            pac.u = false;
                            pac.d = false;
                        }
                    }else {
                        if (pac.canGo(pac.w,pac.h,false, false, false, true)==true) {
                            pac.r = false;
                            pac.l = false;
                            pac.u = false;
                            pac.d = true;
                        }
                    }
                }else if(y<pac.h){
                    if(x-pac.w>pac.h-y) {
                        if (pac.canGo(pac.w,pac.h,true, false, false, false)==true) {
                            pac.r = true;
                            pac.l = false;
                            pac.u = false;
                            pac.d = false;
                        }
                    }else {
                        if (pac.canGo(pac.w,pac.h,false, false, true, false)==true) {
                            pac.r = false;
                            pac.l = false;
                            pac.u = true;
                            pac.d = false;
                        }
                    }
                }
            }else if(x<pac.w){
                if(y>pac.h){
                    if(pac.w-x>y-pac.h) {
                        if (pac.canGo(pac.w,pac.h,false, true, false, false)==true) {
                            pac.r = false;
                            pac.l = true;
                            pac.u = false;
                            pac.d = false;
                        }
                    }else {
                        if (pac.canGo(pac.w,pac.h,false, false, false, true)==true) {
                            pac.r = false;
                            pac.l = false;
                            pac.u = false;
                            pac.d = true;
                        }
                    }
                }else if(y<pac.h){
                    if(pac.w-x>pac.h-y) {
                        if (pac.canGo(pac.w,pac.h,false, true, false, false)==true) {
                            pac.r = false;
                            pac.l = true;
                            pac.u = false;
                            pac.d = false;
                        }
                    }else {
                        if (pac.canGo(pac.w,pac.h,false, false, true, false)==true) {
                            pac.r = false;
                            pac.l = false;
                            pac.u = true;
                            pac.d = false;
                        }
                    }
                }
            }
        }
        public void init(){
            home = BitmapFactory.decodeResource(getResources(), R.drawable.map1);
            home = Bitmap.createScaledBitmap(home,width,height,true);
            pacmanDead = BitmapFactory.decodeResource(getResources(), p);
            pacmanDead= Bitmap.createScaledBitmap(pacmanDead,80,80,true);
            pac.image = BitmapFactory.decodeResource(getResources(), R.drawable.pac);
            pac.image = Bitmap.createScaledBitmap(pac.image,80,80,true);
            mon1.image = BitmapFactory.decodeResource(getResources(),R.drawable.mon1);
            mon1.image = Bitmap.createScaledBitmap(mon1.image,90,90,true);
            mon2.image = BitmapFactory.decodeResource(getResources(),R.drawable.m2);
            mon2.image = Bitmap.createScaledBitmap(mon2.image,90,90,true);
            fin = BitmapFactory.decodeResource(getResources(),R.drawable.fin);
            fin = Bitmap.createScaledBitmap(fin,width,height,true);
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
            eat.put(31,new Eat(60,430));
            eat.put(32,new Eat(130,430));
            eat.put(33,new Eat(200,430));
            eat.put(34,new Eat(270,430));
            eat.put(35,new Eat(340,430));
            eat.put(36,new Eat(420,430));
            eat.put(37,new Eat(590,430));
            eat.put(38,new Eat(660,430));
            eat.put(39,new Eat(730,430));
            eat.put(40,new Eat(800,430));
            eat.put(41,new Eat(870,430));
            eat.put(42,new Eat(940,430));
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

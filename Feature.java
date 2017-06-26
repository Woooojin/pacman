package org.androidtown.pacman;

import android.graphics.Bitmap;

public class Feature {
    public Bitmap image;
    public boolean r,l,u,d;
    public int w,h;

    class Location{
        public int x,y;
    }
    public boolean canGo(int w, int h, boolean r,boolean l,boolean u,boolean d){
        int x=w,y=h;
        Location loc = new Location();
        loc.x=getLocation(x,y,r,l,u,d).x;
        loc.y=getLocation(x,y,r,l,u,d).y;
        if(x==loc.x && y==loc.y) return false;
        else return true;
    }
    public Location getLocation(int x, int y, boolean r,boolean l,boolean u,boolean d){
        Location location = new Location();
        if(u==true) {
            if(y<=80)  y=y;
            else if (y==270&&x>60&&x<420) y=y;
            else if(y==270&&x>590&&x<940) y=y;
            else if(y==430&&x>60&&x<940) y=y;
            else if(y==270&&x>420&&x<590) y=y;
            else if(y==560&&x>420&&x<590) y=y;
            else if(y==700&&x>310&&x<500) y=y;
            else if(y==700&&x>500&&x<710) y=y;
            else if(y==1350&&x>420&&x<590) y=y;
            else if(y==1000&&x>310) y=y;
            else if(y==1000&&x<710) y=y;
            else if(y==1000&&x<310&&x>710) y=y;
            else if(y==1170&&x>60&&x<940) y=y;
            else if(y==1350&&x>60&&x<420) y=y;
            else if(y==1350&&x>590&&x<940) y=y;
            else y-=10;
        }
        else if(d==true) {
            if(y>=1350) y=y;
            else if (y==80&&x>60&&x<420) y=y;
            else if(y==80&&x>590&&x<940) y=y;
            else if(y==270&&x>60&&x<940) y=y;
            else if(y==430&&x<310) y=y;
            else if(y==430&&x>710) y=y;
            else if((y==560||y>560)&&y<1000&&x>310&&x<710) y=y;
            else if(y==1000&&x>60&&x<940) y=y;
            else if(y==1170&&x>60&&x<420) y=y;
            else if(y==11700&&x>590&&x<940) y=y;
            else y+=10;
        }
        else if(r==true) {
            if(x>=940) x=x;
            else if (x==60&&y>80&&y<270)  x=x;
            else if (x==420&&y<270) x=x;
            else if (x==590&&y>80&&y<270)  x=x;
            else if (x==60&&y>270&&y<430)  x=x;
            else if(x==420&&y>270&&y<560)  x=x;
            else if(x==310&&y>560&&y<1000) x=x;
            else if(x==710&&y>430&&y<1000) x=x;
            else if(x==60&&y>1000&&y<1170) x=x;
            else if(x==420&&y>1000&&y<1350) x=x;
            else if(x==60&&y>1170&&y<1350) x=x;
            else if(x==590&&y>1170&&y<1350) x=x;
            else if(y>560&&y<1000&&x>310&&x<710) x=x;
            else x+=10;
        }
        else if(l==true) {
            if(x<=60) x=x;
            else if (x==420&&y>80&&y<270) x=x;
            else if (x==590&&y<270) x=x;
            else if (x==940&&y>80&&y<270) x=x;
            else if (x==940&&y>270&&y<430) x=x;
            else if(x==590&&y>270&&y<560) x=x;
            else if(x==710&&y>560&&y<1000) x=x;
            else if(x==310&&y>430&&y<1000) x=x;
            else if(x==940&&y>1000&&y<1170) x=x;
            else if(x==590&&y>1000&&y<1350) x=x;
            else if(x==420&&y>1170&&y<1350) x=x;
            else if(x==940&&y>1170&&y<1350) x=x;
            else if(y>560&&y<1000&&x>310&&x<710) x=x;
            else x-=10;
        }
        location.x=x;
        location.y=y;
        return location;
    }
}



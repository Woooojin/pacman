package org.androidtown.pacman;

public class Monster1 extends Feature {
    public Monster1(){
        w=500;h=700;
    }
    public void moveMonster() {
        if (canGo(w, h, r, l, u, d) == false) {
            if (canGo(w, h, false, true, false, false)) {
                r = false;
                l = true;
                u = false;
                d = false;
            } else if (canGo(w, h, false, false, false, true)) {
                r = false;
                l = false;
                u = false;
                d = true;
            } else if (canGo(w, h, true, false, false, false)) {
                r = true;
                l = false;
                u = false;
                d = false;
            } else if (canGo(w, h, false, false, true, false)) {
                r = false;
                l = false;
                u = true;
                d = false;
            }
        }
    }
}


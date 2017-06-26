package org.androidtown.pacman;

public class Monster2 extends Feature {
    public Monster2(){
        w=500;
        h=700;

    }
    public void moveMonster(int pac_w, int pac_h) {
        if (pac_w > w) {
            if (pac_h > h) {
                if (pac_w - w > pac_h - h) {
                    if (canGo(w, h, true, false, false, false) == true) {
                        r = true;
                        l = false;
                        u = false;
                        d = false;
                    }else  if (canGo(w, h, false, false, false, true) == true) {
                        r = false;
                        l = false;
                        u = false;
                        d = true;
                    }
                } else {
                    if (canGo(w, h, false, false, false, true) == true) {
                        r = false;
                        l = false;
                        u = false;
                        d = true;
                    }else  if (canGo(w, h, true, false, false, false) == true) {
                        r = true;
                        l = false;
                        u = false;
                        d = false;
                    }
                }
            } else if (h > pac_h) {
                if (pac_w - w > h - pac_h) {
                    if (canGo(w, h, true, false, false, false) == true) {
                        r = true;
                        l = false;
                        u = false;
                        d = false;
                    }else  if (canGo(w, h, false, false, true, false) == true) {
                        r = false;
                        l = false;
                        u = true;
                        d = false;
                    }
                } else {
                    if (canGo(w, h, false, false, true, false) == true) {
                        r = false;
                        l = false;
                        u = true;
                        d = false;
                    }else  if (canGo(w, h, true, false, false, false) == true) {
                        r = true;
                        l = false;
                        u = false;
                        d = false;
                    }
                }
            }
        } else if (w > pac_w) {
            if (h < pac_h) {
                if (w - pac_w > pac_h - h) {
                    if (canGo(w, h, false, true, false, false) == true) {
                        r = false;
                        l = true;
                        u = false;
                        d = false;
                    }else if (canGo(w, h, false, false, false, true) == true) {
                        r = false;
                        l = false;
                        u = false;
                        d = true;
                    }
                } else {
                    if (canGo(w, h, false, false, false, true) == true) {
                        r = false;
                        l = false;
                        u = false;
                        d = true;
                    }else if (canGo(w, h, false, true, false, false) == true){
                        r = false;
                        l = true;
                        u = false;
                        d = false;
                    }
                }
            } else if (h > pac_h) {
                if (w - pac_w > h - pac_h) {
                    if (canGo(w, h, false, true, false, false) == true) {
                        r = false;
                        l = true;
                        u = false;
                        d = false;
                    }else if (canGo(w, h, false, false, true, false) == true) {
                        r = false;
                        l = false;
                        u = true;
                        d = false;
                    }
                } else {
                    if (canGo(w,h, false, false, true, false) == true) {
                        r = false;
                        l = false;
                        u = true;
                        d = false;
                    }else if (canGo(w,h, false, true, false, false) == true){
                        r = false;
                        l = true;
                        u = false;
                        d = false;
                    }
                }
            }
        }
    }
}




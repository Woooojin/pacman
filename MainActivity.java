package org.androidtown.pacman;

import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new MyView(this));
    }
    public void onButton1clicked(View v) {
        Toast.makeText(getApplicationContext(), "시작 버튼이 눌렸어요",Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(getBaseContext(), newActivity.class);
        startActivity(myIntent);
    }
    class MyView extends View {
        //
        // MyView 전역변수 선언 영역
        //
        int width, height;
        int cx,cy;
        int rw,rh;
        Bitmap pacman;
        Button start;


        public MyView (Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
            cx = width/2;
            cy = height/2;
            pacman = BitmapFactory.decodeResource(context.getResources(),R.drawable.pac);
            rw = pacman.getWidth()/2;
            rh = pacman.getHeight()/2;

            //
            // 변수 초기화
            // 기능
        }
        public void onDraw(Canvas canvas){// view class에서 상속받은 것으로 canvas가 주어진다.
                                          // 이 영역에서 캔버스 조작 가
            //
            //실제로 그림을 그리는 영역
            //
            canvas.drawBitmap(pacman,cx-rw,cy-rh,null);
        }
    }
}
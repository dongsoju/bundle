package com.example.myappli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main:MainActivity";
    Bundle bundle;
    SingerAdapter singerAdapter;
    SingerDTO singerDTO;
    Sinner sinner;
    MainFragment mainFragment;
    Recyclemoem recyclemoem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 프래그먼트 생성
        mainFragment = new MainFragment();
        sinner = new Sinner();
        recyclemoem = new Recyclemoem();

        // 먼저 프래그먼트1이 처음 화면에 보이게 초기화
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contain, mainFragment).commit();
        // 디바이스 사이즈 구하기
        Point size = getDeviceSize();



    }
    private Point getDeviceSize(){
        Display display = getWindowManager().getDefaultDisplay(); // in Activity
        // getActivity.getWindowManager().getDefaultDisplay(); // in fragment
        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;
        int height = size.y;
        Log.d(TAG, "getDeviceSize: 넓이 => " + width
                + ", 높이 => " + height);
        return size;
    }

    public void fragmentControl(Fragment f, Bundle b) {
        bundle = b;
        getSupportFragmentManager().beginTransaction().replace(R.id.contain,f).commit();
    }

}
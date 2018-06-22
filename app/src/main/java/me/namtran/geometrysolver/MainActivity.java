package me.namtran.geometrysolver;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.container, fragment);
        //  transaction.show(fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
    private BottomNavigationView _navigationView;
    private Fragment solver, detail, history;
    public static ArrayList<HistoryItem> historyList;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    callFragment(solver);
                    return true;
                case R.id.navigation_dashboard:
                    callFragment(detail);
                    return true;
                case R.id.personal:
                    callFragment(history);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solver= new Solver();
        detail = new Detail();
        history = new History();
        callFragment(solver);
        _navigationView=findViewById(R.id.navigationView);
        _navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String sdate=dateFormat.format(date);
        historyList =new ArrayList<>();
        historyList.add(new HistoryItem("Bài 1: Tính chiều cao h","","a=3\nb=5\nTinh chieu cao?","h_a = 5cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
        historyList.add(new HistoryItem("Bài 2: Tính diện tích S","","a=3\nb=5\nTinh dien tich?", "S = 10cm2", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
        historyList.add(new HistoryItem("Bài 3: Tính a","","a=3\nb=5\nTinh a?", "a = 5cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
        historyList.add(new HistoryItem("Bài 4: Tính b","","a=3\nb=5\nTinh b?", "b = 4cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
        historyList.add(new HistoryItem("Bài 5: Tính c","","a=3\nb=5\nTinh c?", "c = 3cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
        historyList.add(new HistoryItem("Bài 6: Tính góc A","","a=3\nb=5\nTinh goc A?", " A = 30", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
    }
}

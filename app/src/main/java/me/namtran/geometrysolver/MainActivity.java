package me.namtran.geometrysolver;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public void callFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.container, fragment, tag);
        //  transaction.show(fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
    void clearBackStack()
    {
        FragmentManager fm = getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }
    private BottomNavigationView _navigationView;
    private Fragment solver, detail, history;
    public static ArrayList<HistoryItem> historyList;
    public static Bundle budleTriangle;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    clearBackStack();
                    callFragment(solver, "solver");
                    return true;
                case R.id.navigation_dashboard:
                    clearBackStack();
                    callFragment(detail, "detail");
                    return true;
                case R.id.personal:
                    clearBackStack();
                    callFragment(history, "history");
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        solver = new Solver();
        detail = new Detail();
        history = new History();
        _navigationView = findViewById(R.id.navigationView);
        _navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if(savedInstanceState==null) {
            callFragment(solver, "solver");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        String sdate=dateFormat.format(date);
            historyList = new ArrayList<>();
        }
//        historyList.add(new HistoryItem("Bài 1: Tính chiều cao h","","a=3\nb=5\nTinh chieu cao?","h_a = 5cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
//        historyList.add(new HistoryItem("Bài 2: Tính diện tích S","","a=3\nb=5\nTinh dien tich?", "S = 10cm2", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
//        historyList.add(new HistoryItem("Bài 3: Tính a","","a=3\nb=5\nTinh a?", "a = 5cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
//        historyList.add(new HistoryItem("Bài 4: Tính b","","a=3\nb=5\nTinh b?", "b = 4cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
//        historyList.add(new HistoryItem("Bài 5: Tính c","","a=3\nb=5\nTinh c?", "c = 3cm", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
//        historyList.add(new HistoryItem("Bài 6: Tính góc A","","a=3\nb=5\nTinh goc A?", " A = 30", "Buoc 1:\nBuoc 2:\nBuoc 3:", sdate));
    }
}

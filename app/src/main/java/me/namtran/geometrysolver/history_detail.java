package me.namtran.geometrysolver;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class history_detail extends Fragment {


    public history_detail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_detail, container, false);
        String value = getArguments().getString("position");
//        Toast.makeText(this.getActivity(), value, Toast.LENGTH_SHORT).show();
        int pos=Integer.parseInt(value);

        TextView title = (TextView)view.findViewById(R.id.textViewTitle);
        TextView time = (TextView)view.findViewById(R.id.textViewTime);
        TextView yeuCau = (TextView)view.findViewById(R.id.yeuCau);
        TextView ketQua = (TextView)view.findViewById(R.id.ketQua);
        TextView chiTiet = (TextView)view.findViewById(R.id.chiTiet);
        //
        String syeuCau=MainActivity.historyList.get(pos).getYeucau();
        String sketQua=MainActivity.historyList.get(pos).getKetqua();
        String schiTiet=MainActivity.historyList.get(pos).getLoiGiai();
        String stime=MainActivity.historyList.get(pos).getTimeCreate();
        title.setText(MainActivity.historyList.get(pos).getTitle());
        time.setText(stime);
        yeuCau.setText(syeuCau);
        ketQua.setText(sketQua);
        chiTiet.setText(schiTiet);
        return view;
    }

}

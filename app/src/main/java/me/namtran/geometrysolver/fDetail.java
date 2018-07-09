package me.namtran.geometrysolver;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class fDetail extends Fragment {


    public fDetail() {
        // Required empty public constructor
    }

    TextView _textViewTitle, _textViewTime, _yeuCau, _ketQua, _chiTiet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_detail, container, false);
        _textViewTime=view.findViewById(R.id.textViewTime);
        _textViewTitle=view.findViewById(R.id.textViewTitle);
        _yeuCau=view.findViewById(R.id.yeuCau);
        _ketQua=view.findViewById(R.id.ketQua);
        _chiTiet=view.findViewById(R.id.chiTiet);

        Bundle bundle=getArguments();
        if (bundle != null) {
            String _title=bundle.getString("title");
            String _time=bundle.getString("time");
            String _require=bundle.getString("require");
            String _result=bundle.getString("result");
            String _detail=bundle.getString("detail");

            _textViewTime.setText(_time);
            _textViewTitle.setText(_title);
            _yeuCau.setText(_require);
            _ketQua.setText(_result);
            _chiTiet.setText(_detail);
        }
        return view;
    }

}

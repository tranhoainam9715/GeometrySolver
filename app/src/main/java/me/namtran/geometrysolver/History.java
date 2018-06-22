package me.namtran.geometrysolver;


import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class History extends Fragment {


    public History() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_history, container, false);
        ListView listLichSu= (ListView)view.findViewById(R.id.listLichSu);

        CustomAdapter customAdapter=new CustomAdapter(this.getActivity(), R.layout.history_item, MainActivity.historyList);
        listLichSu.setAdapter(customAdapter);
        listLichSu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                history_detail history_fragment_detail = new history_detail();
                Bundle args = new Bundle();
                args.putString("position", Integer.toString(position));
                history_fragment_detail.setArguments(args);
                //Inflate the fragment
                FragmentTransaction trans=getFragmentManager().beginTransaction();
             trans.addToBackStack(null);
                trans.replace(R.id.container,history_fragment_detail).commit();
            }
        });
        return view;
    }

}

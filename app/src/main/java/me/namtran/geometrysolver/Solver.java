package me.namtran.geometrysolver;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class Solver extends Fragment {

    public void callFragment(Fragment fragment, String tag) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.subcontainer, fragment, tag);
        //  transaction.show(fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
    Fragment fragment;
    public Solver() {
        // Required empty public constructor
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String tag="Triangle";
            switch (position)
            {
                case 0:
                    fragment = new Triangle();
                    break;
                case 1:
                    fragment = new Rectangle();
                    tag="Rectangle";
                    break;
                case 2:
                    fragment = new Circle();
                    tag="Circle";
                    break;
                default: fragment = new Triangle();
            }
            callFragment(fragment, tag);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_solver, container, false);

        int[] imgGeometry = {R.drawable.triangle, R.drawable.rectangle, R.drawable.circle};
        String[] names={"Triangle", "Rectangle", "Circle"};
        Spinner spinner = (Spinner) view.findViewById(R.id.geometry_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
//                R.array.planets_array, android.R.layout.simple_spinner_item);
        SpinnerAdapter adapter=new SpinnerAdapter(Objects.requireNonNull(this.getActivity()),names, imgGeometry );// Specify the layout to use when the list of choices appears
       // adapter.setDropDownViewResource(R.layout.selector_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(onItemSelectedListener);
        return view;
    }

}

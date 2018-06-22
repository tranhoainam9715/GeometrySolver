package me.namtran.geometrysolver;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Triangle extends Fragment {

    /*************************************/
    //////List parameter
    ArrayList<Float> listPara;
    //Result
    float result=0;
    /*************************************/
    public Triangle() {
        // Required empty public constructor
    }
    EditText etValue, etResult;
    TextView tvParameters;
    Spinner spParameter, spResult;
    Button _btnAdd, _btnSolve;
    ArrayList<String> listParameterName;
    String[] lp={"a", "b", "c", "ha", "hb", "hc", "A", "B", "C", "S", "p", "r"};
    /////Position of selected item spiner parameters
    int paraPosition=-1;
    /////////////////////////
    /////Position of selected item spiner result
    int resultPosition=-1;
    /////////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triangle, container, false);
        //List of parameters
        listParameterName= new ArrayList<>();
        listPara=new ArrayList<>();
        int n=lp.length;
        for(int i=0; i<n; i++)
        {
            listParameterName.add(lp[i]);
        }
        for(int i=0; i<n; i++)
        {
            listPara.add((float)-1.0);
        }
        tvParameters=view.findViewById(R.id.tvParameter);
        etValue=view.findViewById(R.id.etValue);
        etResult=view.findViewById(R.id.etResult);
        _btnAdd = (Button)view.findViewById(R.id.btnAdd);
        _btnSolve=(Button)view.findViewById(R.id.btnSolve);
        spParameter = view.findViewById(R.id.spParameter);
        spResult = view.findViewById(R.id.spResult);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, listParameterName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spParameter.setAdapter(adapter);
        spParameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paraPosition=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ///


        ArrayAdapter<String> adapter_r = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, lp);
        adapter_r.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spResult.setAdapter(adapter_r);
        spResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultPosition=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /////////////////////////
        //Button event
        _btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(paraPosition>0) {
                    String svalue = etValue.getText().toString();
                    float value = Float.parseFloat(svalue);
                    //Catch exception
                    listPara.set(paraPosition, value);
                    listParameterName.remove(paraPosition);
                    String text = tvParameters.getText().toString();
                    if (text.equals("List of added parameters")) text = "";
                    text += "\n" + listParameterName.get(paraPosition) + " = " + Float.toString(value);
                    tvParameters.setText(text);
                    paraPosition=-1;
                }
            }
        });
        return view;
    }


}

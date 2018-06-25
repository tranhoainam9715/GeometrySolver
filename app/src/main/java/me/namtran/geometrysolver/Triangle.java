package me.namtran.geometrysolver;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Triangle extends Fragment {

    /*************************************/
    //////List parameter
    ArrayList<Float> listPara;
    Map<String, Float> UserValue = new HashMap<String, Float>();
    //Theo thứ tự
    //{"a", "b", "c", "ha", "hb", "hc", "A", "B", "C", "S", "p", "r"};
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
    int paraPosition=0;
    /////////////////////////
    /////Position of selected item spiner result
    int resultPosition=0;
    /////////////////////////

    int find(String[] list, String value)
    {
        int n=list.length;
        for(int i=0; i<n; i++)
            if(list[i].equals(value))
               return i;
        return -1;
    }
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
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, listParameterName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spParameter.setAdapter(adapter);

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
                spParameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        paraPosition=position;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                String textParameter = spParameter.getSelectedItem().toString();

                String svalue = etValue.getText().toString();
                if(!svalue.equals("")) {
                    try {
                        float value = Float.parseFloat(svalue);

                        UserValue.put(textParameter, value);

                        int pos=find(lp, listParameterName.get(paraPosition));
                        if(pos>=0)
                            listPara.set(pos, value);
                        String text = tvParameters.getText().toString();
                        if (text.equals("List of added parameters")) text = "";
                        text += textParameter + " = " + svalue + "\n";
                        tvParameters.setText(text);
                        //String t=listParaF(listPara);
                        //tvParameters.setText(t);
                        //paraPosition = 0;
                        int temp=paraPosition;
                        int nItem=listParameterName.size();
                        if(paraPosition>=nItem-1)
                            paraPosition-=1;
                        listParameterName.remove(temp);
                        etValue.setText("");
                        adapter.notifyDataSetChanged();

                    }
                    catch(NumberFormatException e)
                    {
                        Toast.makeText(Triangle.this.getActivity(), "Invalid value!", Toast.LENGTH_SHORT).show();
                    }


                }
                else Toast.makeText(Triangle.this.getActivity(), "Value cannot be empty!", Toast.LENGTH_SHORT).show();
            }
        });
        //Button solve onclick
        _btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textParameterResult = spResult.getSelectedItem().toString();


                XuLy xl = new XuLy();
                Log.d("debug", "xoxo");
                xl.main(UserValue, textParameterResult);
                String result = String.valueOf(xl.getResult());
                String text=lp[resultPosition] + " = " + result;
                etResult.setText(text);
            }
        });
        return view;
    }

//    String listParaF(ArrayList<Float> list)
//    {
//        String result="";
//        int n=list.size();
//        for(int i=0; i<n; i++)
//        {
//            result= result+lp[i]+" = "+list.get(i).toString()+"\n";
//        }
//        return result;
//    }

}

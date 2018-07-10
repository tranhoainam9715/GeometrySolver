package me.namtran.geometrysolver;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.LoggingPermission;

import mehdi.sakout.fancybuttons.FancyButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Triangle extends Fragment {

    /*************************************/
    //////List parameter
//    ArrayList<Float> listPara;
    //@@@
    String test;
    Map<String, Float> UserValue;
    //Theo thứ tự
    //{"a", "b", "c", "ha", "hb", "hc", "A", "B", "C", "S", "p", "r"};
    //Result
    float mResult=-1;
    /*************************************/
    public Triangle() {
        // Required empty public constructor
    }

    EditText etValue, etResult;
    TextView tvParameters;
    Spinner spParameter, spResult;
    FancyButton _btnAdd, _btnSolve, _btnSave, _btnNew, _btnDetail;
    ArrayList<String> listParameterName;
    String[] lp={"a", "b", "c", "ha", "hb", "hc", "A", "B", "C", "S", "p", "r"};
    /////Position of selected item spiner parameters
    int paraPosition=0;
    /////////////////////////
    /////Position of selected item spiner result
    int resultPosition=0;
    /////////////////////////
    XuLy xl;

    public static String wrapString(String string, int charWrap) {
        int lastBreak = 0;
        int nextBreak = charWrap;
        if (string.length() > charWrap) {
            String setString = "";
            do {
                while (string.charAt(nextBreak-1) != ':' && nextBreak > lastBreak) {
                    nextBreak--;
                }
                if (nextBreak == lastBreak) {
                    nextBreak = lastBreak + charWrap;
                }
                setString += string.substring(lastBreak, nextBreak).trim() + "\n";
                lastBreak = nextBreak;
                nextBreak += charWrap;

            } while (nextBreak < string.length());
            setString += string.substring(lastBreak).trim();
            return setString;
        } else {
            return string;
        }
    }

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

        xl= new XuLy();
        Log.d("debug", "xoxo");
        tvParameters = view.findViewById(R.id.tvParameter);
        etValue = view.findViewById(R.id.etValue);
        etResult = view.findViewById(R.id.etResult);
        _btnAdd = (FancyButton) view.findViewById(R.id.btnAdd);
        _btnSolve = (FancyButton) view.findViewById(R.id.btnSolve);
        _btnSave = view.findViewById(R.id.btnSave);
        _btnNew=view.findViewById(R.id.btnNew);
        _btnDetail= view.findViewById(R.id.btnDetail);
        spParameter = view.findViewById(R.id.spParameter);
        spResult = view.findViewById(R.id.spResult);
        //spResult
        ArrayAdapter<String> adapter_r = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, lp);
        adapter_r.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spResult.setAdapter(adapter_r);
        spResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Restore previous state
        if(MainActivity.budleTriangle!=null)
        {
            tvParameters.setText(MainActivity.budleTriangle.getString("tvParameters"));
            etValue.setText(MainActivity.budleTriangle.getString("etValue"));
            etResult.setText(MainActivity.budleTriangle.getString("etResult"));
            listParameterName=MainActivity.budleTriangle.getStringArrayList("listParameterName");
            UserValue=(Map<String, Float>) MainActivity.budleTriangle.getSerializable("UserValue");
            resultPosition=MainActivity.budleTriangle.getInt("resultPosition");
            spResult.setSelection(resultPosition);
        }
        else
        {
            UserValue = new HashMap<String, Float>();
            listParameterName = new ArrayList<>();
//            listPara = new ArrayList<>();
            int n = lp.length;
            for (int i = 0; i < n; i++) {
                listParameterName.add(lp[i]);
            }
//            for (int i = 0; i < n; i++) {
//                listPara.add((float) -1.0);
//            }

        }
        ///

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(Triangle.this.getActivity()), android.R.layout.simple_spinner_item, listParameterName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spParameter.setAdapter(adapter);

        ///

        /////////////////////////
        //FancyButton event
        _btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spParameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        paraPosition = position;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                String textParameter = spParameter.getSelectedItem().toString();

                String svalue = etValue.getText().toString();
                if (!svalue.equals("")) {
                    try {
                        float value = Float.parseFloat(svalue);

                        UserValue.put(textParameter, value);

                        int pos = find(lp, listParameterName.get(paraPosition));
//                        if (pos >= 0)
//                            listPara.set(pos, value);
                        String text = tvParameters.getText().toString();
                        if (text.equals("List of added parameters")) text = "";
                        text += textParameter + " = " + svalue + "\n";
                        tvParameters.setText(text);
                        //String t=listParaF(listPara);
                        //tvParameters.setText(t);
                        //paraPosition = 0;
                        int temp = paraPosition;
                        int nItem = listParameterName.size();
                        if (paraPosition >= nItem - 1)
                            paraPosition -= 1;
                        listParameterName.remove(temp);
                        etValue.setText("");
                        adapter.notifyDataSetChanged();

                    } catch (NumberFormatException e) {
                        Toast.makeText(Triangle.this.getActivity(), "Invalid value!", Toast.LENGTH_SHORT).show();
                    }


                } else
                    Toast.makeText(Triangle.this.getActivity(), "Value cannot be empty!", Toast.LENGTH_SHORT).show();
            }
        });
        //FancyButton solve onclick
        _btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textParameterResult = spResult.getSelectedItem().toString();



                xl.main(UserValue, textParameterResult);
                mResult = xl.getResult();
                String result = String.valueOf(mResult);
                String text = lp[resultPosition] + " = " + result;
                etResult.setText(text);
            }
        });
        _btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] title = new String[1];
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Triangle.this.getActivity());
                View mView = getLayoutInflater().inflate(R.layout.dl_save, null);
                final EditText _etTitle = (EditText) mView.findViewById(R.id.etTitle);

                Button _btnSaveDl = (Button) mView.findViewById(R.id.btnSaveDl);
                Button _btnCancel = mView.findViewById(R.id.btnCancel);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                _btnSaveDl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!_etTitle.getText().toString().isEmpty()) {
                            title[0] = _etTitle.getText().toString();
                            String require = getRequire(lp[resultPosition], UserValue);
                            String result = etResult.getText().toString();
                            String loigiai="";
                            try {
                                String[] lLoiGiai = xl.cacBuocGiai();
                                loigiai=getBuocGiai(lLoiGiai);
                            }
                            catch (Exception ex)
                            {
                                Log.e("Triangle", ex.getMessage());
                            }
                            loigiai = wrapString(loigiai, 35);
                            Date createDate = new Date();
                            HistoryItem item = new HistoryItem(title[0], null, require, result, loigiai, createDate.toString());
                            MainActivity.historyList.add(item);
                            Toast.makeText(Triangle.this.getActivity(),
                                    "Item saved!",
                                    Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(Triangle.this.getActivity(),
                                    R.string.empty_value,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                _btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            }
        });
        _btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Refresh state
                tvParameters.setText(R.string.default_tvParameters);
                etValue.setText("");
                etResult.setText(R.string.default_etResult);
                UserValue = new HashMap<String, Float>();
                listParameterName.clear();
                int n = lp.length;
                for (int i = 0; i < n; i++) {
                    listParameterName.add(lp[i]);
                }
                adapter.notifyDataSetChanged();
            }
        });

        _btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fDetail fragment_detail = new fDetail();
                Bundle args = new Bundle();
                String s_require=lp[resultPosition];
                String _title= "Tính "+ s_require+"?";
                String _require=getRequire(s_require, UserValue);
                String _result= etResult.getText().toString();
                String _detail="";
                try {
                    String[] lLoiGiai = xl.cacBuocGiai();
                    _detail=getBuocGiai(lLoiGiai);
                }
                catch (Exception ex)
                {
                    Log.e("Triangle", ex.getMessage());
                }
                _detail = wrapString(_detail, 35);
                Date dDate=new Date();
                args.putString("title", _title );
                args.putString("time",dDate.toString() );
                args.putString("require", _require);
                args.putString("result", _result);
                args.putString("detail",_detail );
                fragment_detail.setArguments(args);
                //Inflate the fragment
                FragmentTransaction trans=getFragmentManager().beginTransaction();
                trans.addToBackStack(null);
                trans.replace(R.id.container,fragment_detail).commit();
            }
        });
        return view;
    }

    String getRequire(String srequire, Map<String, Float> userValue)
    {
        StringBuilder result= new StringBuilder();
        result.append("Tìm ").append(srequire).append(" ?");
        result.append("\nDữ kiện: ");
        for(Map.Entry m:userValue.entrySet()){
            result.append("\n\t").append(m.getKey()).append(" = ").append(m.getValue());
        }
        return result.toString();
    }

    String getBuocGiai(String[] list)
    {
        StringBuilder builder=new StringBuilder("");
        for(String s: list)
        {
            builder.append("\t").append(s).append("\n");
        }
        return builder.toString();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.budleTriangle=new Bundle();
        MainActivity.budleTriangle.putString("tvParameters", tvParameters.getText().toString());
        MainActivity.budleTriangle.putString("etValue", etValue.getText().toString());
        MainActivity.budleTriangle.putString("etResult", etResult.getText().toString());
        MainActivity.budleTriangle.putStringArrayList("listParameterName", listParameterName);
        MainActivity.budleTriangle.putSerializable("UserValue", (Serializable) UserValue);
        MainActivity.budleTriangle.putInt("resultPosition", resultPosition);
    }
    //    String getResult(String re, float result)
//    {
//        StringBuilder mres=new StringBuilder("");
//        mres.append(re).append(" = ").append(Float.toString(result));
//        return mres.toString();
//    }
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

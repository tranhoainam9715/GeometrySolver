package me.namtran.geometrysolver;

import android.util.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Global {
    public static HashSet<String> BienGiaThiet = new HashSet<String>();
    static public Map<String, Float> Variables = new HashMap<String , Float>();

    public static float GetValue(String VarName) {
        return Variables.get(VarName);
    }

    public static boolean HaveValue(String varName) {
         return Variables.get(varName) != -1;
    }

    public static void UpdateVarValue(String strTargetGetVarName, float v) {
        Log.d("debug", "UpdateVarValue: " + strTargetGetVarName+" " + v);
            Variables.put(strTargetGetVarName, v);
    }
    public static void setBienGiaThiet(String s){
        BienGiaThiet.add(s);
    }

    public static boolean isBienGiaiThiet(String s){
        return BienGiaThiet.contains(s);
    }
}

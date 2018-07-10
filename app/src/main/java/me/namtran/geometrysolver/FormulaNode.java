package me.namtran.geometrysolver;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class FormulaNode extends Node {
    public String Name; //s = 0.5*a*hA;
    public Map<String, MyFunction> Functions = new HashMap<String, MyFunction>();
    private String cacBien;

    public String[] getCacBien(){
        return cacBien.split(" ");
    }

    public FormulaNode(String Name, boolean bActived, String cacBien) {
        this.Name = Name;
        this.bActived = bActived;
        this.cacBien = cacBien;
    }

    public void AddMethod(String VarName, MyFunction f){
        Functions.put(VarName, f);
    }

    @Override
    public boolean CanActive() {
        int n = getCacBien().length;
        int c = 0;
        for ( String VarName : Functions.keySet()){
            if (Global.HaveValue(VarName)){
                Log.d("dm", "CanActive: " + this.getName() + " " +VarName + "=" + Global.GetValue(VarName));
                c++;
            }

        }

        return n - 1 == c;
    }

    @Override
    public BuocGiai Active() {
        String strTargetGetVarName = FindTargetVarName();
        if (strTargetGetVarName == null) return null;
        MyFunction f = Functions.get(strTargetGetVarName);
        if (f == null) {this.bActived = false; return null;}
        float v = f.Eval();

        Log.d("debug", "Active: " + Functions.keySet());
        Global.UpdateVarValue(strTargetGetVarName, v);
        this.bActived = true;
        return new BuocGiai(strTargetGetVarName, v, this);

    }

    private String FindTargetVarName() {
        for ( String VarName : Functions.keySet()){
            if (!Global.HaveValue(VarName))
                return VarName;
        }
        return null;
    }

    public String getName() {
        return Name;
    }
}

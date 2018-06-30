package me.namtran.geometrysolver;

import android.util.Log;


class Func16_S extends MyFunction {
    @Override
    public float Eval() {
        Log.d("debug", "Eval: " + Global.GetValue("ha") + Global.GetValue("a"));
        return Global.GetValue("ha")*Global.GetValue("a")/2;
    }
}

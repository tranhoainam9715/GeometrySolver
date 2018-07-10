package me.namtran.geometrysolver;

import android.util.Log;

class Func7_S extends MyFunction {
    @Override
    public float Eval() {
        float p = Global.GetValue("p");
        float b = Global.GetValue("b");
        float c = Global.GetValue("c");
        float a = Global.GetValue("a");
        Log.d("debug", "Eval: p" + p);

        return (float)Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

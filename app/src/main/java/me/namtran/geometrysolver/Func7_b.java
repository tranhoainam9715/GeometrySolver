package me.namtran.geometrysolver;

class Func7_b extends MyFunction {
    @Override
    public float Eval() {
        float p = Global.GetValue("S");
        float a = Global.GetValue("a");
        float c = Global.GetValue("c");
        float S = Global.GetValue("S");

        return p-S*S/(p*(p-a)*(p-c));    }
}

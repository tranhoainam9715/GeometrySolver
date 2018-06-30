package me.namtran.geometrysolver;

class Func7_a extends MyFunction {
    @Override
    public float Eval() {
        float p = Global.GetValue("S");
        float b = Global.GetValue("b");
        float c = Global.GetValue("c");
        float S = Global.GetValue("S");

        return p-S*S/(p*(p-b)*(p-c));
    }
}

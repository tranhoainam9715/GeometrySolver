package me.namtran.geometrysolver;

class Func7_c extends MyFunction {
    @Override
    public float Eval() {
        float p = Global.GetValue("S");
        float b = Global.GetValue("b");
        float a = Global.GetValue("a");
        float S = Global.GetValue("S");

        return p-S*S/(p*(p-b)*(p-a));
    }
}

package me.namtran.geometrysolver;

class Func17_b extends MyFunction {
    @Override
    public float Eval() {
        return 2*Global.GetValue("S")/Global.GetValue("hb");
    }
}

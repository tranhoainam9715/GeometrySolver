package me.namtran.geometrysolver;

class Func19_b extends MyFunction {
    @Override
    public float Eval() {
        return 2*Global.GetValue("S")/Global.GetValue("a")/(float)Math.sin(Math.toRadians(Global.GetValue("C")));

    }
}

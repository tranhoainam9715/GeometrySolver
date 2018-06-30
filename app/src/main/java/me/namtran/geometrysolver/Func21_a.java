package me.namtran.geometrysolver;

class Func21_a extends MyFunction {
    @Override
    public float Eval() {
        return 2*Global.GetValue("S")/Global.GetValue("c")/(float)Math.sin(Math.toRadians(Global.GetValue("B")));

    }
}

package me.namtran.geometrysolver;

class Func20_c extends MyFunction {
    @Override
    public float Eval() {
        return 2*Global.GetValue("S")/Global.GetValue("b")/(float)Math.sin(Math.toRadians(Global.GetValue("A")));

    }
}

package me.namtran.geometrysolver;

class Func20_S extends MyFunction {
    @Override
    public float Eval() {
        return Global.GetValue("c")*Global.GetValue("b")*(float)Math.sin(Math.toRadians(Global.GetValue("A")))/2;

    }
}

package me.namtran.geometrysolver;

class Func21_S extends MyFunction {
    @Override
    public float Eval() {
        return Global.GetValue("c")*Global.GetValue("a")*(float)Math.sin(Math.toRadians(Global.GetValue("B")))/2;

    }
}

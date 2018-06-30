package me.namtran.geometrysolver;

class Func19_S extends MyFunction {
    @Override
    public float Eval() {
        return Global.GetValue("a")*Global.GetValue("b")*(float)Math.sin(Math.toRadians(Global.GetValue("C")))/2;

    }
}

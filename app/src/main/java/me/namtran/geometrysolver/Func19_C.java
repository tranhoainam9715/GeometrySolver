package me.namtran.geometrysolver;

class Func19_C extends MyFunction {
    @Override
    public float Eval() {
        return (float)Math.toDegrees(Math.asin(2*Global.GetValue("S")/Global.GetValue("b")/Global.GetValue("a")));
    }
}

package me.namtran.geometrysolver;

class Func21_B extends MyFunction {
    @Override
    public float Eval() {
        return (float)Math.toDegrees(Math.asin(2*Global.GetValue("S")/Global.GetValue("a")/Global.GetValue("c")));

    }
}

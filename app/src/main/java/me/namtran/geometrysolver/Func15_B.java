package me.namtran.geometrysolver;

class Func15_B extends MyFunction {
    @Override
    public float Eval() {
        return 180-Global.GetValue("A")-Global.GetValue("C");

    }
}

package me.namtran.geometrysolver;

class Func15_C extends MyFunction {
    @Override
    public float Eval() {
        return 180-Global.GetValue("B")-Global.GetValue("A");

    }
}

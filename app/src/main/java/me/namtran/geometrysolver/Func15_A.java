package me.namtran.geometrysolver;

class Func15_A extends MyFunction {
    @Override
    public float Eval() {
        return 180-Global.GetValue("B")-Global.GetValue("C");

    }
}

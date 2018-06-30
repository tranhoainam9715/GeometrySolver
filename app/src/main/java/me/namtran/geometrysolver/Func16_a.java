package me.namtran.geometrysolver;

class Func16_a extends MyFunction {
    @Override
    public float Eval() {
        return 2*Global.GetValue("S")/Global.GetValue("ha");
    }
}

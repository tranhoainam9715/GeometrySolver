package me.namtran.geometrysolver;

class Func62 extends MyFunction {

    @Override
    public float Eval() {
        return Global.GetValue("S")/ Global.GetValue("r");
    }
}

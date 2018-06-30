package me.namtran.geometrysolver;

class Func14_p extends MyFunction{


    @Override
    public float Eval() {
        return (Global.GetValue("a")+Global.GetValue("b")+Global.GetValue("c"))/2;
    }
}

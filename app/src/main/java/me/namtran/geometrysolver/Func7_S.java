package me.namtran.geometrysolver;

class Func7_S extends MyFunction {
    @Override
    public float Eval() {
        float p = Global.GetValue("p");
        float b = Global.GetValue("b");
        float c = Global.GetValue("c");
        float a = Global.GetValue("a");

        return (float)Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

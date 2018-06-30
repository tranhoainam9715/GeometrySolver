package me.namtran.geometrysolver;

import android.util.Log;

import java.util.Map;

public class XuLy {
    final String TAG = "debug";
    Node[] nodes = new Node[22];
    public float result;
    public void main(Map<String, Float> Value, String ResultName){

        Log.d(TAG, "main: " + Value.size());
        AddVarNode();

        AddFormulaNode();

        UpdateVarNode(Value);

        Computing();

        result = Global.GetValue(ResultName);

    }

    private void UpdateVarNode(Map<String, Float> Value) {
        for (Map.Entry<String, Float> pair : Value.entrySet()){
            String key = pair.getKey();
            float value = pair.getValue();
            Log.d(TAG, "UpdateVarNode: " + key + String.valueOf(value));
            Global.UpdateVarValue(key, value);
            
        }

    }

    public float getResult(){
        return result;
    }

    private void Computing() {
        boolean process = false;
        do{
            process = false;
            for ( int i = 0; i < nodes.length; i++)
            if (nodes[i].bActived == false){
                if (nodes[i].CanActive()){
                    Log.d("debug", "Computing: " + nodes[i].getName());
                    nodes[i].Active();
                    process = true;
                }
            }
        }
        while(process);
    }

    private void AddFormulaNode() {
        nodes[12] = new FormulaNode("S=p*r", false);
        ((FormulaNode)nodes[12]).AddMethod("S", new Func61());
        ((FormulaNode)nodes[12]).AddMethod("p", new Func62());
        ((FormulaNode)nodes[12]).AddMethod("r", new Func63());

        nodes[13] = new FormulaNode("S=sqrt(p*(p-a)*(p-b)*(p-c))", false);
        ((FormulaNode)nodes[13]).AddMethod("S", new Func7_S());
        ((FormulaNode)nodes[13]).AddMethod("p", new Func7_p());
        ((FormulaNode)nodes[13]).AddMethod("a", new Func7_a());
        ((FormulaNode)nodes[13]).AddMethod("b", new Func7_b());
        ((FormulaNode)nodes[13]).AddMethod("c", new Func7_c());

        nodes[14] = new FormulaNode("p=(a+b+c)/2", false);
        ((FormulaNode)nodes[14]).AddMethod("p", new Func14_p());
        ((FormulaNode)nodes[14]).AddMethod("a", new Func14_a());
        ((FormulaNode)nodes[14]).AddMethod("b", new Func14_b());
        ((FormulaNode)nodes[14]).AddMethod("c", new Func14_c());

        nodes[15] = new FormulaNode("A+B+C=180", false);
        ((FormulaNode)nodes[15]).AddMethod("A", new Func15_A());
        ((FormulaNode)nodes[15]).AddMethod("B", new Func15_B());
        ((FormulaNode)nodes[15]).AddMethod("C", new Func15_C());


        nodes[16] = new FormulaNode("S=1/2*a*ha", false);
        ((FormulaNode)nodes[16]).AddMethod("S", new Func16_S());
        ((FormulaNode)nodes[16]).AddMethod("a", new Func16_a());
        ((FormulaNode)nodes[16]).AddMethod("ha", new Func16_ha());


        nodes[17] = new FormulaNode("S=1/2*b*hb", false);
        ((FormulaNode)nodes[17]).AddMethod("S", new Func17_S());
        ((FormulaNode)nodes[17]).AddMethod("b", new Func17_b());
        ((FormulaNode)nodes[17]).AddMethod("hb", new Func17_hb());


        nodes[18] = new FormulaNode("S=1/2*c*hc", false);
        ((FormulaNode)nodes[18]).AddMethod("S", new Func18_S());
        ((FormulaNode)nodes[18]).AddMethod("c", new Func18_c());
        ((FormulaNode)nodes[18]).AddMethod("hc", new Func18_hc());


        nodes[19] = new FormulaNode("S=1/2*a*b*sin(C)", false);
        ((FormulaNode)nodes[19]).AddMethod("S", new Func19_S());
        ((FormulaNode)nodes[19]).AddMethod("a", new Func19_a());
        ((FormulaNode)nodes[19]).AddMethod("b", new Func19_b());
        ((FormulaNode)nodes[19]).AddMethod("C", new Func19_C());


        nodes[20] = new FormulaNode("S=1/2*b*c*sin(A)", false);
        ((FormulaNode)nodes[20]).AddMethod("S", new Func20_S());
        ((FormulaNode)nodes[20]).AddMethod("b", new Func20_b());
        ((FormulaNode)nodes[20]).AddMethod("c", new Func20_c());
        ((FormulaNode)nodes[20]).AddMethod("A", new Func20_A());

        nodes[21] = new FormulaNode("S=1/2*a*c*sin(B)", false);
        ((FormulaNode)nodes[21]).AddMethod("S", new Func21_S());
        ((FormulaNode)nodes[21]).AddMethod("a", new Func21_a());
        ((FormulaNode)nodes[21]).AddMethod("c", new Func21_c());
        ((FormulaNode)nodes[21]).AddMethod("B", new Func21_B());





    }

    private void AddVarNode() {
        nodes[0] = new VarNode("S", false, -1);
        nodes[1] = new VarNode("a", false, -1);
        nodes[2] = new VarNode("b", false, -1);
        nodes[3] = new VarNode("c", false, -1);
        nodes[4] = new VarNode("p", false, -1);
        nodes[5] = new VarNode("r", false, -1);
        nodes[6] = new VarNode("A", false, -1);
        nodes[7] = new VarNode("B", false, -1);
        nodes[8] = new VarNode("C", false, -1);
        nodes[9] = new VarNode("ha", false, -1);
        nodes[10] = new VarNode("hb", false, -1);
        nodes[11] = new VarNode("hc", false, -1);

    }
}

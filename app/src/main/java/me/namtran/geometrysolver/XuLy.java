package me.namtran.geometrysolver;

import android.util.Log;

import java.util.Map;

public class XuLy {
    final String TAG = "debug";
    Node[] nodes = new Node[8];
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
                    nodes[i].Active();
                    process = true;
                }
            }
        }
        while(process);
    }

    private void AddFormulaNode() {
        nodes[6] = new FormulaNode("S=p*r", false);
        ((FormulaNode)nodes[6]).AddMethod("S", new Func61());
        ((FormulaNode)nodes[6]).AddMethod("p", new Func62());
        ((FormulaNode)nodes[6]).AddMethod("r", new Func63());

        nodes[7] = new FormulaNode("S=sqrt(p*(p-a)*(p-b)*(p-c))", false);
        ((FormulaNode)nodes[7]).AddMethod("S", new Func71());
        ((FormulaNode)nodes[7]).AddMethod("p", new Func72());
        ((FormulaNode)nodes[7]).AddMethod("a", new Func73());
        ((FormulaNode)nodes[7]).AddMethod("b", new Func74());
        ((FormulaNode)nodes[7]).AddMethod("c", new Func75());
    }

    private void AddVarNode() {
        nodes[0] = new VarNode("S", false, -1);
        nodes[1] = new VarNode("a", false, -1);
        nodes[2] = new VarNode("b", false, -1);
        nodes[3] = new VarNode("c", false, -1);
        nodes[4] = new VarNode("p", false, -1);
        nodes[5] = new VarNode("r", false, -1);
    }
}

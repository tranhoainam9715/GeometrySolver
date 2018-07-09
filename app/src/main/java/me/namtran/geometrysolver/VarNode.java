package me.namtran.geometrysolver;

public class VarNode extends Node {
    public String Name;
    public float Value;

    public VarNode(String Name, boolean bActived, float Value){
        this.Name = Name;
        this.bActived = bActived;
        this.Value = Value;
        Global.Variables.put(Name, Value);
    }


    @Override
    public boolean CanActive() {
        return false;
    }

    @Override
    public BuocGiai Active() {
        return null;
    }

    public String getName() {
        return Name;
    }
}

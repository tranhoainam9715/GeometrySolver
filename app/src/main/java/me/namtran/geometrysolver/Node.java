package me.namtran.geometrysolver;

public abstract class Node {
    public boolean bActived = false;
    //tat cac cac bien deu chua co gia tri
    private boolean GiaThiet = false;

    public abstract boolean CanActive();

    public abstract BuocGiai Active();

    public abstract String getName();
}

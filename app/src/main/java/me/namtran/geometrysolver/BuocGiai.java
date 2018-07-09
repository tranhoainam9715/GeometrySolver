package me.namtran.geometrysolver;

public class BuocGiai {
    private String BienTinh;
    private float GiaTri;
    private Node CongThuc;

    public BuocGiai(String bienTinh, float giaTri, Node congThuc) {
        BienTinh = bienTinh;
        GiaTri = giaTri;
        CongThuc = congThuc;
    }

    public String toString(){
        return "Su dung cong thuc: " + CongThuc+ "Tinh "+BienTinh +":\n"
                +"Suy ra: " +BienTinh+" = "+GiaTri;
    }

    public String getBienTinh() {
        return BienTinh;
    }

    public float getGiaTri() {
        return GiaTri;
    }

    public Node getCongThuc() {
        return CongThuc;
    }
}

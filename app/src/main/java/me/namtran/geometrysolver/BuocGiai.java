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
<<<<<<< HEAD
        return "Su dung cong thuc: " + CongThuc.getName()+ ". Tinh "+BienTinh +":\n"
                +"Suy ra: " +BienTinh+" = "+GiaTri+"\n";
=======
        return "Sử dụng công thức: " + CongThuc+ "Tính "+BienTinh +":\n"
                +"\t**Suy ra: " +BienTinh+" = "+GiaTri;
>>>>>>> 396ee7094a0b68696271d446b5e637fd50a3038e
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

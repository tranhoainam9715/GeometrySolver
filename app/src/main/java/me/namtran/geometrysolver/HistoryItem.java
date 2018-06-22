package me.namtran.geometrysolver;

public class HistoryItem {
    private String title;
    private String imagePath;
    private String yeucau;
    private String ketqua;
    private String loigiai;
    private String timecreate;

    public HistoryItem(String _title, String _imagePath, String _yeucau, String _ketqua, String _loigiai, String _timecreate )
    {
        title=_title;
        imagePath=_imagePath;
        yeucau=_yeucau;
        ketqua=_ketqua;
        loigiai=_loigiai;
        timecreate=_timecreate;

    }
    public HistoryItem(String _title, String _ketqua)
    {
        title=_title;
        ketqua=_ketqua;
    }
    public String getTitle()
    {
        return title;
    }
    public String getImagePath()
    {
        return imagePath;
    }
    public String getYeucau()
    {
        return yeucau;
    }
    public String getKetqua(){
        return  ketqua;
    }
    public String getLoiGiai()
    {
        return loigiai;
    }
    public String getTimeCreate(){return timecreate;}

    public void setTitle(String _title)
    {
        title=_title;
    }
    public void setImagePath(String _imagePath)
    {
        imagePath=_imagePath;
    }

    public  void setYeucau(String _yeucau)
    {
        yeucau=_yeucau;
    }

    public void setKetqua(String _ketqua)
    {
        ketqua=_ketqua;
    }
    public  void setLoigiai(String _loigiai)
    {
        loigiai=_loigiai;
    }
    public void setTimecreate(String _timecreate){
        timecreate=_timecreate;
    }
}

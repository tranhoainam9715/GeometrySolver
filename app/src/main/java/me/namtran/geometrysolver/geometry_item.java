package me.namtran.geometrysolver;

import android.widget.ImageView;

public class geometry_item {
    int imageID;
    String name;

    geometry_item(int _imgID, String _name)
    {
        imageID=_imgID;
        name=_name;
    }

    public int getImageID()
    {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setName(String name) {
        this.name = name;
    }
}

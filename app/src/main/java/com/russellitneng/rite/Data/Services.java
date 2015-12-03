package com.russellitneng.rite.Data;

//Making a class that holds the Service list details/ structure
public class Services {

    protected String title;
    protected String dis;
    protected String note;
    protected int imgId;

    public Services(String title, String dis, String note, int imgId) {
        this.title = title;
        this.dis = dis;
        this.note = note;
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public int getImgId() {
        return imgId;
    }

    public String getNote() {
        return note;
    }

    public String getDis() {
        return dis;
    }

    @Override
    public String toString() {
        return title;
    }
}

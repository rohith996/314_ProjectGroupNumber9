package com.example.cars_for_us;

public class Reservations{
    int image;
    String indate,outdate,price;
    Reservations(int image, String indate, String outdate, String price) {
        this.image=image;
        this.indate=indate;
        this.outdate=outdate;
        this.price=price;

    }
    public String getIndate() {
        return indate;
    }
    public void setIndate(String indate) {
        this.indate = indate;
    }
    public String getOutdate() {
        return outdate;
    }
    public void setOutdate(String outdate) {
        this.outdate = outdate;
    }
    String outdate;
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
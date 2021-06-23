package models;

public class ram {
    private String brand;
    private String mesize;
    private String bus;
    private String chips;
    private String img;

    public ram() {
    }

    public ram(String brand, String mesize, String bus, String chips, String img) {
        this.brand = brand;
        this.mesize = mesize;
        this.bus = bus;
        this.chips = chips;
        this.img = img;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMesize() {
        return mesize;
    }

    public void setMesize(String mesize) {
        this.mesize = mesize;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getChips() {
        return chips;
    }

    public void setChips(String chips) {
        this.chips = chips;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

package models;

public class pcdesktop {
    private String brand;
    private String mainboard;
    private String cpu;
    private String ram;
    private String storage;
    private String psu;
    private String pccase;
    private Double precount;
    private Double price;
    private Double discount;

    public pcdesktop() {
    }

    public pcdesktop(String brand, String mainboard, String cpu, String ram, String storage, String psu, String pccase, Double precount, Double price, Double discount) {
        this.brand = brand;
        this.mainboard = mainboard;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.psu = psu;
        this.pccase = pccase;
        this.precount = precount;
        this.price = price;
        this.discount = discount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getPsu() {
        return psu;
    }

    public void setPsu(String psu) {
        this.psu = psu;
    }

    public String getPccase() {
        return pccase;
    }

    public void setPccase(String pccase) {
        this.pccase = pccase;
    }

    public Double getPrecount() {
        return precount;
    }

    public void setPrecount(Double precount) {
        this.precount = precount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public  Double sumprice() {
        return price*precount;
    }

    public Double caldiscount() {
        return (price*precount)*(discount/100);
    }
}

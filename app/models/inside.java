package models;

public class inside extends store {
    private String store_phone,store_opendate;
    private int store_openofweek,store_size;

    public inside() {
    }

    public inside(String storename, String store_address, String store_type, String store_phone, String store_opendate, int store_openofweek, int store_size) {
        super(storename, store_address, store_type);
        this.store_phone = store_phone;
        this.store_opendate = store_opendate;
        this.store_openofweek = store_openofweek;
        this.store_size = store_size;
    }

    public String getStore_phone() {
        return store_phone;
    }

    public void setStore_phone(String store_phone) {
        this.store_phone = store_phone;
    }

    public String getStore_opendate() {
        return store_opendate;
    }

    public void setStore_opendate(String store_opendate) {
        this.store_opendate = store_opendate;
    }

    public int getStore_openofweek() {
        return store_openofweek;
    }

    public void setStore_openofweek(int store_openofweek) {
        this.store_openofweek = store_openofweek;
    }

    public int getStore_size() {
        return store_size;
    }

    public void setStore_size(int store_size) {
        this.store_size = store_size;
    }
}

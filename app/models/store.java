package models;

public class store {
    private String storename,store_address,store_type;

    public  store(){
    }

    public store(String storename, String store_address, String store_type) {
        this.storename = storename;
        this.store_address = store_address;
        this.store_type = store_type;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getStore_type() {
        return store_type;
    }

    public void setStore_type(String store_type) {
        this.store_type = store_type;
    }
}

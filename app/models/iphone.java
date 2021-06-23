package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbIphone")
public class iphone extends Model {
    @Id
    @Column(length = 20)
    private String name;
    @Column(length = 50)
    private String scrsize,ram,storsize;
    private int price;
    @ManyToOne
    private ramtype ramname;

    public iphone() {
    }

    public iphone(String name, String scrsize, String ram, String storsize, int price, ramtype ramname) {
        this.name = name;
        this.scrsize = scrsize;
        this.ram = ram;
        this.storsize = storsize;
        this.price = price;
        this.ramname = ramname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScrsize() {
        return scrsize;
    }

    public void setScrsize(String scrsize) {
        this.scrsize = scrsize;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorsize() {
        return storsize;
    }

    public void setStorsize(String storsize) {
        this.storsize = storsize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ramtype getRamname() {
        return ramname;
    }

    public void setRamname(ramtype ramname) {
        this.ramname = ramname;
    }

    public static Finder<String, iphone> finder = new Finder(String.class, iphone.class);

    public static List<iphone> list() {
        return finder.all();
    }

    /* public static List<iphone> listbyscrsize() {
        return finder.where().eq("5",scrsize).findList();
    } */
}

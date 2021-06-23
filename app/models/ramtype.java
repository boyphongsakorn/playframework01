package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbRamtype")
public class ramtype extends Model {
    @Id
    @Column(length = 20)
    private String ramid;
    @Column(length = 50)
    private String ramsize,ramby;
    @OneToMany(mappedBy = "ramname")
    private List<iphone> iphoneList = new ArrayList<>();

    public ramtype() {
    }

    public ramtype(String ramid, String ramsize, String ramby) {
        this.ramid = ramid;
        this.ramsize = ramsize;
        this.ramby = ramby;
    }

    public String getRamid() {
        return ramid;
    }

    public void setRamid(String ramid) {
        this.ramid = ramid;
    }

    public String getRamsize() {
        return ramsize;
    }

    public void setRamsize(String ramsize) {
        this.ramsize = ramsize;
    }

    public String getRamby() {
        return ramby;
    }

    public void setRamby(String ramby) {
        this.ramby = ramby;
    }
}

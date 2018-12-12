package ru.telenet;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PARAMETRS")
public class Parametrs {
    private Integer num;
    private Integer unqnumber;
    private Integer numParametr;
    private String val;
    private Date offDate;
    private Organizations organizations;
    private KindParametrs kindParametrs;

    @Id
    @Column(name = "NUM", nullable = false, unique = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Column(name = "UNQNUMBER", nullable = false)
    public Integer getUnqnumber() {
        return unqnumber;
    }

    public void setUnqnumber(Integer unqnumber) {
        this.unqnumber = unqnumber;
    }

    @Column(name = "NUM_PARAMETR", nullable = false)
    public Integer getNumParametrs() {
        return numParametr;
    }

    public void setNumParametrs(Integer numParametrs) {
        this.numParametr = numParametrs;
    }

    @Column(name = "VAL")
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "OFFDATE", nullable = false)
    public Date getOffDate() {
        return offDate;
    }

    public void setOffDate(Date offDate) {
        this.offDate = offDate;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "UNQNUMBER", insertable=false, updatable=false)
    public Organizations getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NUM_PARAMETR", insertable=false, updatable=false)
    public KindParametrs getKindParametrs() {
        return kindParametrs;
    }

    public void setKindParametrs(KindParametrs kindParametrs) {
        this.kindParametrs = kindParametrs;
    }

    public Parametrs() {
    }

    public Parametrs(Integer unqnumber, Integer numParametrs, String val, Date offDate) {
        this.num = num;
        this.unqnumber = unqnumber;
        this.numParametr = numParametrs;
        this.val = val;
        this.offDate = offDate;
    }

    public Parametrs(Integer unqnumber, Integer numParametrs, String val, Date offDate, Organizations organizations) {
        this.num = num;
        this.unqnumber = unqnumber;
        this.numParametr = numParametrs;
        this.val = val;
        this.offDate = offDate;
        this.organizations = organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parametrs parametrs = (Parametrs) o;

        if (!num.equals(parametrs.num)) return false;
        if (!unqnumber.equals(parametrs.unqnumber)) return false;
        if (!numParametr.equals(parametrs.numParametr)) return false;
        if (!val.equals(parametrs.val)) return false;
        return offDate.equals(parametrs.offDate);
    }

    @Override
    public int hashCode() {
        int result = num.hashCode();
        result = 31 * result + unqnumber.hashCode();
        result = 31 * result + numParametr.hashCode();
        result = 31 * result + val.hashCode();
        result = 31 * result + offDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return kindParametrs.getCaption() + " " + val + '\'';
    }
}

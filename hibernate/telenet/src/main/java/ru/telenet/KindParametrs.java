package ru.telenet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KIND_PARAMETRS")
public class KindParametrs {
    private Integer numPatametrs;
    private Integer orderNum;
    private String caption;

    @Column (name = "ORDER_NUM", nullable = false)
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Id
    @Column(name = "NUM_PARAMETR", nullable = false, unique = true)
    public Integer getNumPatametr() {
        return numPatametrs;
    }

    public void setNumPatametr(Integer numPatametr) {
        this.numPatametrs = numPatametr;
    }

    @Column(name = "CAPTION")
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}

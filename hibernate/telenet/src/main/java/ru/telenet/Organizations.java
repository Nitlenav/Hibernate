package ru.telenet;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORGANIZATIONS")
public class Organizations {
    private Integer unqnumber;
    private Integer code;
    private String firmName;
    private String info;
    private List<Parametrs> parametrs;

    public Organizations() {
    }

    public Organizations(Integer unqnumber, Integer code, String firmName, String info) {
        this.unqnumber = unqnumber;
        this.code = code;
        this.firmName = firmName;
        this.info = info;
    }

    @Id
    @Column(name = "UNQNUMBER", nullable = false, unique = true)
    public Integer getUnqnumber() {
        return unqnumber;
    }

    public void setUnqnumber(Integer unqnumber) {
        this.unqnumber = unqnumber;
    }
    @Basic
    @Column(name = "CODE", nullable = false)
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Basic
    @Column(name = "FIRM_NAME", nullable = false, length = 200)
    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @Basic
    @Column(name = "INFO", nullable = true, length = 60)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @OneToMany(mappedBy = "organizations", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Parametrs> getParametrs() {
        return parametrs;
    }

    public void setParametrs(List<Parametrs> parametrs) {
        this.parametrs = parametrs;
    }

    @Override
    public String toString() {
        return  '\n' + "Organizations{ " +
                ", code = " + code +
                ", firmName = '" + firmName.trim() + '\'' +
                ", info='" + info + " " +
                '}' + '\n' ;
    }
}

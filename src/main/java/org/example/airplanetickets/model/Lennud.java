package org.example.airplanetickets.model;
import jakarta.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lennud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sihtkoht;
    private Time lennuaeg;
    private LocalDate kuupäev;
    private Double hind;

    public Lennud() {}

    public Lennud(String sihtkoht, Time lennuaeg, LocalDate kuupaev,Double hind) {
        this.sihtkoht = sihtkoht;
        this.lennuaeg = lennuaeg;
        this.hind = hind;
        this.kuupäev = kuupaev;
    }
    @OneToMany(mappedBy = "lennud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Istekohad> istekohad = new ArrayList<>();
//getterid ja setterid
    public void setKuupäev(LocalDate kuupäev) {
        this.kuupäev = kuupäev;
    }
    public List<Istekohad> getIstekohad() {
        return istekohad;
    }
    public void setIstekohad(List<Istekohad> istekohad) {
        this.istekohad = istekohad;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSihtkoht() {
        return sihtkoht;
    }
    public void setSihtkoht(String sihtkoht) {
        this.sihtkoht = sihtkoht;
    }
    public Time getLennuaeg() {
        return lennuaeg;
    }
    public void setLennuaeg(Time lennuaeg) {
        this.lennuaeg = lennuaeg;
    }
    public LocalDate getKuupäev() {
        return kuupäev;
    }
    public void setKuupaev(LocalDate kuupäev) {
        this.kuupäev = kuupäev;
    }
    public Double getHind() {
        return hind;
    }
    public void setHind(Double hind) {
        this.hind = hind;
    }

}

package org.example.airplanetickets.model;
import jakarta.persistence.*;

@Entity
public class Istekohad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "lennud_id", nullable = false)

    private Lennud lennud;

    @Column(name = "istme_number", nullable = false)
    private String istme_number;

    @Column(name = "on_vaba")
    private boolean on_vaba;

    @Column(name = "on_aknaall")
    private boolean on_aknaall;

    @Column(name = "on_jalaruum")
    private boolean on_jalaruum;

    @Column(name = "on_valjapaas")
    private boolean on_valjapaas;

    public Istekohad() {}
    // Getterid ja setterid
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Lennud getLennud() {
        return lennud;
    }
    public void setLennud(Lennud lennud) {
        this.lennud = lennud;
    }
    public String getIstme_number() {
        return istme_number;
    }
    public void setIstme_number(String istme_number) {
        this.istme_number = istme_number;
    }
    public boolean isOn_vaba() {
        return on_vaba;
    }
    public void setOn_vaba(boolean on_vaba) {
        this.on_vaba = on_vaba;
    }
    public boolean isOn_aknaall() {
        return on_aknaall;
    }
    public void setOn_aknaall(boolean on_aknaall) {
        this.on_aknaall = on_aknaall;
    }
    public boolean isOn_jalaruum() {
        return on_jalaruum;
    }
    public void setOn_jalaruum(boolean on_jalaruum) {
        this.on_jalaruum = on_jalaruum;
    }
    public boolean isOn_valjapaas() {
        return on_valjapaas;
    }
    public void setOn_valjapaas(boolean on_valjapaas) {
        this.on_valjapaas = on_valjapaas;
    }
}
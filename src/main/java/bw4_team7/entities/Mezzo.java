package bw4_team7.entities;

import bw4_team7.enums.StatoMezzo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mezzo {
    @Id
    @GeneratedValue
    @Column(name = "mezzo_id")
    protected long id;
    @Enumerated(EnumType.STRING)
    protected StatoMezzo stato;
    protected int capienza;
    @OneToMany(mappedBy = "mezzo")
    protected List<InServizio> periodiServizio;
    @OneToMany(mappedBy = "mezzo")
    protected List<Manutenzione> periodiManutenzione;
    @OneToMany(mappedBy = "mezzo")
    protected List<Biglietto> biglietti;
    @ManyToMany
    @JoinTable(
            name = "mezzo_tratta",
            joinColumns = @JoinColumn(name = "mezzo_id"),
            inverseJoinColumns = @JoinColumn(name = "tratta_id"))
    protected List<Tratta> tratte;

    public Mezzo() {}

    public long getId() {
        return id;
    }

    public StatoMezzo getStato() {
        return stato;
    }

    public int getCapienza() {
        return capienza;
    }

    public List<InServizio> getPeriodiServizio() {
        return periodiServizio;
    }

    public List<Manutenzione> getPeriodiManutenzione() {
        return periodiManutenzione;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setStato(StatoMezzo stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", stato=" + stato +
                ", capienza=" + capienza +
                '}';
    }
}

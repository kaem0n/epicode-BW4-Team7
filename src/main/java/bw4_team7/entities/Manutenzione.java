package bw4_team7.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "periodi_manutenzione")
public class Manutenzione extends Stato {
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    public Manutenzione() {}

    public Manutenzione(LocalDate dataInizio, Mezzo mezzo) {
        super(dataInizio);
        this.mezzo = mezzo;
    }

    public Manutenzione(LocalDate dataInizio, LocalDate dataFine, Mezzo mezzo) {
        super(dataInizio, dataFine);
        this.mezzo = mezzo;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", mezzo=" + mezzo +
                '}';
    }
}

package bw4_team7.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Stato {
    @Id
    @GeneratedValue
    @Column(name = "stato_id")
    protected long id;
    @Column(name = "data_inizio")
    protected LocalDate dataInizio;
    @Column(name = "data_fine")
    protected LocalDate dataFine;

    public Stato() {}

    public Stato(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
        this.dataFine = null;
    }

    public Stato(LocalDate dataInizio, LocalDate dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Stato{" +
                "id=" + id +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}

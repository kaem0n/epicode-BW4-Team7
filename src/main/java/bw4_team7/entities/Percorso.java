package bw4_team7.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "percorsi")
@NamedQuery(name = "trattaPerMezzo", query = "SELECT COUNT(p) FROM Percorso p WHERE p.mezzo = :mezzo AND p.tratta = :tratta")
@NamedQuery(name = "trattaPerMezzoPerData", query = "SELECT COUNT(p) FROM Percorso p WHERE p.mezzo = :mezzo AND p.tratta = :tratta " +
        "AND (p.dataPercorrenza BETWEEN :dataInizio AND :dataFine)")
@NamedQuery(name = "calcolaMediaPercorrenza", query = "SELECT AVG(p.tempoPercorrenza) FROM Percorso p WHERE p.mezzo = :mezzo AND p.tratta = :tratta")
@NamedQuery(name = "calcolaMediaPercorrenzaPerData", query = "SELECT AVG(p.tempoPercorrenza) FROM Percorso p WHERE p.mezzo = :mezzo AND p.tratta = :tratta " +
        "AND (p.dataPercorrenza BETWEEN :dataInizio AND :dataFine)")
public class Percorso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "percorso_id")
    private long id;
    @Column(name = "data_percorrenza")
    private LocalDate dataPercorrenza;
    @Column(name = "tempo_percorrenza")
    private int tempoPercorrenza;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    public Percorso(){}

    public Percorso(LocalDate dataPercorrenza, Mezzo mezzo, Tratta tratta) {
        this.dataPercorrenza = dataPercorrenza;
        if (tratta.getMediaPercorrenza() <= 15) this.tempoPercorrenza = new Random().nextInt(tratta.getMediaPercorrenza() - 5, tratta.getMediaPercorrenza() + 6);
        else this.tempoPercorrenza = new Random().nextInt(tratta.getMediaPercorrenza() - 10, tratta.getMediaPercorrenza() + 11);
        this.mezzo = mezzo;
        this.tratta = tratta;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataPercorrenza() {
        return dataPercorrenza;
    }

    public int getTempoPercorrenza() {
        return tempoPercorrenza;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    @Override
    public String toString() {
        return "Percorso{" +
                "id=" + id +
                ", dataPercorrenza=" + dataPercorrenza +
                ", tempoPercorrenza=" + tempoPercorrenza +
                ", mezzo=" + mezzo +
                ", tratta=" + tratta +
                '}';
    }
}

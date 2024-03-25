package bw4_team7.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "servizi")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Servizio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servizio_id")
    protected long id;
    @Column(name = "data_emissione")
    protected LocalDate dataEmissione;
    @ManyToOne
    @JoinColumn(name = "tessera_id")
    protected Utente utente;
    @ManyToOne
    @JoinColumn(name = "rivenditore_id")
    protected RivenditoreAutorizzato rivenditore;

    public Servizio() {}

    public Servizio(LocalDate dataEmissione, Utente utente, RivenditoreAutorizzato rivenditore) {
        this.dataEmissione = dataEmissione;
        this.utente = utente;
        this.rivenditore = rivenditore;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public Utente getUtente() {
        return utente;
    }

    public RivenditoreAutorizzato getRivenditore() {
        return rivenditore;
    }

    @Override
    public String toString() {
        return "Servizio{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", utente=" + utente +
                ", rivenditore=" + rivenditore +
                '}';
    }
}

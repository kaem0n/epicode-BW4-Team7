package bw4_team7.entities;

import bw4_team7.enums.TipoUtente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utenti")
@NamedQuery(name = "findByNumeroTessera", query = "SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tessera_id")
    private long numeroTessera;
    private String nome;
    private String cognome;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;
    @Enumerated(EnumType.STRING)
    private TipoUtente tipo;
    @OneToMany(mappedBy = "utente")
    private List<Servizio> servizi;

    public Utente() {}

    public Utente(String nome, String cognome, LocalDate dataEmissione) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataEmissione = dataEmissione;
        this.tipo = TipoUtente.USER;
        this.dataScadenza = dataEmissione.plusYears(1);
    }

    public Utente(String nome, String cognome, LocalDate dataEmissione, TipoUtente tipo) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataEmissione = dataEmissione;
        this.tipo = tipo;
        this.dataScadenza = tipo == TipoUtente.ADMIN ? null : dataEmissione.plusYears(1);
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public TipoUtente getTipo() {
        return tipo;
    }

    public List<Servizio> getServizi() {
        return servizi;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataEmissioneTessera=" + dataEmissione +
                ", dataScadenzaTessera=" + dataScadenza +
                '}';
    }
}

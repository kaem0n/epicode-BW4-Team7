package bw4_team7.entities;

import bw4_team7.enums.TipoAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
@NamedQuery(
        name = "subscriptionCheck",
        query = "SELECT a FROM Abbonamento a JOIN Servizio s ON a.id = s.id " +
                "WHERE a.dataScadenza > CURRENT_DATE AND s.utente.numeroTessera = :numeroTessera")
public class Abbonamento extends Servizio {
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipo;
    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    public Abbonamento() {}

    public Abbonamento(LocalDate dataEmissione, Utente utente, RivenditoreAutorizzato rivenditore, TipoAbbonamento tipo) {
        super(dataEmissione, utente, rivenditore);
        this.tipo = tipo;
        if (this.tipo == TipoAbbonamento.MENSILE) this.dataScadenza = dataEmissione.plusMonths(1);
        else if (this.tipo == TipoAbbonamento.SETTIMANALE) this.dataScadenza = dataEmissione.plusWeeks(1);
    }

    public TipoAbbonamento getTipo() {
        return tipo;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                ", utente=" + utente +
                ", rivenditore=" + rivenditore +
                ", tipo=" + tipo +
                '}';
    }
}

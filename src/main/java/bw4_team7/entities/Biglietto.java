package bw4_team7.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "biglietti")
@NamedQuery(name = "ticketByDate", query = "SELECT b FROM Biglietto b WHERE b.dataVidimazione BETWEEN :dataInizio AND :dataFine ")
public class Biglietto extends Servizio {
    private boolean valido;
    @Column(name = "data_vidimazione")
    private LocalDate dataVidimazione;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    public Biglietto() {}

    public Biglietto(LocalDate dataEmissione, Utente utente, RivenditoreAutorizzato rivenditore) {
        super(dataEmissione, utente, rivenditore);
        this.valido = true;
        this.dataVidimazione = null;
        this.mezzo = null;
    }

    public boolean isValido() {
        return valido;
    }

    public LocalDate getDataVidimazione() {
        return dataVidimazione;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public void setDataVidimazione(LocalDate dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", dataVidimazione=" + dataVidimazione +
                ", utente=" + utente +
                ", rivenditore=" + rivenditore +
                ", valido=" + valido +
                ", mezzo=" + mezzo +
                '}';
    }
}

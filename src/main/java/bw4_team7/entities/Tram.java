package bw4_team7.entities;

import bw4_team7.enums.StatoMezzo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Tram extends Mezzo {
    public Tram() {
        super.capienza = 280;
        super.stato = StatoMezzo.IN_SERVIZIO;
        super.percorsiPerServizio = 0;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "id=" + id +
                ", stato=" + stato +
                ", capienza=" + capienza +
                '}';
    }
}

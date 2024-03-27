package bw4_team7.entities;

import bw4_team7.enums.StatoMezzo;
import jakarta.persistence.Entity;

@Entity
public class Autobus extends Mezzo {
    public Autobus() {
        super.capienza = 100;
        super.stato = StatoMezzo.IN_SERVIZIO;
        super.percorsiPerServizio = 0;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "id=" + id +
                ", stato=" + stato +
                ", capienza=" + capienza +
                ", percorsiPerServizio=" + percorsiPerServizio +
                '}';
    }
}

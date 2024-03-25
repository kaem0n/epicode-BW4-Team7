package bw4_team7.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Tram extends Mezzo {
    public Tram() {
        super.capienza = 280;
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

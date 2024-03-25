package bw4_team7.entities;

import jakarta.persistence.Entity;

@Entity
public class Autobus extends Mezzo {
    public Autobus() {
        super.capienza = 100;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "id=" + id +
                ", stato=" + stato +
                ", capienza=" + capienza +
                '}';
    }
}

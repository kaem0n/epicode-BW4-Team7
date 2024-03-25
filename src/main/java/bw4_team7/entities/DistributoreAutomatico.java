package bw4_team7.entities;

import bw4_team7.enums.StatoDistributore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "distributori_automatici")
public class DistributoreAutomatico extends RivenditoreAutorizzato {
    @Enumerated(EnumType.STRING)
    private StatoDistributore stato;

    public DistributoreAutomatico() {}

    public DistributoreAutomatico(String nome, StatoDistributore stato) {
        super(nome);
        this.stato = stato;
    }

    public StatoDistributore getStato() {
        return stato;
    }

    public void setStato(StatoDistributore stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", stato=" + stato +
                '}';
    }
}

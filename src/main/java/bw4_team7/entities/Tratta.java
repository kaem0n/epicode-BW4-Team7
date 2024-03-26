package bw4_team7.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tratte")
public class Tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tratta_id")
    private long id;
    private String nome;
    private String partenza;
    private String capolinea;
    @Column(name = "tempo_percorrenza")
    private int tempoPercorrenza;
    @ManyToMany(mappedBy = "tratte")
    private List<Mezzo> mezzi;

    public Tratta() {}

    public Tratta(String partenza, String capolinea, int tempoPercorrenza) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.nome = this.partenza + " - " + this.capolinea;
        this.tempoPercorrenza = tempoPercorrenza;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPartenza() {
        return partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public int getTempoPercorrenza() {
        return tempoPercorrenza;
    }

    public List<Mezzo> getMezzi() {
        return mezzi;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", partenza='" + partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoPercorrenza=" + tempoPercorrenza +
                '}';
    }
}

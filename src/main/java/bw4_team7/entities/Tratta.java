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
    @Column(name = "media_percorrenza")
    private int mediaPercorrenza;
    @OneToMany(mappedBy = "tratta")
    private List<Percorso> percorsi;

    public Tratta() {}

    public Tratta(String partenza, String capolinea, int mediaPercorrenza) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.nome = this.partenza + " - " + this.capolinea;
        this.mediaPercorrenza = mediaPercorrenza;
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

    public int getMediaPercorrenza() {
        return mediaPercorrenza;
    }

    public List<Percorso> getPercorsi() {
        return percorsi;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", partenza='" + partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", mediaPercorrenza=" + mediaPercorrenza +
                '}';
    }
}

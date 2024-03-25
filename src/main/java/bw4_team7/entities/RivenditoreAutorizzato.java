package bw4_team7.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rivenditori")
@Inheritance(strategy = InheritanceType.JOINED)
public class RivenditoreAutorizzato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rivenditore_id")
    protected long id;
    protected String nome;
    @OneToMany(mappedBy = "rivenditore")
    protected List<Servizio> servizi;

    public RivenditoreAutorizzato() {}

    public RivenditoreAutorizzato(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Servizio> getServizi() {
        return servizi;
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

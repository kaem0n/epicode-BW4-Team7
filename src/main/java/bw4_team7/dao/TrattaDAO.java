package bw4_team7.dao;

import bw4_team7.entities.Tratta;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) { this.em = em; }

    public void save(Tratta path) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(path);
        tr.commit();
        System.out.println("Tratta id " + path.getId() + " salvata con successo!");
    }

    public Tratta findPathById(long id) {
        Tratta path = em.find(Tratta.class, id);
        if (path == null) throw new NotFoundException(id);
        else return path;
    }

    public void delete(long id) {
        Tratta path = findPathById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(path);
        tr.commit();
        System.out.println("Tratta cancellata con successo dal database.");
    }
}

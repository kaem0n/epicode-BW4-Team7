package bw4_team7.dao;

import bw4_team7.entities.DistributoreAutomatico;
import bw4_team7.entities.RivenditoreAutorizzato;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RivenditoreDAO {
    private final EntityManager em;

    public RivenditoreDAO(EntityManager em) { this.em = em; }

    public void saveSeller(RivenditoreAutorizzato seller) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(seller);
        tr.commit();
        System.out.println("Rivenditore id " + seller.getId() + " salvato con successo!");
    }

    public RivenditoreAutorizzato findSellerById(long id) {
        RivenditoreAutorizzato vehicle = em.find(RivenditoreAutorizzato.class, id);
        if (vehicle == null) throw new NotFoundException(id);
        else return vehicle;
    }

    public void delete(long id) {
        RivenditoreAutorizzato vehicle = findSellerById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(vehicle);
        tr.commit();
        System.out.println("RivenditoreAutorizzato cancellato con successo dal database.");
    }
}

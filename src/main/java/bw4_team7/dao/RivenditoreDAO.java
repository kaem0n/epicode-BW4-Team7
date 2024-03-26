package bw4_team7.dao;

import bw4_team7.entities.*;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

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
    public void creaTicket(Biglietto ticket) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(ticket);
        tr.commit();
        System.out.println(ticket);
    }

    public void creaSubscription(Abbonamento sub) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(sub);
        tr.commit();
        System.out.println(sub);
    }

    public List<Biglietto> ticketsForDate(LocalDate data){
        TypedQuery<Biglietto> query = em.createQuery("SELECT b FROM Biglietto b WHERE b.dataEmissione = :data",Biglietto.class);
        query.setParameter("data",data);
        return query.getResultList();
    }

    public List<Biglietto> serviziForRivenditore(long rivenditoreid){
        TypedQuery<Biglietto> query = em.createQuery("SELECT b FROM Biglietto b WHERE b.rivenditore.id = :rivenditoreid", Biglietto.class);
        query.setParameter("rivenditoreid", rivenditoreid);
        return query.getResultList();
    }
}

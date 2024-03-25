package bw4_team7.dao;

import bw4_team7.entities.*;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

public class ServizioDAO {
    private final EntityManager em;

    public ServizioDAO(EntityManager em) { this.em = em; }

    public void saveTicket(Biglietto ticket) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(ticket);
        tr.commit();
        System.out.println("Biglietto id " + ticket.getId() + " salvato con successo!");
    }

    public Biglietto findTicketById(long id) {
        Biglietto ticket = em.find(Biglietto.class, id);
        if (ticket == null) throw new NotFoundException(id);
        else return ticket;
    }


    public void saveSubscription(Abbonamento sub) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(sub);
        tr.commit();
        System.out.println("Abbonamento id " + sub.getId() + " salvato con successo!");
    }

    public Servizio findServiceById(long id) {
        Servizio vehicle = em.find(Servizio.class, id);
        if (vehicle == null) throw new NotFoundException(id);
        else return vehicle;
    }

    public void delete(long id) {
        Servizio vehicle = findServiceById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(vehicle);
        tr.commit();
        System.out.println("Biglietto/abbonamento cancellato con successo dal database.");
    }

    public void ricercaBigliettiObliteratiPerData(LocalDate dataInizio, LocalDate dataFine){
        TypedQuery<Biglietto> query = em.createNamedQuery("ticketByDate", Biglietto.class);
        query.setParameter("dataInizio", dataInizio);
        query.setParameter("dataFine", dataFine);
        query.getResultList().forEach(System.out::println);
    }
}

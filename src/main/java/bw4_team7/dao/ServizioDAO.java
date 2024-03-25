package bw4_team7.dao;

import bw4_team7.entities.*;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
        Servizio service = em.find(Servizio.class, id);
        if (service == null) throw new NotFoundException(id);
        else return service;
    }

    public void delete(long id) {
        Servizio service = findServiceById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(service);
        tr.commit();
        System.out.println("Biglietto/abbonamento cancellato con successo dal database.");
    }

    public void ricercaBigliettiObliteratiPerData(LocalDate dataInizio, LocalDate dataFine){
        TypedQuery<Biglietto> query = em.createNamedQuery("ticketByDate", Biglietto.class);
        query.setParameter("dataInizio", dataInizio);
        query.setParameter("dataFine", dataFine);
        query.getResultList().forEach(System.out::println);
    }

    public void checkSubscription(long cardNumber) {
        TypedQuery<Abbonamento> query = em.createNamedQuery("subscriptionCheck", Abbonamento.class);
        query.setParameter("numeroTessera", cardNumber);
        if (query.getResultList().isEmpty()) System.out.println("Nessun abbonamento valido trovato.");
        else {
            System.out.println("Abbonamento valido trovato:");
            query.getResultList().forEach(System.out::println);
        }
    }
}

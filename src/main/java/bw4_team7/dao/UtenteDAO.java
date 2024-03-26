package bw4_team7.dao;

import bw4_team7.entities.Servizio;
import bw4_team7.entities.Utente;
import bw4_team7.entities.Mezzo;
import bw4_team7.entities.Tram;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) { this.em = em; }

    public void save(Utente user) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(user);
        tr.commit();
        System.out.println("Utente " + user.getNome() + " " + user.getCognome() + " tessera n° " + user.getNumeroTessera() + " salvato con successo!");
    }

    public Utente findUserById(long id) {
        Utente user = em.find(Utente.class, id);
        if (user == null) throw new NotFoundException(id);
        else return user;
    }

    public void delete(long id) {
        Utente user = findUserById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(user);
        tr.commit();
        System.out.println("Utente cancellato con successo dal database.");
    }
    public void trovaUtentePerNumeroTessera(long numeroTessera) {
        TypedQuery<Utente> query = em.createNamedQuery("findByNumeroTessera", Utente.class);
        query.setParameter("numeroTessera", numeroTessera);
        query.getResultList().forEach(System.out::println);
    }

    public void trovaServiziPerNumeroTessera(long numeroTessera) {
        TypedQuery<Utente> query = em.createNamedQuery("findByNumeroTessera", Utente.class);
        query.setParameter("numeroTessera", numeroTessera);
        Utente utente = query.getSingleResult();
        if (utente != null) {
            List<Servizio> servizi = utente.getServizi();
            for (Servizio servizio : servizi) {
                System.out.println(servizio);
            }
        } else {
            System.out.println("Utente non trovato");
        }

    }
}

package bw4_team7.dao;

import bw4_team7.entities.Manutenzione;
import bw4_team7.entities.Mezzo;
import bw4_team7.entities.Percorso;
import bw4_team7.entities.Tratta;
import bw4_team7.enums.StatoMezzo;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

public class PercorsoDAO {
    private final EntityManager em;

    public PercorsoDAO(EntityManager em) { this.em = em; }

    public void save(Percorso path) {
        if (path.getMezzo().getStato() == StatoMezzo.IN_MANUTENZIONE || path.getMezzo().getStato() == StatoMezzo.RITIRATO) {
            System.out.println("Il mezzo " + path.getMezzo().getId() + " non è disponibile per la tratta.");
        } else {
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            em.persist(path);
            System.out.println("Percorso id " + path.getId() + " salvato con successo!");
            path.getMezzo().setPercorsiPerServizio(path.getMezzo().getPercorsiPerServizio() + 1);
            if (path.getMezzo().getPercorsiPerServizio() >= 30 && path.getMezzo().getPercorsiPerServizio() < 40) System.out.println("ATTENZIONE: Tra poco il mezzo " + path.getMezzo().getId() + " dovrà andare in manutenzione.");
            else if (path.getMezzo().getPercorsiPerServizio() >= 40) {
                path.getMezzo().getPeriodiServizio().get(path.getMezzo().getPeriodiServizio().size() - 1).setDataFine(path.getDataPercorrenza());
                if (path.getMezzo().getPeriodiManutenzione().size() == 20) {
                    System.out.println("ATTENZIONE: Il mezzo " + path.getMezzo().getId() + " è stato ritirato dal servizio.");
                    path.getMezzo().setStato(StatoMezzo.RITIRATO);
                    path.getMezzo().setPercorsiPerServizio(0);
                }
                else {
                    System.out.println("ATTENZIONE: Il mezzo " + path.getMezzo().getId() + " sta andando in manutenzione.");
                    em.persist(new Manutenzione(LocalDate.now(), path.getMezzo()));
                    path.getMezzo().setStato(StatoMezzo.IN_MANUTENZIONE);
                    path.getMezzo().setPercorsiPerServizio(0);
                }
            }
            tr.commit();
        }
    }

    public Percorso findPathById(long id) {
        Percorso path = em.find(Percorso.class, id);
        if (path == null) throw new NotFoundException(id);
        else return path;
    }

    public void delete(long id) {
        Percorso path = findPathById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(path);
        tr.commit();
        System.out.println("Percorso cancellato con successo dal database.");
    }

    public long trattaPerMezzo(Tratta tratta, Mezzo mezzo) {
        TypedQuery<Long> query = em.createNamedQuery("trattaPerMezzo", Long.class);
        query.setParameter("tratta", tratta);
        query.setParameter("mezzo", mezzo);
        long result = query.getSingleResult();
        System.out.println("Il mezzo con ID " + mezzo.getId() + " ha percorso la tratta " + tratta.getNome() + " per un totale di " + result + " volte.");
        return result;
    }

    public double trattaPerMezzoPerData(Tratta tratta, Mezzo mezzo, LocalDate dataInizio, LocalDate dataFine) {
        TypedQuery<Long> query = em.createNamedQuery("trattaPerMezzoPerData", Long.class);
        query.setParameter("tratta", tratta);
        query.setParameter("mezzo", mezzo);
        query.setParameter("dataInizio", dataInizio);
        query.setParameter("dataFine", dataFine);
        long result = query.getSingleResult();
        System.out.println("Il mezzo con ID " + mezzo.getId() + " ha percorso la tratta " + tratta.getNome() + " dal " + dataInizio + " al " + dataFine + " per un totale di " + result + " volte.");
        return result;
    }

    public double calcolaMediaPercorrenza(Tratta tratta, Mezzo mezzo) {
        TypedQuery<Double> query = em.createNamedQuery("calcolaMediaPercorrenza", Double.class);
        query.setParameter("tratta", tratta);
        query.setParameter("mezzo", mezzo);
        double result = query.getSingleResult();
        System.out.println("Il tempo di percorrenza medio della tratta " + tratta.getNome() + " per il mezzo id " + mezzo.getId() + " è di: " + Math.round(result) + " minuti.");
        return result;
    }

    public double calcolaMediaPercorrenzaPerData(Tratta tratta, Mezzo mezzo, LocalDate dataInizio, LocalDate dataFine) {
        TypedQuery<Double> query = em.createNamedQuery("calcolaMediaPercorrenzaPerData", Double.class);
        query.setParameter("tratta", tratta);
        query.setParameter("mezzo", mezzo);
        query.setParameter("dataInizio", dataInizio);
        query.setParameter("dataFine", dataFine);
        double result = query.getSingleResult();
        System.out.println("Il tempo di percorrenza medio della tratta " + tratta.getNome() + " per il mezzo id " + mezzo.getId() + " percorsa dal " + dataInizio + " al " + dataFine + " è di: " + Math.round(result) + " minuti.");
        return result;
    }
}

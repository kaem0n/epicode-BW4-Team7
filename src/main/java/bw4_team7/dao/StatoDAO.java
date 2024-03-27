package bw4_team7.dao;

import bw4_team7.entities.InServizio;
import bw4_team7.entities.Manutenzione;
import bw4_team7.entities.Stato;
import bw4_team7.enums.StatoMezzo;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class StatoDAO {
    private final EntityManager em;

    public StatoDAO(EntityManager em) { this.em = em; }

    public void saveMaintenance(Manutenzione maintenance) {
        if (maintenance.getMezzo().getStato() == StatoMezzo.RITIRATO) System.out.println("Errore: il mezzo " + maintenance.getMezzo().getId() + " è stato ritirato permanentemente dal servizio.");
        else {
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            em.persist(maintenance);
            System.out.println("Manutenzione id " + maintenance.getId() + " salvata con successo!");
            if (maintenance.getDataFine() == null) {
                maintenance.getMezzo().setStato(StatoMezzo.IN_MANUTENZIONE);
                maintenance.getMezzo().getPeriodiServizio().get(maintenance.getMezzo().getPeriodiServizio().size() -1).setDataFine(maintenance.getDataInizio());
                maintenance.getMezzo().setPercorsiPerServizio(0);
            }
            tr.commit();
        }
    }

    public void saveInService(InServizio inService) {
        if (inService.getMezzo().getStato() == StatoMezzo.RITIRATO) System.out.println("Errore: il mezzo " + inService.getMezzo().getId() + " è stato ritirato permanentemente dal servizio.");
        else {
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            if (inService.getMezzo().getPeriodiManutenzione().size() == 20) {
                inService.getMezzo().setStato(StatoMezzo.RITIRATO);
                System.out.println("Il mezzo " + inService.getMezzo().getId() + " è stato appena ritirato dal servizio.");
            } else {
                em.persist(inService);
                inService.getMezzo().setStato(StatoMezzo.IN_SERVIZIO);
                inService.getMezzo().getPeriodiManutenzione().get(inService.getMezzo().getPeriodiManutenzione().size() - 1).setDataFine(inService.getDataInizio());
                System.out.println("InServizio id " + inService.getId() + " salvato con successo!");
            }
            tr.commit();
        }
    }

    public Stato findStatusById(long id) {
        Stato vehicle = em.find(Stato.class, id);
        if (vehicle == null) throw new NotFoundException(id);
        else return vehicle;
    }

    public void delete(long id) {
        Stato vehicle = findStatusById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(vehicle);
        tr.commit();
        System.out.println("Stato cancellato con successo dal database.");
    }

    public void definitedFinishMaintenance(long id, LocalDate finish_date){
        Stato s = findStatusById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        s.setDataFine(finish_date);
        tr.commit();
        System.out.println("fine manutenzione definito");
    }
}

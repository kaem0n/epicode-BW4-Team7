package bw4_team7.dao;

import bw4_team7.entities.Autobus;
import bw4_team7.entities.Mezzo;
import bw4_team7.entities.Tram;
import bw4_team7.entities.Tratta;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MezzoDAO {
    private final EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveBus(Autobus vehicle) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(vehicle);
        tr.commit();
        System.out.println("Autobus id " + vehicle.getId() + " salvato con successo!");
    }

    public void saveTram(Tram vehicle) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(vehicle);
        tr.commit();
        System.out.println("Tram id " + vehicle.getId() + " salvato con successo!");
    }

    public Mezzo findVehicleById(long id) {
        Mezzo vehicle = em.find(Mezzo.class, id);
        if (vehicle == null) throw new NotFoundException(id);
        else return vehicle;
    }

    public void delete(long id) {
        Mezzo vehicle = findVehicleById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(vehicle);
        tr.commit();
        System.out.println("Mezzo cancellato con successo dal database.");
    }

    public void trattaAMezzo(long mezzoId, long trattaId) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();

        Mezzo mezzo = em.find(Mezzo.class, mezzoId);
        Tratta tratta = em.find(Tratta.class, trattaId);

        mezzo.getTratte().add(tratta);
        tratta.getMezzi().add(mezzo);

        em.persist(mezzo);
        em.persist(tratta);

        em.getTransaction().commit();
        System.out.println("Tratta collegata a mezzo (junction-table). idMezzo:" + mezzoId + ", idTratta:" + trattaId);
    }

    public long contaTrattePerMezzo(long mezzoId, long trattaId) {
        Long conteggio = em.createNamedQuery("Mezzo.contaTrattePerMezzo", Long.class)
                .setParameter("mezzoId", mezzoId)
                .setParameter("trattaId", trattaId)
                .getSingleResult();
        System.out.println("Il mezzo con ID " + mezzoId + " ha percorso la tratta con ID " + trattaId + " per " + conteggio + " volte.");
        return conteggio;
    }

    public double calcolaTempoPercorrenzaMedio(long mezzoId) {
        Double tempoMedio = em.createNamedQuery("Mezzo.calcolaTempoPercorrenzaMedio", Double.class)
                .setParameter("mezzoId", mezzoId)
                .getSingleResult();

        if (tempoMedio == null) {
            System.out.println("Nessuna tratta trovata per il mezzo con ID: " + mezzoId);
            return 0.0; // Restituisco un valore di default.
        } else {
            System.out.println("Il tempo medio di percorrenza del mezzo con id " + mezzoId + " è " + tempoMedio);
            return tempoMedio;
        }
    }
}

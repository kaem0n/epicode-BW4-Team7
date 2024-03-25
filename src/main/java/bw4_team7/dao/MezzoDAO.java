package bw4_team7.dao;

import bw4_team7.entities.Autobus;
import bw4_team7.entities.Mezzo;
import bw4_team7.entities.Tram;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MezzoDAO {
    private final EntityManager em;

    public MezzoDAO(EntityManager em) { this.em = em; }

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
}

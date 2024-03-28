package bw4_team7.dao;

import bw4_team7.entities.*;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class MezzoDAO {
    private final EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveBus(Autobus vehicle) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(vehicle);
        em.persist(new InServizio(LocalDate.now(), vehicle));
        tr.commit();
        System.out.println("Autobus id " + vehicle.getId() + " salvato con successo!");
    }

    public void saveTram(Tram vehicle) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(vehicle);
        em.persist(new InServizio(LocalDate.now(), vehicle));
        tr.commit();
        System.out.println("Tram id " + vehicle.getId() + " salvato con successo!");
    }

    public void saveBusWithDate(Autobus vehicle, LocalDate date) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(vehicle);
        em.persist(new InServizio(date, vehicle));
        tr.commit();
        System.out.println("Autobus id " + vehicle.getId() + " salvato con successo!");
    }

    public void saveTramWithDate(Tram vehicle, LocalDate date) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(vehicle);
        em.persist(new InServizio(date, vehicle));
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

    public void validateTicket(Biglietto tk, Mezzo m, LocalDate l) {
        if (!tk.isValido()) {
            System.out.println("Il biglietto è stato già obliterato nel mezzo " + tk.getMezzo().getId() + ".");
        } else {
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            tk.setValido(false);
            tk.setDataVidimazione(l);
            tk.setMezzo(m);
            tr.commit();
            System.out.println("Biglietto: " + tk.getId() + " è stato obliterato nel mezzo: " + m.getId());
        }
    }

    public void totaleBigliettiObliteratiSuUnMezzo(Mezzo m) {
        System.out.println("Biglietti obliterati del mezzo: " + m.getId() + " Sono stati obliterati TOTALE:" + m.getBiglietti().size());
        m.getBiglietti().forEach(System.out::println);
    }

    public String ricercaPeriodiDiStato(LocalDate data, Mezzo mezzo) {
        StringBuilder stato = new StringBuilder();

        TypedQuery<InServizio> query1 = em.createQuery("SELECT s FROM InServizio s WHERE s.mezzo = :mezzo AND s.dataInizio >= :data", InServizio.class);
        query1.setParameter("mezzo", mezzo);
        query1.setParameter("data", data);
        List<InServizio> listaInServizio = query1.getResultList();
        if (listaInServizio.isEmpty()) System.out.println("Non sono stati trovati periodi di servizio per il mezzo " + mezzo.getId() + " a partire dal " + data + ".");
        else {
            System.out.println("Sono stati trovati " + listaInServizio.size() + " periodi di servizio per il mezzo " + mezzo.getId() + " a partire dal " + data + ":");
            listaInServizio.forEach(inServizio -> System.out.println("- " +inServizio.toString()));
            System.out.println();
        }

        TypedQuery<Manutenzione> query2 = em.createQuery("SELECT m FROM Manutenzione m WHERE m.mezzo = :mezzo AND m.dataInizio >= :data", Manutenzione.class);
        query2.setParameter("mezzo", mezzo);
        query2.setParameter("data", data);
        List<Manutenzione> listaManutenzioni = query2.getResultList();
        if (listaManutenzioni.isEmpty()) System.out.println("Non sono stati trovati periodi di manutenzione per il mezzo " + mezzo.getId() + " a partire dal " + data + ".");
        else {
            System.out.println("Sono stati trovati " + listaManutenzioni.size() + " periodi di manutenzione per il mezzo " + mezzo.getId() + " a partire dal " + data + ":");
            listaManutenzioni.forEach(manutenzione -> System.out.println("- " +manutenzione.toString()));
            System.out.println();
        }
        return stato.toString();
    }
}

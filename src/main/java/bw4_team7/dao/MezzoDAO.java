package bw4_team7.dao;

import bw4_team7.entities.*;
import bw4_team7.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

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
        if (tk.isValido() == false) {
            System.out.println("biglietto già obliterato");
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

        TypedQuery<InServizio> periodiServizio = em.createQuery("SELECT s FROM InServizio s WHERE s.mezzo = :mezzo AND s.dataInizio >= :data", InServizio.class);
        periodiServizio.setParameter("mezzo", mezzo);
        periodiServizio.setParameter("data", data);
        periodiServizio.getResultList().forEach(System.out::println);

        TypedQuery<Manutenzione> periodiManutenzione = em.createQuery("SELECT m FROM Manutenzione m WHERE m.mezzo = :mezzo AND m.dataInizio >= :data", Manutenzione.class);
        periodiManutenzione.setParameter("mezzo", mezzo);
        periodiManutenzione.setParameter("data", data);
        periodiManutenzione.getResultList().forEach(System.out::println);
        return stato.toString();
    }
}

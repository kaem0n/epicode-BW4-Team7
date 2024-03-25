package bw4_team7;

import bw4_team7.dao.*;
import bw4_team7.entities.*;
import bw4_team7.enums.StatoDistributore;
import bw4_team7.enums.TipoAbbonamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4-team7");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        MezzoDAO md = new MezzoDAO(em);
        RivenditoreDAO rd = new RivenditoreDAO(em);
        ServizioDAO sd1 = new ServizioDAO(em);
        StatoDAO sd2 = new StatoDAO(em);
        TrattaDAO td = new TrattaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);

//      ud.save(new Utente("Mario", "Rossi", LocalDate.parse("2023-06-30")));
//      ud.save(new Utente("Maria", "Bianchi", LocalDate.parse("2024-01-20")));
//      ud.save(new Utente("Giovanni", "Neri", LocalDate.parse("2023-02-18")));
//      ud.save(new Utente("Marco", "Bruni", LocalDate.parse("2022-04-05")));
//      ud.save(new Utente("Eleonora", "Verdi", LocalDate.parse("2024-03-05")));



//
//      rd.saveSeller(new RivenditoreAutorizzato("Rivenditore 1"));
//      rd.saveSeller(new DistributoreAutomatico("Distributore 1", StatoDistributore.ATTIVO));
//      rd.saveSeller(new RivenditoreAutorizzato("Rivenditore 2"));
//      rd.saveSeller(new DistributoreAutomatico("Distributore 2", StatoDistributore.ATTIVO));
//      rd.saveSeller(new RivenditoreAutorizzato("Rivenditore 3"));
//      rd.saveSeller(new DistributoreAutomatico("Distributore 3", StatoDistributore.ATTIVO));

        //CREAZIONE RIVENDITORE
/*        RivenditoreAutorizzato riv1 = new RivenditoreAutorizzato("Rivenditore stazione");
        rd.saveSeller(riv1);*/

        //CREAZIONE UTENTE
/*        Utente utente1=new Utente("Maria","Rossi",LocalDate.now());
        ud.save(utente1);*/

        //CREAZIONE BIGLIETTO
/*        Biglietto biglietto = new Biglietto(LocalDate.now(),utente1,riv1);*/

        //IL RIVENDITORE STAMPA E RESTITUISCE IL BIGLIETTO
/*        rd.creaTicket(biglietto);*/

        //CREAZIONE ABBONAMENTO
/*        Abbonamento abbonamento = new Abbonamento(LocalDate.now(),utente1,riv1, TipoAbbonamento.MENSILE);*/

        //IL RIVENDITORE STAMPA E RESTITUISCE L'ABBONAMENTO
/*        rd.creaSubscription(abbonamento);*/

        System.out.println(rd.ticketsForDate(LocalDate.now()));






//        md.saveBus(new Autobus());
//        md.saveBus(new Autobus());
//        md.saveBus(new Autobus());
//        md.saveTram(new Tram());
//        md.saveTram(new Tram());
//        md.saveTram(new Tram());
//
//        td.save(new Tratta("Roma Termini", "Colosseo", 40));
//        td.save(new Tratta("Roma Termini", "Piazza di Spagna", 30));
//        td.save(new Tratta("Roma Termini", "Aeroporto di Fiumicino", 90));
//        td.save(new Tratta("Roma Tiburtina", "Aeroporto di Fiumicino", 100));
//        td.save(new Tratta("Colosseo", "Piazza del Popolo", 20));

//        sd1.saveTicket(new Biglietto(LocalDate.of(2024,1,2), ud.findUserById(1), rd.findSellerById(1)));

//        sd2.saveMainentance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(4)));

//        md.saveBus(new Autobus());md.saveBus(new Autobus());md.saveBus(new Autobus());md.saveBus(new Autobus());
//        md.saveTram(new Tram());md.saveTram(new Tram());md.saveTram(new Tram());md.saveTram(new Tram());

        // SET DATA FINE MANUTENZIONE
//        sd2.definitedFinishMaintenance(1, LocalDate.of(2024, 4,2));

        // VALIDAZIONE BIGLIETTO
//        md.validateTicket(sd1.findTicketById(2), md.findVehicleById(59), LocalDate.now());

        // BIGLIETTI OBLITERATI PER MEZZO
//        md.totaleBigliettiObliteratiSuUnMezzo(md.findVehicleById(59));
        // BIGLIETTI OBLITERATI PER PERIODO
//        sd1.ricercaBigliettiObliteratiPerData(LocalDate.of(2020,1,1), LocalDate.now());

        // PERIODI DI SERVIZI E MANUTENZIONE IN BASE ALLA DATA
//        md.ricercaPeriodiDiStato(LocalDate.of(2020,2,2), md.findVehicleById(4));
//        sd2.saveMainentance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(56)));

//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(1), rd.findSellerById(2), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.parse("2024-03-04"), ud.findUserById(3), rd.findSellerById(4), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(2), rd.findSellerById(3), TipoAbbonamento.MENSILE));

        sd1.checkSubscription(4);
    }
}

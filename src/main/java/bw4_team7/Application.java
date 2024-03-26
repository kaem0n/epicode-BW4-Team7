package bw4_team7;

import bw4_team7.dao.*;
import bw4_team7.entities.Biglietto;
import bw4_team7.entities.Mezzo;
import bw4_team7.entities.RivenditoreAutorizzato;
import bw4_team7.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

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

//       ud.save(new Utente("Mario", "Rossi", LocalDate.parse("2023-06-30")));
//      ud.save(new Utente("Maria", "Bianchi", LocalDate.parse("2024-01-20")));
//      ud.save(new Utente("Giovanni", "Neri", LocalDate.parse("2023-02-18")));
//      ud.save(new Utente("Marco", "Bruni", LocalDate.parse("2022-04-05")));
//      ud.save(new Utente("Eleonora", "Verdi", LocalDate.parse("2024-03-05")));

//      rd.saveSeller(new RivenditoreAutorizzato("Rivenditore 1"));
//      rd.saveSeller(new DistributoreAutomatico("Distributore 1", StatoDistributore.ATTIVO));
//      rd.saveSeller(new RivenditoreAutorizzato("Rivenditore 2"));
//      rd.saveSeller(new DistributoreAutomatico("Distributore 2", StatoDistributore.ATTIVO));
//      rd.saveSeller(new RivenditoreAutorizzato("Rivenditore 3"));
//      rd.saveSeller(new DistributoreAutomatico("Distributore 3", StatoDistributore.ATTIVO));

        //CREAZIONE RIVENDITORE
      RivenditoreAutorizzato riv1 = new RivenditoreAutorizzato("Rivenditore stazione");
        rd.saveSeller(riv1);
//
//        //CREAZIONE UTENTE
//       Utente utente1=new Utente("Maria","Rossi",LocalDate.now());
//     ud.save(utente1);

        //CREAZIONE BIGLIETTO
//           Biglietto biglietto = new Biglietto(LocalDate.now(),utente1,riv1);

        //IL RIVENDITORE STAMPA E RESTITUISCE IL BIGLIETTO
        /*        rd.creaTicket(biglietto);*/

        //CREAZIONE ABBONAMENTO
        /*        Abbonamento abbonamento = new Abbonamento(LocalDate.now(),utente1,riv1, TipoAbbonamento.MENSILE);*/

        //IL RIVENDITORE STAMPA E RESTITUISCE L'ABBONAMENTO
        /*        rd.creaSubscription(abbonamento);*/

        //QUANTITA' DI BIGLIETTI VENDUTI IN BASE AL RIVENDITORE
//        System.out.println("Questo Rivenditore ha venduto " + rd.serviziForRivenditore(12).size() + " biglietto/i");

//        System.out.println(rd.ticketsForDate(LocalDate.now()));

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

//        sd1.saveTicket(new Biglietto(LocalDate.of(2024, 1, 2), ud.findUserById(1), rd.findSellerById(1)));

//        sd2.saveMainentance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(4)));

//        md.saveBus(new Autobus());md.saveBus(new Autobus());md.saveBus(new Autobus());md.saveBus(new Autobus());
//        md.saveTram(new Tram());md.saveTram(new Tram());md.saveTram(new Tram());md.saveTram(new Tram());

        // SET DATA FINE MANUTENZIONE
//        sd2.definitedFinishMaintenance(1, LocalDate.of(2024, 4,2));
//

        // VALIDAZIONE BIGLIETTO
//        md.validateTicket(sd1.findTicketById(2), md.findVehicleById(59), LocalDate.now());

        // BIGLIETTI OBLITERATI PER MEZZO
//        md.totaleBigliettiObliteratiSuUnMezzo(md.findVehicleById(59));

        // BIGLIETTI OBLITERATI PER PERIODO
//        sd1.ricercaBigliettiObliteratiPerData(LocalDate.of(2020,1,1), LocalDate.now());

        // PERIODI DI SERVIZI E MANUTENZIONE IN BASE ALLA DATA
//        md.ricercaPeriodiDiStato(LocalDate.of(2020,2,2), md.findVehicleById(4));

        //                    md.totaleBigliettiObliteratiSuUnMezzo(md.findVehicleById(59));


//        sd2.saveMainentance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(4)));

//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(1), rd.findSellerById(2), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.parse("2024-03-04"), ud.findUserById(3), rd.findSellerById(4), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(2), rd.findSellerById(3), TipoAbbonamento.MENSILE));

//        sd1.checkSubscription(4);


//        System.out.println(rd.ticketsForDate(LocalDate.now()));


//        md.calcolaTempoPercorrenzaMedio(2);

        //RICERCA DEI SERVIZI ASSOCIATI AL NUMERO DI TESSERA
//        ud.trovaServiziPerNumeroTessera(2);

        // RICERCA UTENTE PER NUMERO TESSERA
//        ud.trovaUtentePerNumeroTessera(3);

//        sd2.saveMainentance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(56)));

//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(1), rd.findSellerById(2), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.parse("2024-03-04"), ud.findUserById(3), rd.findSellerById(4), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(2), rd.findSellerById(3), TipoAbbonamento.MENSILE));

//        sd1.checkSubscription(4);


//        System.out.println(rd.ticketsForDate(LocalDate.now()));


//        md.calcolaTempoPercorrenzaMedio(2);

        int scelta = 0;
        long mezzoId, trattaId, ticketId, mezzoPerTicketId;
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("---------------------------------------- BENVENUTO NEL GESTIONALE DELLA NOSTRA AZIENDA DI TRASPORTO -------------------------------------------");

            System.out.println("1) Per contare le tratte per ogni mezzo; ");
            System.out.println("2) Per calcolare il tempo di percorrenza medio; ");
            System.out.println("3) Per assegnare una tratta ad un mezzo; ");
            System.out.println("4) Per vidimare i biglietti ed assegnarli al mezzo; ");
            System.out.println("5) Per cercare i peridodi di servizio e manutenzione in base alla data;");
            System.out.println("6) Per cercare i biglietti emessi in base alla data;");
            System.out.println("7) Per cercare i biglietti obliterati su uno specifico mezzo;");
            System.out.println("8) Per verificare la validità di un abbonamento in base ad utente;");
            System.out.println("9) Per creare un biglietto;");
            System.out.println("10) Per contare i biglietti venduti da un determinato rivenditore;");
            System.out.println("0) Per uscire dal programma; ");


            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {

                case 0:
                    System.out.println("Uscita dal programma...");
                    System.out.println("Arrivederci e grazie!");
                    scanner.close();
                    return;

                case 1:
                    System.out.println("Inserisci l'ID del mezzo:");
                    mezzoId = scanner.nextLong();
                    System.out.println("Inserisci l'ID della tratta:");
                    trattaId = scanner.nextLong();
                    md.contaTrattePerMezzo(mezzoId, trattaId);
                    break;


                case 3:
                    System.out.println("Inserisci l'ID del mezzo a cui assegnare una tratta:");
                    mezzoId = scanner.nextLong();
                    System.out.println("Inserisci l'ID della tratta da assegnare al mezzo:");
                    trattaId = scanner.nextLong();
                    md.trattaAMezzo(mezzoId, trattaId);
                    break;

                case 4:
                    System.out.println("Inserisci l'id del ticket da cercare:");
                    ticketId = scanner.nextLong();
                    Biglietto biglietto2 = em.find(Biglietto.class, ticketId);
                    if (biglietto2 != null) {
                        System.out.println("Biglietto trovato: " + biglietto2.toString());
                        System.out.println("Inserisci l'id del veicolo da assegnare al ticket: ");
                        mezzoPerTicketId = scanner.nextLong();
                        Mezzo mezzo = em.find(Mezzo.class, mezzoPerTicketId);
                        md.validateTicket(biglietto2, mezzo, LocalDate.now());
                    } else {
                        System.out.println("Nessun biglietto trovato con ID: " + ticketId);
                    }
                    break;

                case 5:
                    System.out.println("Inserisci una data per trovare lo stato del veicolo:");
                    String input = scanner.nextLine();
                    LocalDate dataStatoVeicolo;
                    try {
                        dataStatoVeicolo = LocalDate.parse(input);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato della data non valido. Assicurati di inserire la data nel formato YYYY-MM-DD.");
                        break;
                    }

                    System.out.println("Inserisci id del veicolo per trovare lo stato del veicolo in questa data:");
                    mezzoId = Long.parseLong(scanner.nextLine());
                    Mezzo mezzoo = em.find(Mezzo.class, mezzoId);

                    if (mezzoo != null | dataStatoVeicolo != null) {
                        System.out.println("Stato veicolo in data " + dataStatoVeicolo + " :");
                        md.ricercaPeriodiDiStato(dataStatoVeicolo, mezzoo);
                    } else {
                        System.out.println("Nessun mezzo trovato con id: " + mezzoId + " in data " + dataStatoVeicolo);
                    }
                    break;

                case 6:
                    System.out.println("Inserisci una data per visualizzare i biglietti emessi: ");
                    LocalDate data = LocalDate.parse(scanner.nextLine());
                    List<Biglietto> biglietti = rd.ticketsForDate(data);

                    if (biglietti.isEmpty()) {
                        System.out.println("Nessun biglietto emesso in questa data.");
                    } else {
                        System.out.println("Biglietti emessi in data " + data + " :");
                        for (Biglietto bigliettoo : biglietti) {
                            System.out.println(bigliettoo);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Inserisci l'id di un mezzo per cercare i biglietti obliterati su di esso:");
                    long idMezzo = Long.parseLong(scanner.nextLine());
                    md.totaleBigliettiObliteratiSuUnMezzo(md.findVehicleById(idMezzo));
                    break;

                case 8:
                    System.out.println("Inserisci il numero di abbonamento di utente per verificarne la validità:");
                    long cardNumber = Long.parseLong(scanner.nextLine());
                    sd1.checkSubscription(cardNumber);
                    break;

                case 9:
                    System.out.println("Inserisci la data per creare il biglietto:");
                    LocalDate emissione = LocalDate.parse(scanner.nextLine());
                    System.out.println("Inserisci il nome dell'utente:");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci il cognome:");
                    String cognome = scanner.nextLine();
                    Utente utente1=new Utente(nome,cognome,emissione);
     ud.save(utente1);
                    Biglietto bigliettoNuovo = new Biglietto(emissione,utente1,riv1);
                    rd.creaTicket(bigliettoNuovo);
                    break;

                case 10:
                    System.out.println("Inserisci l'id del rivenditore:");
                    long rivenditoreId = Long.parseLong(scanner.nextLine());
                    System.out.println("Questo Rivenditore ha venduto " + rd.serviziForRivenditore(rivenditoreId).size() + " biglietto/i");
break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }

        } while (true);
    }
}

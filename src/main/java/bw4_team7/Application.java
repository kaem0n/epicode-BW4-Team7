package bw4_team7;

import bw4_team7.dao.*;
import bw4_team7.entities.*;
import bw4_team7.enums.StatoDistributore;
import bw4_team7.enums.StatoMezzo;
import bw4_team7.enums.TipoUtente;
import bw4_team7.exceptions.NotFoundException;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4-team7");
    public static final Faker faker = new Faker(Locale.ITALY);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        MezzoDAO md = new MezzoDAO(em);
        RivenditoreDAO rd = new RivenditoreDAO(em);
        ServizioDAO sd1 = new ServizioDAO(em);
        StatoDAO sd2 = new StatoDAO(em);
        TrattaDAO td = new TrattaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PercorsoDAO pd = new PercorsoDAO(em);

//        fillDb(em);
//        ud.save(new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(new Random().nextInt(2020, 2024), new Random().nextInt(1, 13), new Random().nextInt(1, 29)), TipoUtente.ADMIN));


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

//        pd.save(new Percorso(LocalDate.now(), 80, md.findVehicleById(254), td.findRouteById(4)));
//        for (int i = 0; i < 20; i++) {
//        pd.save(new Percorso(LocalDate.now(), md.findVehicleById(1), td.findRouteById(1)));
//        pd.save(new Percorso(LocalDate.now(), md.findVehicleById(1), td.findRouteById(2)));
//        }

//        sd2.saveInService(new InServizio(LocalDate.now(), md.findVehicleById(1)));

//        sd2.saveInService(new InServizio(LocalDate.now(), md.findVehicleById(302)));

//        pd.trattaPerMezzo(td.findRouteById(1), md.findVehicleById(252));
//        pd.trattaPerMezzoPerData(td.findRouteById(1), md.findVehicleById(252), LocalDate.parse("2023-04-01"), LocalDate.parse("2023-05-01"));
//        pd.calcolaMediaPercorrenza(td.findRouteById(1), md.findVehicleById(252));
//        pd.calcolaMediaPercorrenzaPerData(td.findRouteById(1), md.findVehicleById(252), LocalDate.parse("2023-04-01"), LocalDate.parse("2023-05-01"));

//        sd1.saveTicket(new Biglietto(LocalDate.of(2024, 1, 2), ud.findUserById(1), rd.findSellerById(1)));

//        sd2.saveMaintenance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(4)));

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


//        sd2.saveMaintenance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(4)));

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

//        sd2.saveMaintenance(new Manutenzione(LocalDate.parse("2024-03-23"), md.findVehicleById(56)));

//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(1), rd.findSellerById(2), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.parse("2024-03-04"), ud.findUserById(3), rd.findSellerById(4), TipoAbbonamento.SETTIMANALE));
//        sd1.saveSubscription(new Abbonamento(LocalDate.now(), ud.findUserById(2), rd.findSellerById(3), TipoAbbonamento.MENSILE));

//        sd1.checkSubscription(4);


//        System.out.println(rd.ticketsForDate(LocalDate.now()));


//        md.calcolaTempoPercorrenzaMedio(2);

        long mezzoId, trattaId, ticketId, mezzoPerTicketId;
        int minuti;
        Scanner sc = new Scanner(System.in);

            System.out.println();
            System.out.println("---------------------------------------- BENVENUTO NEL GESTIONALE DELLA NOSTRA AZIENDA DI TRASPORTO -------------------------------------------");
            System.out.println();
            loop: while(true) {
                try {
                    System.out.println("Inserisci il tuo numero di tessera:");
                    int numeroTessera = Integer.parseInt(sc.nextLine());
                    Utente me = ud.findUserById(numeroTessera);
                    System.out.println();
                    System.out.println("Benvenuto " + me.getNome() + " " + me.getCognome() + " Tessera n. " + me.getNumeroTessera());
                    System.out.println();
                    System.out.println("Seleziona un'opzione:");
                    if (me.getTipo() == TipoUtente.ADMIN) {
                        admin: while(true) {
                            System.out.println("1) Per contare le tratte per ogni mezzo;");
                            System.out.println("2) Per calcolare il tempo di percorrenza medio;");
                            System.out.println("3) Per registrare una tratta percorsa da un mezzo;");
                            System.out.println("4) Per cercare i periodi di servizio e manutenzione in base alla data;");
                            System.out.println("5) Per cercare i biglietti emessi in base alla data;");
                            System.out.println("6) Per cercare i biglietti obliterati su uno specifico mezzo;");
                            System.out.println("7) Per verificare la validità di un abbonamento in base ad utente;");
                            System.out.println("8) Per contare i biglietti venduti da un determinato rivenditore;");
                            System.out.println("0) Per uscire dal programma;");
                            int scelta = Integer.parseInt(sc.nextLine());
                            switch (scelta) {
                                case 0 -> {
                                    System.out.println("Uscita dal programma...");
                                    System.out.println("Arrivederci e grazie!");
                                    sc.close();
                                    break loop;
                                }
                                case 1 -> {
                                    case1: while(true) {
                                        try {
                                            System.out.println("Inserisci l'ID del mezzo:");
                                            mezzoId = Long.parseLong(sc.nextLine());
                                            System.out.println();
                                            System.out.println("Inserisci l'ID della tratta:");
                                            trattaId = Long.parseLong(sc.nextLine());
                                            System.out.println();
                                            pd.trattaPerMezzo(td.findRouteById(trattaId), md.findVehicleById(mezzoId));
                                            System.out.println();
                                            break case1;
                                        } catch (NumberFormatException e) {
                                            System.err.println("Inserisci un ID valido.");
                                        } catch (NotFoundException e) {
                                            System.err.println(e.getMessage());
                                            break case1;
                                        }
                                    }
                                }
                                case 2 -> {
                                    case2: while(true) {
                                        try {
                                            System.out.println("Inserisci l'ID del mezzo:");
                                            mezzoId = Long.parseLong(sc.nextLine());
                                            System.out.println("Inserisci l'ID della tratta:");
                                            trattaId = Long.parseLong(sc.nextLine());
                                            pd.calcolaMediaPercorrenza(td.findRouteById(trattaId), md.findVehicleById(mezzoId));
                                            System.out.println();
                                            break case2;
                                        } catch (NumberFormatException e) {
                                            System.err.println("Inserisci un ID valido.");
                                        } catch (NotFoundException e) {
                                            System.err.println(e.getMessage());
                                            break case2;
                                        } catch (NullPointerException e) {
                                            System.err.println("Nessun risultato trovato.");
                                            break case2;
                                        }
                                    }
                                }
                                case 3 -> {
                                    case3: while(true) {
                                        try {
                                            System.out.println("Inserisci l'ID del mezzo che ha percorso la tratta:");
                                            mezzoId = Long.parseLong(sc.nextLine());
                                            System.out.println("Inserisci l'ID della tratta percorsa:");
                                            trattaId = Long.parseLong(sc.nextLine());
                                            Percorso nuovoPercorso = new Percorso(LocalDate.now(), md.findVehicleById(mezzoId), td.findRouteById(trattaId));
                                            pd.save(nuovoPercorso);
                                            if (md.findVehicleById(mezzoId).getStato() == StatoMezzo.IN_SERVIZIO) {
                                                System.out.println(nuovoPercorso.toString());
                                            }
                                            System.out.println();
                                            break case3;
                                        } catch (NumberFormatException e) {
                                            System.err.println("Inserisci un ID valido.");
                                        } catch (NotFoundException e) {
                                            System.err.println(e.getMessage());
                                            break case3;
                                        }
                                    }
                                }
                                case 4 -> {
                                    case4: while(true) {
                                        try {
                                            System.out.println("Inserisci una data per trovare lo stato del veicolo:");
                                            LocalDate dataStatoVeicolo = LocalDate.parse(sc.nextLine());
                                            System.out.println("Inserisci id del veicolo per trovare lo stato del veicolo in questa data:");
                                            mezzoId = Long.parseLong(sc.nextLine());
                                            Mezzo mezzoo = md.findVehicleById(mezzoId);
                                            System.out.println();
                                            md.ricercaPeriodiDiStato(dataStatoVeicolo, mezzoo);
                                            System.out.println();
                                            break case4;
                                        } catch (DateTimeParseException e) {
                                            System.err.println("Formato della data non valido. Assicurati di inserire la data nel formato (YYYY-MM-DD).");
                                        } catch (NotFoundException e) {
                                            System.err.println(e.getMessage());
                                        }
                                    }
                                }
                                case 5 -> {
                                    System.out.println("Inserisci una data per visualizzare i biglietti emessi: ");
                                    LocalDate data = LocalDate.parse(sc.nextLine());
                                    List<Biglietto> biglietti = rd.ticketsForDate(data);

                                    if (biglietti.isEmpty()) {
                                        System.out.println("Non ci sono biglietti emessi in questa data.");
                                    } else {
                                        System.out.println("Biglietti emessi il " + data + ":");
                                        for (Biglietto bigliettoo : biglietti) {
                                            System.out.println(bigliettoo);
                                        }
                                    }
                                }
                                case 6 -> {
                                    System.out.println("Inserisci l'id di un mezzo per cercare i biglietti obliterati su di esso:");
                                    long idMezzo = Long.parseLong(sc.nextLine());
                                    md.totaleBigliettiObliteratiSuUnMezzo(md.findVehicleById(idMezzo));
                                }
                                case 7 -> {
                                    System.out.println("Inserisci il numero di abbonamento di utente per verificarne la validità:");
                                    long cardNumber = Long.parseLong(sc.nextLine());
                                    sd1.checkSubscription(cardNumber);
                                }
                                case 8 -> {
                                    System.out.println("Inserisci l'id del rivenditore:");
                                    long rivenditoreId = Long.parseLong(sc.nextLine());
                                    System.out.println("Questo Rivenditore ha venduto " + rd.serviziForRivenditore(rivenditoreId).size() + " biglietto/i");
                                }
                                default -> System.err.println("Scelta non valida. Riprova.");
                            }
                        }
                    } else {

                    }
                } catch (NumberFormatException e) {
                    System.err.println("Inserisci un numero valido.");
                    System.out.println();
                } catch (NotFoundException e) {
                    System.err.println(e.getMessage());
                    System.out.println();
                }

            }






















//        do {
//
//
//
//            System.out.println("4) Per vidimare i biglietti ed assegnarli al mezzo; ");
//            System.out.println("9) Per creare un biglietto;");
//            System.out.println("0) Per uscire dal programma; ");
//
//
//            scelta = sc.nextInt();
//            sc.nextLine();
//
//            switch (scelta) {
//
//                case 0:
//                    System.out.println("Uscita dal programma...");
//                    System.out.println("Arrivederci e grazie!");
//                    sc.close();
//                    return;
//
//                case 1:
//                    System.out.println("Inserisci l'ID del mezzo:");
//                    mezzoId = Long.parseLong(sc.nextLine());
//                    System.out.println("Inserisci l'ID della tratta:");
//                    trattaId = Long.parseLong(sc.nextLine());
//                    pd.trattaPerMezzo(td.findRouteById(trattaId), md.findVehicleById(mezzoId));
//                    break;
//
//                case 2:
//                    System.out.println("Inserisci l'ID del mezzo:");
//                    mezzoId = Long.parseLong(sc.nextLine());
//                    System.out.println("Inserisci l'ID della tratta:");
//                    trattaId = Long.parseLong(sc.nextLine());
//                    pd.calcolaMediaPercorrenza(td.findRouteById(trattaId), md.findVehicleById(mezzoId));
//                    break;
//
//                case 3:
//                    System.out.println("Inserisci l'ID del mezzo a cui assegnare una tratta:");
//                    mezzoId = Long.parseLong(sc.nextLine());
//                    System.out.println("Inserisci l'ID della tratta da assegnare al mezzo:");
//                    trattaId = Long.parseLong(sc.nextLine());
//                    pd.save(new Percorso(LocalDate.now(), md.findVehicleById(mezzoId), td.findRouteById(trattaId)));
//                    break;
//
//                case 4:
//                    System.out.println("Inserisci l'id del ticket da cercare:");
//                    ticketId = Long.parseLong(sc.nextLine());
//                    Biglietto biglietto2 = em.find(Biglietto.class, ticketId);
//                    if (biglietto2 != null) {
//                        System.out.println("Biglietto trovato: " + biglietto2.toString());
//                        System.out.println("Inserisci l'id del veicolo da assegnare al ticket: ");
//                        mezzoPerTicketId = Long.parseLong(sc.nextLine());
//                        Mezzo mezzo = em.find(Mezzo.class, mezzoPerTicketId);
//                        md.validateTicket(biglietto2, mezzo, LocalDate.now());
//                    } else {
//                        System.out.println("Nessun biglietto trovato con ID: " + ticketId);
//                    }
//                    break;
//
//                case 5:
//                    System.out.println("Inserisci una data per trovare lo stato del veicolo:");
//                    String input = sc.nextLine();
//                    LocalDate dataStatoVeicolo;
//                    try {
//                        dataStatoVeicolo = LocalDate.parse(input);
//                    } catch (DateTimeParseException e) {
//                        System.out.println("Formato della data non valido. Assicurati di inserire la data nel formato YYYY-MM-DD.");
//                        break;
//                    }
//
//                    System.out.println("Inserisci id del veicolo per trovare lo stato del veicolo in questa data:");
//                    mezzoId = Long.parseLong(sc.nextLine());
//                    Mezzo mezzoo = em.find(Mezzo.class, mezzoId);
//
//                    if (mezzoo != null | dataStatoVeicolo != null) {
//                        System.out.println("Stato veicolo in data " + dataStatoVeicolo + " :");
//                        md.ricercaPeriodiDiStato(dataStatoVeicolo, mezzoo);
//                    } else {
//                        System.out.println("Nessun mezzo trovato con id: " + mezzoId + " in data " + dataStatoVeicolo);
//                    }
//                    break;
//
//                case 6:
//                    System.out.println("Inserisci una data per visualizzare i biglietti emessi: ");
//                    LocalDate data = LocalDate.parse(sc.nextLine());
//                    List<Biglietto> biglietti = rd.ticketsForDate(data);
//
//                    if (biglietti.isEmpty()) {
//                        System.out.println("Nessun biglietto emesso in questa data.");
//                    } else {
//                        System.out.println("Biglietti emessi in data " + data + " :");
//                        for (Biglietto bigliettoo : biglietti) {
//                            System.out.println(bigliettoo);
//                        }
//                    }
//                    break;
//                case 7:
//                    System.out.println("Inserisci l'id di un mezzo per cercare i biglietti obliterati su di esso:");
//                    long idMezzo = Long.parseLong(sc.nextLine());
//                    md.totaleBigliettiObliteratiSuUnMezzo(md.findVehicleById(idMezzo));
//                    break;
//
//                case 8:
//                    System.out.println("Inserisci il numero di abbonamento di utente per verificarne la validità:");
//                    long cardNumber = Long.parseLong(sc.nextLine());
//                    sd1.checkSubscription(cardNumber);
//                    break;
//
//                case 9:
//                    System.out.println("Inserisci la data per creare il biglietto:");
//                    LocalDate emissione = LocalDate.parse(sc.nextLine());
//                    System.out.println("Inserisci il nome dell'utente:");
//                    String nome = sc.nextLine();
//                    System.out.println("Inserisci il cognome:");
//                    String cognome = sc.nextLine();
//                    Utente utente1=new Utente(nome,cognome,emissione);
//                    ud.save(utente1);
//                    Biglietto bigliettoNuovo = new Biglietto(emissione,utente1,rd.findSellerById(1));
//                    rd.creaTicket(bigliettoNuovo);
//                    break;
//
//                case 10:
//                    System.out.println("Inserisci l'id del rivenditore:");
//                    long rivenditoreId = Long.parseLong(sc.nextLine());
//                    System.out.println("Questo Rivenditore ha venduto " + rd.serviziForRivenditore(rivenditoreId).size() + " biglietto/i");
//                    break;
//
//                default:
//                    System.out.println("Scelta non valida. Riprova.");
//                    break;
//            }
//
//        } while (true);
    }

    public static void fillDb(EntityManager em) {
        MezzoDAO md = new MezzoDAO(em);
        RivenditoreDAO rd = new RivenditoreDAO(em);
        ServizioDAO sd1 = new ServizioDAO(em);
        StatoDAO sd2 = new StatoDAO(em);
        TrattaDAO td = new TrattaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PercorsoDAO pd = new PercorsoDAO(em);

        ud.save(new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(new Random().nextInt(2020, 2024), new Random().nextInt(1, 13), new Random().nextInt(1, 29)), TipoUtente.ADMIN));
        for (int i = 0; i < 10; i++) {
            md.saveBusWithDate(new Autobus(), LocalDate.of(new Random().nextInt(2017, 2024), new Random().nextInt(1, 13), new Random().nextInt(1, 29)));
            md.saveTramWithDate(new Tram(), LocalDate.of(new Random().nextInt(2017, 2024), new Random().nextInt(1, 13), new Random().nextInt(1, 29)));
            rd.saveSeller(new RivenditoreAutorizzato("Rivenditore" + i));
            rd.saveSeller(new DistributoreAutomatico("Distributore" + i, StatoDistributore.ATTIVO));
            ud.save(new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(new Random().nextInt(2020, 2024), new Random().nextInt(1, 13), new Random().nextInt(1, 29))));
        }
        td.save(new Tratta("Roma Termini", "Colosseo", 40));
        td.save(new Tratta("Colosseo", "Roma Termini", 40));
        td.save(new Tratta("Roma Termini", "Piazza di Spagna", 30));
        td.save(new Tratta("Piazza di Spagna", "Roma Termini", 30));
        td.save(new Tratta("Roma Termini", "Aeroporto di Fiumicino", 90));
        td.save(new Tratta("Aeroporto di Fiumicino", "Roma Termini", 90));
        td.save(new Tratta("Roma Tiburtina", "Aeroporto di Fiumicino", 100));
        td.save(new Tratta("Aeroporto di Fiumicino", "Roma Tiburtina", 100));
        td.save(new Tratta("Colosseo", "Piazza del Popolo", 20));
        td.save(new Tratta("Piazza del Popolo", "Colosseo", 20));
    }
}

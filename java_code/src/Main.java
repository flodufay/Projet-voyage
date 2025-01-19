import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Créer une seule instance ici
        try {
            System.out.println("Que souhaitez-vous faire ?");
            
            System.out.println("1 : Afficher tous les clients");
            System.out.println("2 : Afficher un client");
            System.out.println("3 : Ajouter un client");
            System.out.println("4 : Supprimer un client");
            System.out.println("5 : Modifier l'information d'un client");
            
            System.out.println("6 : Afficher toutes les réservations");
            System.out.println("7 : Afficher une réservation");
            System.out.println("8 : Ajouter une réservation");
            System.out.println("9 : Supprimer une réservation");
            System.out.println("10 : Modifier une réservation");
            
            System.out.println("11 : Afficher tous les vols");
            System.out.println("12 : Afficher un vol");
            System.out.println("13 : Ajouter un vol");
            System.out.println("14 : Supprimer un vol");
            System.out.println("15 : Modifier un vol");
            
            System.out.println("0 : quitter le programme");
            
            System.out.print("Veuillez choisir une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                	Client.displayAll();
                    break;
                case 2:
                	afficherUnClient(scanner);
                    break;
                case 3:
                	ajouterClient(scanner);
                    break;
                case 4:
                    supprimerClient(scanner);
                    break;
                case 5:
                    modifierClient(scanner);
                    break;
                case 6:
                    Reservation.displayAll();
                    break;
                case 7:
                    afficherUneReservation(scanner);
                    break;
                case 8:
                    ajouterReservation(scanner);
                    break;
                case 9:
                    annulerReservation(scanner);
                    break;
                case 10:
                    modifierReservation(scanner);
                    break;
                case 11:
                    Vol.displayAll();
                    break;
                case 12:
                    afficherUnVol(scanner);
                    break;
                case 13:
                    ajouterVol(scanner);
                    break;
                case 14:
                    supprimerVol(scanner);
                    break;
                case 15:
                    modifierVol(scanner);
                    break;
                case 0:
                	break;
                default:
                    System.out.println("Choix non valide");
            }
        } finally {
            scanner.close();
        }
    }

    // Ajouter un client
    public static void ajouterClient(Scanner scanner) {
        scanner.nextLine();  // Consume the newline character left by nextInt
        System.out.print("Nom du client (en majuscules) : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom du client : ");
        String prenom = scanner.nextLine();
        System.out.print("Numéro de téléphone (facultatif) : ");
        String numTelephone = scanner.nextLine();
        System.out.print("Adresse e-mail (facultatif) : ");
        String mail = scanner.nextLine();
        System.out.print("Date de naissance (YYYY-MM-DD) : ");
        String dateNaissance = scanner.nextLine();

        String[] valuesClient = {nom, prenom, numTelephone, mail, dateNaissance};
        Client.add(valuesClient);
    }

    // Ajouter une réservation
    public static void ajouterReservation(Scanner scanner) {
        System.out.print("Identifiant du client : ");
        int idClient = scanner.nextInt();
        System.out.print("Identifiant de la personne ayant réservé : ");
        int idReservataire = scanner.nextInt();
        System.out.print("Identifiant du conseiller : ");
        int idConseiller = scanner.nextInt();
        System.out.print("Numéro du vol : ");
        int numVol = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type de vol (Economy, Business, etc.) : ");
        String typeVol = scanner.nextLine();
        System.out.print("Type de paiement (CB, Espèces, etc.) : ");
        String typePaiement = scanner.nextLine();
        System.out.print("Date de paiement (YYYY-MM-DD) : ");
        String datePaiement = scanner.nextLine();
        System.out.print("Annulation possible (non : 0, oui : 1) : ");
        int annulationPossible = scanner.nextInt();

        String[] valuesReservation = {
            String.valueOf(idClient), 
            String.valueOf(idReservataire),
            String.valueOf(idConseiller),
            String.valueOf(numVol),
            typeVol,
            typePaiement,
            datePaiement,
            String.valueOf(annulationPossible)
        };

        Reservation.add(valuesReservation);
    }

    // Annuler une réservation
    public static void annulerReservation(Scanner scanner) {
        System.out.print("Identifiant de la réservation à annuler : ");
        int idReservation = scanner.nextInt();
        Reservation.delete(idReservation);
    }

    // Afficher un client
    public static void afficherUnClient(Scanner scanner) {
        System.out.print("ID du client à afficher : ");
        int id = scanner.nextInt();
        Client.displayByPrimeKey(id);
    }

    // Supprimer un client
    public static void supprimerClient(Scanner scanner) {
        System.out.print("ID du client à supprimer : ");
        int id = scanner.nextInt();
        Client.delete(id);
    }

    // Modifier un client
    public static void modifierClient(Scanner scanner) {
        System.out.print("ID du client à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consommer le saut de ligne
        System.out.print("Nom de la colonne à modifier (nom, prenom, num_telephone, mail, date_naissance) : ");
        String colonne = scanner.nextLine();
        System.out.print("Nouvelle valeur : ");
        String nouvelleValeur = scanner.nextLine();

        Client.modify(id, colonne, nouvelleValeur);
    }


    // Afficher une réservation
    public static void afficherUneReservation(Scanner scanner) {
        System.out.print("ID de la réservation à afficher : ");
        int id = scanner.nextInt();
        Reservation.displayByPrimeKey(id);
    }


    // Modifier une réservation
    public static void modifierReservation(Scanner scanner) {
        System.out.print("ID de la réservation à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consommer le saut de ligne
        System.out.print("Nom de la colonne à modifier : ");
        String colonne = scanner.nextLine();
        System.out.print("Nouvelle valeur : ");
        String nouvelleValeur = scanner.nextLine();

        Reservation.modify(id, colonne, nouvelleValeur);
    }

    // Ajouter un vol
    public static void ajouterVol(Scanner scanner) {
        scanner.nextLine();  // Consommer le saut de ligne
        System.out.print("ID de la compagnie : ");
        String idCompagnie = scanner.nextLine();
        System.out.print("Date et heure de départ (YYYY-MM-DD HH:MM:SS) : ");
        String dateHeureDepart = scanner.nextLine();
        System.out.print("Lieu de départ : ");
        String lieuDepart = scanner.nextLine();
        System.out.print("Date et heure d'arrivée (YYYY-MM-DD HH:MM:SS) : ");
        String dateHeureArrivee = scanner.nextLine();
        System.out.print("Lieu d'arrivée : ");
        String lieuArrivee = scanner.nextLine();

        String[] values = {idCompagnie, dateHeureDepart, lieuDepart, dateHeureArrivee, lieuArrivee};
        Vol.add(values);
    }

    // Afficher un vol
    public static void afficherUnVol(Scanner scanner) {
        System.out.print("Numéro du vol à afficher : ");
        int numVol = scanner.nextInt();
        Vol.displayByPrimeKey(numVol);
    }

    // Supprimer un vol
    public static void supprimerVol(Scanner scanner) {
        System.out.print("Numéro du vol à supprimer : ");
        int numVol = scanner.nextInt();
        Vol.delete(numVol);
    }

    // Modifier un vol
    public static void modifierVol(Scanner scanner) {
        System.out.print("Numéro du vol à modifier : ");
        int numVol = scanner.nextInt();
        scanner.nextLine();  // Consommer le saut de ligne
        System.out.print("Nom de la colonne à modifier : ");
        String colonne = scanner.nextLine();
        System.out.print("Nouvelle valeur : ");
        String nouvelleValeur = scanner.nextLine();

        Vol.modify(numVol, colonne, nouvelleValeur);
    }
}


	
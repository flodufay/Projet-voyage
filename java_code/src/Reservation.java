import java.sql.*;

public class Reservation extends Table{
    
    //Attribut specific for the table
    private static String nameTable = "Reservations";
    private static String[] nameColumns = {"id_client", "id_reservation", "id_reservataire", "id_conseiller", "num_vol", "type_vol", "type_paiement", "date_paiement", "annulation_possible"};
    private static String namePrimeKey = "id_reservation";

    public static void main(String[] args) {

    }
}

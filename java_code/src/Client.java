import java.sql.*;

public class Client extends Table {

    //Attribut specific for the table
    private static String nameTable = "Client";
    private static String[] nameColumns = {"id_client", "nom", "prenom", "num_telephone", "mail", "date_naissance"};
    private static String namePrimeKey = "id_client";


    // Main-Methode for tests
    public static void main(String[] args) {

    }
}

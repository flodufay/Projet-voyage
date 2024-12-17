import java.sql.*;

public class Vol extends Table {


    
    //Attribut specific for the table
    private static String nameTable = "Vol";
    private static String[] nameColumns = {"num_vol", "compagnie", "date_heure_depart", "lieu_depart", "date_heure_arrivee", "lieu arrivee"};
    private static String namePrimeKey = "num_vol";

    // Main-Methode for tests
    public static void main(String[] args) {

    }
}

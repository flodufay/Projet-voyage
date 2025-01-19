import java.sql.*;

public class Reservation extends Table{
    
    //Attribut specific for the table
    private static String nameTable = "reservation";
    private static String[] nameColumns = {"id_client", "id_reservataire", "id_conseiller", "num_vol", "type_vol", "type_paiement", "date_paiement", "annulation_possible"};
    private static String namePrimeKey = "id_reservation";
    
    //override of method add
    public static void add(String[] values) {
    	add(nameTable, nameColumns, namePrimeKey, values);
    }
    
    //override of method delete
    public static void delete(int id) {
    	delete(nameTable, nameColumns, namePrimeKey, id);
    }
    
    //override of method displayAll
    public static void displayAll() {
        displayAll(nameTable, nameColumns, namePrimeKey);
    }
    
    //override displayByPrimeKey
    public static void displayByPrimeKey(int id) {
        displayByPrimeKey(nameTable, nameColumns, namePrimeKey, id);
    }
    
    //override of modify method
    public static void modify(int id, String column, String newValue ) {
        modify(nameTable, nameColumns, namePrimeKey, id, column, newValue );
    }


    public static void main(String[] args) {
    	String[] values_reservation = {"1", "1", "3", "ceci est un numéro", "Business", "CB", "2024-06-27", "0"};
    	displayAll();
    	add(values_reservation);
    	displayAll();
    	displayByPrimeKey(4);
    	modify(4, "id_client", "10");
    	displayAll();
    	displayByPrimeKey(4);
    	delete(4);
    	displayAll();
    }
}

import java.sql.*;

public class Vol extends Table {


    
    //Attribut specific for the table
    private static String nameTable = "vol";
    private static String[] nameColumns = {"id_compagnie", "date_heure_depart", "lieu_depart", "date_heure_arrivee", "lieu_arrivee"};
    private static String namePrimeKey = "num_vol";
    
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


    // Main-Methode for tests
    public static void main(String[] args) {
    	String[] values_vol = {"5", "10", "2024-08-10 10:02:00.000", "LILLE", "2024-08-10 11:03:00.000", "QUIMPER"};
    	displayAll();
    	add(values_vol);
    	displayAll();
    	displayByPrimeKey(3);
    	modify(3, "id_compagnie", "20");
    	displayAll();
    	displayByPrimeKey(3);
    	delete(3);
    	displayAll();
    }
}

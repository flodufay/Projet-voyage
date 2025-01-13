import java.sql.*;

public class Client extends Table {
	
    //Attribut specific for the table
    private static final String nameTable = "client";
    private static final String[] nameColumns = {"id_client", "nom", "prenom", "num_telephone", "mail", "date_naissance"};
    private static final String namePrimeKey = "id_client";

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
    	String[] values_client = {"5", "Paul", "Jean", "0783782361", "mail@mail.com", "1985-07-22"};
    	displayAll();
    	add(values_client);
    	displayAll();
    	displayByPrimeKey(5);
    	modify(5, "nom", "Sebastien");
    	displayAll();
    	displayByPrimeKey(5);
    	delete(5);
    	displayAll();
    }
}

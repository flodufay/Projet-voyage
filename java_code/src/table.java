import java.sql.*;

public class table {

    // Attritbuts
	//DB connection details
	private static final String hostName ="localhost";
	private static final String port ="8584";
    private static final String URL = "jdbc :mysql://"+hostName+":" + port;
    private static final String USER = "root";
    private static final String PASSWORD = "motdepasse";

    private static Connection connection;

    
    //Attributs specific for the table
    private static String nameTable;
    private static String[] nameColumns;
    private static String namePrimeKey;
    
    // method for the connection
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    // add method
    public static void add(String[] values) {
    	
    	String sqlValues = "'" + values[0]+ "'";
    	
    	for (int i = 1; i<values.length, i++) {
    		sqlValues = sqlValues + "," + "'" + values[i]+ "'";
    	}
    	
    	String sqlNames=nameColumns[0];
    	
    	for (int i = 1; i<nameColumns.length, i++) {
    		sqlNames = sqlNames + "," + nameColumns[i];
    	}
    	
        String query = "INSERT INTO "+ nameTable +" ( " + sqlNames +" ) VALUES (" + sqlValues + " )";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             System.out.println("Added passenger succesfully.");
             connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //delete method
    public static void delete(int id) {
    	 
    	String query = "DELETE FROM " + nameTable + " WHERE " + namePrimeKey +" = " + "'" + id+ "'";
    	try (Connection conn = getConnection();
    		PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println("Deleted reservation succesfully");
            connection.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    // Display all method 
    public static void displayAll() {
        String query = "SELECT * FROM " + tablename;
        
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            //Display tablehead:
            String tableNames=nameColumns[0];
        	
        	for (int i = 1; i<nameColumns.length, i++) {
        		tableNames = tableNames + "/" + nameColumns[i];
        	}
        	System.out.println(tableNames);
        	System.out.println("---------------------------------")
        	
            while (rs.next()) {
            	String line=rs.getString(nameColumns[0]);
            	for (int i=1; i<nameColumns.length, i++) {
            		line = line + "\t" + rs.getString(nameColumns[i]);
            	}
                System.out.println(line);
            } connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    //Display by primeKey
    public static void displayByPrimeKey(int id) {
        String query = "SELECT * FROM " + tablename + "WHERE " + primeKey " = " + "'" + id+ "'";
        
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            //Display tablehead:
            String tableNames=nameColumns[0];
        	
        	for (int i = 1; i<nameColumns.length, i++) {
        		tableNames = tableNames + "/" + nameColumns[i];
        	}
        	System.out.println(tableNames);
        	System.out.println("---------------------------------")
        	
            while (rs.next()) {
            	String line=rs.getString(nameColumns[0]);
            	for (int i=1; i<nameColumns.length, i++) {
            		line = line + "\t" + rs.getString(nameColumns[i]);
            	}
                System.out.println(line);
            } connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //modify method
    public static void modify() {

    }

    // Main-Methode for tests
    public static void main(String[] args) {
        // Add passenger example
        addPassenger("Max", "Mustermann", Date.valueOf("1985-06-15"));
        addPassenger("Anna", "Müller", Date.valueOf("1990-11-22"));
        
        // create reservation example
        createReservation(1, "XY123", Date.valueOf("2024-12-20"));
        createReservation(2, "AB456", Date.valueOf("2024-12-21"));
        
        // display passenger and reservation information
        displayPassenger(1);
        displayReservations(1);
    }
}

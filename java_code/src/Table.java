import java.sql.*;

public class Table {

    // Attritbuts
	//DB connection details
	private static final String hostName ="localhost";
	private static final String port ="3306";
    private static final String URL = "jdbc:mysql://"+hostName + ":" + port + "/projet";
    private static final String USER = "projet";
    private static final String PASSWORD = "projet";

    private static Connection connection;

    
    // method for the connection
    public static Connection getConnection() throws SQLException {
        try {
        	String unicode="?useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL + unicode, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return connection;
    }

    // add method
    public static void add(String nameTable,  String[] nameColumns, String namePrimeKey, String[] values) {
    	
    	String sqlValues = "'" + values[0]+ "'";
    	
    	for (int i = 1; i<values.length; i++) {
    		sqlValues = sqlValues + "," + "'" + values[i]+ "'";
    	}
    	
    	String sqlNames=nameColumns[0];
    	
    	for (int i = 1; i<nameColumns.length; i++) {
    		sqlNames = sqlNames + "," + nameColumns[i];
    	}
    	
        String query = "INSERT INTO "+ nameTable +" ( " + sqlNames +" ) VALUES (" + sqlValues + " )";
        
        try (Connection conn = getConnection();
        	PreparedStatement stmt = conn.prepareStatement(query)) {
        	stmt.executeUpdate();

            System.out.println("Added " + nameTable + " succesfully.");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //delete method
    public static void delete(String nameTable,  String[] nameColumns, String namePrimeKey, int id) {
    	 
    	String query = "DELETE FROM " + nameTable + " WHERE " + namePrimeKey +" = " + "'" + id+ "'";
    	try (Connection conn = getConnection();
    		PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
            System.out.println("Deleted " + nameTable + " succesfully");
            connection.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    // Display all method 
    public static void displayAll(String nameTable,  String[] nameColumns, String namePrimeKey) {
        String query = "SELECT * FROM " + nameTable;
                
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            //Display tablehead:
            String tableNames=nameColumns[0];
        	
        	for (int i = 1; i<nameColumns.length; i++) {
        		tableNames = tableNames + "/" + nameColumns[i];
        	}
        	System.out.println(tableNames);
        	System.out.println("---------------------------------");
        	
            while (rs.next()) {
            	String line=rs.getString(nameColumns[0]);
            	for (int i=1; i<nameColumns.length; i++) {
            		line = line + "\t" + rs.getString(nameColumns[i]);
            	}
                System.out.println(line);
            } connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    //Display by primeKey
    public static void displayByPrimeKey(String nameTable,  String[] nameColumns, String namePrimeKey, int id) {
        String query = "SELECT * FROM " + nameTable + " WHERE " + namePrimeKey + " = " + id;
    	
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            //Display tablehead:
            String tableNames=nameColumns[0];
        	
        	for (int i = 1; i<nameColumns.length; i++) {
        		tableNames = tableNames + "/" + nameColumns[i];
        	}
        	System.out.println(tableNames);
        	System.out.println("---------------------------------");
        	
            while (rs.next()) {
            	String line=rs.getString(nameColumns[0]);
            	for (int i=1; i<nameColumns.length; i++) {
            		line = line + "\t" + rs.getString(nameColumns[i]);
            	}
                System.out.println(line);
            } connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //modify method
    public static void modify(String nameTable,  String[] nameColumns, String namePrimeKey, int id, String column, String newValue ) {
    	String query = "UPDATE " + nameTable + " SET "+ column + " = " + "'" + newValue + "'" + "WHERE " + namePrimeKey + " = " + "'" + id+ "'";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
        		stmt.executeUpdate();

                System.out.println(nameTable + " modified succesfully.");
                connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }

    // Main-Methode for tests
    public static void main(String[] args) {
    }
}

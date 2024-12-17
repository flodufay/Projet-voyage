import java.sql.*;

public class reservations {

    // DB connection details
    private static final String URL = "jdbc:mysql://localhost:3306/reservations";
    private static final String USER = "root";
    private static final String PASSWORD = "motdepasse";

    private static Connection connection;

    // method for the connection
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    // method to add a passenger
    public static void addPassenger(String prename, String name, Date birthday) {
        String query = "INSERT INTO tablename (prename, name, birthday) VALUES (?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, prename);
            stmt.setString(2, name);
            stmt.setDate(3, birthday);
            
            stmt.executeUpdate();
            System.out.println("Added passenger succesfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to add a reservation
    //here we need to adjust the variables based on our SQL database!
    //missing: conseiller, compagnie, date, heure et lieu de départ et arrivée du vol, type de vol, type de paiement, date et heure de paiement, annulation possible
    public static void createReservation(int passagerId, String flightNr, Date reservationDate) {
        String query = "INSERT INTO tablename (passager_id, flight_nr, reservation_date) VALUES (?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, passagerId);
            stmt.setString(2, flightNr);
            stmt.setDate(3, reservationDate);
            
            stmt.executeUpdate();
            System.out.println("Added reservation succesfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //method to delete a reservation -> based on annulation ?
    //are the variables below sufficient to delete reservations ?
    public static void deleteReservation(int passagerId, String flightNr, Date reservationDate) {
    	String query = "DELETE FROM tablename WHERE passager_id = passagerID AND flight_nr = flightNr AND reservation_date = reservationDate";
    	try (Connection conn = getConnection();
    		PreparedStatement stmt = conn.prepareStatement(query)) {
    		stmt.setInt(1, passagerId);
            stmt.setString(2, flightNr);
            stmt.setDate(3, reservationDate);
    		
            stmt.executeUpdate();
            System.out.println("Deleted reservation succesfully");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    // Method to display passenger information
    public static void displayPassenger(int passagierId) {
        String query = "SELECT * FROM tablename WHERE passager_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, passagierId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String prename = rs.getString("prename");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                System.out.println("Passagier: " + prename + " " + name + ", Birthday: " + birthday);
            } else {
                System.out.println("Passenger could not be found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display reservations of a passenger
    public static void displayReservations(int passagerId) {
        String query = "SELECT * FROM tablename WHERE passager_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, passagerId);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println("Reseravtions of the Passenger (ID: " + passagerId + "):");
            while (rs.next()) {
                String flightNr = rs.getString("Flightnumber");
                Date reservationDate = rs.getDate("Reservationdate");
                System.out.println("Flightnumber: " + flightNr + ", Reservationdate: " + reservationDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //method to 

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

package holidaymaker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Hotel {
Scanner console = new Scanner(System.in);
    public void getAllReservations(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM AllBookingsPrice");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("There are no bookings in the system yet.");
            }
            while (resultSet.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSet.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSet.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSet.getString("Check-in") + "\n" +
                        " Check-Out Date: " + resultSet.getString("Check-out") + "\n" +
                        " Room Number: " + resultSet.getString("Room_Number") + "\n" +
                        " Hotel Name: " + resultSet.getString("Hotel_Name") + "\n" +
                        " City: " + resultSet.getString("City") + "\n" +
                        " Booking Name: " + resultSet.getString("Booking_Name") + "\n" +
                        " Company: " + resultSet.getString("Company") + "\n" +
                        " Price: " + resultSet.getString("Price") + "\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

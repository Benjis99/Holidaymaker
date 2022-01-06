package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Booking {
    private Scanner console = new Scanner(System.in);
    private Customer customer = new Customer();
    private int reservationId;


    public void deleteBooking(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        customer.findGuestBookings(connect, statement, resultSet);
        System.out.println("Select reservation ID you wish to remove: ");
        int removeReservation = Integer.parseInt(console.nextLine());
        try {
            statement = connect.prepareStatement("DELETE FROM Booking WHERE Booking_Id = ?");
            statement.setInt(1, removeReservation);
            statement.executeUpdate();
            System.out.println("Reservation successfully removed!");
        } catch (Exception e) {
            System.out.println("There was an error, try again");
        }
    }



    private void executeUpdate(Connection connect, PreparedStatement statement, String query, String setValue) {
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1, setValue);
            statement.executeUpdate();
            System.out.println("updated successfully!");
        } catch (Exception e) {
            System.out.println("There was an error, try again");
        }
    }

    private void displayReservation(Connection connect, PreparedStatement statement, ResultSet resultSet) {

        customer.findGuestBookings(connect, statement, resultSet);
        while (true) {
            try {
                System.out.println("Select reservation ID you wish to update ('N': to exit): ");
                String updateOrExit = console.nextLine();
                if (updateOrExit.toLowerCase().equals("n")) {
                    break;
                } else {
                    int updateReservation = Integer.parseInt(updateOrExit);
                    reservationId = updateReservation;
                    statement = connect.prepareStatement("SELECT * FROM guest_bookings WHERE booking_id = ? ");
                    statement.setInt(1, updateReservation);
                    resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        String row = "Booking ID: " + resultSet.getString("Booking_Id")
                                + ", Check-In Date: " + resultSet.getString("Start_Date")
                                + ", Check-Out Date: " + resultSet.getString("End_Date")
                                + ", Room Number: " + resultSet.getString("Hotel_Rooms_Id");
                        System.out.println(row);
                    }
                }
            } catch (Exception e) {
                System.out.println("There was an error, try again");
            }
        }
    }

    public void reservation(Connection connect, PreparedStatement statement, ResultSet resultSets) {

        System.out.println("""
                    Make your reservation:""");
        System.out.println("BookingId");
        String bookingId = console.nextLine();
        System.out.println("CustomerId: ");
        String customerId = console.nextLine();
        System.out.println("Check-in date m/d/year");
        String checkinDate = console.nextLine();
        System.out.println("Check-out date m/d/year");
        String checkoutDate = console.nextLine();

        try {
            statement = connect.prepareStatement("UPDATE Booking set Customer_Id = ?, Start_Date = ?, End_Date = ? WHERE Booking_Id = ?");
            statement.setString(1, customerId);
            statement.setString(2, checkinDate);
            statement.setString(3, checkoutDate);
            statement.setString(4, bookingId);
            System.out.println("successfully updated! ");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateReservation(Connection connect, PreparedStatement statement, ResultSet resultSets) {

        System.out.println("""
                    Update a reservation:""");
        System.out.println("BookingId");
        String bookingId = console.nextLine();
        System.out.println("CustomerId: ");
        String customerId = console.nextLine();
        System.out.println("Check-in date m/d/year");
        String checkinDate = console.nextLine();
        System.out.println("Check-out date m/d/year");
        String checkoutDate = console.nextLine();

        try {
            statement = connect.prepareStatement("UPDATE Booking set Customer_Id = ?, Start_Date = ?, End_Date = ? WHERE Booking_Id = ?");
            statement.setString(1, customerId);
            statement.setString(2, checkinDate);
            statement.setString(3, checkoutDate);
            statement.setString(4, bookingId);
            System.out.println("successfully updated! ");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

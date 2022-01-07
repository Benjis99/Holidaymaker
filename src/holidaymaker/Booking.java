package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Booking {

    private Customer customer = new Customer();
    private int reservationId;


    public void deleteBooking(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        customer.findGuestBookings(connect, statement, resultSet);
        int removeReservation = Dialog.dialog("Select reservation ID you wish to remove: ");
        try {
            statement = connect.prepareStatement("DELETE FROM Booking WHERE Booking_Id = ?");
            statement.setInt(1, removeReservation);
            statement.executeUpdate();
            System.out.println("Reservation successfully removed!");
        } catch (Exception e) {
            System.out.println("There was an error, try again");
        }
    }


    public void booking(Connection connect, PreparedStatement statement, ResultSet resultSets) {

        System.out.println("""
                Make your reservation:""");
        int bookingId = Dialog.dialog("BookingId: ");
        int customerId = Dialog.dialog("CustomerId: ");
        String checkinDate = Dialog.dialogString("Check-in date m/d/year");
        String checkoutDate = Dialog.dialogString("Check-out date m/d/year");

        try {
            statement = connect.prepareStatement("UPDATE Booking set Customer_Id = ?, Start_Date = ?, End_Date = ? WHERE Booking_Id = ?");
            statement.setInt(1, customerId);
            statement.setString(2, checkinDate);
            statement.setString(3, checkoutDate);
            statement.setInt(4, bookingId);
            System.out.println("successfully updated! ");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateReservation(Connection connect, PreparedStatement statement, ResultSet resultSets) {

        System.out.println("""
                    Update a reservation:""");
        int bookingId = Dialog.dialog("BookingId");
        int customerId = Dialog.dialog("CustomerId: ");
        String checkinDate = Dialog.dialogString("Check-in date m/d/year");
        String checkoutDate = Dialog.dialogString("Check-out date m/d/year");

        try {
            statement = connect.prepareStatement("UPDATE Booking set Customer_Id = ?, Start_Date = ?, End_Date = ? WHERE Booking_Id = ?");
            statement.setInt(1, customerId);
            statement.setString(2, checkinDate);
            statement.setString(3, checkoutDate);
            statement.setInt(4, bookingId);
            System.out.println("successfully updated! ");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

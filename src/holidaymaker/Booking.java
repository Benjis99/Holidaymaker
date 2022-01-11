package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Booking {
    private Customer customer = new Customer();
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";

    public void deleteBooking(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        customer.findCustomer(connect, statement, resultSet);
        int removeBooking = Dialog.dialog("Select BookingID you want to remove: ");
        try {
            statement = connect.prepareStatement("UPDATE Booking SET Customer_Id = ?, Start_Date = ?, End_Date = ? WHERE Booking_Id = ?");
            statement.setInt(4, removeBooking);
            statement.executeUpdate();
            System.out.println(TEXT_GREEN+"Reservation successfully removed!"+TEXT_RESET);
        } catch (Exception e) {
            System.out.println(TEXT_RED+"There was a problem, please try again"+TEXT_RESET);
        }
    }


    public void mbooking(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        System.out.println("""
                Make your booking:""");
        int roomId = Dialog.dialog("roomId: ");
        int customerId = Dialog.dialog("CustomerId: ");
        String checkinDate = Dialog.dialogString("Check-in date m/d/year");
        String checkoutDate = Dialog.dialogString("Check-out date m/d/year");

        try {
            statement = connect.prepareStatement("INSERT INTO Booking (Customer_Id, Start_Date, End_Date, Hotel_Rooms_Id) VALUES(?,?,?,?)");
            statement.setInt(1, customerId);
            statement.setString(2, checkinDate);
            statement.setString(3, checkoutDate);
            statement.setInt(4, roomId);
            System.out.println(TEXT_GREEN+"Successfully booked room! "+TEXT_RESET);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBooking(Connection connect, PreparedStatement statement, ResultSet resultSets) {

        System.out.println("""
                    Update a booking:""");
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
            System.out.println(TEXT_GREEN+"successfully updated! "+TEXT_RESET);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
/*
  public void findCustomer(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        while(true) {
            String firstName = Dialog.dialogString("Enter Customers first name:");
            String lastName = Dialog.dialogString("Enter Customers last name: ");
            try {
                statement = connect.prepareStatement("SELECT BookingId FROM bookingId WHERE Firstname = ? AND Lastname = ?");
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                resultSet = statement.executeQuery();
                if (!resultSet.isBeforeFirst()) {
                    System.out.println(TEXT_RED+"No bookings were found"+TEXT_RESET);
                    findCustomer(connect, statement, resultSet);
                    break;
                }
                while (resultSet.next()) {
                    String row = "Booking ID: " + TEXT_GREEN+resultSet.getString("BookingId")+TEXT_RESET;
                    System.out.println(row);
                    System.out.println("────────────────────────────────────────────────────────────────────");
                    id = resultSet.getString("BookingId");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                statement = connect.prepareStatement("SELECT * FROM AllBookingsNew WHERE BookingId = ?");
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                if (!resultSet.isBeforeFirst()) {
                    System.out.println(TEXT_RED+"No bookings were found"+TEXT_RESET);
                    findCustomer(connect, statement, resultSet);
                    break;
                }
                while (resultSet.next()) {
                    String row =
                            "Booking ID: " +resultSet.getString("BookingId")+"\n"+
                           TEXT_GREEN+ " CustomerId: "+ TEXT_RESET +resultSet.getString("CustomerId") +"\n"+
                           TEXT_RED+ " Check-in date: "+ TEXT_RESET +resultSet.getString("Check-in")+
                           TEXT_BLUE+ " Check-out date: " + TEXT_RESET+resultSet.getString("Check-out")+"\n"+
                           TEXT_CYAN+ " Hotel Name: " + TEXT_RESET+resultSet.getString("Hotel_Name")+
                           TEXT_PURPLE+ " City: "+ TEXT_RESET +resultSet.getString("City");

                    System.out.println(row);
                    System.out.println("────────────────────────────────────────────────────────────────────");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            break;
        }
    }

 */

package holidaymaker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Hotel {
Scanner console = new Scanner(System.in);
    public void getAllReservations(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM AllBookings");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("There are no bookings in the system yet.");
            }
            while (resultSet.next()) {
                String row = "__________________________________________________________________________" + "\n" +
                        " Booking ID: " + resultSet.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSet.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSet.getString("Check-in") + "\n" +
                        " Check-Out Date: " + resultSet.getString("Check-out") + "\n" +
                        " Room Number: " + resultSet.getString("Room_Number") + "\n" +
                        " Hotel Name: " + resultSet.getString("Hotel_Name") + "\n" +
                        " City: " + resultSet.getString("City") + "\n" +
                        " Booking Name: " + resultSet.getString("Booking_Name") + "\n" +
                        " Company: " + resultSet.getString("Company") + "\n" +
                        "__________________________________________________________________________";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllEmptyRoomsFullboard(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM Rooms");
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "__________________________________________________________________________" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("Check-in") + "\n" +
                        " Check-Out Date: " + resultSets.getString("Check-out") + "\n" +
                        " Room Number: " + resultSets.getString("RoomNumber") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        "__________________________________________________________________________";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getAllEmptyRoomsExtrabed(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM RoomsExtrabed");
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "__________________________________________________________________________" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("Check-in") + "\n" +
                        " Check-Out Date: " + resultSets.getString("Check-out") + "\n" +
                        " Room Number: " + resultSets.getString("RoomNumber") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        "__________________________________________________________________________";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllEmptyRoomshalfboard(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM RoomsHalfboard");
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "__________________________________________________________________________" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("Check-in") + "\n" +
                        " Check-Out Date: " + resultSets.getString("Check-out") + "\n" +
                        " Room Number: " + resultSets.getString("RoomNumber") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        "__________________________________________________________________________";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getAllEmptyRoomsNone(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM RoomsNone");
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "__________________________________________________________________________" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("Check-in") + "\n" +
                        " Check-Out Date: " + resultSets.getString("Check-out") + "\n" +
                        " Room Number: " + resultSets.getString("RoomNumber") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        "__________________________________________________________________________";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}

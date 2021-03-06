package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Hotel {

    public void getAllReservationsCompany(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM AllBookingsPrice");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("There are no bookings in the system.");
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

    public void getAllBooks(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM AllBookingsNew");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("There are no bookings in the system.");
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
                        " Price: " + resultSet.getString("Price") + "\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void allHotels(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM hotelDESC");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("There are no hotels in the system yet.");
            }
            while (resultSet.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " HotelName: " + resultSet.getString("Name") + "\n" +
                        " City: " + resultSet.getString("City") + "\n" +
                        " Stars: " + resultSet.getString("Rw") + "/5\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void allHotelsViaBeach(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM hotelDistanceBeach");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Error.");
            }
            while (resultSet.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " HotelName: " + resultSet.getString("Name") + "\n" +
                        " City: " + resultSet.getString("City") + "\n" +
                        " Distance to the city: " + resultSet.getString("CityDs") + "km\n" +
                        " Distance to the Beach: " + resultSet.getString("Beach") + "km\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void allHotelsViaCity(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM hotelDistanceCity");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("There are no hotels in the system yet.");
            }
            while (resultSet.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " HotelName: " + resultSet.getString("Name") + "\n" +
                        " City: " + resultSet.getString("City") + "\n" +
                        " Distance to the Beach: " + resultSet.getString("Beach") + "km\n" +
                        " Distance to the city: " + resultSet.getString("CityDs") + "km\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

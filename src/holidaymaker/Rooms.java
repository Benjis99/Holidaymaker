package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Rooms {

    public void getAllEmptyRoomsFullboard(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            statement = connect.prepareStatement(" SELECT * FROM RoomsFullboard");
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
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
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "\n" +
                        "────────────────────────────────────────────────────────────────────";
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
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
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
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "\n" +
                        "────────────────────────────────────────────────────────────────────";
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
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
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
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "\n" +
                        "────────────────────────────────────────────────────────────────────";
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
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
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
                        " Bed-Size: " + resultSets.getString("BedSize") + "km\n" +
                        " Price: " + resultSets.getString("Price") + "km\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

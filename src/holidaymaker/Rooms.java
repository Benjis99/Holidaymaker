package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Rooms {

    public void getAllEmptyRoomsFullboard(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInF = Dialog.dialogString("Check-in date m/d/year");
            String checkOutF = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND ExtraOption IS 'Full board, breakfast, lunch and dinner' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND ExtraOption IS 'Full board, breakfast, lunch and dinner' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInF);
            statement.setString(2, checkInF);
            statement.setString(3, checkOutF);
            statement.setString(4, checkOutF);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllEmptyRoomsExtrabed(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInE = Dialog.dialogString("Check-in date m/d/year");
            String checkOutE = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND ExtraOption IS 'Extra bed' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND ExtraOption IS 'Extra bed' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInE);
            statement.setString(2, checkInE);
            statement.setString(3, checkOutE);
            statement.setString(4, checkOutE);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllEmptyRoomshalfboard(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInH = Dialog.dialogString("Check-in date m/d/year");
            String checkOutH = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND ExtraOption IS 'Half board, breakfast and lunch' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND ExtraOption IS 'Half board, breakfast and lunch' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInH);
            statement.setString(2, checkInH);
            statement.setString(3, checkOutH);
            statement.setString(4, checkOutH);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllEmptyRoomsNone(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInN = Dialog.dialogString("Check-in date m/d/year");
            String checkOutN = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND ExtraOption IS 'None' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND ExtraOption IS 'None' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInN);
            statement.setString(2, checkInN);
            statement.setString(3, checkOutN);
            statement.setString(4, checkOutN);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void roomRestaurant(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInR = Dialog.dialogString("Check-in date m/d/year");
            String checkOutR = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND R IS 'true' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND R IS 'true' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInR);
            statement.setString(2, checkInR);
            statement.setString(3, checkOutR);
            statement.setString(4, checkOutR);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: "+ resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void roomKidsClub(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInK = Dialog.dialogString("Check-in date m/d/year");
            String checkOutK = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND K IS 'true' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND K IS 'true' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInK);
            statement.setString(2, checkInK);
            statement.setString(3, checkOutK);
            statement.setString(4, checkOutK);
            resultSets = statement.executeQuery();

            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: "+ resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void roomPool(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInP = Dialog.dialogString("Check-in date m/d/year");
            String checkOutP = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND P IS 'true' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND P IS 'true' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInP);
            statement.setString(2, checkInP);
            statement.setString(3, checkOutP);
            statement.setString(4, checkOutP);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: "+ resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void roomEvenening(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInEE = Dialog.dialogString("Check-in date m/d/year");
            String checkOutEE = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND E IS 'true' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND E IS 'true' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInEE);
            statement.setString(2, checkInEE);
            statement.setString(3, checkOutEE);
            statement.setString(4, checkOutEE);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " RoomId: " + resultSets.getString("RoomId") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: "+ resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bradissonHotel(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInB = Dialog.dialogString("Check-in date m/d/year");
            String checkOutB = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND HotelName IS 'Bradisson Blu' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND HotelName IS 'Bradisson Blu' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInB);
            statement.setString(2, checkInB);
            statement.setString(3, checkOutB);
            statement.setString(4, checkOutB);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: " + resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void qualityHotel(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInQ = Dialog.dialogString("Check-in date m/d/year");
            String checkOutQ = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND HotelName IS 'Quality Hotel' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND HotelName IS 'Quality Hotel' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInQ);
            statement.setString(2, checkInQ);
            statement.setString(3, checkOutQ);
            statement.setString(4, checkOutQ);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: "+ resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gothiaTowers(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInG = Dialog.dialogString("Check-in date m/d/year");
            String checkOutG = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND HotelName IS 'Gothia Towers' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND HotelName IS 'Gothia Towers' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInG);
            statement.setString(2, checkInG);
            statement.setString(3, checkOutG);
            statement.setString(4, checkOutG);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: "+ resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void comfortHotel(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInC = Dialog.dialogString("Check-in date m/d/year");
            String checkOutC = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND HotelName IS 'Comfort Hotel' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND HotelName IS 'Comfort Hotel' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInC);
            statement.setString(2, checkInC);
            statement.setString(3, checkOutC);
            statement.setString(4, checkOutC);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R")
                        + "| Pool: "+ resultSets.getString("P")
                        + "| KidsClub: " + resultSets.getString("K")
                        + "| Evening Entertainment: " + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clarionHotel(Connection connect, PreparedStatement statement, ResultSet resultSets) {
        try {
            System.out.println("Search for empty date:");
            String checkInCH = Dialog.dialogString("Check-in date m/d/year");
            String checkOutCH = Dialog.dialogString("Check-out date m/d/year");
            statement = connect.prepareStatement("SELECT * FROM hotels1 \n" +
                    "WHERE RoomId NOT IN (SELECT RoomId FROM hotels1 WHERE startDate BETWEEN ? AND ?)\n" +
                    "AND NOT (endDate BETWEEN ? AND ?)\n" +
                    "AND HotelName IS 'Clarion Hotel' OR startDate IS NULL AND endDate IS NULL\n" +
                    "AND HotelName IS 'Clarion Hotel' \n" +
                    "GROUP BY RoomId");
            statement.setString(1, checkInCH);
            statement.setString(2, checkInCH);
            statement.setString(3, checkOutCH);
            statement.setString(4, checkOutCH);
            resultSets = statement.executeQuery();
            if (!resultSets.isBeforeFirst()) {
                System.out.println("There are no empty rooms.");
            }
            while (resultSets.next()) {
                String row = "────────────────────────────────────────────────────────────────────" + "\n" +
                        " Booking ID: " + resultSets.getString("BookingId") + "\n" +
                        " CustomerId: " + resultSets.getString("CustomerId") + "\n" +
                        " Check-in Date: " + resultSets.getString("startDate") + "\n" +
                        " Check-Out Date: " + resultSets.getString("endDate") + "\n" +
                        " Hotel Name: " + resultSets.getString("HotelName") + "\n" +
                        " City: " + resultSets.getString("City") + "\n" +
                        " Extras: " + resultSets.getString("ExtraOption") + "\n" +
                        " Distance beach: " + resultSets.getString("Beach") + "km\n" +
                        " Distance city: " + resultSets.getString("CityDS") + "km\n" +
                        " Bed-Size: " + resultSets.getString("BedSize") + "\n" +
                        " Price: " + resultSets.getString("Price") + "kr\n" +
                        " Restaurant: " + resultSets.getString("R") + "| Pool: "
                        + resultSets.getString("P") + "| KidsClub: "
                        + resultSets.getString("K")
                        + "| Evening Entertainment: "
                        + resultSets.getString("E")+ "|\n" +
                        "────────────────────────────────────────────────────────────────────";
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

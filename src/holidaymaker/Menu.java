package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu {

    private Customer customer = new Customer();
    private Booking booking = new Booking();
    private Hotel hotel = new Hotel();
    private Rooms rooms = new Rooms();
    private Company company = new Company();

    public Menu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        mainMenu(connect, statement, resultSet);
    }


    private void mainMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean running = true;
        while (running){
            int userInput = Dialog.dialog("""
                    
                    Welcome! Please, choose an option:
                    |1| Register a customer or Company
                    |2| Delete a customer
                    |3| Search rooms and make a reservation
                    |4| Change, delete or update a booking
                    |5| See all bookings
                    |6| All Registered customers
                    |7| All Hotels
                    |8| Exit""");
            switch (userInput) {
                case 1 -> registerMenu(connect, statement, resultSet);
                case 2 -> customer.deleteCustomer(connect, statement);
                case 3 -> searchMenu(connect, statement, resultSet);
                case 4 -> bookingOptions(connect, statement, resultSet);
                case 5 -> hotel.getAllReservations(connect, statement, resultSet);
                case 6 -> customer.printAllCustomers(connect, statement, resultSet);
                case 7 -> hotel.allHotels(connect, statement, resultSet);
                case 8 -> System.exit(1);

            }

        }
    }
    private void registerMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        boolean optionsIsRunning = true;
        while (optionsIsRunning) {
            int userInput = Dialog.dialog("""
                    |1| Register Customer
                    |2| Register Company
                    |3| Exit to Main Menu""");

            switch (userInput) {
                case 1 -> customer.registerUser(connect, statement, resultSet);
                case 2 -> company.registerUser(connect, statement, resultSet);
                case 3 -> optionsIsRunning = false;
                default -> System.out.println("Please enter a number between 1-3");
            }
        }
    }


    private void bookingOptions(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        boolean optionsIsRunning = true;
        while (optionsIsRunning) {
            int userInput = Dialog.dialog("""
                    |1| Delete booking
                    |2| Update booking
                    |3| Exit to Main Menu""");
            switch (userInput) {
                case 1 -> booking.deleteBooking(connect, statement, resultSet);
                case 2 -> booking.updateBooking(connect, statement, resultSet);
                case 3 -> optionsIsRunning = false;
                default -> System.out.println("Please enter a number between 1-3");
            }
        }
    }
    private void searchMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
            int beginSearchOrExit = Dialog.dialog("""
                    |1| Search for empty rooms with extras
                    |2| Search for empty rooms with entertainments
                    |3| Search for empty rooms via hotel
                    |4| Exit""");
            switch (beginSearchOrExit) {
                case 1 -> searchMenuExtras(connect, statement, resultSet);
                case 2 -> entertainments(connect, statement, resultSet);
                case 3 -> searchViaHotel(connect, statement, resultSet);
                case 4 -> isRunning = false;
                default -> System.out.println("Please enter a number between 1-3");
            }
        }
    }

    private void searchMenuExtras(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
            int beginSearchOrExit = Dialog.dialog("""
                    |1| Search for empty rooms with |full board|
                    |2| Search for empty rooms with |half board|
                    |3| Search for empty rooms with |extra bed|
                    |4| Search for empty rooms with |no extras|
                    |5| Make booking
                    |6| Exit""");
            switch (beginSearchOrExit) {
                case 1 -> rooms.getAllEmptyRoomsFullboard(connect, statement, resultSet);
                case 2 -> rooms.getAllEmptyRoomshalfboard(connect, statement, resultSet);
                case 3 -> rooms.getAllEmptyRoomsExtrabed(connect, statement, resultSet);
                case 4 -> rooms.getAllEmptyRoomsNone(connect, statement, resultSet);
                case 5 -> booking.booking(connect, statement, resultSet);
                case 6 -> isRunning = false;
                default -> System.out.println("Please enter a number between 1-6");
            }
        }
    }

    private void searchViaHotel(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
            int beginSearchOrExit = Dialog.dialog("""
                    |1| Search for empty rooms |Gothia Towers - Göteborg|
                    |2| Search for empty rooms |Bradisson Blu - Stockholm|
                    |3| Search for empty rooms |Clarion Hotel - Luleå|
                    |4| Search for empty rooms |Comfort Hotel - Malmö|
                    |5| Search for empty rooms |Quality Hotel - Skövde|
                    |6| Exit""");
            switch (beginSearchOrExit) {
                case 1 -> rooms.gothiaTowers(connect, statement, resultSet);
                case 2 -> rooms.bradissonHotel(connect, statement, resultSet);
                case 3 -> rooms.clarionHotel(connect, statement, resultSet);
                case 4 -> rooms.comfortHotel(connect, statement, resultSet);
                case 5 -> rooms.qualityHotel(connect, statement, resultSet);
                case 6 -> isRunning = false;
                default -> System.out.println("Please enter a number between 1-6");
            }
        }
    }

    private void entertainments(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
            int beginSearchOrExit = Dialog.dialog("""
                    |1| Search for empty rooms with |Restaurant|
                    |2| Search for empty rooms with |Kids Club|
                    |3| Search for empty rooms with |Pool|
                    |4| Search for empty rooms with |Evening Entertainment|
                    |5| Exit""");
            switch (beginSearchOrExit) {
                case 1 -> rooms.roomRestaurant(connect, statement, resultSet);
                case 2 -> rooms.roomKidsClub(connect, statement, resultSet);
                case 3 -> rooms.roomPool(connect, statement, resultSet);
                case 4 -> rooms.roomEvenening(connect, statement, resultSet);
                case 5 -> isRunning = false;
                default -> System.out.println("Please enter a number between 1-5");
            }
        }
    }



}

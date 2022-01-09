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
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";

    public Menu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        adminLogin(connect, statement, resultSet);
    }

    private void adminLogin (Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException{
        String first = Dialog.dialogNoLine("Enter admin username: ");
        String last = Dialog.dialogNoLine("Enter password: ");

        if (first.equalsIgnoreCase("admin") && last.equalsIgnoreCase("admin")){
            System.out.println(TEXT_GREEN+"Successfully logged in "+TEXT_RESET);
            mainMenu(connect, statement, resultSet);
        } else{
            System.out.println(TEXT_RED+"Wrong username or password, try again"+TEXT_RESET);
            adminLogin(connect, statement, resultSet);
        }

    }

    private void mainMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean running = true;
        while (running){
            int userInput = Dialog.dialog("""
                    
                    Welcome! Please, choose an option:
                    |1| Register Customer or Company
                    |2| Delete Customer
                    |3| Search rooms and make a booking
                    |4| Change, delete or update a booking
                    |5| See all bookings
                    |6| All Registered customers
                    |7| Available Hotels
                    |8| Exit""");
            switch (userInput) {
                case 1 -> registerMenu(connect, statement, resultSet);
                case 2 -> customer.deleteCustomer(connect, statement);
                case 3 -> searchMenu(connect, statement, resultSet);
                case 4 -> bookingOptions(connect, statement, resultSet);
                case 5 -> hotel.getAllReservations(connect, statement, resultSet);
                case 6 -> customer.printAllCustomers(connect, statement, resultSet);
                case 7 -> hotelMenu(connect, statement, resultSet);
                case 8 -> System.exit(1);
            }
        }
    }
    private void hotelMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        boolean optionsIsRunning = true;
        while (optionsIsRunning) {
            int userInput = Dialog.dialog("""
                    Hotels via:
                    |1| Review/Stars
                    |2| Distance city
                    |3| Distance beach
                    |4| Exit to Main Menu""");

            switch (userInput) {
                case 1 -> hotel.allHotels(connect, statement, resultSet);
                case 2 -> hotel.allHotelsViaCity(connect, statement, resultSet);
                case 3 -> hotel.allHotelsViaBeach(connect, statement, resultSet);
                case 4 -> optionsIsRunning = false;
                default -> System.out.println("Please enter a number between 1-4");
            }
        }
    }

    private void registerMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        boolean optionsIsRunning = true;
        while (optionsIsRunning) {
            int userInput = Dialog.dialog("""
                    Register menu:
                    |1| Customer
                    |2| Company
                    |3| Exit to Main Menu""");

            switch (userInput) {
                case 1 -> customer.registerUser(connect, statement, resultSet);
                case 2 -> company.registerCompany(connect, statement, resultSet);
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
                    Empty rooms via:
                    |1| Extras
                    |2| Entertainments
                    |3| Hotels
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
                    Empty rooms with:
                    |1| |full board|
                    |2| |half board|
                    |3| |extra bed|
                    |4| |no extras|
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
                    Empty rooms in:
                    |1| |Gothia Towers - Göteborg|
                    |2| |Bradisson Blu - Stockholm|
                    |3| |Clarion Hotel - Luleå|
                    |4| |Comfort Hotel - Malmö|
                    |5| |Quality Hotel - Skövde|
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
                    Empty rooms with: 
                    |1| |Restaurant|
                    |2| |Kids Club|
                    |3| |Pool|
                    |4| |Evening Entertainment|
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

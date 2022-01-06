package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private Scanner console = new Scanner(System.in);
    private Customer customer = new Customer();
   // private Database database = new Database();
    private Booking booking = new Booking();
    private Hotel hotel = new Hotel();
    private Rooms rooms = new Rooms();

    public Menu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        mainMenu(connect, statement, resultSet);
    }


    private void mainMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean running = true;
        while (running){
            System.out.println("""
                    Welcome! Please, choose an option:
                    |1| Register a customer
                    |2| Delete a customer
                    |3| Search rooms and make a reservation
                    |4| Change, delete or update a booking
                    |5| See all bookings
                    |6| All Registered Users
                    |7| All Hotels
                    |8| Exit""");
            String userInput = console.nextLine();
            switch (userInput) {
                case "1" -> customer.registerUser(connect, statement, resultSet);
                case "2" -> customer.deleteCustomer(connect, statement);
                case "3" -> searchMenu(connect, statement, resultSet);
                case "4" -> reservationOptions(connect, statement, resultSet);
                case "5" -> hotel.getAllReservations(connect, statement, resultSet);
                case "6" -> customer.printAllCustomers(connect, statement, resultSet);
                case "7" -> hotel.allHotels(connect, statement, resultSet);
                case "8" -> System.exit(1);

            }

        }
    }

    private void reservationOptions(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        boolean optionsIsRunning = true;
        while (optionsIsRunning) {
            System.out.println("|1| Delete Reservation");
            System.out.println("|2| Update Reservation");
            System.out.println("|3| Exit to Main Menu");
            String userInput = console.nextLine();
            switch (userInput) {
                case "1" -> booking.deleteBooking(connect, statement, resultSet);
                case "2" -> booking.updateReservation(connect, statement, resultSet);
                case "3" -> optionsIsRunning = false;
                default -> System.out.println("Please enter a number between 1-3");
            }
        }
    }


    private void searchMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("|1| Search for empty rooms with |full board|");
            System.out.println("|2| Search for empty rooms with |half board|");
            System.out.println("|3| Search for empty rooms with |extra bed|");
            System.out.println("|4| Search for empty rooms with |no extras|");
            System.out.println("|5| Make reservation");
            System.out.println("|6| Exit");
            String beginSearchOrExit = console.nextLine();
            switch (beginSearchOrExit) {
                case "1" -> rooms.getAllEmptyRoomsFullboard(connect, statement, resultSet);
                case "2" -> rooms.getAllEmptyRoomshalfboard(connect, statement, resultSet);
                case "3" -> rooms.getAllEmptyRoomsExtrabed(connect, statement, resultSet);
                case "4" -> rooms.getAllEmptyRoomsNone(connect, statement, resultSet);
                case "5" -> booking.reservation(connect, statement, resultSet);
                case "6" -> isRunning = false;
                default -> System.out.println("Please enter a number between 1-2");
            }
        }
    }



}

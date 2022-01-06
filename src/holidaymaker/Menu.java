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

    public Menu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        mainMenu(connect, statement, resultSet);
    }


    private void mainMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean running = true;
        while (running){
            System.out.println("Welcome! Please, choose an option: ");
            System.out.println("[1] Register a customer. ");
            System.out.println("[2] Delete a customer. ");
            System.out.println("[3] Search rooms and make a reservation");
            System.out.println("[4] Change, delete or update a booking.");
            System.out.println("[5] See reservations ");
            System.out.println("[6] All Registered Users ");
            System.out.println("[7] Exit");
            String userInput = console.nextLine();
            switch (userInput) {
                case "1":
                    customer.registerUser(connect, statement, resultSet);
                    break;

                case "2":
                    customer.deleteCustomer(connect, statement);
                    break;

                case "3":
                    searchMenu(connect, statement, resultSet);
                    break;

                case "4":
                    reservationOptions(connect, statement, resultSet);
                    break;

                case "5":
                    seeReservations(connect, statement, resultSet);
                    break;

                case "6":
                    customer.printAllCustomers(connect, statement, resultSet);
                    break;


                case "7":
                    System.out.println("Bye!");
                    System.exit(1);
                    break;
            }

        }
    }
    private void seeReservations(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        boolean isMenuOn = true;
        while (isMenuOn) {
            System.out.println("[1] See all reservations");
            System.out.println("[2] See reservations by specific guest");
            System.out.println("[3] Exit to main menu");
            String userInput = console.nextLine();
            switch (userInput) {
                case "1":
                    hotel.getAllReservations(connect, statement, resultSet);
                    break;

                case "2":
                    customer.findGuestBookings(connect, statement, resultSet);
                    break;

                case "3":
                    isMenuOn = false;
                    break;

                default:
                    System.out.println("Please enter a number between 1-3");
                    break;
            }
        }
    }

    private void reservationOptions(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        boolean optionsIsRunning = true;
        while (optionsIsRunning) {
            System.out.println("[1] Delete Reservation");
            System.out.println("[2] Update Reservation");
            System.out.println("[3] Exit to Main Menu");
            String userInput = console.nextLine();
            switch (userInput) {
                case "1":
                    booking.deleteBooking(connect, statement, resultSet);
                    break;

                case "2":
                    booking.updateReservation(connect, statement, resultSet);
                    break;

                case "3":
                    optionsIsRunning = false;
                    break;

                default:
                    System.out.println("Please enter a number between 1-3");
                    break;
            }
        }
    }


    private void searchMenu(Connection connect, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("[1] Search for empty rooms with full board");
            System.out.println("[2] Search for empty rooms with extra bed");
            System.out.println("[3] Search for empty rooms with half board");
            System.out.println("[4] Search for empty rooms with no extras");
            System.out.println("[5] Make reservation");
            System.out.println("[6] Exit");
            String beginSearchOrExit = console.nextLine();
            switch (beginSearchOrExit) {
                case "1" -> hotel.getAllEmptyRoomsFullboard(connect, statement, resultSet);
                case "2" -> hotel.getAllEmptyRoomsExtrabed(connect, statement, resultSet);
                case "3" -> hotel.getAllEmptyRoomshalfboard(connect, statement, resultSet);
                case "4" -> hotel.getAllEmptyRoomsNone(connect, statement, resultSet);
                case "5" -> booking.reservation(connect, statement, resultSet);
                case "6" -> isRunning = false;
                default -> System.out.println("Please enter a number between 1-2");
            }
        }
    }



}

package holidaymaker;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    private String id;


    public void registerUser(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        String firstName = Dialog.dialogString("Enter first name: ");
        String lastName = Dialog.dialogString("Enter last name: ");
        String birthDate = Dialog.dialogString("Enter Birth Date/Year: ");
        String email = Dialog.dialogString("Enter Email: ");
        String phoneNumber = Dialog.dialogString("Enter phone number: ");
        String creditcard = Dialog.dialogString("Enter Creditcard number: ");
        String cardType = Dialog.dialogString("Enter card type: ");
        try {
            statement = connect.prepareStatement("INSERT INTO Customer(First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard, Creditcard_Type)VALUES(?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName.toLowerCase());
            statement.setString(2, lastName.toLowerCase());
            statement.setString(3, birthDate);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setString(6, creditcard);
            statement.setString(7, cardType);
            statement.executeUpdate();
            System.out.println(TEXT_GREEN+ "Registration was successful! "+TEXT_RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
        statement = connect.prepareStatement("SELECT Customer_Id FROM Customer WHERE First_Name = ? AND Last_Name = ?");
            statement.setString(1, firstName.toLowerCase());
            statement.setString(2, lastName.toLowerCase());
            resultSet = statement.executeQuery();
            System.out.println(firstName + " " + lastName +"'s CustomerId: " + TEXT_GREEN+resultSet.getString("Customer_Id")+TEXT_RESET);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Connection connect, PreparedStatement statement) {
        int customerId = Dialog.dialog("Enter CustomerId:");

        try {
            statement = connect.prepareStatement("DELETE FROM Customer WHERE Customer_Id = ?");
            statement.setInt(1, customerId);
            statement.executeUpdate();
            System.out.println(TEXT_GREEN+"successfully deleted! "+TEXT_RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findCustomer(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        while(true) {
            String firstName = Dialog.dialogString("Enter Customers first name:");
            String lastName = Dialog.dialogString("Enter Customers last name: ");
       //     checkIfGuestIsPresent(connect, statement, resultSet, firstName, lastName);
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
                statement = connect.prepareStatement("SELECT * FROM customerRoom WHERE BookingId = ?");
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                if (!resultSet.isBeforeFirst()) {
                    System.out.println(TEXT_RED+"No bookings were found"+TEXT_RESET);
                    findCustomer(connect, statement, resultSet);
                    break;
                }
                while (resultSet.next()) {
                    String row =
                           TEXT_GREEN+ " CustomerId: "+ TEXT_RESET +resultSet.getString("CustomerId") +"\n"+
                           TEXT_RED+ " Check-in date: "+ TEXT_RESET +resultSet.getString("Check-in")+
                           TEXT_BLUE+ " Check-out date: " + TEXT_RESET+resultSet.getString("Check-out")+"\n"+
                           TEXT_CYAN+ " Hotel Name: " + TEXT_RESET+resultSet.getString("Hotel_Name")+
                           TEXT_PURPLE+ " City: "+ TEXT_RESET +resultSet.getString("City")+"\n"+
                           TEXT_YELLOW+ " Firstname: " + TEXT_RESET+resultSet.getString("FirstName")+"\n"+
                           TEXT_YELLOW+ " Lastname: " + TEXT_RESET+resultSet.getString("LastName");

                    System.out.println(row);
                    System.out.println("────────────────────────────────────────────────────────────────────");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            break;
        }
    }


    public void printAllCustomers(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            statement = connect.prepareStatement("SELECT First_Name, Last_Name, Phone_Number, Customer_Id FROM Customer");
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("There are no registered Customers yet. ");
            }
            while (resultSet.next()) {
                String row = "First Name: " + resultSet.getString("First_Name")
                        + " | Last Name: " + resultSet.getString("Last_Name")
                        + " | Phone Number: " + resultSet.getString("Phone_Number")
                        + " | CustomerId: " + TEXT_GREEN+resultSet.getString("Customer_Id")+TEXT_RESET;
                System.out.println(row);
                System.out.println("────────────────────────────────────────────────────────────────────");
            }
        } catch (Exception ex) {
            System.out.println("There was an error, try again.");
        }
    }

}

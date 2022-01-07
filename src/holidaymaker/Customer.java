package holidaymaker;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer {



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
            String fullName = firstName + " " + lastName;
            System.out.println(fullName + " registered successfully! ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
        statement = connect.prepareStatement("SELECT Customer_Id FROM Customer WHERE First_Name = ? AND Last_Name = ?");
            statement.setString(1, firstName.toLowerCase());
            statement.setString(2, lastName.toLowerCase());
            resultSet = statement.executeQuery();
            System.out.println(firstName + " " + lastName +" CustomerId:" + resultSet.getString("Customer_Id"));

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
            System.out.println("successfully deleted! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findGuestBookings(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        while(true) {
            String firstName = Dialog.dialogString("Enter guest's first name:");
            String phoneNumber = Dialog.dialogString("Enter guest's phone number: ");
            checkIfGuestIsPresent(connect, statement, resultSet, firstName, phoneNumber);
            try {
                statement = connect.prepareStatement("SELECT * FROM Customer WHERE Customer_Id = (SELECT Id FROM Customer WHERE First_Name = ? AND Phone_Number = ?)");
                statement.setString(1, firstName.toLowerCase());
                statement.setString(2, phoneNumber);
                resultSet = statement.executeQuery();
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No reservations were found");
                    break;
                }
                while (resultSet.next()) {
                    String row = "Booking ID: " + resultSet.getString("Booking_Id") + "\n"
                            + " Check-In Date: " + resultSet.getString("Start_Date") + "\n"
                            + " Check-Out Date: " + resultSet.getString("End_Date") + "\n"
                            + " Room Number: " + resultSet.getString("Hotel_Rooms_Id") + "\n";
                    System.out.println(row);
                    System.out.println("────────────────────────────────────────────────────────────────────");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
        }
    }

    private void checkIfGuestIsPresent(Connection connect, PreparedStatement statement, ResultSet resultSet, String firstName, String phoneNumber) {
        try {
            statement = connect.prepareStatement("SELECT id FROM guests WHERE first_name = ? AND phone_number = ?");
            statement.setString(1, firstName.toLowerCase());
            statement.setString(2, phoneNumber);
            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Guest was not found.");
                findGuestBookings(connect, statement, resultSet);
            }
        } catch (Exception ex) {
            System.out.println("There was an error, try again.");
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
                        + " | CustomerId: " + resultSet.getString("Customer_Id");
                System.out.println(row);
                System.out.println("────────────────────────────────────────────────────────────────────");
            }
        } catch (Exception ex) {
            System.out.println("There was an error, try again.");
        }
    }

}

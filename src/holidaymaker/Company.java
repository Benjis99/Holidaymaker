package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Company {

    private Scanner console = new Scanner(System.in);

    public void registerUser(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        System.out.println("Enter first name: ");
        String firstName = console.nextLine();
        System.out.println("Enter last name: ");
        String lastName = console.nextLine();
        System.out.println("Enter Birth Date/Year: ");
        String birthDate = console.nextLine();
        System.out.println("Enter Email: ");
        String email = console.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = console.nextLine();
        System.out.println("Enter CustomerId for the company: ");
        String customerId = console.nextLine();

        try {
            statement = connect.prepareStatement("INSERT INTO Company(First_Name, Last_Name, Email, Phone_Number, Birth_Date, Customer_Id)VALUES" +
                    "(?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName.toLowerCase());
            statement.setString(2, lastName.toLowerCase());
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.setString(5, birthDate);
            statement.setString(6, customerId);
            statement.executeUpdate();
            String fullName = firstName + " " + lastName;
            System.out.println(fullName + " registered company successfully! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

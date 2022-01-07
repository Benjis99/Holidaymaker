package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Company {

    private Scanner console = new Scanner(System.in);

    public void registerUser(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        String firstName = Dialog.dialogString("Enter first name: ");
        String lastName = Dialog.dialogString("Enter last name: ");
        String birthDate = Dialog.dialogString("Enter Birth Date/Year: ");
        String email = Dialog.dialogString("Enter Email: ");
        String phoneNumber = Dialog.dialogString("Enter phone number: ");
        String customerId = Dialog.dialogString("Enter CustomerId for the company: ");

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
            System.out.println(firstName + " " + lastName + " registered company successfully! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package holidaymaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Company {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";

    public void registerCompany(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        String customerId = Dialog.dialogString("Enter CustomerId for the company: ");
        String firstName = Dialog.dialogString("Enter first name: ");
        String lastName = Dialog.dialogString("Enter last name: ");
        String birthDate = Dialog.dialogString("Enter Birth Date/Year: ");
        String email = Dialog.dialogString("Enter Email: ");
        String phoneNumber = Dialog.dialogString("Enter phone number: ");


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
            System.out.println(TEXT_GREEN + "Registered company successfully! " + TEXT_RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

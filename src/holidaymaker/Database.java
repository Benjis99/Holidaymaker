package holidaymaker;

import java.sql.*;

public class Database {

    private Connection connection = null;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public void connect(){
        try {
           connection = DriverManager.getConnection("jdbc:sqlite:Holidaymaker2.db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addCustomerToDatabase(String fullName,  String lastName, String birthDate, String email, String phoneNumber, String creditCard, String creditCardType) {
        try {
            statement = connection.prepareStatement("INSERT INTO Customer (First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard, Creditcard_Type) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, fullName);
            statement.setString(2, lastName);
            statement.setString(3, birthDate);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setString(6, creditCard);
            statement.setString(7, creditCardType);

            System.out.println("New customer " + fullName + " " + lastName +  " added.");

            try {
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error message: " + e.getMessage());
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }


}

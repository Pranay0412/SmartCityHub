package src.Main;


import java.sql.*;
import java.util.Scanner;

class LoginSystem {
    // for main
//    // Database connection details
//    String DB_URL = "jdbc:mysql://localhost:3306/login_system";
//    String DB_USER = "root";
//    String DB_PASSWORD = "yourpassword";
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to the Login System");
//        System.out.println("1. Admin Login");
//        System.out.println("2. Customer Login");
//        System.out.println("3. Customer Registration");
//        System.out.print("Select an option: ");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        switch (choice) {
//            case 1:
//                adminLogin(scanner);
//                break;
//            case 2:
//                customerLogin(scanner);
//                break;
//            case 3:
//                customerRegistration(scanner);
//                break;
//            default:
//                System.out.println("Invalid option!");
//        }
//
//        scanner.close();
//    }

     void adminLogin(Scanner scanner) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter admin username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT password FROM admins WHERE username = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String dbPassword = rs.getString("password");

                    if (password.equals(dbPassword)) {
                        System.out.println("Admin login successful!");
                        adminDashboard(scanner);
                        return;
                    } else {
                        attempts++;
                        System.out.println("Invalid password! Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                    }
                } else {
                    System.out.println("Admin not found!");
                    attempts++;
                    System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return;
            }
        }

        System.out.println("Maximum login attempts reached. Please try again later.");
    }

    void customerLogin(Scanner scanner) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter customer username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT password, full_name FROM customers WHERE username = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String dbPassword = rs.getString("password");
                    String fullName = rs.getString("full_name");

                    if (password.equals(dbPassword)) {
                        System.out.println("Customer login successful!");
                        System.out.println("Welcome, " + fullName + "!");
                        customerDashboard(scanner);
                        return;
                    } else {
                        attempts++;
                        System.out.println("Invalid password! Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                    }
                } else {
                    System.out.println("Customer not found!");
                    attempts++;
                    System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return;
            }
        }

        System.out.println("Maximum login attempts reached. Please try again later.");
    }

    void customerRegistration(Scanner scanner) {
        System.out.println("Customer Registration");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Check if username or email already exists
            String checkSql = "SELECT id FROM customers WHERE username = ? OR email = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            checkStmt.setString(2, email);

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Username or email already exists!");
                return;
            }

            // Insert new customer (password stored in plain text - not recommended for production)
            String insertSql = "INSERT INTO customers (username, password, email, full_name) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.setString(3, email);
            insertStmt.setString(4, fullName);

            int rowsAffected = insertStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registration successful! You can now login.");
            } else {
                System.out.println("Registration failed!");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    void adminDashboard(Scanner scanner) {
        System.out.println("\nAdmin Dashboard");
        System.out.println("1. View all customers");
        System.out.println("2. Logout");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                viewAllCustomers();
                adminDashboard(scanner); // Show menu again
                break;
            case 2:
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid option!");
                adminDashboard(scanner);
        }
    }

    void customerDashboard(Scanner scanner) {
        System.out.println("\nCustomer Dashboard");
        System.out.println("1. View profile");
        System.out.println("2. Logout");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Profile information would be displayed here.");
                customerDashboard(scanner); // Show menu again
                break;
            case 2:
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid option!");
                customerDashboard(scanner);
        }
    }

    void viewAllCustomers() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT id, username, email, full_name, created_at FROM customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nList of all customers:");
            System.out.println("ID\tUsername\tEmail\t\tFull Name\tJoined Date");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("username") + "\t" +
                                rs.getString("email") + "\t" +
                                rs.getString("full_name") + "\t" +
                                rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

// for database
//-- Create database
//CREATE DATABASE IF NOT EXISTS login_system;
//USE login_system;
//
//-- Create admin table
//CREATE TABLE IF NOT EXISTS admins (
//        id INT AUTO_INCREMENT PRIMARY KEY,
//        username VARCHAR(50) NOT NULL UNIQUE,
//password VARCHAR(50) NOT NULL, -- Storing plain text password (not recommended)
//email VARCHAR(100) NOT NULL UNIQUE,
//created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
//
//        -- Create customer table
//CREATE TABLE IF NOT EXISTS customers (
//        id INT AUTO_INCREMENT PRIMARY KEY,
//        username VARCHAR(50) NOT NULL UNIQUE,
//password VARCHAR(50) NOT NULL, -- Storing plain text password (not recommended)
//email VARCHAR(100) NOT NULL UNIQUE,
//full_name VARCHAR(100),
//created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
//
//        -- Insert sample admin (password is 'admin123')
//INSERT INTO admins (username, password, email)
//VALUES ('admin', 'admin123', 'admin@example.com');
//
//-- Insert sample customer (password is 'customer123')
//INSERT INTO customers (username, password, email, full_name)
//VALUES ('customer1', 'customer123', 'customer@example.com', 'John Doe');
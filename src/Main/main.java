package src.Main;

import src.Authentication.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Login l=new Login();
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                Welcome to Smart city HUB                        ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("Enter choice: ");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
            {
                boolean b=l.adminLogin();
                if(b)
                {
                    System.out.println("\nAdmin Dashboard");
                    System.out.println("1. View all customers");
                    System.out.println("2. Area");
                    System.out.println("3. Bus");
                    System.out.println("4. EmergencyServices");
                    System.out.println("5. Metro");
                    System.out.println("6. ParkingLot");
                    System.out.println("7. Route");
                    System.out.println("8. Schedule");
                    System.out.println("9. Station");
                    System.out.println("10. Street");
                    System.out.println("11. Logout");
                    System.out.print("Select an option: ");

                    int choice = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    switch (choice) {
                        case 1: {
                            l.viewAllCustomers();
                            break;
                        }
                        case 2: {
                            DataBase.AreaDAO a=new DataBase.AreaDAO();
                            System.out.println("1. To add Area");
                            System.out.println("2. To Update Area");
                            System.out.println("3. To delete Area");
                            System.out.println("4. To exit");
                            System.out.println("Enter choice: ");
                            int ch=sc.nextInt();
                            switch(ch) {
                                case 1: {
                                    boolean b = a.addArea();
                                    if (b) {
                                        System.out.println("Added successfully");
                                    }
                                    else {
                                        System.out.println("Failed");
                                    }
                                    break;
                                }
                                case 2:
                                {
                                    boolean b=a.updateArea();
                                    if (b) {
                                        System.out.println("updated successfully");
                                    }
                                    else {
                                        System.out.println("Failed");
                                    }
                                    break;
                                }
                                case 3:
                                {
                                    boolean b= a.deleteArea();
                                    if (b) {
                                        System.out.println("Deleted successfully");
                                    }
                                    else {
                                        System.out.println("Failed");
                                    }
                                    break;
                                }
                                case 4:
                                    System.out.println("Exiting.....");
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                                    break;
                            }
                            break;
                        }
                        case 3:
                        {
                            DataBase.BusDAO a=new DataBase.BusDAO();
                            System.out.println("Bus System");
                            System.out.println("1.Add bus");
                            System.out.println("2.Update bus Location");
                            System.out.println("3.Update bus Route");
                            System.out.println("4.Exit");
                            int ch=sc.nextInt();
                            switch (ch)
                            {
                                case 1: {
                                    boolean b = a.addBus();
                                    if (b) {
                                        System.out.println("Added successfully");
                                    }
                                    else {
                                        System.out.println("Failed");
                                    }
                                    break;
                                }
                                case 2:
                                {
                                    boolean b=a.updateBusLocation();
                                    if (b) {
                                        System.out.println("updated successfully");
                                    }
                                    else {
                                        System.out.println("Failed");
                                    }
                                    break;
                                }
                                case 3:
                                {
                                    boolean b= a.updateBusRoute();
                                    if (b) {
                                        System.out.println("Updated successfully");
                                    }
                                    else {
                                        System.out.println("Failed");
                                    }
                                    break;
                                }
                                case 4:
                                    System.out.println("Exiting.....");
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                                    break;
                            }
                            break;
                        }
                        case 4: {
                            DataBase.EmergencyServiceDAO a=new DataBase.EmergencyServiceDAO();
                            System.out.println("1. To add EmergencyServices");
                            System.out.println("2.display all EmergencyServices");
                            System.out.println("3. To exit");
                            System.out.println("Enter choice: ");
                            int ch=sc.nextInt();
                            switch(ch) {
                                case 1: //add
                                {
                                    boolean b = a.addEmergencyService();
                                    if (b) {
                                        System.out.println("Added successfully");
                                    }
                                    else {
                                        System.out.println("Failed");
                                    }
                                    break;
                                }
                                case 2: //display
                                {
                                    ArrayList b=a.getAllEmergencyService();
                                    break;
                                }
                                case 3:
                                    System.out.println("Exiting.....");
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                                    break;
                            }
                            break;
                        }
                        default:
                            System.out.println("Invalid option!");
                            break;
                    }
                }
                else
                {
                    System.out.println("login failed");
                }
            }
        }
    }
}

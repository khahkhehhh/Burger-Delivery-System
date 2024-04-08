/*SECJ 2154 - OOP Project
Section: 02
Lecturer Name: Dr. Nur Eiliyah @ Wong Yee Leng
Group No. : Group 11
Group Member:
Ling Wan Yin A21EC0047
Ng Suang Joo A21EC0102
Fong Khah Kheh A21EC0026
SHUVEINEEA A/P GUNASEKARAN A22EC8018 

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class CustomerApp {
   public static void displayMenu() {
            System.out.println("------------------------------------------");
            System.out.println(" Yumz Burger Delivery System");
            System.out.println("------------------------------------------");
            System.out.println("[1] Add Customer");
            System.out.println("[2] Display Customers");
            System.out.println("[3] Exit");
            System.out.print("Your choice: ");
            }
            
            public static void displayBurgerMenu() {
            try (Scanner fileScanner = new Scanner(new File("burgermenu.txt"))) {
               System.out.println("***** Burger Menu *****");
               System.out.println("------------------------");

               int count = 1;
               while (fileScanner.hasNextLine()) {
                   String line = fileScanner.nextLine();
                   String[] burgerInfo = line.split(", ");
                   String description = burgerInfo[0];
                   System.out.println(count + ") " + description );
                   count++;
                }
           } 

           catch (FileNotFoundException e) {
           System.out.println("Error: Burger menu file not found....");
           }
            }
            
            public static String getBurgerFromMenu(int burgerNumber) {
            try (Scanner fileScanner = new Scanner(new File("burgermenu.txt"))) {
                int count = 1;
                while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (count == burgerNumber) {
                  String[] burgerInfo = line.split(", ");
                  return burgerInfo[0]; // Return the burger description
                }
                count++;
                }
            } catch (FileNotFoundException e) {
                 System.out.println("Error: Burger menu file not found.");
            }
             return null; // Return null if the burger is not found
            }
            public static void main(String[]args){
                Scanner scanner = new Scanner(System.in);
                String firstName, lastName, paymentMode, street, city;
                int choice;
                Address address;
                Vector <NonMember> customerList = new Vector<>(); 
                Vector <Member> memberList = new Vector<>(); 

                do{
                    displayMenu();
                    choice = scanner.nextInt();

                    switch(choice){
                    case 1:
                    System.out.println();
                    System.out.println("***** Add Customer *****");
                    System.out.print("First name: ");
                    firstName = scanner.next();
                    firstName+=scanner.nextLine();
                    System.out.print("Last name: ");
                    lastName = scanner.next();
                    lastName+=scanner.nextLine();
                    System.out.println("Address: ");
                    System.out.print("\tStreet: ");
                    street = scanner.next();
                    street+=scanner.nextLine();
                    System.out.print("\tCity: ");
                    city = scanner.next();
                    city+=scanner.nextLine();
                    System.out.print("Payment mode (Online/COD): ");
                    paymentMode = scanner.next();
                    address = new Address(street, city);
                    System.out.print("Are you a member? (Y|N): ");
                    String member = scanner.next();
                    if (member.equalsIgnoreCase("Y"))
                    {
                        System.out.print("Member ID: ");
                        String memberId = scanner.next();
                        Member members= new Member(paymentMode, firstName, lastName, memberId, address);
                        System.out.print("Number of burger: ");
                        int burgerCount = scanner.nextInt(); 
                        
                        System.out.println(" ");
                        displayBurgerMenu();
                        System.out.println(" ");

                        for(int i=0;i<burgerCount;i++)
                        {
                             System.out.println("Burger #"+(i+1)+ ":");
                             System.out.print("Select your choice of burger number: ");
                             int burgerNumber = scanner.nextInt();
                             String burgerDescription = getBurgerFromMenu(burgerNumber);
                       
                             if (burgerDescription != null) 
                             {
                                System.out.println("Description: " + burgerDescription);
                             } 
                             else {
                                while (burgerDescription==null)
                                {  
                                     System.out.println("Invalid burger number. Please enter again.");
                                     System.out.println("");
                                     System.out.println("Burger #"+(i+1)+ ":");
                                     System.out.print("Select your choice of burger number: ");
                                     burgerNumber = scanner.nextInt();
                                     burgerDescription = getBurgerFromMenu(burgerNumber);
                                }
                                System.out.println("Description: " + burgerDescription);

                             }
                             System.out.print("Size [R-Regular, L-Large]: ");
                             String size=scanner.next();
                             Burger burger= new Burger(burgerDescription, size);
                             members.order(burger);
                             System.out.println("");
                        }
                    memberList.add(members);
                    }
                    
                    else{

                         NonMember nonmember = new NonMember(paymentMode, firstName, lastName, address);
                         System.out.print("Number of burger: ");
                         int burgerCount = scanner.nextInt();

                         System.out.println(" ");
                         displayBurgerMenu();
                         System.out.println(" ");

                         for(int i=0;i<burgerCount;i++)
                        {
                           System.out.println("Burger #"+(i+1)+ ":");
                           System.out.print("Select your choice of burger number: ");
                           int burgerNumber = scanner.nextInt();
                           String burgerDescription = getBurgerFromMenu(burgerNumber);
                        
                           if (burgerDescription != null) 
                           {
                              System.out.println("Description: " + burgerDescription);
                           } 
                        
                           else {
                              while (burgerDescription==null)
                              {  
                                 System.out.println("Invalid burger number. Please enter again.");
                                 System.out.println("");
                                 System.out.println("Burger #"+(i+1)+ ":");
                                 System.out.print("Select your choice of burger number: ");
                                 burgerNumber = scanner.nextInt();
                                 burgerDescription = getBurgerFromMenu(burgerNumber);
                              }
                              System.out.println("Description: " + burgerDescription);

                           }
                            System.out.print("Size [R-Regular, L-Large]: ");
                            String size=scanner.next();
                            Burger burger= new Burger(burgerDescription, size);
                            nonmember.order(burger);
                            System.out.println();

                        }
                    customerList.add(nonmember);
                    }
                    break;

                    case 2:
                    int option;

                    do{
                        System.out.println();
                        System.out.println("***** List of Customers *****");
                        System.out.println("[1] Member");
                        System.out.println("[2] Non-member");
                        System.out.println("[3] Back to main page");
                        System.out.print("Your choice: ");
                        option=scanner.nextInt();
                        System.out.println();

                    switch(option)
                    {
                        case 1: //MEMBER
                        if (memberList.isEmpty()){
                        System.out.println("There is no member customers ordering yet....");
                        }

                        else{
                        System.out.println("Member Customers");
                        System.out.println("-----------------");

                            for(int i=0;i<memberList.size();i++)
                            {   
                                System.out.println("Customer #"+(i+1));
                                memberList.get(i).display();
                                System.out.println();
                            }
                        }
                        break;
                
                        case 2: //NON MEMBER
                        if (customerList.isEmpty())
                        System.out.println("There is no non-member customers ordering yet....");
                        else{
                        System.out.println("Non-Member Customers");
                        System.out.println("---------------------");

                            for(int i=0;i<customerList.size();i++)
                            {
                                System.out.println("Customer #"+(i+1));
                                customerList.get(i).display();
                                System.out.println();
                        }
                        }
                        break;

                        case 3:
                        break;
                        
                        default:
                        System.out.println("Invalid choice. Please reenter the choice again.");

                    }

                } while (option != 3);

                    break;
                                            
                    case 3:
                    System.out.println("Thank you for using this system :)");
                    break;

                    }
                    
                }
                while (choice !=3);
                scanner.close(); // close the scanner

              }
}

import java.util.ArrayList;

public abstract class Customer {
   private String paymentMode;
    private Name name;
    private Address address;
    public ArrayList <Burger> burgerList;
    private final double DELIVERY_CHARGE = 4.00;

    public Customer(String paymentMethod,String firstName, String lastName, Address address)
    {
        this.paymentMode=paymentMethod;
        this.name=new Name(firstName,lastName);
        this.address=address;
        burgerList = new ArrayList<>(); // Initialize the burgerList

    }

    public abstract void order(Burger burger);
   
    public void display()
    {
            System.out.println("Name:"+ name.toString());
            System.out.println("Address:"+ address.toString());
            System.out.println("Number of ordered burger:"+ burgerList.size());
            int i=1;
            double totalPrice=0.0;
            System.out.printf("%-1s%-21s%25s%13s","","========","======","=======");
            System.out.println();
            System.out.printf("%-1s%-21s%25s%12s",""," Burger","Size "," Price");
            System.out.println("");
            System.out.printf("%-1s%-21s%25s%13s","","========","======","=======");	
            System.out.println("");

            for(Burger burger : burgerList)
            {
                Size burgerSize = burger.getBurgerSize();
                System.out.print(i + ")");
                String burgerPrice = String.format("RM %2.2f",burgerSize.getPrice());
                System.out.printf("%-39s%-12s%-14s", burger.getDesciption(), burgerSize.getSize(), burgerPrice);
                i++;
                System.out.println();
                totalPrice += burgerSize.getPrice();
            }

            System.out.println();
            System.out.printf("Total price: RM %2.2f ", totalPrice);
            System.out.println();
            if (paymentMode.equalsIgnoreCase("Online"))
            {
                totalPrice = totalPrice*0.90;
            }      
            System.out.printf("Price after discount: RM %2.2f", totalPrice);
            System.out.println();
            totalPrice += DELIVERY_CHARGE;
            System.out.printf("Total charge: RM %2.2f", totalPrice);
    
    }
}

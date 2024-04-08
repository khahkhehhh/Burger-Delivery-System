public class NonMember extends Customer{

    public NonMember(String paymentMethod,String firstName, String lastName, Address address)
    {
        super(paymentMethod, firstName, lastName, address);
    }
    
    public void order(Burger burger)
    {
        burgerList.add(burger);
    }

    public void display()
    {
        super.display();
    }

}

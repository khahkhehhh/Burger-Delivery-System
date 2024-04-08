public class Member extends Customer{
    private String memberId;
    private int points;

    public Member(String paymentMethod,String firstName, String lastName, String memberId, Address address)
    {
        super(paymentMethod,firstName,lastName,address);
        this.memberId=memberId;
    }

    public void order(Burger burger)
    {
        burgerList.add(burger);
        calculatePoints(burger);
    }

    public void calculatePoints(Burger burger) {
        Size burgerSize = burger.getBurgerSize();
        double totalPrice = burgerSize.getPrice();
        int earnedPoints = (int) (totalPrice); // Earn 1 point for every RM 1 spent exluding the discount and delivery charge
        points += earnedPoints;
    }

    public void display()
    {
        System.out.println("Member ID: "+ memberId);
        super.display();
        System.out.println();
        System.out.println("Membership points earned: "+ points);
    }

}
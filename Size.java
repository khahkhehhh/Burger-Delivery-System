enum Size {
    R(15.00, "Regular"),
    L(25.00, "Large");

    private double price;
    private String size;

    Size(double price, String size) {
        this.price = price;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }
}
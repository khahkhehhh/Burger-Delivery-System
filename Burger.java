public class Burger {
    private String description;
    private Size saiz;
    
    public Burger(String description,String size)
    {
         this.description=description;
         saiz=Size.valueOf(size);
    }
    
    public String getDesciption(){
       return description;
    }

    public Size getBurgerSize(){
       return saiz;
    }
        
}



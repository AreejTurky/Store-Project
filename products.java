package project.pkg151;

public class products {
    private final String name;
    private int ID;
    private static int count_product=0;
    private double price;
  
    
 public products(String name,double price) {
     this.name=name;
     this.price=price; 
     ID+=++count_product;
   }
 //default constructor
    public products() {
    this.name=null;
    }

    public final int returnID(){
                return this.ID;
    }

    public final String getName() {
        return name;
    }
   
    public final double returnPrice(){
                return this.price;
        }
        public void setPrice(double price) {
        this.price = price;
    }
        
    @Override
    public String toString() {
        return "("+ID+")Products(" + "name: " + name + ", price: " + price + "SR )";
    }
}


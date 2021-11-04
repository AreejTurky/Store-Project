package project.pkg151;

import java.util.ArrayList;

public final class special_product extends products{
       
        private String ReleationShip ;
        private int size;
        private  special_product arraySP[];
       
        
    public special_product( String name,double cost , String t , int size) {
        super(name, cost);
        ReleationShip=t;
        arraySP=new special_product[size];
    }

    public special_product(String name ,double cost) {
        super(name, cost);
    }
//default constructor
    public special_product() {
     
    }
         
    public void setSize(int size) {
        this.size = size;
    }
    
        public int getSize() {
        return size;
    }

    public String getReleationShip() {
        return ReleationShip;
    }

    public void setReleationShip(String ReleationShip) {
        this.ReleationShip = ReleationShip;
    }

    public special_product[] getArraySP() {
        return arraySP;
    }    

 
    @Override
    public String toString() {
        return "special_product{ " +"With ID number"+ " ("+returnID()+" ) Products ( " + "name: " + getName() + ", price: " + returnPrice() + " SR )";
    }

}

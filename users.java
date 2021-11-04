package project.pkg151;
import java.util.ArrayList;
import java.util.Scanner;

//////////////////////////
abstract public class users{
protected final String name;
protected int ID=1000;
protected static int count=0;

    public users(String name) {
        this.name = name;
       this.ID +=++count;  
    }
    public users() {
        this("No name");
    }
    public String getName() {
        return name;
    }
    public  int getID() {
        return ID;
    }
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", ID=" + ID + '}';
    }  
}
//////////////////////////

class Employee extends users{
    private double salary;

    public Employee(String name,double salary) {
        super(name);
        this.salary = salary;
    }
    public Employee() {
        this("",0);
    }
    
      public final String checkEmployee(){
        if (super.getID() == 1001 ) {
         return "Manager";   
        }
        else
      return "Normal";
    }
       @Override
          public String getName() {
        return name;
    }
           @Override
    public  int getID() {
        return ID;
    }
     public final void UpdateSalary(int bounes  )
    {
    salary = salary * bounes/100 + salary ;
    }
       
      public void setSalary(double Salary) {
        this.salary = Salary;
    }

    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "Employee (" + checkEmployee() + ")" + " name : " + name + " , ID :" + ID + " , Salary :" + salary  + ')';
    } 
}
//////////////////////////
class customer extends users{
    private int visit;
    private String typecustmer;
    public customer() {   
        this("");
    }
    public customer(String name) {
        super(name);
    }
        
    public int getVisit() {
        return visit;
    }
    
    public final String checkcustmer(){
        if ( getVisit() > 2 )
       return  typecustmer = "special custmer";   
        else
        return  typecustmer = "new custmer";      
    }
        
    public void setVisit(int visit) {
        this.visit = visit;
    }
           @Override
          public String getName() {
        return name;
    }
           @Override
    public  int getID() {
        return ID;
    }
        
           @Override
    public String toString() {
        return "customer{" +" name: "+getName()+" with ID: "+getID()+ "and time of visit= " + visit + '}';
    }
 
}









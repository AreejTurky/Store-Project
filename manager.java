package project.pkg151;
public final class manager extends Employee{
    private final int ID =1001;

    public manager(String name,double salary) {
        super(name,salary);
    }
    //default constructor
    public manager() {
        this("",0);
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
        return "manager{" +"Name"+getName()+ " with ID num=" + ID +"and salary "+getSalary()+ '}';
    }
    

}

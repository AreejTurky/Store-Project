//Bonus#3
package project.pkg151;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JtestStore {
    store t;
    Employee e;

    //assign values
      @Before
    public void tearDownClass() {
     t= new store();  
     e=new Employee("Abeer",100);
    }
    
    //test the right value
    @Test
    public void testExist() {
        boolean d=t.isExist(new products("",0));
        assertEquals(false,d);
       
    }
    
    //test the wrong value
    @Test
    public void testUpdate(){  
    double t=190.0;
    e.UpdateSalary(20);
    double a=e.getSalary();
    assertNotEquals(t, a);
    
    }
}

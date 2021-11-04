package project.pkg151;
import java.util.*;

public class Test {

	public static void main(String [] args ) {	
	
	
          Scanner input = new Scanner (System.in ) ;
       
          //Array of all product 
          ArrayList<products> objproducts = new ArrayList <products> ();
          objproducts.add(new products ("phone" , 4000.0) );
          objproducts.add(new products ("tablet " , 200.0 ));
          objproducts.add(new products ("smart pen" ,500.0));
          objproducts.add(new products ("cover" , 80.0 ) );
          objproducts.add(new products ("Ipad " , 2000.0));
          
         //Array of special product  
         ArrayList<products> listSp1 = new ArrayList <products> ();
         listSp1.add(objproducts.get(0));
         listSp1.add(objproducts.get(1));
         listSp1.add(objproducts.get(2));    
         //2 type of special list
         ArrayList<products> listSp2 = new ArrayList <products> ();
         listSp2.add(objproducts.get(3));
         listSp2.add(objproducts.get(4));
        
         
        //object of special product get RelashtoinShip
        special_product R = new special_product();
     
        //Object of Store 
         store s = new store ("NICE LIFE");
         s.setArray(objproducts);
         
        //Araay of Employee
         ArrayList<Employee> ListEmployee = new ArrayList <Employee> ();
         ListEmployee.add(new Employee( "abeer", 15000 ));
         ListEmployee.add(new Employee( "khaled",10000 ));
          
         //object of custmer 
         customer c1 = new customer("ahmad"); 
         customer c2 = new customer("amal"); 
          
        
        
          System.out.println("----- Welcom in Happy Store " +s.getName() +" ------");
          System.out.println("If are you custmer click c or are you manger click m ");
          
          //use click to choose process custumer or Employee 
            char click = input.next().charAt(0);
            if ( click  == 'c')
            {
           System.out.println("-----Menu of Product Process ------");
           
            try {
           int choice ;
            do  {
//             Bonus#2   
            System.out.println("1. Display all product ");
            System.out.println("2. Display Special product");
            System.out.println("3. check is Exist ");
            System.out.println("4. Cart & Buy ");
            System.out.println("5. Exit");
            System.out.println("Choice:");
            
                choice = input.nextInt();            
                switch (choice) {
                //Display all product
                case 1:
                  System.out.println("it contains " + s.getArray1().size() + " Product in store");
                  for ( int i=0 ; i < s.getArray1().size() ; i++ ) {
                  System.out.println(s.getArray1().get(i));   
                    } 
                    break;
                //Display Special product    
                case 2:
                   R.setReleationShip("1- offer 10% if buy all ");
                   for ( int i=0 ; i <listSp1.size() ; i++ ) {    
                    System.out.println( R.getReleationShip() +  listSp1.get(i).toString() ); 
                     }
                   R.setReleationShip("2- buy 1 get 1 free  ");
                   for ( int i=0 ; i <listSp2.size() ; i++ ) {    
                    System.out.println( R.getReleationShip() +  listSp2.get(i).toString() ); 
                     }
                   
                    break;
                //check is Exist
                case 3:
                    System.out.print("Enter num of prodect ; " );
                    System.out.println( s.isExist(objproducts.get(input.nextInt()-1)));//array statred from0
                    break;
                    
                //Cart & Buy   
                case 4:
                        
                      ArrayList<products> cart = new ArrayList <products> ();
                           
                     System.out.println( " Enter num of prodect what you want buy if you finish click -1 : "   );
                     int index = input.nextInt();
                     if(index==1 || index==2 || index==3){
                     R.setReleationShip(" offer 10% if buy all ");
                     for ( int i=0 ; i <listSp1.size() ; i++ ) {    
                     System.out.println("(in "+listSp1.get(i).getName()+" )"+R.getReleationShip() +  listSp1.get(i)+")" ); 
                     }
                     }
                     else if(index==3 || index==4){
                     R.setReleationShip(" buy 1 get 1 free  ");
                     for ( int i=0 ; i <listSp2.size() ; i++ ) {    
                     System.out.println("(in "+listSp2.get(i).getName()+" )"+R.getReleationShip() +  listSp2.get(i)+")" );
                     }
                     }
                     cart.add(objproducts.get(index - 1 ) );
                     for(int i = 0 ; i < cart.size() ; i++ ) {

                     System.out.println( " Enter num of prodect what you want buy if you finish click -1 : "   );
                           
                      index = input.nextInt();
                        if(index==1 || index==2 || index==3){
                     R.setReleationShip(" offer 10% if buy all ");
                     for ( int k=0 ; k <listSp1.size() ; k++ ) {    
                     System.out.println("(in "+listSp1.get(k).getName()+" )"+R.getReleationShip() +  listSp1.get(k)+")" ); 
                     }
                     }
                     else if(index==3 || index==4){
                     R.setReleationShip(" buy 1 get 1 free  ");
                     for ( int j=0 ; j <listSp2.size() ; j++ ) {    
                     System.out.println("(in "+listSp2.get(j).getName()+" )"+R.getReleationShip() +  listSp2.get(j)+")" );
                     }
                     }
                       if (index == -1 ) {
                             break;
                                      }
              else { 
                    cart.add(objproducts.get(index - 1 ) ); 
                    for(products c : cart )   
                    System.out.println(c); //add product in cart
                                      }     
                                           }

      System.out.println( s.totalPrice(cart));  //print total price of all product in cart
      System.out.println( " If you agree to the price, press 1 to buy else press any number ");
        int agree =  input.nextInt();
            if ( agree == 1 ){
            s.buy(cart , c1 ); // buy product of cart   
                                           }
           else 
           System.out.println( "  again add product in cart  ");

             break;
                                                        
                   //to end choosing opration          
                    case 5:
                        break;
                        
              default:
              System.out.println("Sorry, please enter valid Option");
                }
            
            }
            while (choice != 5);


        }//Bonus#4
            catch (Exception ex) {
            
            System.out.println("Sorry not avaliable choice ");
            input.nextInt(); 
        }
         finally {
          System.out.println("Thanks for your coming See you soon ");
        }

    }// End of custmer process
             
  /////////////////////////////////////////////////////////
            
            else  // Start process of Employee
                
             if ( click  == 'm')  {  
                 System.out.println(" Please Enter ID of Manger  : "); 
                 int idpass = input.nextInt();
                  if ( idpass == 1001 )  {    
                System.out.println("-----Menu of Product Process for Manger  ------");
           
            try {
           int choice;
            do {
                
            System.out.println("1. Display all product ");
            System.out.println("2. Display Special product");
            System.out.println("3. Add product");
            System.out.println("4. Remove Product");
            System.out.println("5. Display list of Employee" );
            System.out.println("6. Update Salary of Employee");
            System.out.println("7. Display list Custmer");
            System.out.println("8. Exit");
            System.out.println("Choice:");
            
                choice = input.nextInt();            
                switch (choice) {
                //Display all product
                case 1:
                System.out.println("it contains " + s.getArray1().size() + " Product in store");
                  for ( int i=0 ; i < s.getArray1().size() ; i++ ) {
                  System.out.println(s.getArray1().get(i));     
                    } 
                    break;
                //Display Special product    
                case 2:
                   R.setReleationShip("1- offer in buy all ");
                   for ( int i=0 ; i <listSp1.size() ; i++ ) {    
                    System.out.println( R.getReleationShip() +  listSp1.get(i).toString() ); 
                     }
                   
                    break;
                //Add product
                case 3:
                    System.out.println("Enter the name and price for the product ");
                    String n= input.next();
                    double cost = input.nextDouble();
                    s.addProduct(new products(n,cost));
                    System.out.println(s.getArray());
                    break;
                //Remove Product
                case 4:
                              store e= new store();
                               e.setArray(objproducts);
                               e.textArea.setText(e.getArray());

                    break;
                //Display list of Employee
                case 5:
                        for ( int i=0 ; i < ListEmployee.size() ; i++ ) {
                                 System.out.println(ListEmployee.get(i).toString());   
                        }
                    break;  
                //Update Salary of Employee
                case 6:
                  
                  System.out.println(" Update percentage number  ");
                  int update = input.nextInt();
                  System.out.println(" please Enter the last numebr in ID of The employee whose salary you want to increase :  ");
                  int indexEmployee = input.nextInt();
                  ListEmployee.get(indexEmployee - 1).UpdateSalary(update);
                  System.out.println("the Salary after Update :" + ListEmployee.get(indexEmployee - 1).toString());   
              
                break;
                  //Display list Custmer
               case 7:
                   
                     System.out.println( c1.toString() +"\n"+ c2.toString()  );
         
                     break;
                   
                   case 8:
                     break;  
           
                    default:
                    System.out.println("Sorry, please enter valid Option");

                }

            } while (choice!= 8);

          
            System.out.println(" End process ");

        } catch (Exception ex) {
            
            System.out.println("Sorry not avaliable choice ");
            input.nextInt();
        } finally {
            
            System.out.println("Thanks for your coming See you soon ");
        } 
             }
                  
             }
             else 
                  System.out.println(" NOT correct option ");
            
        }
        
}

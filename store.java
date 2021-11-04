package project.pkg151;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


final public class store extends JFrame implements ActionListener{
    private final String name;
    private ArrayList<products> array=new ArrayList<products>();
    private static int counter=0;
    
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label1 = new JLabel("Welcome to store");
    JLabel jlabel2 = new JLabel();
    JLabel JText = new JLabel("Enter product ID to remove");
    JButton button1 = new JButton("click");
    JButton b1=new JButton("1");
    JTextArea textArea=new JTextArea() ;
    JTextArea textArea2=new JTextArea() ;    
    JTextField text = new JTextField (25);

    public store() {
     this("");
     
     //frame's setting
setLayout(new FlowLayout());
setSize(700, 900);
setTitle("Project-151");
setDefaultCloseOperation(EXIT_ON_CLOSE); 
setVisible(true);

//row, col,gapR ,gapC
panel1.setLayout(new GridLayout(4,3,5,5));
panel2.setLayout(new GridLayout(4,3,5,5));

panel1.setPreferredSize(new Dimension(550, 300));
panel2.setPreferredSize(new Dimension(700, 1000));
label1.setHorizontalAlignment(label1.CENTER);
JText.setHorizontalAlignment(label1.CENTER);

Font newFont = new Font("Arial", Font.BOLD, 30);
label1.setFont(newFont);
JText.setFont(newFont);
button1.setFont(newFont);
textArea.setFont(newFont);
textArea2.setFont(newFont);
textArea.setSize(400,400);
String text = label1.getText();
label1.setForeground(Color.blue);
//run time exception
button1.setEnabled(true);
//اضافتها للفريم +اضافتها للبانل 
add (panel1);
add (panel2);
panel1.add(label1);
panel1.add(JText);
panel2.add(textArea);
panel2.add(button1);
panel2.add(textArea2);



//تفعيل الاكشن للزر
button1.addActionListener(this);
     

    }
    @Override
 public void actionPerformed(ActionEvent event) {
panel2.add(jlabel2);
if(event.getSource()==button1){;
   if ( removeMA(Integer.parseInt(textArea2.getText()),new manager("",0)) )
   { jlabel2.setText("correct remove opration");
    textArea.setText(getArray());
}
else
  jlabel2.setText("can't remove");     
}

}
  /////////////////////////////
 
    public store(String name) {
        this.name = name;
    }
  /////////////////////////////
    
    public String getName() {
        return name;
    }
  /////////////////////////////
    
    public void setArray(ArrayList<products> a) {
        for(int i =0; i<a.size();i++){
            if(counter <= 100){
                array.add(a.get(i));
            counter++;
            
        }}
    }
  /////////////////////////////
    
    public String getArray() {
        String n="";
       
        for (int i = 0; i < array.size(); i++) 
        { n+=array.get(i)+"\n";
            }
        return n;
                }
    public ArrayList<products> getArray1(){
        return array;
    }
  /////////////////////////////
    
   public boolean isExist(products p){
        return array.contains(p);
   }
   /////////////////////////////  
   
   public void addProduct(products p){
 
       if(counter<=100){
          array.add(p);
           System.out.println("correct add"); 
       }
       else
           System.out.println("cann't add");
       
   }
     /////////////////////////////
   
   public boolean removeMA(int id, users a){
         if(a instanceof Employee){
         if(a.getID()==1001){
        
       for(int i=0; i<array.size() ; i++)
       if(id==array.get(i).returnID())
       {
                  array.remove(array.get(i));
                    return true;
       }
       else
           return false;
        }
         //to change the dirction
       for (int i = 0; i <array.size() ; i++) {
           if(id==array.get(i).returnID())
               removeProduct(array.get(i), a);
       }
         
}
   return false;
   }
     /////////////////////////////
   
   public void removeProduct(products p, users a){
    
   if(a instanceof customer){
       customer r=(customer)a;
       if(r.getVisit()>0)
       {
       if(isExist(p)){
           array.remove(p);
        System.out.println("correct remove opration");}
       else
               System.out.println("sorry the product is not exist");
       }
       else
             System.out.println("sorry you have to buy first");
       
      }
      
   }
     /////////////////////////////
    
   
   public double totalPrice(ArrayList<products>a){
       
       double price=0;
       for (int i = 0; i < a.size(); i++) {
         price+=a.get(i).returnPrice();   
       }
        return price; 
   }   
   /////////////////////////////
   
   public void buy(ArrayList<products> a, customer b){
       //we got an array from the user as cart
       //a==cart
       for (int i = 0; i < a.size(); i++) {
          if(isExist(a.get(i)))
         System.out.println("you buy :"+a.get(i)+" with price: "+a.get(i).returnPrice()); 
          
          else 
          {     
              System.out.println("sorry cannot find the product");
          System.exit(0);
          //break;
          }
       }
       
      b.setVisit(b.getVisit()+1);
      
       if(b.getVisit()>2)
       System.out.println("and total price = "+(totalPrice(a)-(totalPrice(a)*0.25))+" "+b.checkcustmer()+" "+b.getName()+" time of visit: "+b.getVisit());
       else
       System.out.println("and total price = "+totalPrice(a)+" costumer: "+b.getName()+" time of visit: "+b.getVisit());
 
       
        for (products a1 : a) 
            removeProduct(a1, b);
           
   }  
   }   
   
  


//class tests{
////    
//   public static void main(String[] args) {
//        store obj = new store("Happy store");
//        Employee sec=new Employee(1000,"slima");//the manger with ID=1001
//        customer first= new customer("areej"); 
//        products o1= new products("ipad",100);
//        products o2= new products("iphone",100);
//        products o3= new products("laptop",400);
//        products o4= new special_product("toy",50);
//        ArrayList< products > n=new ArrayList<>();
//        n.add(o1);
//        n.add(o2);
//        n.add(o3);
//        n.add(o4);
//        
//         obj.setArray(n);
//        
//        //System.out.println(obj.getArray());
//        
////          obj.addProduct(new products("",0));
////          obj.removeProduct(o2,first);
////          obj.removeProduct(o2,sec);
////          System.out.println(obj.isExist(o2));
////         System.out.println(obj.isExist(o4));
////         ArrayList<products>cart=new ArrayList<>();
////         cart.add(o4);
////         obj.buy(cart, first);
////         System.out.println("------------");
////         
////         obj.buy(cart, first);
//       store e= new store();
//       e.setArray(n);
//       e.textArea.setText(e.getArray());// اضافه في الواجهه في مربع النص
//    
//    }
//}
////    


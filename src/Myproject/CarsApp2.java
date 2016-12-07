package Myproject;

/**
 *
 * @author Wayne Vanzile
 */
public class CarsApp2 {
     public static void main(String[] args) {
         Saveforlater data = new Saveforlater();
        data.create(new Cars(1, "Dodge","Daytona", 500));
        data.create(new Cars(2, "Dodge", "Dakota", 600));
        data.create(new Cars(3, "Dodge", "Intrepid", 700));
        data.create(new Cars(4, "Dodge", "Ram", 800));
        System.out.println(data);
        
        System.out.println(data.retrieve(2));
        System.out.println(data.retrieve(-1));
        
        Cars c2 = new Cars(2, "Dodge", "Dakota", 1000);
        data.update(c2);
        System.out.println(data.retrieve(2));
        
        data.delete(3);
        System.out.println(data);



//System.out.println("Cars App 2");
        //CarsList pets = new CarsList();
        //System.out.println(pets);
//        Cars myCars = new Cars(3,"cat",50);
//        Carss.create(myCars);
       
    }
} 

package Myproject;

/**
 *
 * @author Wayne Vanzile
 */
public class CarsApp3 {

    public static void main(String[] args) {
        DAOCars data = new DAOCars();
        System.out.println(data);

        // Do these commands once. Then exit. 
        // Then comment out and run again to see if data was saved.
        data.create(new Cars(1, "Dodge", "Daytona", 500));
        data.create(new Cars(2, "Dodge", "Dakota", 600));
        data.create(new Cars(3, "Dodge", "Intrepid", 700));
        data.create(new Cars(4, "Dodge", "Ram", 800));
        data.create(new Cars(5, "Toyota", "Supra", 5000));
        System.out.println(data);
    }
}

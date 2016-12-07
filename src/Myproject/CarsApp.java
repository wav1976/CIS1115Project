package Myproject;

/**
 *
 * @author Wayne Vanzile
 */
public class CarsApp {

    public static void main(String[] args) {
        Cars c1 = new Cars(1, "Dodge", "Daytona", 500);
        Cars c2 = new Cars(2, "Dodge", "Dakota", 600);
        Cars c3 = new Cars(3, "Dodge", "Intrepid", 700);
        Cars c4 = new Cars(4, "Dodge", "Ram", 800);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}

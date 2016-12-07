package Myproject;

import java.util.Scanner;
import utilities.Prompt;

/**
 *
 * @author 55jphillip
 */
public class CarsAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOCars data = new DAOCars();

    public CarsAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String make;
        String model;
        double price;

        while (choice != 0) {
            System.out.println("\nCars App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Make");
            System.out.println("8 = Retrieve All: Order by Model");
            System.out.println("9 = Retrieve All: Order by Price");
            System.out.println("10 = Retrieve All: Order by Make / Price Descending");
            System.out.println("11 = Retrieve All: Order by Model / Price Descending version 2");
            System.out.println("12 = Statistics");
            choice = Prompt.getInt("Number of choice: ", 0, 12);

            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter cars id: ");
                make = Prompt.getLine("Enter Make: ");
                model = Prompt.getLine("Enter Model: ");
                price = Prompt.getDouble("Enter Price: ");
                Cars cars = new Cars(id, make, model, price);
                data.create(cars);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter cars id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                ;
            } else if (choice == 5) {
                id = Prompt.getInt("Enter cars id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderByMake());
            } else if (choice == 8) {
                System.out.println(data.orderByModel());
            } else if (choice == 9) {
                System.out.println(data.orderByPrice());
            } else if (choice == 10) {
                System.out.println(data.orderByMakePrice());
            } else if (choice == 11) {
                ;
            } else if (choice == 0) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        new CarsAppMenu();
    }
}

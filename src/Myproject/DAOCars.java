package Myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 55jphillip
 */
public class DAOCars {

    private final String fileName = "Carsdata.txt";
    private List<Cars> myList;

    public DAOCars() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOCars.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Cars cars) {
        myList.add(cars);
        writeList();
    }

    public Cars retrieve(int id) {
        for (Cars cars : myList) {
            if (cars.getId() == id) {
                return cars;
            }
        }
        return null;
    }
    
    public void delete(int id) {
        for (Cars cars : myList) {
            if (cars.getId() == id) {
                myList.remove(cars);
            }
        }
        writeList();
    }

    public String orderById() {
        myList.sort(Comparator.comparing(Cars::getId));
        return this.toString();       
    }

    public String orderByMake() {
        myList.sort(Comparator.comparing(Cars::getMake));
        return this.toString();     
    }
    public String orderByModel() {
        myList.sort(Comparator.comparing(Cars::getModel));
        return this.toString();     
    }
    
    public String orderByPrice() {
        myList.sort(Comparator.comparing(Cars::getPrice).reversed());
        return this.toString();     
    }

    public String orderByMakePrice() {
        myList.sort(Comparator.comparing(Cars::getMake).thenComparing(Cars::getPrice).reversed());
        return this.toString();     
    }    

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String Make = data[1];
                String Model = data[2];
                double Price = Double.parseDouble(data[3]);
                Cars mycars = new Cars(id, Make, Model, Price);
                myList.add(mycars);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Cars cars : myList) {
                writer.write(String.format("%d,%s,%s,%.2f\n",
                        cars.getId(),
                        cars.getMake(),
                        cars.getModel(),
                        cars.getPrice()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cars cars : myList) {
            sb.append(cars).append("\n");
        }
        return sb.toString();
        //return myList.toString();
    }
}

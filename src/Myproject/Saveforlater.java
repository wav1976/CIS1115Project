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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * The Data Access Object to a collection of Coins.
 *
 * @author Wayne Vanzile
 */
   
public class Saveforlater {
 
private final String fileName = "Carsdata.txt";
List<Cars> myList;

    public Saveforlater() {
        myList = new ArrayList<>();
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
        
    }

    public Cars retrieve(int id) {
        
        for (Cars c : myList) {
            if (c.getId() == id) {
                return c;
            }     
        }
        return null;
    }

    public void update(Cars cars) {
        for (Cars c : myList) {
            if (c.getId() == cars.getId()) {
                c.setMake(cars.getMake());
                // do this for all fields
                break;
            }
        }
    }

    public void delete(int id) {
        Cars myCars = null;
        for (Cars c : myList) {
            if (c.getId() == id) {
                myCars = c;
                break;
            }
        }
        myList.remove(myCars);
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
            Logger.getLogger(Saveforlater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Cars cars : myList) {
            sb.append(cars).append("\n");
        }
        return sb.toString();
    }
}
  


package Myproject;


/**
 * Cars class.
 *
 * @author Wayne Vanzile 
 */
public class Cars {
    private int id;
    private String Make;
     private String Model;
    private double price;

    public Cars(int id, String Make, String Model, double price) {
        this.id = id;
        this.Make = Make;
        this.Model = Model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String Make) {
        this.Make = Make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
  @Override
    public String toString() {
       // return "Cars{" + "id=" + id + ", Make=" + Make + ", Model=" + Model + ", price=" + price + '}';
        return String.format("%5d %-10s %-10s %8.2f", id, Make, Model, price);
    }

}

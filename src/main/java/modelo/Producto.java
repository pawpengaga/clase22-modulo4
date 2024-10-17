package modelo;

import java.util.Map;

public class Producto {
  private int id;
  private String title;
  private double price;
  private String description;
  private String category;
  private String image;
  private Map<String, Double> rating;

  public Producto(){

  }

  public Producto(int id, String title, double price, String description, String category, String image, Map<String,Double> rating) {
    super();
    this.id = id;
    this.title = title;
    this.price = price;
    this.description = description;
    this.category = category;
    this.image = image;
    this.rating = rating;
  }

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public double getPrice() {
    return this.price;
  }

  public String getDescription() {
    return this.description;
  }

  public String getCategory() {
    return this.category;
  }

  public String getImage() {
    return this.image;
  }

  public Map<String,Double> getRating() {
    return this.rating;
  }

  @Override
  public String toString() {
    return "{ Producto \n" +
      "\tid='" + getId() + "'\n" +
      "\ttitle='" + getTitle() + "'\n" +
      "\tprice='" + getPrice() + "'\n" +
      "\tdescription='" + getDescription() + "'\n" +
      "\tcategory='" + getCategory() + "'\n" +
      "\timage='" + getImage() + "'\n" +
      "\trating='" + getRating() + "'\n" +
      "}";
  }
}

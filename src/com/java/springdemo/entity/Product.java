/**
 * Represents a product in an e-commerce system.
 * 
 * The Product class is an entity class that is mapped to the "ecom_product" table in the database.
 * It contains various attributes such as id, name, productDetails, brand, imageName, price, discount, section, imageData, and quantity.
 * 
 * The class also defines a many-to-many relationship with the User class, where a product can be associated with multiple users.
 * 
 * The class provides getters and setters for all the attributes, as well as additional methods to add a user to the list of associated users.
 * 
 * Note: The imageData attribute is stored as a LONGBLOB in the database and is represented as a byte array in the class
 */
package com.java.springdemo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "product")
@Table(name = "ecom_product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "ECOM_ProductDetails")
  private String productDetails;
  @Column(name = "ECOM_Brand")
  private String brand;
  @Column(name = "ECOM_Product_Image_Name")
  private String imageName;
  @Column(name = "ECOM_Product_Actual_Price")
  private int price;
  @Column(name = "ECOM_Product_Discount")
  private String discount;
  @Column(name = "ECOM_Product_Section")
  private String section;
  @Lob
  @Column(columnDefinition = "LONGBLOB")
  private byte[] imageData;
  @Transient
  private int quantity;

  @Transient
  private String base64Image;

  @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH })
  @JoinTable(name = "wish_list", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "username"))
  List<User> users;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the productDetails
   */
  public String getProductDetails() {
    return productDetails;
  }

  /**
   * @param productDetails the productDetails to set
   */
  public void setProductDetails(String productDetails) {
    this.productDetails = productDetails;
  }

  /**
   * @return the brand
   */
  public String getBrand() {
    return brand;
  }

  /**
   * @param brand the brand to set
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * @return the imageName
   */
  public String getImageName() {
    return imageName;
  }

  /**
   * @param imageName the imageName to set
   */
  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  /**
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * @return the discount
   */
  public String getDiscount() {
    return discount;
  }

  /**
   * @param discount the discount to set
   */
  public void setDiscount(String discount) {
    this.discount = discount;
  }

  /**
   * @return the section
   */
  public String getSection() {
    return section;
  }

  /**
   * @param section the section to set
   */
  public void setSection(String section) {
    this.section = section;
  }

  public Product() {
  }

  /**
   * @return the base64Image
   */
  public String getBase64Image() {
    return base64Image;
  }

  /**
   * @param base64Image the base64Image to set
   */
  public void setBase64Image(String base64Image) {
    this.base64Image = base64Image;
  }

  public Product(String name, String productDetails, String brand, String imageName, int price,
      String discount, String section) {
    this.name = name;
    this.productDetails = productDetails;
    this.brand = brand;
    this.imageName = imageName;
    this.price = price;
    this.discount = discount;
    this.section = section;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", productDetails=" + productDetails
        + ", brand=" + brand + ", imageName=" + imageName + ", price=" + price + ", discount="
        + discount + ", section=" + section + "]";
  }

  public void addUser(User user) {
    if (users == null) {
      users = new ArrayList<>();
    }
    users.add(user);
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * @return the imageData
   */
  public byte[] getImageData() {
    return imageData;
  }

  /**
   * @param imageData the imageData to set
   */
  public void setImageData(byte[] imageData) {
    this.imageData = imageData;
  }

}

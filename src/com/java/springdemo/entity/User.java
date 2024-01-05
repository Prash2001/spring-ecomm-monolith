/**
 * Represents a User entity in the application.
 * 
 * This entity is mapped to the "user" table in the database.
 * It contains information about the user's username, password, first name, last name, contact, and email.
 * It also maintains a list of products in the user's wish list.
 */
package com.java.springdemo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "user")
public class User {
  @Id
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "contact")
  private String contact;
  @Column(name = "email")
  private String email;
  @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE })
  @JoinTable(name = "wish_list", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "username"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
  List<Product> products;

  /**
   * @return the products
   */
  public List<Product> getProducts() {
    return products;
  }

  /**
   * @param products the products to set
   */
  public void setProducts(List<Product> products) {
    this.products = products;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the contact
   */
  public String getContact() {
    return contact;
  }

  /**
   * @param contact the contact to set
   */
  public void setContact(String contact) {
    this.contact = contact;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public User() {
  }

  public User(String password, String firstName, String lastName, String contact, String email,
      List<Product> products) {// , Cart cart
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.contact = contact;
    this.email = email;
    this.products = products;
    // this.cart = cart;
  }

  @Override
  public String toString() {
    return "User [username=" + username + ", password=" + password + ", firstName=" + firstName
        + ", lastName=" + lastName + ", contact=" + contact + ", email=" + email + ", products="
        + products + "]";
  }

  public void addProduct(Product product) {
    if (products == null) {
      products = new ArrayList<>();
    }
    products.add(product);
  }

  public void removeProduct(Product product) {
    if (products == null) {
      products = new ArrayList<>();
    }
    products.remove(product);
  }

}

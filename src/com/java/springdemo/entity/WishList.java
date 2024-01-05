/**
 * Represents a WishList entity in the application.
 * This entity is mapped to the "wish_list" table in the database.
 */
package com.java.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "wishlist")
@Table(name = "wish_list")
public class WishList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "product_id")
  private int productId;
  @Column(name = "user_id")
  private String username;

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
   * @return the productId
   */
  public int getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(int productId) {
    this.productId = productId;
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

  public WishList() {
  }

  public WishList(int productId, String username) {
    this.productId = productId;
    this.username = username;
  }

  @Override
  public String toString() {
    return "WishList [productId=" + productId + ", username=" + username + "]";
  }

}

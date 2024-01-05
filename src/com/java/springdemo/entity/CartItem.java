/**
 * Represents an item in a shopping cart.
 * 
 * This entity is mapped to the "cartItem" table in the database.
 */
package com.java.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "cartItem")
@Table(name = "cartItem")
public class CartItem {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @OneToOne(targetEntity = Cart.class, cascade = CascadeType.DETACH)
  @JoinColumn(name = "cart_id", referencedColumnName = "id")
  private Cart cart;

  @OneToOne(targetEntity = Product.class, cascade = CascadeType.DETACH)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  @Column(name = "quantity")
  private int quantity;

  public CartItem() {
  }

  public CartItem(Cart cart, Product product, int quantity) {
    this.cart = cart;
    this.product = product;
    this.quantity = quantity;
  }

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
   * @return the cart
   */
  public Cart getCart() {
    return cart;
  }

  /**
   * @param cart the cart to set
   */
  public void setCart(Cart cart) {
    this.cart = cart;
  }

  /**
   * @return the product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * @param product the product to set
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "CartItem [id=" + id + ", cart=" + cart + ", product=" + product + ", quantity="
        + quantity + "]";
  }

}

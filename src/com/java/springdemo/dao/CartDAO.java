/**
 * The CartDAO interface provides methods for accessing and manipulating cart data in the database.
 */
package com.java.springdemo.dao;

import com.java.springdemo.entity.Cart;
import com.java.springdemo.entity.User;

public interface CartDAO {
  public Cart getUsersCart(String userId);

  public void createCart(User userId);
}

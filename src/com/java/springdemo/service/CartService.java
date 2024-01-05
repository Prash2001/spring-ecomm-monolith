/**
 * The CartService interface provides methods for managing user carts.
 */
package com.java.springdemo.service;

import com.java.springdemo.entity.Cart;

public interface CartService {
  public Cart getUsersCart(String userId);

  public void createCart(String username);

}

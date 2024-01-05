/**
 * Implementation of the CartService interface.
 * This class provides methods to interact with the Cart entity and perform operations related to the user's cart.
 */
package com.java.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.springdemo.dao.CartDAO;
import com.java.springdemo.entity.Cart;
import com.java.springdemo.entity.User;

@Service
public class CartServiceImpl implements CartService {
  @Autowired
  private CartDAO cartDAO;

  @Autowired
  private UserService userService;

  @Override
  @Transactional
  public Cart getUsersCart(String userId) {
    return cartDAO.getUsersCart(userId);
  }

  @Override
  @Transactional
  public void createCart(String userId) {
    User user = userService.getUserByUserName(userId);
    cartDAO.createCart(user);
  }

}

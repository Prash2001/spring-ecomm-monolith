/**
 * Implementation of the UserService interface that provides methods for managing users.
 * This service is responsible for interacting with the UserDAO and CartService to perform
 * operations related to user management.
 */
package com.java.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.springdemo.dao.UserDAO;
import com.java.springdemo.entity.User;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDAO userDAO;

  @Autowired
  private CartService cartService;

  @Override
  @Transactional
  public User getUser(String userName, String password) {
    return userDAO.getUser(userName, password);
  }

  @Override
  @Transactional
  public void addUser(User user) {
    userDAO.addUser(user);
    if (cartService.getUsersCart(user.getUsername()) == null) {
      cartService.createCart(user.getUsername());
    }
  }

  @Override
  @Transactional
  public User getUserByUserName(String username) {

    return userDAO.getUserByUserName(username);
  }

}

/**
 * The UserDAO interface provides methods for accessing and manipulating user data.
 */
package com.java.springdemo.dao;

import com.java.springdemo.entity.User;

public interface UserDAO {
  public User getUser(String userName, String password);

  public void addUser(User user);

  public User getUserByUserName(String username);

}

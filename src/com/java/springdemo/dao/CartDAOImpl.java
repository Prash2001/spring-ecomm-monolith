/**
 * This class is an implementation of the CartDAO interface and is responsible for
 * interacting with the database to perform CRUD operations on the Cart entity.
 * It uses Hibernate for database operations and Spring's @Repository annotation
 * to indicate that it is a repository component.
 */
package com.java.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.springdemo.entity.Cart;
import com.java.springdemo.entity.User;
@Repository
public class CartDAOImpl implements CartDAO {
  @Autowired
  private SessionFactory sessionfactory;
  @Override
  public Cart getUsersCart(String userId) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<Cart> query = currentSession.createQuery(
        "from cart where user_id like :userName", Cart.class);
    query.setParameter("userName", userId);
    Cart cart = null;
    try {
      cart = query.getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cart;
  }
  @Override
  public void createCart(User user) {
    Session currentSession = sessionfactory.getCurrentSession();
    Cart cart = new Cart();
    cart.setUserId(user.getUsername());
    currentSession.saveOrUpdate(cart);
  }

}

/**
 * This class implements the CartItemDAO interface and provides the implementation for
 * interacting with the database to perform CRUD operations on CartItem entities.
 * It uses Hibernate as the ORM framework and Spring's SessionFactory for managing database sessions.
 */
package com.java.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.springdemo.entity.CartItem;
@Repository
public class CartItemDAOImpl implements CartItemDAO {
  @Autowired
  private SessionFactory sessionfactory;
  @Override
  public void addCartItem(CartItem newCartItem) {
    Session currentSession = sessionfactory.getCurrentSession();
    currentSession.saveOrUpdate(newCartItem);
  }
  @Override
  public boolean checkIfProductAlreadyInTheCart(int productId, int cartId) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<CartItem> query = currentSession.createQuery(
        "from cartItem where cart_id like :cartId and product_id like :productId", CartItem.class);
    query.setParameter("cartId", cartId);
    query.setParameter("productId", productId);
    CartItem item;
    try {
      item = query.getSingleResult();
    } catch (Exception e) {
      item = null;
    }
    return (item!=null);
  }
  @Override
  public List<CartItem> getCartItems(int cartId) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<CartItem> query = currentSession.createQuery("from cartItem where cart_id like:cartId", CartItem.class);
    query.setParameter("cartId", cartId);
    List<CartItem> items = query.getResultList();
    return items;
  }
  @Override
  public CartItem getCartItemByProductId(int productId, int cartId) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<CartItem> query = currentSession.createQuery(
        "from cartItem where cart_id like :cartId and product_id like :productId", CartItem.class);
    query.setParameter("cartId", cartId);
    query.setParameter("productId", productId);
    CartItem item;
    try {
      item = query.getSingleResult();
    } catch (Exception e) {
      item = null;
    }
    return item;
  }
  @Override
  public void saveOrUpdateCartItem(CartItem item) {
    Session currentSession = sessionfactory.getCurrentSession();
    currentSession.saveOrUpdate(item);
  }
  @Override
  public void removeCartItem(int productId, int cartId) {
    Session currentSession = sessionfactory.getCurrentSession();
    CartItem item = getCartItemByProductId(productId,cartId);
    currentSession.delete(item);
  }
}

/**
 * Implementation of the WishListDAO interface that provides methods to interact with the WishList entity in the database.
 */
package com.java.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.springdemo.entity.WishList;

@Repository
public class WishListDAOImpl implements WishListDAO {
  @Autowired
  private SessionFactory sessionfactory;

  @Override
  public List<WishList> getWishListItems(String username) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<WishList> query = currentSession.createQuery("from wishlist where user_id like :username", WishList.class);
    query.setParameter("username", username);
    List<WishList> items = query.getResultList();
    return items;
  }

  @Override
  public WishList getItemFromWishList(String username, int productId) {
    Session currentSession = sessionfactory.getCurrentSession();
    System.out.println("This is uname " + username + " This is productId " + productId);
    Query<WishList> query = currentSession
        .createQuery("from wishlist where user_id like :username and product_id like :productId", WishList.class);
    query.setParameter("username", username);
    query.setParameter("productId", productId);
    WishList item = query.getSingleResult();
    return item;
  }

  @Override
  public void removeFromWishList(String username, int productId) {
    Session currentSession = sessionfactory.getCurrentSession();
    WishList item = getItemFromWishList(username, productId);
    currentSession.delete(item);
  }
}

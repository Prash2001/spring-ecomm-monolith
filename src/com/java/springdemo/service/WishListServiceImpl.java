/**
 * Service implementation for managing wish list items.
 */
package com.java.springdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.springdemo.dao.WishListDAO;
import com.java.springdemo.entity.WishList;

@Service
public class WishListServiceImpl implements WishListService {
  @Autowired
  private WishListDAO wishListDAO;

  @Override
  @Transactional
  public List<WishList> getWishListItems(String username) {
    return wishListDAO.getWishListItems(username);
  }

  @Override
  @Transactional
  public void removeFromWishList(String username, int productId) {
    wishListDAO.removeFromWishList(username, productId);
  }

}

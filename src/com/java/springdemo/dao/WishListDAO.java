/**
 * The WishListDAO interface provides methods for accessing and manipulating wish list items.
 */
package com.java.springdemo.dao;

import java.util.List;
import com.java.springdemo.entity.WishList;

public interface WishListDAO {

  List<WishList> getWishListItems(String username);

  public WishList getItemFromWishList(String username, int productId);

  public void removeFromWishList(String username, int productId);
}

/**
 * The CartItemDAO interface provides methods for accessing and manipulating cart items in the database.
 */
package com.java.springdemo.dao;

import java.util.List;
import com.java.springdemo.entity.CartItem;

public interface CartItemDAO {

 public void addCartItem(CartItem newCartItem);

public boolean checkIfProductAlreadyInTheCart(int productId, int cartId);

public List<CartItem> getCartItems(int cartId);

public CartItem getCartItemByProductId(int productId, int cartId);

public void saveOrUpdateCartItem(CartItem item);

public void removeCartItem(int productId, int cartId);

}

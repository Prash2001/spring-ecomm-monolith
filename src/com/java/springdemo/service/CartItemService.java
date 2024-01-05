/**
 * The CartItemService interface provides methods for managing cart items.
 */
package com.java.springdemo.service;

import java.util.Map;
import com.java.springdemo.entity.CartItem;

public interface CartItemService {

  public void addCartItem(CartItem newCartItem);

  public boolean checkIfProductAlreadyInTheCart(int productId, int cartId);

  public Map<String, Object> getCartItems(int cartId);

  public CartItem getCartItemByProductId(int productId, int cartId);

  public void saveOrUpdateCartItem(CartItem item);

  public void removeCartItem(int productId, int cartId);

}

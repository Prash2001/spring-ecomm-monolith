/**
 * This class implements the CartItemService interface and provides the implementation for managing cart items.
 * It interacts with the CartItemDAO and ProductService to perform CRUD operations on cart items.
 */
package com.java.springdemo.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.springdemo.dao.CartItemDAO;
import com.java.springdemo.entity.CartItem;
import com.java.springdemo.entity.Product;

@Service
public class CartItemServiceImpl implements CartItemService {
  @Autowired
  private CartItemDAO cartItemDAO;
  @Autowired
  private ProductService productService;

  @Override
  @Transactional
  public void addCartItem(CartItem newCartItem) {
    cartItemDAO.addCartItem(newCartItem);

  }

  @Override
  @Transactional
  public boolean checkIfProductAlreadyInTheCart(int productId, int cartId) {
    return cartItemDAO.checkIfProductAlreadyInTheCart(productId, cartId);
  }

  @Override
  @Transactional
  public Map<String, Object> getCartItems(int cartId) {
    Map<String, Object> resultMap = new HashMap<>();
    List<CartItem> items = cartItemDAO.getCartItems(cartId);
    Set<Integer> productIds = new HashSet<Integer>();
    int totalQuantity = 0;
    int totalPrice = 0;
    Map<Integer, Integer> productMap = new HashMap<>();
    for (CartItem item : items) {
      productIds.add(item.getProduct().getId());
      totalQuantity += item.getQuantity();
      productMap.put(item.getProduct().getId(), item.getQuantity());
    }
    List<Product> products = productService.getProductsByIds(productIds);
    for (Product prod : products) {
      totalPrice += (Integer.valueOf(prod.getPrice() - (prod.getPrice() * Integer.valueOf(prod.getDiscount()) / 100)))
          * productMap.get(prod.getId());
      prod.setQuantity(productMap.get(prod.getId()));
      if (prod.getImageData() != null) {
        String base64Image = java.util.Base64.getEncoder().encodeToString(prod.getImageData());
        prod.setBase64Image(base64Image);
      }
    }
    resultMap.put("totalQuantity", totalQuantity);
    resultMap.put("totalPrice", totalPrice);
    resultMap.put("products", products);

    return resultMap;
  }

  @Override
  @Transactional
  public CartItem getCartItemByProductId(int productId, int cartId) {
    return cartItemDAO.getCartItemByProductId(productId, cartId);
  }

  @Override
  @Transactional
  public void saveOrUpdateCartItem(CartItem item) {

    cartItemDAO.saveOrUpdateCartItem(item);
  }

  @Override
  @Transactional
  public void removeCartItem(int productId, int cartId) {
    cartItemDAO.removeCartItem(productId, cartId);
  }

}

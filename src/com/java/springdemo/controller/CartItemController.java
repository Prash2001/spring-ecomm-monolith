/**
 * Controller class for managing cart items.
 */
package com.java.springdemo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java.springdemo.entity.CartItem;
import com.java.springdemo.service.CartItemService;

@Controller
@RequestMapping("/cartItem")
public class CartItemController {
  @Autowired
  private CartItemService cartItemService;

  @GetMapping("/increaseQuantity")
  public String increaseQuantity(@RequestParam("productId") int productId, @RequestParam("cartId") int cartId,
      Model model, HttpSession session) {
    CartItem item = cartItemService.getCartItemByProductId(productId, cartId);
    item.setQuantity(item.getQuantity() + 1);
    cartItemService.saveOrUpdateCartItem(item);
    return "redirect:/cart/fetchCart";
  }

  @GetMapping("/decreaseQuantity")
  public String decreaseQuantity(@RequestParam("productId") int productId, @RequestParam("cartId") int cartId,
      Model model, HttpSession session) {
    CartItem item = cartItemService.getCartItemByProductId(productId, cartId);
    if ((item.getQuantity() - 1) == 0) {
      cartItemService.removeCartItem(productId, cartId);
    } else {
      item.setQuantity(item.getQuantity() - 1);
      cartItemService.saveOrUpdateCartItem(item);
    }
    return "redirect:/cart/fetchCart";
  }

  @GetMapping("/removeCartItem")
  public String removeCartItem(@RequestParam("productId") int productId, @RequestParam("cartId") int cartId,
      Model model, HttpSession session) {
    cartItemService.removeCartItem(productId, cartId);
    return "redirect:/cart/fetchCart";
  }
}

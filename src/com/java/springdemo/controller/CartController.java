/**
 * Controller class for managing the cart functionality.
 */
package com.java.springdemo.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java.springdemo.entity.Cart;
import com.java.springdemo.entity.CartItem;
import com.java.springdemo.entity.Product;
import com.java.springdemo.entity.User;
import com.java.springdemo.service.CartItemService;
import com.java.springdemo.service.CartService;
import com.java.springdemo.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
  @Autowired
  private CartService cartService;
  @Autowired
  private ProductService productService;
  @Autowired
  private CartItemService cartItemService;

  @GetMapping("/addToCart")
  public String addToCart(@RequestParam("cartItem") int id, Model model, HttpSession session) {
    User cartOwner = (User) session.getAttribute("gandva");
    if (cartOwner == null) {
      return "redirect:/user/login";
    }
    Cart ownerCart = cartService.getUsersCart(cartOwner.getUsername());
    Product newlyAddedProduct = productService.getProductById(id);
    if (checkIfProductAlreadyInTheCart(id, ownerCart.getId())) {
      return "already-in-cart";
    }
    CartItem newCartItem = new CartItem();
    newCartItem.setCart(ownerCart);
    newCartItem.setProduct(newlyAddedProduct);
    newCartItem.setQuantity(1);
    cartItemService.addCartItem(newCartItem);
    return "added-to-cart";
  }

  public boolean checkIfProductAlreadyInTheCart(int productId, int cartId) {
    boolean isExist = cartItemService.checkIfProductAlreadyInTheCart(productId, cartId);
    return isExist;
  }

  @GetMapping("/fetchCart")
  public String fetchCart(Model model, HttpSession session) {
    User cartOwner = (User) session.getAttribute("gandva");
    if (cartOwner == null) {
      return "redirect:/user/login";
    }
    Cart ownerCart = cartService.getUsersCart(cartOwner.getUsername());
    Map<String, Object> mappedItems = cartItemService.getCartItems(ownerCart.getId());

    model.addAttribute("products", (List<Product>) mappedItems.get("products"));
    model.addAttribute("totalQuantity", (Integer) mappedItems.get("totalQuantity"));
    model.addAttribute("totalPrice", (Integer) mappedItems.get("totalPrice"));
    model.addAttribute("cartId", ownerCart.getId());
    return "cart";
  }
}

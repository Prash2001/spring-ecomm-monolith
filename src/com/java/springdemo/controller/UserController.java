/**
 * Controller class for handling user-related operations.
 */
package com.java.springdemo.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java.springdemo.entity.Product;
import com.java.springdemo.entity.User;
import com.java.springdemo.entity.WishList;
import com.java.springdemo.service.ProductService;
import com.java.springdemo.service.UserService;
import com.java.springdemo.service.WishListService;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  private ProductService productService;
  @Autowired
  private UserService userService;
  @Autowired
  private WishListService wishListService;

  @GetMapping("/login")
  public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
    System.out.println("-------->" + user);
    session.setAttribute("section", "All");
    return "login";
  }

  @GetMapping("/showRegistrationForm")
  public String showRegistrationForm(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "user-registration";
  }

  @GetMapping("/validateUser")
  public String validateUser(@RequestParam("txtName") String username,
      @RequestParam("txtPwd") String password, Model model, HttpSession session) {
    User user = userService.getUser(username, getMd5(password));
    if (user == null) {
      return "failure";
    }
    session.setAttribute("gandva", user);
    return "redirect:/product/getProducts?section=All";// ?id="+user.getUsername();
  }

  @PostMapping("/addUser")
  public String addUser(@ModelAttribute("user") User user) {
    user.setPassword(getMd5(user.getPassword()));
    userService.addUser(user);
    return "redirect:/user/login";
  }

  @GetMapping("/myUser") // @RequestParam("user") @Validated String user
  public String myUser(Model model, HttpSession currentSession) {
    User theUser = (User) currentSession.getAttribute("gandva");
    if (theUser == null) {
      return "failure";
    }
    System.out.println(theUser);
    model.addAttribute("user", theUser);
    return "user-details";
  }

  @GetMapping("/addToWishList")
  public String addToWishList(@RequestParam("wishListItem") int id, Model model, HttpSession session) {
    Product product = productService.getProductById(id);
    User us = (User) session.getAttribute("gandva");
    if (us == null) {
      return "redirect:/user/login";
    }
    model.addAttribute("productId", id);
    if (checkIfProductAlreadyExists(us.getUsername(), product.getId())) {
      return "already-exists";
    }
    try {
      us.addProduct(product);
      userService.addUser(us);
    } catch (Exception exc) {
      return "redirect:/user/login";
    }

    return "add-to-wishlist";
  }

  @GetMapping("/addWishListItem")
  public String addWishListItem(Model model, HttpSession session) {
    User myUser = (User) session.getAttribute("gandva");
    if (myUser == null) {
      return "redirect:/user/login";
    }
    List<WishList> items = wishListService.getWishListItems(myUser.getUsername());
    List<Product> myWishListItems = new ArrayList<>();
    for (WishList item : items) {
      myWishListItems.add(productService.getProductById(item.getProductId()));
    }
    model.addAttribute("products", myWishListItems);
    return "my_wish_list";
  }

  @GetMapping("/removeFromWishList")
  public String removeFromWishList(@RequestParam("productId") int productId, Model model, HttpSession session) {
    User user = (User) session.getAttribute("gandva");
    if (user == null) {
      return "redirect:/user/login";
    }
    Product prod = productService.getProductById(productId);
    System.out.println("This is product we are trying to remove " + prod);
    System.out.println("Before this many prods" + user.getProducts().size());
    int i = 0;
    int gotHim = -1;
    for (Product produ : user.getProducts()) {
      if (produ.getId() == productId) {
        gotHim = i;
      }
      i++;
    }
    if (gotHim != -1) {
      user.getProducts().remove(gotHim);
    }
    System.out.println("After this many prods" + user.getProducts().size());
    userService.addUser(user);
    return "redirect:/user/addWishListItem";
  }

  public boolean checkIfProductAlreadyExists(String username, int productId) {
    List<WishList> items = wishListService.getWishListItems(username);
    for (WishList wl : items) {
      if (wl.getProductId() == productId) {
        return true;
      }
    }
    return false;
  }

  public static String getMd5(String input) {
    try {

      // Static getInstance method is called with hashing MD5
      MessageDigest md = MessageDigest.getInstance("MD5");

      // digest() method is called to calculate message digest
      // of an input digest() return array of byte
      byte[] messageDigest = md.digest(input.getBytes());

      // Convert byte array into signum representation
      BigInteger no = new BigInteger(1, messageDigest);

      // Convert message digest into hex value
      String hashtext = no.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    }

    // For specifying wrong message digest algorithms
    catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}

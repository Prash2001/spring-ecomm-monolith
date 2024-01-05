/**
 * Service implementation for managing products.
 */
package com.java.springdemo.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.springdemo.dao.ProductDAO;
import com.java.springdemo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductDAO productDAO;

  @Override
  @Transactional
  public void saveProduct(Product product) {
    productDAO.saveProduct(product);
  }

  @Override
  @Transactional
  public Product getProductById(int id) {
    Product prod = productDAO.getProductById(id);
    if (prod.getImageData() != null) {
      String base64Image = java.util.Base64.getEncoder().encodeToString(prod.getImageData());
      prod.setBase64Image(base64Image);
    }
    return prod;
  }

  @Override
  @Transactional
  public List<Product> getProductsByIds(Set<Integer> items) {
    List<Product> prods = productDAO.getProductsByIds(items);
    for (Product prod : prods) {
      if (prod.getImageData() != null) {
        String base64Image = java.util.Base64.getEncoder().encodeToString(prod.getImageData());
        prod.setBase64Image(base64Image);
      }
    }
    return prods;
  }

  @Override
  @Transactional
  @Async
  public List<Product> getProducts(String section) {
    List<Product> prods = productDAO.getProducts(section);
    for (Product prod : prods) {
      if (prod.getImageData() != null) {
        String base64Image = java.util.Base64.getEncoder().encodeToString(prod.getImageData());
        prod.setBase64Image(base64Image);
      }
    }
    return prods;
  }

  @Override
  @Transactional
  public List<Product> searchProducts(String searchString) {
    List<Product> prods = productDAO.searchProducts(searchString);
    for (Product prod : prods) {
      if (prod.getImageData() != null) {
        String base64Image = java.util.Base64.getEncoder().encodeToString(prod.getImageData());
        prod.setBase64Image(base64Image);
      }
    }
    return prods;
  }

}

/**
 * The ProductService interface provides methods for managing products.
 */
package com.java.springdemo.service;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;
import com.java.springdemo.entity.Product;

@Component
public interface ProductService {
  public void saveProduct(Product product);

  public List<Product> getProductsByIds(Set<Integer> items);

  public Product getProductById(int id);

  public List<Product> getProducts(String section);

  public List<Product> searchProducts(String searchString);
}

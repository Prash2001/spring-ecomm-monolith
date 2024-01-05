/**
 * The ProductDAO interface provides methods for accessing and manipulating product data.
 */
package com.java.springdemo.dao;

import java.util.List;
import java.util.Set;
import com.java.springdemo.entity.Product;

public interface ProductDAO {
  public void saveProduct(Product product);

  public List<Product> getProducts(String section);

  public Product getProductById(int id);

  public List<Product> getProductsByIds(Set<Integer> items);

  public List<Product> searchProducts(String searchString);
}

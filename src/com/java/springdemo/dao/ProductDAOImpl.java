/**
 * This class implements the ProductDAO interface and provides the implementation for
 * interacting with the database to perform CRUD operations on Product entities.
 */
package com.java.springdemo.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.springdemo.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
  @Autowired
  private SessionFactory sessionfactory;

  @Override
  public void saveProduct(Product product) {
    Session currentSession = sessionfactory.getCurrentSession();
    currentSession.saveOrUpdate(product);
  }

  @Override
  public List<Product> getProducts(String section) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<Product> query;
    System.out.println("This is current section " + section);
    if (section.equals("All")) {
      System.out.println("In if part");
      query = currentSession.createQuery("from product", Product.class);

    } else {
      System.out.println("In else part");
      query = currentSession.createQuery("from product where ECOM_Product_Section like:section", Product.class);
      query.setParameter("section", section);
    }
    List<Product> products = query.getResultList();
    return products;
  }

  @Override
  public Product getProductById(int id) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<Product> query = currentSession.createQuery("from product where id like :id", Product.class);
    query.setParameter("id", id);
    Product product = query.getSingleResult();
    return product;
  }

  @Override
  public List<Product> getProductsByIds(Set<Integer> items) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<Product> query = currentSession.createQuery("from product where id IN :ids", Product.class);
    query.setParameter("ids", items);
    List<Product> products = query.getResultList();
    return products;
  }

  @Override
  public List<Product> searchProducts(String searchString) {
    Session currentSession = sessionfactory.getCurrentSession();
    Query<Product> query = currentSession.createQuery(
        "from product where name like:searchString or ECOM_ProductDetails like:searchString or ECOM_Brand like: searchString",
        Product.class);
    query.setParameter("searchString", "%" + searchString + "%");
    List<Product> products = query.getResultList();
    return products;
  }

}

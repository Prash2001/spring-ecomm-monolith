<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.java.springdemo.util.SortUtils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>My WishList</title>
<link rel="icon" href='${pageContext.request.contextPath}/resources/icon/my4.ico'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/home.css'>
<style>
  body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
  }

  .product {
    max-width: 1200px;
    margin: 0 auto;
    padding: 40px 20px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }

  .product-category {
    font-size: 24px;
    font-weight: bold;
    color: #a8b8da; /* Blue */
    text-align: center;
    margin-bottom: 40px;
    width: 100%;
  }

  .product-card {
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.1);
    padding: 20px;
    width: calc(25% - 20px); /* Set 25% width for each product card (minus the margin) */
    margin-bottom: 30px;
    box-sizing: border-box;
    text-align: center;
    position: relative; /* To enable positioning of the button */
    display: flex;
    flex-flow: wrap;
    justify-content: center;
    margin-left:15px;
    margin-right:15px;
  }

  .product-image {
    position: relative;
    height: 230px;
    
  }
.product-image img {
    flex-shrink: 0;
    min-width: 100%;
    min-height: 100%
}
  .discount-tag {
    position: absolute;
    top: 10px;
    right: 10px;
    background-color: #a8b8da; /* Blue */
    color: #ffffff; /* White */
    padding: 4px 10px;
    border-radius: 5px;
    font-size: 12px;
  }

  .product-thumb {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-radius: 8px;
    margin-botton:0;
  }

  .product-info {
    margin-top: 0px;
  }

  .product-brand {
    font-size: 18px;
    font-weight: bold;
    color: #444444; /* Dark Gray */
    margin-bottom: 5px;
  }

  .product-short-des {
    color: #888888; /* Light Gray */
    margin-bottom: 15px;
  }

  .price {
    font-size: 20px;
    font-weight: bold;
    color: #a8b8da; /* Blue */
  }

  .actual-price {
    text-decoration: line-through;
    color: #888888; /* Light Gray */
    margin-left: 8px;
  }

  .add-to-cart-button {
    background-color: #a8b8da; /* Blue */
    color: #ffffff; /* White */
    border: none;
    border-radius: 4px;
    padding: 12px 24px;
    font-size: 16px;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s ease;
    width: 100%;
  }

  .add-to-cart-button:hover {
    background-color: #0056b3; /* Darker Blue on hover */
  }
  .cross{
  position: absolute; 
  top: 10px; 
  right: 0px; 
  cursor:pointer;
  }
</style>
</head>
<body>
  <section class="product">
    <h2 class="product-category" style="padding-right:150px;"><input style="float:left; margin-left:150px;" type="button" value="&#8249;" onclick="window.location.href='${pageContext.request.contextPath}/product/getProducts?section=All'">Wish List</h2>

    <c:forEach var="tempProduct" items="${products}">
      <div class="product-card">
      <i class="fa-regular fa-circle-xmark fa-lg cross" onClick="window.location.href='${pageContext.request.contextPath}/user/removeFromWishList?productId=${tempProduct.id}'"></i>
        <div class="product-image">																												
          <span class="discount-tag">${tempProduct.discount}% off</span>
          <img src="data:image/jpeg;base64, ${tempProduct.base64Image}" class="product-thumb" alt="">
        </div>
        <div class="product-info">
          <h2 class="product-brand">${tempProduct.brand}</h2>
          <p class="product-short-des">${tempProduct.productDetails}</p>
          <span class="price">Rs.${Integer.valueOf(tempProduct.price - tempProduct.price * tempProduct.discount / 100)}</span>
          <span class="actual-price">Rs.${tempProduct.price}</span>
        </div>
        <button class="add-to-cart-button" onclick="window.location.href='${pageContext.request.contextPath}/cart/addToCart?cartItem=${tempProduct.id}'">Add to Cart</button>
      </div>
    </c:forEach>
  </section>
</body>
</html>

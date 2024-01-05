<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="icon" href='${pageContext.request.contextPath}/resources/icon/my4.ico'>
    <script src="${pageContext.request.contextPath}/resources/js/cart.js" defer></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        /* Styles for the navbar */
        .navbar {
            background-blend-mode: lighten;
            color: #fff;
            text-align: center;
            padding: 20px;
            font-family: Arial, sans-serif;
            border-radius: 8px;
        }

        .navbar-text {
            font-size: 24px;
            font-weight: bold;
        }

        /* Rest of the styles (updated) */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: linear-gradient(135deg, #a8b8da 50%, hsl(0, 22%, 96%) 50%);
        }

        .cart-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            width: 100%;
        }

        .product-card {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
            border-bottom: 1px solid #e0e0e0;
            padding-bottom: 10px;
        }

        .product-image {
            position: relative;
            width: 100px;
            height: 100px;
            overflow: hidden;
            border-radius: 8px;
        }

        .discount-tag {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: #a8b8da;
            color: #ffffff;
            padding: 4px 8px;
            border-radius: 5px;
            font-size: 12px;
            font-weight: bold;
        }

        .product-thumb {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .product-info {
            flex: 1;
            padding: 0 20px;
        }

        .product-brand {
            font-size: 18px;
            font-weight: bold;
            color: #333333;
            margin-bottom: 5px;
        }

        .product-short-des {
            color: #666666;
            margin-bottom: 10px;
        }

        .price {
            font-size: 20px;
            font-weight: bold;
            color: #a8b8da;
        }

        .actual-price {
            text-decoration: line-through;
            color: #888888;
            margin-left: 8px;
        }

        .product-actions {
            display: flex;
            align-items: center;
        }

        .quantity {
            font-size: 18px;
            font-weight: bold;
            margin: 0 12px;
            color: #333333;
        }

        .button {
            background-color: #a8b8da;
            border: none;
            color: #ffffff;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-weight: bold;
            margin: 5px;
        }

        .button.remove-from-cart {
            background-color: #a8b8da;
        }

        .total-container {
            display: flex;
            background-blend-mode: lighten;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
            font-size: 20px;
             color: #3c6dd5;
            border-radius: 8px;
            width: 100%;
        }

        .total-label {
            margin-right: 10px;
             color: #3c6dd5;
        }
        
        .total-quantity {
            margin-left: 25px;
             color: #3c6dd5;
             margin-right:10px;
        }

        .back-to-home {
            float: left;
        }
        .inner-total{
            padding: 10px;
        }
    </style>
</head>
<body>
 <div style="display: flex; flex-direction: column; height: 100vh;">
    <!-- Navbar -->
    <div class="navbar">
        <h1 class="navbar-text"><i class="fas fa-arrow-left back-to-home" onclick="window.location.href='${pageContext.request.contextPath}/product/getProducts?section=All';"></i>Your Cart</h1>
        
    </div>

    <!-- Rest of the content -->
    <div class="cart-container">
        <c:forEach var="tempProduct" items="${products}">
            <div class="product-card">
                <div class="product-image">
                    <span class="discount-tag">${tempProduct.discount}% OFF</span>
                    <img src="data:image/jpeg;base64, ${tempProduct.base64Image}" class="product-thumb" alt="">
                </div>
                <div class="product-info">
                    <h2 class="product-brand">${tempProduct.brand}</h2>
                    <p class="product-short-des">${tempProduct.productDetails}</p>
                    <span class="price">Rs. ${Integer.valueOf(tempProduct.price - tempProduct.price * tempProduct.discount / 100)}</span>
                    <span class="actual-price">Rs. ${tempProduct.price}</span>
                </div>
                <div class="product-actions">
                    <button class="button increase-quantity" onClick="increaseQuantity('${pageContext.request.contextPath}',${tempProduct.id},${cartId})">+</button>
                    <span class="quantity">${tempProduct.quantity}</span>
                    <button class="button decrease-quantity" onClick="decreaseQuantity('${pageContext.request.contextPath}',${tempProduct.id},${cartId})">-</button>
                    <button class="button remove-from-cart" onClick="removeCartItem('${pageContext.request.contextPath}',${tempProduct.id},${cartId})">Remove</button>
                </div>
            </div>
        </c:forEach>
</div>
        <!-- Total container -->
        <div class="total-container">
            <div class="inner-total">
                <span class="total-label">Total:</span>
                <span id="totalPrice">Rs. ${totalPrice}</span>
                <span class="total-quantity">Quantity:</span>
                <span id="totalPrice">${totalQuantity}</span>
            </div>
            
        </div>
    </div>
</body>
</html>

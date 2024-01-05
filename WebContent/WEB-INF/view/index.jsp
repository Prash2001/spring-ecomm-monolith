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
<title>Fashion-G - Best Apparels Online Store</title>
    <script src="${pageContext.request.contextPath}/resources/js/index.js" defer></script>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href='${pageContext.request.contextPath}/resources/icon/my4.ico'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/resources/css/home1.css?v=3'>
</head>
<body onload="changeSection('${section}','${pageContext.request.contextPath}')">
	<nav class="navbar">
		<div class="nav">
			<img
				src="${pageContext.request.contextPath}/resources/img/dark-logo (2).png"
				class="brand-logo" alt="">
			<div class="nav-items">
				<div class="search">
					<input type="text" class="search-box"
						placeholder="search brand, product" name="searchString">
					<button class="search-btn" onclick="search('${pageContext.request.contextPath}');">search</button>
				</div>
               <i class="fa-regular fa-heart fa-beat fa-lg wishlist" onClick = "goToWishList('${pageContext.request.contextPath}');")></i>
				<a href="${pageContext.request.contextPath}/cart/fetchCart"><img
					src="${pageContext.request.contextPath}/resources/img/cart.png"
					alt=""></a>
				<a href="${pageContext.request.contextPath}/user/myUser"><img
					src="${pageContext.request.contextPath}/resources/img/user.png"
					alt=""></a>
			</div>
		</div>
		<ul class="links-container">
			<li class="link-item"><a href="getProducts?section=All" class="link">home</a></li>
			<li class="link-item"><a href="getProducts?section=Women" class="link">women</a></li>
			<li class="link-item"><a href="getProducts?section=Men" class="link">men</a></li>
			<li class="link-item"><a href="getProducts?section=Kids" class="link">kids</a></li>
			<li class="link-item"><a href="getProducts?section=Accessories" class="link">accessories</a></li>
		</ul>
	</nav>
	<header class="hero-section" id="mainImg">
		<div class="content"></div>
		<img
			src="${pageContext.request.contextPath}/resources/img/light-logo.png"
			class="logo" alt="">
		<p class="sub-heading">winter is here...</p>
	</header>
	<section class="product">
		<h2 class="product-category">best selling</h2>
		<div class="product-container">
			<c:forEach var="tempProduct" items="${products}">

				<div class="product-card">
					<div class="product-image">
						<span class="discount-tag">${tempProduct.discount}% off</span> <img
							src="data:image/jpeg;base64, ${tempProduct.base64Image}"
							class="product-thumb" alt="">
						<c:url var="myWishList" value="/user/addToWishList">
							<c:param name="wishListItem" value="${tempProduct.id}"></c:param>
						</c:url>
						<button class="card-btn"
							onclick="window.location.href='${myWishList}';">add to
							wishlist</button>
					</div>
					<c:url var="addToCart" value="/cart/addToCart">
							<c:param name="cartItem" value="${tempProduct.id}"></c:param>
						</c:url>
					<button class="add-to-cart-btn"
							onclick="window.location.href='${addToCart}'">Add to
							Cart</button>
					<div class="product-info">
						<h2 class="product-brand">${tempProduct.brand}</h2>
						<p class="product-short-des">${tempProduct.productDetails}</p>
						<span class="price">Rs.${Integer.valueOf(tempProduct.price-tempProduct.price *tempProduct.discount/100)}</span><span
							class="actual-price">Rs.${tempProduct.price}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
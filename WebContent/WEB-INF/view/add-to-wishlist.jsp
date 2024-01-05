<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ page
import="com.java.springdemo.util.SortUtils"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/icon/my4.ico"
    />
    <title>Wish List</title>
    <style>
      body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: rgba(
          0,
          0,
          0,
          0.5
        ); /* Semi-transparent black overlay */
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
      }

      .modal {
        background-color: #fff; /* Set a white background color for the content */
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* Add a subtle box shadow */
        padding: 20px;
        text-align: center;
        max-width: 400px;
      }

      h3 {
        color: #555; /* Set a dark grey color for the heading */
      }

      p {
        color: #777; /* Set a lighter grey color for the paragraph */
      }

      .button {
        padding: 10px 20px;
        border: none;
        cursor: pointer;
        font-size: 16px;
        border-radius: 4px;
        margin: 10px;
      }

      .button-no {
        background-color: #f44336; /* Use a red color for "Go Back" button */
        color: #fff;
      }

      .button-yes {
        background-color: #4caf50; /* Use a green color for "Go to WishList" button */
        color: #fff;
      }

      .close_popup {
        position: absolute;
        top: 0;
        right: 0;
        padding: 10px;
        color: #fff;
        font-size: 20px;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <div class="modal">
      <span class="close_popup"><i class="fas fa-times"></i></span>
      <div class="text-wrapper">
        <h3>Successfully Added To WishList!</h3>
        <p>
          We will pass wishlist attribute in the model and show product details
          here
        </p>
        <button
          class="button button-no"
          onclick="window.location.href='${pageContext.request.contextPath}/product/getProducts?section=All';"
        >
          Go Back
        </button>
        <button
          class="button button-yes"
          onclick="window.location.href='${pageContext.request.contextPath}/user/addWishListItem';"
        >
          Go To WishList
        </button>
      </div>
    </div>
  </body>
</html>

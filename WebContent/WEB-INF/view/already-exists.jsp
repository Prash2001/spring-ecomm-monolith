<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/icon/my4.ico"
    />
    <title>Product Already Exists in Wishlist</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f0f0f0;
      }

      .container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: #ffffff;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 80%;
      }

      h1 {
        font-size: 24px;
        margin-bottom: 20px;
        text-align: center;
      }

      p {
        font-size: 16px;
        text-align: center;
        margin-bottom: 40px;
      }

      .button-container {
        display: flex;
        justify-content: center;
      }

      .button {
        background-color: #4caf50;
        border: none;
        color: white;
        padding: 12px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
        margin-right: 10px;
      }

      .button:hover {
        background-color: #45a049;
      }

      .go-to-wishlist-button {
        background-color: #007bff;
      }

      .go-to-wishlist-button:hover {
        background-color: #0056b3;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Product Already Exists in Wishlist</h1>
      <p>The product you're trying to add already exists in your wishlist.</p>
      <div class="button-container">
        <a href="javascript:history.go(-1)" class="button">Go Back</a>
        <a href="addWishListItem" class="button go-to-wishlist-button"
          >Go to Wishlist</a
        >
      </div>
    </div>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/icon/my4.ico"
    />
    <title>Product Added to Cart</title>
    <style>
      body {
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-image: linear-gradient(135deg, #a8b8da 50%, #f7f2f2 50%);
      }

      .message-container {
        text-align: center;
        background-color: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 80%;
        font-family: Arial, sans-serif;
      }

      h1 {
        font-size: 28px;
        font-weight: bold;
        color: #333333;
        margin-bottom: 20px;
      }

      p {
        font-size: 18px;
        color: #666666;
        margin-bottom: 30px;
      }

      .button-container {
        display: flex;
        justify-content: center;
      }

      .button {
        background-color: #a8b8da;
        border: none;
        color: #ffffff;
        padding: 12px 24px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        font-weight: bold;
        margin: 10px;
        font-family: Arial, sans-serif;
      }

      .button.go-back {
        background-color: #c7acac;
      }

      .button:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <div class="message-container">
      <h1>Product successfully added to cart</h1>
      <p>
        Thank you for choosing our product. It has been successfully added to
        your cart.
      </p>
      <div class="button-container">
        <button class="button" onclick="javascript:history.go(-1)">
          Go Back
        </button>
        <button
          class="button go-back"
          onclick="window.location.href='${pageContext.request.contextPath}/cart/fetchCart';"
        >
          Go to Cart
        </button>
      </div>
    </div>
  </body>
</html>

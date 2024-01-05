<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/icon/my4.ico"
    />
    <title>User Details</title>
    <style>
      body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-image: url("${pageContext.request.contextPath}/resources/img/samu.jpg"); /* Replace with the image URL you obtained */
        background-size: cover;
        background-position: center;
      }

      .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.1);
        position: relative;
      }

      .header {
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        color: #a8b8da; /* Blue */
        margin-bottom: 20px;
      }

      .user-info {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
      }

      .field {
        width: 48%;
        margin-bottom: 20px;
      }

      .field label {
        display: block;
        font-size: 14px;
        font-weight: bold;
        color: #444444; /* Dark Gray */
        margin-bottom: 5px;
      }

      .field span {
        color: #888888; /* Light Gray */
      }

      .go-back-btn {
        display: block;
        margin-top: 20px;
        background-color: #a8b8da; /* Blue */
        color: #ffffff; /* White */
        border: none;
        border-radius: 4px;
        padding: 10px 20px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
      }

      .go-back-btn:hover {
        background-color: #0056b3; /* Darker Blue on hover */
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="header">User Details</div>
      <div class="user-info">
        <div class="field">
          <label>First Name</label>
          <span>${user.firstName}</span>
        </div>
        <div class="field">
          <label>Last Name</label>
          <span>${user.lastName}</span>
        </div>
        <div class="field">
          <label>Email</label>
          <span>${user.email}</span>
        </div>
        <div class="field">
          <label>Contact</label>
          <span>${user.contact}</span>
        </div>
      </div>
      <button class="go-back-btn" onclick="goBack()">Go Back</button>
    </div>

    <script>
      function goBack() {
        window.history.back();
      }
    </script>
  </body>
</html>

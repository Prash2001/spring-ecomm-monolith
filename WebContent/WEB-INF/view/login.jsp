<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/icon/my4.ico"
    />
    <title>Welcome!</title>
    <style>
      body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
      }

      .login-container {
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.1);
        padding: 30px;
        width: 360px;
        max-width: 100%;
        text-align: center;
      }

      .login-header {
        font-size: 28px;
        font-weight: bold;
        margin-bottom: 20px;
        color: #555555; /* Dark Gray */
      }

      .form-group {
        text-align: left;
        margin-bottom: 20px;
      }

      .form-group label {
        display: block;
        font-size: 14px;
        font-weight: bold;
        margin-bottom: 8px;
        color: #444444; /* Slightly Darker Gray */
      }

      .form-group input {
        width: 100%;
        padding: 12px;
        border: 1px solid #cccccc; /* Light Gray */
        border-radius: 4px;
        font-size: 16px;
        box-sizing: border-box;
      }

      .form-group button {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 4px;
        background-color: #007bff; /* Blue */
        color: #ffffff; /* White */
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
      }

      .form-group button:hover {
        background-color: #0056b3; /* Darker Blue on hover */
      }

      .error-message {
        color: #dc3545; /* Red */
        margin-top: 6px;
      }
      .buttons-container {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
      }

      /* Adjust the width of the buttons to evenly distribute space */
      .buttons-container button {
        width: 48%;
        padding: 12px;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
      }

      /* Style the "Login" button */
      .buttons-container button[type="submit"] {
        background-color: #007bff; /* Blue */
        color: #ffffff; /* White */
      }

      /* Style the "Register" button */
      .buttons-container button[type="button"] {
        background-color: #28a745; /* Green */
        color: #ffffff; /* White */
      }

      /* Hover styles for the buttons */
      .buttons-container button:hover {
        opacity: 0.9;
      }
    </style>
  </head>
  <body>
    <div class="login-container">
      <div class="login-header">Welcome Back!</div>
      <form id="login-form" action="validateUser" method="GET">
        <div class="form-group">
          <label for="username">Username</label>
          <input
            type="text"
            id="username"
            name="txtName"
            placeholder="Enter your username"
            required
          />
          <div class="error-message" id="username-error"></div>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input
            type="password"
            id="password"
            name="txtPwd"
            placeholder="Enter your password"
            required
          />
          <div class="error-message" id="password-error"></div>
        </div>
        <div class="buttons-container">
          <button class="form-group" type="submit">Login</button>
          <button
            class="form-group"
            type="button"
            onclick="window.location.href='${pageContext.request.contextPath}/user/showRegistrationForm';"
          >
            Register
          </button>
        </div>
      </form>
    </div>

    <script>
      const form = document.getElementById("login-form");
      const usernameInput = document.getElementById("username");
      const passwordInput = document.getElementById("password");
      const usernameError = document.getElementById("username-error");
      const passwordError = document.getElementById("password-error");

      function validateForm() {
        let isValid = true;
        const usernameValue = usernameInput.value.trim();
        const passwordValue = passwordInput.value.trim();

        if (usernameValue === "") {
          isValid = false;
          usernameError.textContent = "Username is required.";
        } else {
          usernameError.textContent = "";
        }

        if (passwordValue === "") {
          isValid = false;
          passwordError.textContent = "Password is required.";
        } else {
          passwordError.textContent = "";
        }

        return isValid;
      }
    </script>
  </body>
</html>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/icon/my4.ico"
    />
    <title>Login Failed!</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
      }

      .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }

      .login-box {
        padding: 20px;
        border-radius: 5px;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
      }

      h1 {
        color: #d32f2f;
        margin-bottom: 20px;
      }

      a {
        display: inline-block;
        margin-top: 15px;
        padding: 10px 20px;
        background-color: #d32f2f;
        color: #fff;
        text-decoration: none;
        border-radius: 3px;
        transition: background-color 0.3s ease;
      }

      a:hover {
        background-color: #b71c1c;
      }

      .not-found-img {
        max-width: 100%;
        height: auto;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="login-box">
        <img
          class="not-found-img"
          src="${pageContext.request.contextPath}/resources/img/404.png"
          alt="404 Not Found"
        />
        <h1>Login Failed!</h1>
        <p>
          Sorry, your login attempt was unsuccessful. Please check your
          credentials and try again.
        </p>
        <a href="${pageContext.request.contextPath}/user/login">Try Again</a>
      </div>
    </div>
  </body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href='${pageContext.request.contextPath}/resources/icon/my4.ico'>
<title>User Registration Form</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
  }

  .container {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }

  .container h1 {
    text-align: center;
    margin-bottom: 20px;
  }

  table {
    width: 100%;
  }

  table td {
    padding: 10px;
  }

  table td:first-child {
    font-weight: bold;
    width: 150px;
  }

  .input-field {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px; /* Adjust font size for better appearance */
  }

  .submit-btn {
    display: block;
    width: 100%;
    padding: 12px 0;
    background-color: #4CAF50;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px; /* Adjust font size for better appearance */
    font-weight: bold; /* Adjust font weight for better appearance */
  }
 .set-credentials {
    text-align: center;
    font-size: 20px;
    font-weight: bold;
    margin: 20px 0;
  }
  .submit-btn:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>
  <div class="container">
    <h1>User Registration Form</h1>
    <form:form action="addUser" modelAttribute="user">
      <table>
        <tr>
          <td>First Name :</td>
          <td><form:input path="firstName" class="input-field" /></td>
        </tr>

        <tr>
          <td>Last Name :</td>
          <td><form:input path="lastName" class="input-field" /></td>
        </tr>

        <tr>
          <td>Contact :</td>
          <td><form:input path="contact" class="input-field" /></td>
        </tr>

        <tr>
          <td>Email :</td>
          <td><form:input path="email" class="input-field" /></td>
        </tr>
</table>
 <div class="set-credentials">Set User Credentials</div>
<table>
        <tr>
          <td>Username :</td>
          <td><form:input path="username" class="input-field" /></td>
        </tr>

        <tr>
          <td>Password :</td>
          <td><form:input path="password" class="input-field" type="password" /></td>
        </tr>
      </table>
      <input type="submit" value="Submit" class="submit-btn">
    </form:form>
  </div>
</body>
</html>

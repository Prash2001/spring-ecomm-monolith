<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/icon/my4.ico"
    />
    <title>Add Product</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }

      .container {
        width: 80%;
        max-width: 600px;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        display: flex;
        flex-direction: column;
        height: 100vh;
      }

      .container h2 {
        text-align: center;
        margin-bottom: 20px;
      }

      .form-group {
        margin-bottom: 20px;
      }

      label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
      }

      input[type="text"],
      input[type="number"],
      select {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
      }

      .file-input {
        position: relative;
      }

      .file-input input[type="file"] {
        position: absolute;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        opacity: 0;
        cursor: pointer;
      }

      .file-input label {
        display: block;
        padding: 10px;
        background-color: #4caf50;
        color: #fff;
        border: none;
        border-radius: 5px;
        text-align: center;
        cursor: pointer;
      }

      .section-select {
        display: flex;
        justify-content: space-between;
      }

      .section-option {
        flex: 1;
        margin-right: 10px;
      }

      .submit-btn {
        display: block;
        width: 100%;
        padding: 12px 0;
        background-color: #4caf50;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 50px;
        margin-bottom: 50px;
      }

      .submit-btn:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h2>Add Product</h2>
      <form action="insertProduct" method="POST" enctype="multipart/form-data">
        <div class="form-group">
          <label for="productName">Product Name</label>
          <input type="text" id="productName" name="productName" required />
        </div>
        <div class="form-group">
          <label for="productDetails">Product Details</label>
          <input
            type="text"
            id="productDetails"
            name="productDetails"
            required
          />
        </div>
        <div class="form-group">
          <label for="brand">Brand</label>
          <input type="text" id="brand" name="brand" required />
        </div>
        <div class="form-group file-input">
          <label for="uploadImage" id="imageNameDisplay">Upload Image</label>
          <input
            type="file"
            accept=""
            id="uploadImage"
            name="uploadImage"
            onchange="displayImageName(event)"
          />
          <!-- <span class="image-name" id="imageNameDisplay"></span> -->
        </div>
        <div class="form-group">
          <label for="price">Price in Rs.</label>
          <input type="number" id="price" name="price" required />
        </div>
        <div class="form-group">
          <label for="discount">Discount%</label>
          <input type="number" id="discount" name="discount" required />
        </div>
        <div class="form-group">
          <label for="section">Section</label>
          <div class="section-select">
            <div class="section-option">
              <input
                type="radio"
                id="all"
                name="section"
                value="All"
                required
              />
              <label for="all">All</label>
            </div>
            <div class="section-option">
              <input
                type="radio"
                id="men"
                name="section"
                value="Men"
                required
              />
              <label for="men">Men</label>
            </div>
            <div class="section-option">
              <input
                type="radio"
                id="women"
                name="section"
                value="Women"
                required
              />
              <label for="women">Women</label>
            </div>
            <div class="section-option">
              <input
                type="radio"
                id="kids"
                name="section"
                value="Kids"
                required
              />
              <label for="kids">Kids</label>
            </div>
            <div class="section-option">
              <input
                type="radio"
                id="accessories"
                name="section"
                value="Accessories"
                required
              />
              <label for="accessories">Accessories</label>
            </div>
          </div>
        </div>
        <button type="submit" class="submit-btn">Add Product</button>
      </form>
    </div>
  </body>
  <script>
    function displayImageName(event) {
      const fileInput = event.target;
      const imageNameDisplay = document.getElementById("imageNameDisplay");

      if (fileInput.files.length > 0) {
        imageNameDisplay.textContent = fileInput.files[0].name;
      } else {
        imageNameDisplay.textContent = "Upload Image";
      }
    }
  </script>
</html>

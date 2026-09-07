<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.ecommerce.model.Product" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Edit Product</title>

    
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet">

</head>


<body class="bg-light">


<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-warning">

            <h3 class="mb-0">
                Edit Product
            </h3>

        </div>


        <div class="card-body">

            <%
                Product product =
                    (Product) request.getAttribute("product");
            %>


            <form
                action="${pageContext.request.contextPath}/products"
                method="post">


                <!-- ACTION -->

                <input
                    type="hidden"
                    name="action"
                    value="update">


                <!-- PRODUCT ID -->

                <input
                    type="hidden"
                    name="productId"
                    value="<%= product.getProductId() %>">


                <!-- CATEGORY ID -->

                <div class="mb-3">

                    <label class="form-label">
                        Category ID
                    </label>

                    <input
                        type="number"
                        name="categoryId"
                        class="form-control"
                        value="<%= product.getCategoryId() %>"
                        required>

                </div>


                <!-- PRODUCT NAME -->

                <div class="mb-3">

                    <label class="form-label">
                        Product Name
                    </label>

                    <input
                        type="text"
                        name="productName"
                        class="form-control"
                        value="<%= product.getProductName() %>"
                        required>

                </div>


                <!-- DESCRIPTION -->

                <div class="mb-3">

                    <label class="form-label">
                        Description
                    </label>

                    <textarea
                        name="description"
                        class="form-control"
                        rows="4"><%= product.getDescription() %></textarea>

                </div>


                <!-- PRICE -->

                <div class="mb-3">

                    <label class="form-label">
                        Price
                    </label>

                    <input
                        type="number"
                        name="price"
                        class="form-control"
                        step="0.01"
                        value="<%= product.getPrice() %>"
                        required>

                </div>


                <!-- STOCK -->

                <div class="mb-3">

                    <label class="form-label">
                        Stock Quantity
                    </label>

                    <input
                        type="number"
                        name="stockQuantity"
                        class="form-control"
                        value="<%= product.getStockQuantity() %>"
                        required>

                </div>


                <!-- IMAGE URL -->

                <div class="mb-3">

                    <label class="form-label">
                        Image URL
                    </label>

                    <input
                        type="text"
                        name="imageURL"
                        class="form-control"
                        value="<%= product.getImageURL() %>">

                </div>


                <!-- STATUS -->

                <div class="mb-3">

                    <label class="form-label">
                        Status
                    </label>

                    <select
                        name="status"
                        class="form-select">

                        <option
                            value="ACTIVE"
                            <%= "ACTIVE".equalsIgnoreCase(product.getStatus())
                                ? "selected" : "" %>>
                            ACTIVE
                        </option>

                        <option
                            value="INACTIVE"
                            <%= "INACTIVE".equalsIgnoreCase(product.getStatus())
                                ? "selected" : "" %>>
                            INACTIVE
                        </option>

                    </select>

                </div>


                <!-- BUTTONS -->

                <div class="d-flex gap-2">

                    <button
                        type="submit"
                        class="btn btn-success">

                        Update Product

                    </button>


                    <a
                        href="${pageContext.request.contextPath}/products"
                        class="btn btn-secondary">

                        Cancel

                    </a>

                </div>


            </form>

        </div>

    </div>

</div>


</body>

</html>
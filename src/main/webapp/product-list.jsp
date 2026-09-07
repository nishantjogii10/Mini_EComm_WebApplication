<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.model.Product" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Product Management</title>

   
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">


    <!-- HEADER -->
   

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Product Management
        </h1>

        <!-- ADD PRODUCT -->
        <a href="${pageContext.request.contextPath}/add-product.jsp"
           class="btn btn-primary">
            Add Product
        </a>

    </div>


    <%
        List<Product> products =
                (List<Product>) request.getAttribute("products");
    %>


    
    <!-- PRODUCT TABLE -->
    

    <div class="table-responsive">

        <table class="table table-bordered table-striped table-hover">

            <!-- TABLE HEADER -->

            <thead class="table-dark">

                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Stock</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>

            </thead>


            <!-- TABLE BODY -->

            <tbody>

            <%
                if (products != null && !products.isEmpty()) {

                    for (Product product : products) {
            %>

                <tr>

                    <!-- PRODUCT ID -->

                    <td>
                        <%= product.getProductId() %>
                    </td>


                    <!-- PRODUCT NAME -->

                    <td>
                        <%= product.getProductName() %>
                    </td>


                    <!-- PRICE -->

                    <td>
                        ₹ <%= product.getPrice() %>
                    </td>


                    <!-- DESCRIPTION -->

                    <td>
                        <%= product.getDescription() %>
                    </td>


                    <!-- STOCK -->

                    <td>
                        <%= product.getStockQuantity() %>
                    </td>


                    <!-- STATUS -->

                    <td>

                        <%
                            if ("ACTIVE".equalsIgnoreCase(product.getStatus())) {
                        %>

                            <span class="badge bg-success">
                                ACTIVE
                            </span>

                        <%
                            } else {
                        %>

                            <span class="badge bg-danger">
                                <%= product.getStatus() %>
                            </span>

                        <%
                            }
                        %>

                    </td>


                    <!-- ACTION -->

                    <td>

                        <!-- EDIT BUTTON -->

                <a href="${pageContext.request.contextPath}/products?action=edit&id=<%= product.getProductId() %>"
   class="btn btn-warning btn-sm">
    Edit
</a>

                    </td>

                </tr>

            <%
                    }

                } else {
            %>

                <!-- NO PRODUCTS -->

                <tr>

                    <td colspan="7"
                        class="text-center text-danger">

                        No Products Found

                    </td>

                </tr>

            <%
                }
            %>

            </tbody>

        </table>

    </div>

</div>

</body>
</html>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Mini E-Commerce Application</title>

   
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet">

</head>


<body class="bg-light">


<div class="container mt-5">

    <div class="card shadow text-center">

        <div class="card-body p-5">

            <h1 class="mb-3">
                Welcome to Mini E-Commerce
            </h1>

            <h4 class="text-secondary mb-4">
                Java Web App Running Successfully!!
            </h4>


            <!-- PRODUCT LIST BUTTON -->

            <a
                href="${pageContext.request.contextPath}/products"
                class="btn btn-primary">

                View Products

            </a>

        </div>

    </div>

</div>


</body>

</html>
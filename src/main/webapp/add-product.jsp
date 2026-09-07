<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body class="bg-light">
<div class="conatiner mt-5">
<div class="card shadow">
<div class="card-header">
<h3>Add Product</h3>

</div>
<div class="card-body">
<form action="products" method="post">
<input type="hidden" name="action" value="add">
<div class="mb-3">
<label class="form-label">
Category ID
</label>
<input type="number" name="categoryId" class="form-control" required="required">

</div>
<div class="mb-3">
<label class="form-label">
Product Name
</label>
<input type="text" name="productName" class="form-control" required="required">

</div>
<div class="mb-3">
<label class="form-label">
Product Description
</label><br>
<textarea name="description" class="from-control"></textarea>
</div>
<div class="mb-3">
<label class="form-label">
Product Price
</label>
<input type="number"
       name="price"
       step="0.01"
       class="form-control"
       required="required">

</div>
<div class="mb-3">
<label class="form-label">
Stock Quantity
</label>
<input type="number" name="stockQuantity" class="form-control" required="required">

</div>
<div class="mb-3">
<label class="form-label">
Product Status
</label>
<select name="status" class="form-select" required="required">
<option value="ACTIVE">ACTIVE</option>
<option value="INACTIVE">INACTIVE</option>
</select>

</div>

<button type="submit" class="btn btn-primary">Create Product</button>
<button type="reset" class="btn btn-warning">Reset</button>
<a href="products" class="btn btn-danger">
Cancel
</a>
</form>
</div>
</div>
</div>

</body>
</html>
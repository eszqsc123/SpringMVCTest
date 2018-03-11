<!DOCTYPE html>
<html>
    <head>
        <title>Add Product Form</title>
        <style type="text/css">@import url(../../../../../target/product/WEB-INF/css/main.css);</style>
    </head>
    <body>
        <form method="post" action="save-product">
            <h1>Add Product
                <span>Please use this form to enter product details</span>
            </h1>
            <label>
                <span>Product Name: </span>
                <input type="text" name="name" placeholder="Product description"/>
            </label>
            <label>
                <span>Price: </span>
                <input type="text" name="price" step="any" placeholder="Product price in #.## format"/>
            </label>
            <label>
                <span>&nbsp; </span>
                <input type="submit"/>
            </label>
        </form>
    </body>
</html>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Product</title>
        <!--<style type="text/css">@import url(../css/main.css);</style>-->
        <link ref="stylesheet" href="../../../../../target/product/WEB-INF/css/main.css" type="text/css"/>
    </head>
    <body>
        <div id="global">
            <h4>The product has been saved.</h4>
            <p>
                <h5>Detail: </h5>
                Product Name: ${product["name"]}<br/>
                Description: ${product["description"]}<br/>
                Price: $${product["price"]}
            </p>
        </div>
    </body>
</html>
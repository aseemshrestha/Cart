<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
 .error {
     color: red;
     font-weight: bold;
  }
</style>
<div class="container main-container headerOffset">
  <div class="row">
    <div class="breadcrumbDiv col-lg-12">
      <ul class="breadcrumb">
        <li><a href="/secure/home">Back to Home</a></li>
        <li><a href="/secure/addproduct">Add Products</a></li>
        <li><a href="/secure/product-listing">Product Listing</a></li>
        <li><a href="/secure/users">Admin users</a></li>
        <li><a href="/home/logout">Logout</a></li>
        <li><a href="/secure/addNewUser">Add New User</a></li>
      </ul>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-9 col-md-9 col-sm-7">
      <h1 class="section-title-inner">
        <span>Edit / Update Product</span>
      </h1>
      <div class="row userInfo">
        <div class="col-lg-12">
          <p class="required"> <sup>*</sup> Required field</p>
        </div>
        <span style="color:red">${message}</span>
        <form:form method="POST" action="${contextRoot}/secure/addNewProduct" modelAttribute="productForm">
         <form:input type="hidden" path="product_id"/>
          <div class="col-xs-12 col-sm-6">
            <div class="form-group required">
              <label for="ProductName">Product Name<sup>*</sup></label>
              <form:input type="text" class="form-control" id="productName" path="productName" value ="${product.productName}"/>
              <form:errors path="productName"  cssClass="error"/>
            </div>
            
             <div class="form-group required">
              <label for="Category">Category <sup>*</sup></label>
               <form:select class="form-control" path="category">
                  <form:option value="" label="Select"/>
                  <form:option selected="selected" value="${product.category}">${product.category}</form:option>
                  <form:options items="${productCategories}" />
               </form:select>
               <form:errors path="category"  cssClass="error"/>
            </div>
            <div class="form-group required">
              <label for="Product Description">Product Description<sup>*</sup></label>
              <form:input type="text" class="form-control" id="productDescription" path="productDescription" value ="${product.productDescription}"/>
              <form:errors path="productDescription"  cssClass="error"/>
            </div>
            
            <div class="form-group">
              <label for="price"> Price <sup> * </sup></label>
              <form:input type="text" class="form-control" id="price" path="price" value ="${product.price}"/>
              <form:errors path="price"  cssClass="error"/>
            </div>
            <div class="form-group required">
              <label for="quantity"> Quantity<sup>*</sup></label>
              <form:input type="number" path="quantity" class="form-control" id="quantity" value ="${product.quantity}" />
              <form:errors path="quantity"  cssClass="error"/>
            </div>
          </div>
          <div class="col-xs-12 col-md-12">
            <div class="form-group required">
              <label for="image1Loc"> Image Url 1</label>
              <form:input type="text" path="image1Loc" class="form-control" id="image1Loc" value ="${product.image1Loc}" />
              <form:errors path="image1Loc"  cssClass="error"/>
            </div>
            
            <div class="form-group required">
              <label for="image2Loc"> Image Url 2</label>
              <form:input type="text" path="image2Loc" class="form-control" id="image2Loc" value ="${product.image2Loc}" />
            </div>
            
            <div class="form-group required">
              <label for="image3Loc"> Image Url 3</label>
              <form:input type="text" path="image3Loc" class="form-control" id="image3Loc" value ="${product.image3Loc}" />
            </div>
            
            <div class="form-group required">
              <label for="image4Loc"> Image Url 4</label>
              <form:input type="text" path="image4Loc" class="form-control" id="image4Loc" value ="${product.image4Loc}"/>
            </div>
            
            <div class="form-group required">
              <label for="image5Loc"> Image Url 5</label>
              <form:input type="text" path="image5Loc" class="form-control" id="image5Loc" value ="${product.image5Loc}"/>
            </div>
             <div class="form-group required">
              <label for="image1Thumb"> ThumbNail Url 1</label>
              <form:input type="text" path="image1Thumb" class="form-control" id="image1Thumb" value ="${product.image1Thumb}"/>
            </div>
            
            <div class="form-group required">
              <label for="image2Thumb"> ThumbNail Url 2</label>
              <form:input type="text" path="image2Thumb" class="form-control" id="image2Thumb" value ="${product.image2Thumb}" />
            </div>
            
            <div class="form-group required">
              <label for="image3Thumb"> ThumbNail Url 3</label>
              <form:input type="text" path="image3Thumb" class="form-control" id="image3Thumb" value ="${product.image3Thumb}"/>
            </div>
            
            <div class="form-group required">
              <label for="image4Thumb"> ThumbNail Url 4</label>
              <form:input type="text" path="image4Thumb" class="form-control" id="image4Thumb" value ="${product.image4Thumb}"/>
            </div>
            
            <div class="form-group required">
              <label for="image5Thumb"> ThumbNail Url 5</label>
              <form:input type="text" path="image5Thumb" class="form-control" id="image5Thumb" value ="${product.image5Thumb}" />
            </div>
            <div class="form-group required">
              <label for="Category">Status</label>
               <form:select class="form-control" path="status">
                  <form:option value="" label="Select"/>
                   <form:option selected="selected" value="${product.status}">${product.status}</form:option>
                  <form:options items="${productStatus}" />
               </form:select>
               <form:errors path="status"  cssClass="error"/>
            </div>
          </div>
          <div class="col-lg-12">
            <button type="submit" class="btn  btn-primary">Save Product</button>
          </div>
         
        </form:form>
        <div class="col-lg-12 clearfix">
          <ul class="pager">
            <li class="next pull-left"><a href="/secure/home"> &larr;
              Back to Admin Home</a>
            </li>
          </ul>
        </div>
      </div>
      <!--/row end-->
    </div>
    <div class="col-lg-3 col-md-3 col-sm-5"></div>
  </div>
  <!--/row-->
  <div style="clear:both"></div>
</div>
<!-- /main-container -->
<div class="gap"></div>
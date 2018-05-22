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
      <h1 class="section-title-inner"><span><i class="glyphicon glyphicon-user"></i> Update your password</span></h1>
      <div class="row userInfo">
        <span style="color:red">${updated}</span>
        <form:form method="POST" action="${contextRoot}/secure/updatepassnow" modelAttribute="updatePassForm">
          <div class="col-xs-12 col-sm-6">
            <div class="form-group required">
              <label for="InputName">Old Password</label>
              <form:input type="password" class="form-control" path="oldPassword" />
              <form:errors path="oldPassword"  cssClass="error"/>
            </div>
            <div class="form-group">
              <label for="InputEmail">New Password</label>
              <form:input type="password" class="form-control" path="newPassword" />
              <form:errors path="newPassword"  cssClass="error"/>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
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
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
        <li><a href="javascript:void(0)">Add New User</a></li>
      </ul>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-9 col-md-9 col-sm-7">
      <h1 class="section-title-inner">Add New User</h1>
      <div class="row userInfo">
        <span style="color:red">${msg}</span>
        <form:form method="POST" action="${contextRoot}/secure/createNewUser" modelAttribute="createUserForm">
          <div class="col-xs-12 col-sm-6">
            <div class="form-group required">
              <label for="InputName">Name</label>
              <form:input type="text" class="form-control" path="name" />
              <form:errors path=""  cssClass="error"/>
            </div>
            <div class="form-group">
              <label for="InputEmail">Email</label>
              <form:input type="text" class="form-control" path="email" />
              <form:errors path="email"  cssClass="error"/>
            </div>
            <div class="form-group">
              <label for="InputPassword">Password</label>
              <form:input  type="password" class="form-control" path="password" />
              <form:errors path="password"  cssClass="error"/>
            </div>
            <div class="form-group">
              <label>User Role:</label>
              <div class="row">
                <div class="col-xs-6">
                  <form:select class="form-control" path="roles">
                    <form:option value="" label="Select"/>
                    <form:options items="${rolesList}" />
                  </form:select>
                  <form:errors path="roles"  cssClass="error"/>
                </div>
              </div>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
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
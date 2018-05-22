<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
      <h2 class="section-title-inner"><span> Admin User List </span></h2>
       <h2 class="section-title-inner">
        <a href="/secure/addNewUser" style="color:blue;text-decoration: underline">Create New User</a>
      </h2>
      <div class="row userInfo">
        <div style="clear: both"></div>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Name</th>
              <th scope="col">Email</th>
              <th scope="col">Created On</th>
              <th scope="col">Last Seen On</th>
              <th scope="col">IP</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${userList}" var="user" varStatus="loopParent">
              <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.createdOn}</td>
                <td>${user.lastSeenOn}</td>
                <td>${user.ipAddress}</td>
                <td><a href="/secure/deleteuser/${user.id}" class="btn btn-primary"> DELETE </a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div style="clear: both"></div>
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
<div style="clear: both"></div>
<!-- /main-container -->
<div class="gap"></div>
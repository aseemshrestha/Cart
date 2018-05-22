<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container main-container headerOffset">
  <div class="row">
    <div class="breadcrumbDiv col-lg-12">
      <ul class="breadcrumb">
        <li><a href="javascript:void(0)">Secure Admin Area</a></li>
      </ul>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-9 col-md-9 col-sm-7">
      <h1 class="section-title-inner">
        <span>Admin Paradise</span>
      </h1>
      <div class="row userInfo">
        <div class="col-xs-12 col-sm-12">
          <h2 class="block-title-2">
            <span>Careful in what you do !.</span>
          </h2>
          <ul class="myAccountList row">
            <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a href="/secure/orders" class="btn btn-block btn-gray">ORDERS</a>
            </li>
            <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a href="/secure/users" class="btn btn-block btn-gray">MANAGE ADMIN USERS</a>
            </li>
            <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a title="My addresses" href="/secure/updatepass" class="btn btn-block btn-gray">UPDATE YOUR PASSWORD</a>
            </li>
            <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a title="Add  address" href="/secure/addproduct" class="btn btn-block btn-gray">ADD PRODUCTS</a>
            </li>
            <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a title="Add  address" href="/secure/product-listing" class="btn btn-block btn-gray">PRODUCT LISTINGS</a>
            </li>
            <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a title="Personal information" href="user-information.html" class="btn btn-block btn-gray">FEEDBACK</a>
            </li>
            <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a title="My wishlists" href="wishlist.html" class="btn btn-block btn-gray">SALES SNAPSHOT</a>
            </li>
             <li class="col-lg-3 col-md-2 col-sm-3 col-xs-4  text-center">
                <a href="/logout" href="wishlist.html" class="btn btn-block btn-gray">LOGOUT</a>
            </li>
          </ul>
          <div class="clear clearfix"></div>
        </div>
      </div>
      <!--/row end-->
    </div>
    <div class="col-lg-3 col-md-3 col-sm-5"></div>
  </div>
  <!--/row-->
  <div style="clear: both"></div>
</div>
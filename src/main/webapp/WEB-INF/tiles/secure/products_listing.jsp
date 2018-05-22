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
  <form role="form" class="logForm ">
     <div class="form-group">
         <label>Search by keyword e.g. product name, product description</label>
         <input type="text" class="form-control" placeholder="search by keyword">
     </div>
    </form>
  <div class="row">
    <div class="col-lg-9 col-md-9 col-sm-7">
      <h1 class="section-title-inner"><span>Products List</span></h1>
      <div class="row userInfo">
        <div class="col-lg-12">
          <h1 id="totalProducts"></h1>
        </div>
        <div class="col-xs-12 col-sm-12">
          <table>
            <tbody id="products-tbody">
             </tbody>
          </table>
        </div>
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
</div>
<!--/.row-->
<div style="clear: both"></div>

<script type ="text/javascript">
var ProductList = ProductList || {};
var totalProducts = $("#totalProducts");
var productsTBody = $("#products-tbody");

ProductList.fetchProduct = function(from, to) {
  $.getJSON('/secure/productslist?from=' + from + "&to=" + to, function(response) {
     totalProducts.text("Total # Of Products: " + response.totalCount);
     console.log(response);
     $.each(response.list, function(i) {
    	 productsTBody.append(
    	  '<tr class="CartProduct"><td style="width: 10%" class="CartProductThumb"><div>'+
    	    '<a href="javascript:void(0)"><img src="'+response.list[i].image1Loc+'" alt="img"></a></div></td>'+
            '<td style="width: 40%"><div class="CartDescription"><h4><a href="javscript:void(0)" id="productName">'+response.list[i].productName +'</a></h4>'+
            '<span class="size">'+response.list[i].productDescription+'</span><div class="price"><span>'+response.list[i].price+'</span></div> </div></td>'+
            '<td style="width: 40%" class="delete"><a title="Delete" href="/secure/delete/products-listing/'+ response.list[i].productId+'">'+
            '<i class="glyphicon glyphicon-trash fa-2x"></i></a></td>'+
            '<td style="width: 40%" class="delete"><a title="Status">'+response.list[i].status+'</a> </td>'+
            '<td style="width: 40%" class="edit"><a title="Edit" href="/secure/edit/products-listing/'+ response.list[i].productId+'"> EDIT</a></td>'+
          '</tr>');
      });
    });	   
 }
 
 ProductList.fetchProduct(0,25);

</script>
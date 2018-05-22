<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="robots" content="index, follow">
    <meta name="description" content="">
    <meta name="keywords" content="tshirts, cactus, bamboo, nepal, organic">
    <meta name="author" content="Cart">
    <title>Cart</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${contextRoot}/assets/bootstrap/css/bootstrap.css" type="text/css">
    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${contextRoot}/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${contextRoot}/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${contextRoot}/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${contextRoot}/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="${contextRoot}/assets/ico/favicon.png">
    <!-- Custom styles for this template -->
    <link href="${contextRoot}/assets/css/style.css" rel="stylesheet">
    <!-- Just for debugging purposes. -->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <!-- include pace script for automatic web page progress bar  -->
    <script>
      paceOptions = {
          elements: true
      };
    </script>
    <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
    <script src="${contextRoot}/assets/js/pace.min.js"></script>
    <script src="${contextRoot}/assets/js/bootstrap.min.js"></script>
    <!-- add theme styles for this template -->
    <link id="pagestyle" rel="stylesheet" type="text/css" href="${contextRoot}/assets/css/skin-1.css">
    <link rel='stylesheet prefetch' href='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
  </head>
  <body>
	
	<tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="content" />
	<tiles:insertAttribute name="footer" />
	

    <!-- include jqueryCycle plugin -->
    <script src="${contextRoot}/assets/js/jquery.cycle2.min.js"></script>
    <!-- include easing plugin -->
    <script src="${contextRoot}/assets/js/jquery.easing.1.3.js"></script>
    <!-- include  parallax plugin -->
    <script type="text/javascript" src="${contextRoot}/assets/js/jquery.parallax-1.1.js"></script>
    <!-- optionally include helper plugins -->
    <script type="text/javascript" src="${contextRoot}/assets/js/helper-plugins/jquery.mousewheel.min.js"></script>
    <!-- include mCustomScrollbar plugin //Custom Scrollbar  -->
    <script type="text/javascript" src="${contextRoot}/assets/js/jquery.mcustomScrollbar.js"></script>
    <!-- include icheck plugin // customized checkboxes and radio buttons   -->
    <script type="text/javascript" src="${contextRoot}/assets/plugins/icheck-1.x/icheck.min.js"></script>
    <!-- include grid.js // for equal Div height  -->
    <script src="${contextRoot}/assets/plugins/jquery-match-height-master/dist/jquery.matchHeight-min.js"></script>
    <script src="${contextRoot}/assets/js/grids.js"></script>
    <!-- include carousel slider plugin  -->
    <script src="${contextRoot}/assets/js/owl.carousel.min.js"></script>
    <!-- jQuery select2 // custom select   -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <!-- include touchspin.js // touch friendly input spinner component   -->
    <script src="${contextRoot}/assets/js/bootstrap.touchspin.js"></script>
    <!-- include custom script for only homepage  -->
    <script src="${contextRoot}/assets/js/home.js"></script>
    <script src="${contextRoot}/assets/js/grids.js"></script>
    <script src="${contextRoot}/assets/js/enquire.min.js"></script>
    <!-- include custom script for site  -->
    <script src="${contextRoot}/assets/js/script.js"></script>
    
  </body>
</html>
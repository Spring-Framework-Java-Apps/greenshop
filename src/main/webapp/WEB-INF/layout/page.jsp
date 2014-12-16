<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Greenshop</title>
<base href='<c:url value="/resources/"/>' />
<link rel="stylesheet" type="text/css" href="ext/jquery/ui/redmond/jquery-ui-1.8.6.css" />
<script type="text/javascript" src="ext/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="ext/jquery/ui/jquery-ui-1.8.6.min.js"></script>


<script type="text/javascript" src="ext/jquery/bxGallery/jquery.bxGallery.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="ext/jquery/fancybox/jquery.fancybox-1.3.4.css" />
<script type="text/javascript" src="ext/jquery/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="ext/960gs/960_24_col.css" />
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>
<body>

<div id="bodyWrapper" class="container_24">


<div id="header" class="grid_24">
  <div id="storeLogo"><a href="http://shadowfax/oscommerce2/index.php"><img src="images/store_logo.png" alt="osCommerce2" title=" osCommerce2 " width="200" height="50" /></a></div>

  <div id="headerShortcuts">
<span class="tdbLink"><a id="tdb1" href="<c:url value="/shoppingCart" />">Cart Contents<c:if test="${!transientBasket.emptyCart}"> (<c:out value="${transientBasket.size}" />)</c:if></a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/checkout/shipping" />">Checkout</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id='tdb3' href='<c:url value="/account"/>'>My Account</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-person"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><sec:authorize access="fullyAuthenticated"><span class="tdbLink"><a id="tdb4" href='<c:url value="/j_spring_security_logout"/>'>Log Off</a></span><script type="text/javascript">$("#tdb4").button().addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></sec:authorize> </div>

<script type="text/javascript">
  $("#headerShortcuts").buttonset();
</script>
</div>

<div class="grid_24 ui-widget infoBoxContainer">
  <div class="ui-widget-header infoBoxHeading">&nbsp;&nbsp;<a href="http://shadowfax" class="headerNavigation">Top</a> &raquo; <a href='<c:url value="/"/>' class='headerNavigation'>Catalog</a>
  <c:forEach items="${categoryTree.breadcrumb}" var="breadcrumb">  &raquo; <a href='<c:url value="/category/${breadcrumb.category.id}"/>' class='headerNavigation'>${breadcrumb.name}</a></c:forEach>
  <c:if test="${! empty product}"> &raquo; <a href='<c:url value="/product/${product.product.id}"/>' class='headerNavigation'>${product.product.model}</a></c:if>
  </div> 
</div>


<div id="bodyContent" class="grid_16 push_4">
<tiles:insertAttribute name="bodyContent" />	
</div> <!-- bodyContent //-->


<div id="columnLeft" class="grid_4 pull_16">
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Categories</div>  
<div class="ui-widget-content infoBoxContents">
<c:forEach items="${categoryTree.categoriesMenuList}" var="categoryTreeNode"> 
<c:forEach begin="0" end="${categoryTreeNode.level}">&nbsp;&nbsp;</c:forEach><a href='<c:url value="/category/${categoryTreeNode.categoryDescription.category.id}"/>'><c:if test="${categoryTreeNode.categoryDescription.category.id == categoryTree.categoryId}"><b></c:if>${categoryTreeNode.categoryDescription.name}<c:if test="${categoryTreeNode.categoryDescription.category.id == categoryTree.categoryId}"></b></c:if><c:if test="${categoryTreeNode.hasChildCategories}">-&gt;</c:if></a>&nbsp;(${categoryTreeNode.numberOfProducts})<br />
</c:forEach>
</div>
</div>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Manufacturers</div>  <div class="ui-widget-content infoBoxContents"><form name="manufacturers" action="../manufacturer/" method="get"><select name="manufacturers_id" onchange="this.form.submit();" size="1" style="width: 100%">
<c:choose>
<c:when test="${manufacturers.manufacturerId == 0}">
	<option value="0" selected="selected">Please Select</option>
</c:when>
<c:otherwise>
	<option value="0">Please Select</option>
</c:otherwise>
</c:choose>
<c:forEach items="${manufacturers.manufacturers}" var="manufacturer">
<c:choose>
<c:when test="${manufacturers.manufacturerId == manufacturer.id}">
	<option value="${manufacturer.id}" selected="selected">${manufacturer.name}</option>
</c:when>
<c:otherwise>
	<option value="${manufacturer.id}">${manufacturer.name}</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select></form></div></div>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Quick Find</div>  <div class="ui-widget-content infoBoxContents" style="text-align: center;">    <form name="quick_find" action="http://shadowfax/oscommerce2/advanced_search_result.php" method="get">    <input type="text" name="keywords" size="10" maxlength="30" style="width: 75%" />&nbsp;<input type="hidden" name="search_in_description" value="1" /><input type="image" src="includes/languages/english/images/buttons/button_quick_find.gif" alt="Quick Find" title=" Quick Find " /><br />Use keywords to find the product you are looking for.<br /><a href="http://shadowfax/oscommerce2/advanced_search.php"><strong>Advanced Search</strong></a>    </form>  </div></div>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading"><a href="http://shadowfax/oscommerce2/products_new.php">What's New?</a></div>  <div class="ui-widget-content infoBoxContents" style="text-align: center;"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=23"><img src="images/gt_interactive/wheel_of_time.gif" alt="The Wheel Of Time" title=" The Wheel Of Time " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=23">The Wheel Of Time</a><br />$99.99</div></div>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Information</div>  <div class="ui-widget-content infoBoxContents">    <a href="http://shadowfax/oscommerce2/shipping.php">Shipping &amp; Returns</a><br />    <a href="http://shadowfax/oscommerce2/privacy.php">Privacy Notice</a><br />    <a href="http://shadowfax/oscommerce2/conditions.php">Conditions of Use</a><br />    <a href="http://shadowfax/oscommerce2/contact_us.php">Contact Us</a>  </div></div></div>


<div id="columnRight" class="grid_4">
<c:choose>
<c:when test="${transientBasket.emptyCart}"> 
  <div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading"><a href="<c:url value="/shoppingCart" />">Shopping Cart</a></div>  <div class="ui-widget-content infoBoxContents">0 items</div></div>
</c:when>
<c:otherwise>
<div class="ui-widget infoBoxContainer">
<div class="ui-widget-header infoBoxHeading"><a href="<c:url value="/shoppingCart" />">Shopping Cart</a></div>
<table border="0" width="100%" cellspacing="0" cellpadding="0" class="ui-widget-content infoBoxContents">
<c:forEach items="${transientBasket.numberOfProducts}" var="product">
<tr>
<td align="right" valign="top">${product.value}&nbsp;x&nbsp;</td>
<td valign="top"><a href="<c:url value="/product/${product.key.productDescription.product.id}" />">${product.key.productDescription.name}</a></td>
</tr>
</c:forEach>
<tr><td colspan="2" style="padding-top: 5px; padding-bottom: 2px;"><img src="images/pixel_black.gif" alt="" width="100%" height="1" /></td>
</tr>
<tr>
<td colspan="2" align="right">$<fmt:formatNumber value="${transientBasket.subTotal}" minFractionDigits="2" maxFractionDigits="2" /></td>
</tr></table></div>
</c:otherwise>
</c:choose>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Bestsellers</div>  <div class="ui-widget-content infoBoxContents"><ol style="margin: 0; padding-left: 25px;"><li><a href="http://shadowfax/oscommerce2/product_info.php?products_id=1">Matrox G200 MMS</a></li></ol></div></div>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading"><a href="http://shadowfax/oscommerce2/specials.php">Specials</a></div>  <div class="ui-widget-content infoBoxContents" style="text-align: center;"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=16"><img src="images/dvd/courage_under_fire.gif" alt="Courage Under Fire" title=" Courage Under Fire " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=16">Courage Under Fire</a><br /><del>$38.99</del><br /><span class="productSpecialPrice">$29.99</span></div></div>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading"><a href="http://shadowfax/oscommerce2/reviews.php">Reviews</a></div>  <div class="ui-widget-content infoBoxContents"><div align="center"><a href="http://shadowfax/oscommerce2/product_reviews_info.php?products_id=19&amp;reviews_id=1"><img src="images/dvd/theres_something_about_mary.gif" alt="There's Something About Mary" title=" There's Something About Mary " width="100" height="80" /></a></div><a href="http://shadowfax/oscommerce2/product_reviews_info.php?products_id=19&amp;reviews_id=1">This has to be one of the funniest movies released for 1999! ..</a><br /><div align="center"><img src="images/stars_5.gif" alt="5 of 5 Stars!" title=" 5 of 5 Stars! " width="59" height="11" /></div></div></div>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Currencies</div>  <div class="ui-widget-content infoBoxContents">    <form name="currencies" action="http://shadowfax/oscommerce2/index.php" method="get">    <select name="currency" onchange="this.form.submit();" style="width: 100%"><option value="USD" selected="selected">U.S. Dollar</option><option value="EUR">Euro</option></select></form>  </div></div></div>



<div class="grid_24 footer">
  <p align="center">Copyright &copy; 2012 <a href="http://shadowfax/oscommerce2/index.php">osCommerce2</a><br />Powered by <a href="http://www.oscommerce.com" target="_blank">osCommerce</a></p>
</div>


<div class="grid_24" style="text-align: center; padding-bottom: 20px;">
  <a href="http://shadowfax/oscommerce2/redirect.php?action=banner&amp;goto=1" target="_blank"><img src="images/banners/oscommerce.gif" alt="osCommerce" title=" osCommerce " width="468" height="50" /></a></div>


<script type="text/javascript">
$('.productListTable tr:nth-child(even)').addClass('alt');
</script>

</div> <!-- bodyWrapper //-->


</body>
</html>

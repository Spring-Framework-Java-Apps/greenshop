<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="contentContainer">
	<h1>${productsByCategory.thisCategory.name}</h1>
</div>
<c:if test="${! empty productsByCategory.childCategories}">
<div class="contentContainer">
	<div class="contentText">
    <table border="0" width="100%" cellspacing="0" cellpadding="2">
	<c:forEach var="category" items="${productsByCategory.childCategories}" varStatus="status">
      	<td align="center" class="smallText" width="33%" valign="top"><a href='<c:url value="/category/${category.category.id}"/>'><img src="images/${category.category.image}" alt="${category.name}" title="${category.name}" width="100" height="57" /><br />${category.name}</a></td>
   	<c:if test="${status.index % 3 == 2}">
	</tr><tr>	
   	</c:if>
	</c:forEach>
    </tr>
    </table>
    <br />
	</div>
</div>
</c:if>
<div class="contentContainer">

<c:if test="${! empty productsByCategory.products}">

<div>
<form name="filter" action='<c:url value="/category/${productsByCategory.thisCategory.category.id}/manufacturer/"/>' method="get">
<p align="right"><strong>Show:</strong>&nbsp;
<input type="hidden" name="sort" value="2a" />
<select name="manufacturer" onchange="this.form.submit()">
<c:choose>
<c:when test="${productsByCategory.manufacturerId == 0}">
	<option value="0" selected="selected">All Manufacturers</option>
</c:when>
<c:otherwise>
	<option value="0">All Manufacturers</option>
</c:otherwise>
</c:choose>
<c:forEach items="${productsByCategory.manufacturers}" var="manufacturer">
<c:choose>
<c:when test="${productsByCategory.manufacturerId == manufacturer.id}">
	<option value="${manufacturer.id}" selected="selected">${manufacturer.name}</option>
</c:when>
<c:otherwise>
	<option value="${manufacturer.id}">${manufacturer.name}</option>
</c:otherwise>
</c:choose>	
</c:forEach>
</select></p>
</form>
</div>

  <div class="contentText">

<div class="ui-widget infoBoxContainer">  
<div class="ui-widget-header ui-corner-top infoBoxHeading">    
<table border="0" width="100%" cellspacing="0" cellpadding="2" class="productListingHeader">      
<tr>        
<td align="center"></td>        
<td><a href="http://shadowfax/oscommerce2/index.php?cPath=3_10&amp;page=1&amp;sort=2d" title="Sort products descendingly by Product Name" class="productListing-heading">Product Name+</a></td>        
<td align="right"><a href="http://shadowfax/oscommerce2/index.php?cPath=3_10&amp;page=1&amp;sort=3a" title="Sort products ascendingly by Price" class="productListing-heading">Price</a></td>        
<td align="center">Buy Now</td>      
</tr>    
</table>  
</div>  
<div class="ui-widget-content ui-corner-bottom productListTable">    
<table border="0" width="100%" cellspacing="0" cellpadding="2" class="productListingData">
<c:forEach items="${productsByCategory.products}" var="product" varStatus="status">
<tr> 	
	<td align="center"><a href='<c:url value="/product/${product.productDescription.product.id}" />'><img
			src="images/${product.productDescription.product.image}"
			alt="${product.productDescription.name}"
			title="${product.productDescription.name}"
			width="100" height="80" /></a></td>
	<td><a href='<c:url value="/product/${product.productDescription.product.id}" />'>${product.productDescription.name}</a></td>
	<td align="right">
		<c:if test="${! product.specialProduct}">
		$${product.productDescription.product.price}
		</c:if>
		<c:if test="${product.specialProduct}">
		<del>$<fmt:formatNumber
				value="${product.productDescription.product.price}"
				minFractionDigits="2" maxFractionDigits="2" /></del>&nbsp;&nbsp;
			<span class="productSpecialPrice">$<fmt:formatNumber
					value="${product.special.newPrice}"
					minFractionDigits="2" maxFractionDigits="2" /></span>
		</c:if>
	</td>
	<td align="center">
		<span class="tdbLink">
			<a id="tdb${status.index + 4}"
			   href="<c:url value="/shoppingCart/add/${product.productDescription.product.id}" />">Buy Now</a>
		</span>
		<script type="text/javascript">$("#tdb${status.index + 4}").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
	</td>
</tr>
</c:forEach>      
</table>  
</div>
</div>
    <br />
    <div>
      <span style="float: right;">Result Pages: &nbsp;<strong>1</strong>&nbsp;</span>

      <span>Displaying <strong>1</strong> to <strong>9</strong> (of <strong>9</strong> products)</span>
    </div>
  </div>

</c:if>

<c:if test="${empty productsByCategory.products}">
  <h2>New Products</h2>

  <div class="contentText">
  <!-- 
    <table border="0" width="100%" cellspacing="0" cellpadding="2"><tr><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=28"><img src="images/samsung/galaxy_tab.gif" alt="Samsung Galaxy Tab" title=" Samsung Galaxy Tab " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=28">Samsung Galaxy Tab</a><br />$749.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=16"><img src="images/dvd/courage_under_fire.gif" alt="Courage Under Fire" title=" Courage Under Fire " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=16">Courage Under Fire</a><br />$29.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=17"><img src="images/dvd/speed.gif" alt="Speed" title=" Speed " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=17">Speed</a><br />$39.99</td></tr><tr><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=18"><img src="images/dvd/speed_2.gif" alt="Speed 2: Cruise Control" title=" Speed 2: Cruise Control " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=18">Speed 2: Cruise Control</a><br />$42.00</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=19"><img src="images/dvd/theres_something_about_mary.gif" alt="There's Something About Mary" title=" There's Something About Mary " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=19">There's Something About Mary</a><br />$49.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=20"><img src="images/dvd/beloved.gif" alt="Beloved" title=" Beloved " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=20">Beloved</a><br />$54.99</td></tr><tr><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=21"><img src="images/sierra/swat_3.gif" alt="SWAT 3: Close Quarters Battle" title=" SWAT 3: Close Quarters Battle " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=21">SWAT 3: Close Quarters Battle</a><br />$79.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=22"><img src="images/gt_interactive/unreal_tournament.gif" alt="Unreal Tournament" title=" Unreal Tournament " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=22">Unreal Tournament</a><br />$89.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=23"><img src="images/gt_interactive/wheel_of_time.gif" alt="The Wheel Of Time" title=" The Wheel Of Time " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=23">The Wheel Of Time</a><br />$99.99</td></tr></table>  
  --> 
   	<table border="0" width="100%" cellspacing="0" cellpadding="2">
	<tr>
   	<c:forEach items="${newProducts}" var="newProduct" varStatus="status">
   		<td width="33%" align="center" valign="top">
   		<a href='<c:url value="/product/${newProduct.productDescription.product.id}" />'>
			<img src='<c:url value="/resources/images/${newProduct.productDescription.product.image}" />'/>
		</a>
			<br/>
			<a href='<c:url value="/product/${newProduct.productDescription.product.id}" />'>
				<c:out value="${newProduct.productDescription.name}"/>
			</a>
			<br/>
			<c:if test="${! newProduct.specialProduct}">
			$<fmt:formatNumber
				value="${newProduct.productDescription.product.price}"
				minFractionDigits="2" maxFractionDigits="2" />
			</c:if>
			<c:if test="${newProduct.specialProduct}">
				<del>$<fmt:formatNumber
						value="${product.productDescription.product.price}"
						minFractionDigits="2" maxFractionDigits="2" /></del>
				<span class="productSpecialPrice">$<fmt:formatNumber
						value="${newProduct.special.newPrice}"
						minFractionDigits="2" maxFractionDigits="2" /></span>
			</c:if>
			<br/>
   		</td>
   		<c:if test="${status.index % 3 == 2}">
   			</tr><tr>	
   		</c:if>
   	</c:forEach>
   	</tr>
	</table>
</div>
</c:if>
</div>

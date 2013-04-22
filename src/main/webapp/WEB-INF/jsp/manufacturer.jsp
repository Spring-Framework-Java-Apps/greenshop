<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="contentContainer">

<h1>${manufacturer.name}</h1>

<c:if test="${! empty products}">
<div class="contentContainer">

<div><form name="filter" action='<c:url value="/manufacturer/${manufacturer.id}/category/"/>' method="get"><p align="right"><strong>Show:</strong>&nbsp;<input type="hidden" name="sort" value="2a" />
<select name="categoryId" onchange="this.form.submit()">
<c:choose>
<c:when test="${products.categoryId==0}">
	<option value="0" selected="selected">All Categories</option>
</c:when>
<c:otherwise>
	<option value="0">All Categories</option>
</c:otherwise>
</c:choose>	
	<c:forEach items="${products.categoriesOfProducts}" var="category">
	<c:choose>
	<c:when test="${products.categoryId==category.category.id}">
		<option value="${category.category.id}" selected="selected">${category.name}</option>
	</c:when>
	<c:otherwise>
		<option value="${category.category.id}">${category.name}</option>
	</c:otherwise>
	</c:choose>	
	</c:forEach>
</select></p>
</form></div>
  <div class="contentText">
	<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header ui-corner-top infoBoxHeading">    <table border="0" width="100%" cellspacing="0" cellpadding="2" class="productListingHeader">      <tr>        <td align="center"></td>        <td><a href="http://shadowfax/oscommerce2/index.php?manufacturers_id=2&amp;page=1&amp;sort=2d" title="Sort products descendingly by Product Name" class="productListing-heading">Product Name+</a></td>        <td align="right"><a href="http://shadowfax/oscommerce2/index.php?manufacturers_id=2&amp;page=1&amp;sort=3a" title="Sort products ascendingly by Price" class="productListing-heading">Price</a></td>        <td align="center">Buy Now</td>      </tr>    </table>  </div>  <div class="ui-widget-content ui-corner-bottom productListTable">    
	<table border="0" width="100%" cellspacing="0" cellpadding="2" class="productListingData">
		  <c:forEach items="${products.products}" var="product" varStatus="status">
		  <tr>        <td align="center"><a href='<c:url value="/product/${product.product.id}" />'><img src="images/${product.product.image}" alt="${product.name}" title=" ${product.name} " width="100" height="80" /></a></td>        <td><a href='<c:url value="/product/${product.product.id}" />'>${product.name}</a></td>        <td align="right">$${product.product.price}</td>        <td align="center"><span class="tdbLink"><a id="tdb${status.index + 4}" href="http://shadowfax/oscommerce2/index.php?manufacturers_id=2&amp;sort=2a&amp;action=buy_now&amp;products_id=${product.product.id}">Buy Now</a></span><script type="text/javascript">$("#tdb${status.index + 4}").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>      </tr>
		  </c:forEach>      
	      
	      </table>  
	     </div></div>
    
    <br />
    <div>
      <span style="float: right;">Result Pages: &nbsp;<strong>1</strong>&nbsp;</span>
      <span>Displaying <strong>1</strong> to <strong>3</strong> (of <strong>3</strong> products)</span>
    </div>
  </div>
</div>
</c:if>
<c:if test="${empty products}">
	<div class="contentText">
	There are no products available for this manufacturer.
	</div>
</c:if>
</div>





<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>What's In My Cart?</h1>
<c:set var="btnIndex" value="4" />
<sec:authorize access="fullyAuthenticated">	
	<c:set var="btnIndex" value="5" />
</sec:authorize>
<c:choose>
<c:when test="${transientBasket.emptyCart}">
<div class="contentContainer">
  <div class="contentText">
    Your Shopping Cart is empty!
    <p align="right"><span class="tdbLink"><a id="tdb${btnIndex}" href="<c:url value="/" />">Continue</a></span><script type="text/javascript">$("#tdb${btnIndex}").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></p>
  </div>
</div>
</c:when>
<c:otherwise>
<form name="cart_quantity" action="<c:url value="/shoppingCart/update/" />" method="post">
<div class="contentContainer">
  <h2>Product(s)</h2>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="0" cellpadding="0">
    <c:forEach items="${transientBasket.transientProducts}" var="product" varStatus="status">
    <c:set var="index"  value="${status.index}"/>
    <tr><td valign="top">
    	<table border="0" cellspacing="2" cellpadding="2">  
    	<tr>    
    		<td align="center"><a href="<c:url value="/product/${product.productDescription.product.id}" />?products_id=1{4}3{3}6"><img src="<c:url value="/resources/images/${product.productDescription.product.image}"/>" alt="${product.productDescription.name}" title="${product.productDescription.name}" width="100" height="80" /></a>
    		</td>    
    		<td valign="top"><a href="<c:url value="/product/${product.productDescription.product.id}" />?products_id=1{4}3{3}6&amp;osCsid=ure5eesi6qocme5pbbc4pvp2g0"><strong>${product.productDescription.name}</strong></a><br />
    			<c:forEach items="${product.productOptionAttributeList}" var="productOptionAttribute">
     			<small><i> - ${productOptionAttribute.productOption.name} ${productOptionAttribute.productOptionValue.name}</i></small><br />
    			</c:forEach>
    			<br />
    			<input type="text" name="cartQuantity[]" value="${transientBasket.numberOfProducts[product]}" size="4" />
    			<input type="hidden" name="productId[]" value="${product.productDescription.product.id}" />
    			<span class="tdbLink"><button id="tdb${status.index+btnIndex}" type="submit">Update</button></span>
    			<script type="text/javascript">$("#tdb${status.index+btnIndex}").button({icons:{primary:"ui-icon-refresh"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>&nbsp;&nbsp;&nbsp;or <a href="<c:url value="/shoppingCart/remove/${product.productDescription.product.id}?${product.parameterForUrl}" />">remove</a>    
    		</td>  
    	</tr></table>
    	</td>        
    	<td align="right" valign="top"><strong>$<fmt:formatNumber value="${product.price}" minFractionDigits="2" maxFractionDigits="2" /></strong></td>      
    </tr> 	
    </c:forEach>
    <!--  
      <tr>        <td valign="top"><table border="0" cellspacing="2" cellpadding="2">  <tr>    <td align="center"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=1{4}3{3}6&amp;osCsid=ure5eesi6qocme5pbbc4pvp2g0"><img src="images/matrox/mg200mms.gif" alt="Matrox G200 MMS" title="Matrox G200 MMS" width="100" height="80" /></a></td>    <td valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=1{4}3{3}6&amp;osCsid=ure5eesi6qocme5pbbc4pvp2g0"><strong>Matrox G200 MMS</strong></a><br /><small><i> - Memory 16 mb</i></small><br /><small><i> - Model Premium</i></small><br /><br /><input type="text" name="cart_quantity[]" value="1" size="4" /><input type="hidden" name="products_id[]" value="1{4}3{3}6" /><span class="tdbLink"><button id="tdb4" type="submit">Update</button></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-refresh"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>&nbsp;&nbsp;&nbsp;or <a href="http://shadowfax/oscommerce2/shopping_cart.php?products_id=1{4}3{3}6&amp;action=remove_product&amp;osCsid=ure5eesi6qocme5pbbc4pvp2g0">remove</a>    </td>  </tr></table></td>        <td align="right" valign="top"><strong>$469.99</strong></td>      </tr>      
      <tr>        <td valign="top"><table border="0" cellspacing="2" cellpadding="2">  <tr>    <td align="center"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=12&amp;osCsid=ure5eesi6qocme5pbbc4pvp2g0"><img src="images/dvd/die_hard_3.gif" alt="Die Hard With A Vengeance" title="Die Hard With A Vengeance" width="100" height="80" /></a></td>    <td valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=12&amp;osCsid=ure5eesi6qocme5pbbc4pvp2g0"><strong>Die Hard With A Vengeance</strong></a><br /><br /><input type="text" name="cart_quantity[]" value="1" size="4" /><input type="hidden" name="products_id[]" value="12" /><span class="tdbLink"><button id="tdb5" type="submit">Update</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-refresh"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>&nbsp;&nbsp;&nbsp;or <a href="http://shadowfax/oscommerce2/shopping_cart.php?products_id=12&amp;action=remove_product&amp;osCsid=ure5eesi6qocme5pbbc4pvp2g0">remove</a>    </td>  </tr></table></td>        <td align="right" valign="top"><strong>$39.99</strong></td>      </tr>
    -->
    </table>
    <p align="right"><strong>Sub-Total: $<fmt:formatNumber value="${transientBasket.subTotal}" minFractionDigits="2" maxFractionDigits="2" /></strong></p>
  </div>

  <div class="buttonSet">
    <span class="buttonAction"><span class="tdbLink"><a id="tdb${index+btnIndex+1}" href="<c:url value="/checkout/shipping" />">Checkout</a></span><script type="text/javascript">$("#tdb${index+btnIndex+1}").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>
  </div>

  <p align="right" style="clear: both; padding: 15px 50px 0 0;">- OR -</p>
  <p align="right"><a href="http://shadowfax/oscommerce2/ext/modules/payment/paypal/express.php?osCsid=ure5eesi6qocme5pbbc4pvp2g0"><img src="https://www.paypal.com/en_US/i/btn/btn_xpressCheckout.gif" border="0" alt="" title="Checkout with PayPal" /></a></p>
</div>

</form>
</c:otherwise>
</c:choose>
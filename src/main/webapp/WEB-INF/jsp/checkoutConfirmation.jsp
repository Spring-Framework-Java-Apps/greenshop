<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<h1>Order Confirmation</h1>

<form:form method="POST">
<div class="contentContainer">
  <h2>Shipping Information</h2>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="1" cellpadding="2">
      <tr>


        <td width="30%" valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
          <tr>
            <td><strong>Delivery Address</strong> <a href="<c:url value="/checkout/shippingAddress" />"><span class="orderEdit">(Edit)</span></a></td>
          </tr>
          <tr>
            <td>${checkout.shippingAddress.formattedAddress}</td>
          </tr>


          <tr>
            <td><strong>Shipping Method</strong> <a href="<c:url value="/checkout/shipping" />"><span class="orderEdit">(Edit)</span></a></td>
          </tr>
          <tr>
            <td>Flat Rate (Best Way)</td>
          </tr>

        </table></td>


        <td width="70%" valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">


          <tr>
            <td colspan="3"><strong>Products</strong> <a href="<c:url value="/shoppingCart" />"><span class="orderEdit">(Edit)</span></a></td>
          </tr>
		  <c:forEach items="${transientBasket.numberOfProducts}" var="product">
          <tr>
            <td align="right" valign="top" width="30">${product.value}&nbsp;x</td>
            <td valign="top">${product.key.productDescription.name}</td>
            <td align="right" valign="top">$<fmt:formatNumber value="${product.key.price * product.value}" minFractionDigits="2" maxFractionDigits="2"/></td>
          </tr>
		  </c:forEach>
        </table></td>
      </tr>
    </table>
  </div>

  <h2>Billing Information</h2>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="1" cellpadding="2">
      <tr>
        <td width="30%" valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
          <tr>
            <td><strong>Billing Address</strong> <a href="<c:url value="/checkout/paymentAddress" />"><span class="orderEdit">(Edit)</span></a></td>
          </tr>
          <tr>
            <td>${checkout.paymentAddress.formattedAddress}</td>
          </tr>
          <tr>
            <td><strong>Payment Method</strong> <a href="<c:url value="/checkout/payment" />"><span class="orderEdit">(Edit)</span></a></td>
          </tr>
          <tr>
            <td>Cash on Delivery</td>
          </tr>
        </table></td>
        <td width="70%" valign="top" align="right"><table border="0" cellspacing="0" cellpadding="2">

              <tr>
                <td align="right" class="main">Sub-Total:</td>
                <td align="right" class="main">$<fmt:formatNumber value="${transientBasket.subTotal}" minFractionDigits="2" maxFractionDigits="2"/></td>
              </tr>              <tr>
                <td align="right" class="main">Flat Rate (Best Way):</td>
                <td align="right" class="main">$5.00</td>
              </tr>              <tr>
                <td align="right" class="main">Total:</td>
                <td align="right" class="main"><strong>$<fmt:formatNumber value="${transientBasket.subTotal+5.0}" minFractionDigits="2" maxFractionDigits="2"/></strong></td>
              </tr>
        </table></td>
      </tr>
    </table>
  </div>


  <div class="contentText">
    <div style="float: left; width: 60%; padding-top: 5px; padding-left: 15%;">
      <div id="coProgressBar" style="height: 5px;"></div>

      <table border="0" width="100%" cellspacing="0" cellpadding="2">
        <tr>
          <td align="center" width="33%" class="checkoutBarFrom"><a href="<c:url value="/checkout/shipping" />" class="checkoutBarFrom">Delivery Information</a></td>
          <td align="center" width="33%" class="checkoutBarFrom"><a href="<c:url value="/checkout/payment" />" class="checkoutBarFrom">Payment Information</a></td>
          <td align="center" width="33%" class="checkoutBarCurrent">Confirmation</td>
        </tr>
      </table>
    </div>

    <div style="float: right;">

	<span class="tdbLink"><button id="tdb5" type="submit">Confirm Order</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-check"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script>
    </div>
  </div>

</div>

<script type="text/javascript">
$('#coProgressBar').progressbar({
  value: 100
});
</script>

</form:form>
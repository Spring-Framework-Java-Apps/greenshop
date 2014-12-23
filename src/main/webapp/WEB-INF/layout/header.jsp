<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div id="header" class="grid_24">
    <div id="storeLogo"><a href="http://shadowfax/oscommerce2/index.php"><img src="images/store_logo.png" alt="osCommerce2" title=" osCommerce2 " width="200" height="50" /></a></div>

    <div id="headerShortcuts">
        <span class="tdbLink"><a id="tdb1" href="<c:url value="/shoppingCart" />">Cart Contents<c:if test="${!transientBasket.emptyCart}"> (<c:out value="${transientBasket.size}" />)</c:if></a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/checkout/shipping" />">Checkout</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id='tdb3' href='<c:url value="/account"/>'>My Account</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-person"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><sec:authorize access="fullyAuthenticated"><span class="tdbLink"><a id="tdb4" href='<c:url value="/j_spring_security_logout"/>'>Log Off</a></span><script type="text/javascript">$("#tdb4").button().addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></sec:authorize> </div>

    <script type="text/javascript">
        $("#headerShortcuts").buttonset();
    </script>
</div>
<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
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
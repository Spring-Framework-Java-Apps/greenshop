<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">
        <a href="<c:url value="/specials"/>">Specials</a>
    </div>
    <div class="ui-widget-content infoBoxContents" style="text-align: center;">
        <a href="<c:url value="/product/${randomSpecialProduct.productDescription.product.id}"/>">
            <img src="images/${randomSpecialProduct.productDescription.product.image}"
                 alt="${randomSpecialProduct.productDescription.name}"
                 title=" ${randomSpecialProduct.productDescription.name} " width="100" height="80" />
        </a>
        <br />
        <a href="<c:url value="/product/${randomSpecialProduct.productDescription.product.id}"/>">
            <c:out value="${randomSpecialProduct.productDescription.name}" />
        </a>
        <br />
        <del>$<fmt:formatNumber value="${randomSpecialProduct.productDescription.product.price}"
                                minFractionDigits="2" maxFractionDigits="2" /></del>
        <br />
        <span class="productSpecialPrice">$<fmt:formatNumber
                value="${randomSpecialProduct.special.newPrice}"
                minFractionDigits="2" maxFractionDigits="2" /></span>
    </div>
</div>

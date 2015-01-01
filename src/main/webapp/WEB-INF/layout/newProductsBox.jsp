<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">
        <a href="<c:url value="/newproducts"/>">What's New?</a>
    </div>
    <div class="ui-widget-content infoBoxContents" style="text-align: center;">
        <a href="<c:url value="/product/${randomNewProduct.productDescription.product.id}"/>">
            <img src="images/${randomNewProduct.productDescription.product.image}"
                 alt="${randomNewProduct.productDescription.name}"
                 title=" ${randomNewProduct.productDescription.name} "
                 width="100" height="80" />
        </a>
        <br />
        <a href="<c:url value="/product/${randomNewProduct.productDescription.product.id}"/>">
            <c:out value="${randomNewProduct.productDescription.name}" />
        </a>
        <br />
        <c:if test="${! randomNewProduct.specialProduct}">
            $<fmt:formatNumber value="${randomNewProduct.productDescription.product.price}"
                               minFractionDigits="2" maxFractionDigits="2" />
        </c:if>
        <c:if test="${randomNewProduct.specialProduct}">
            <del>$<fmt:formatNumber value="${randomNewProduct.productDescription.product.price}"
                                    minFractionDigits="2" maxFractionDigits="2" /></del>
            <br />
        <span class="productSpecialPrice">$<fmt:formatNumber
                value="${randomNewProduct.special.newPrice}"
                minFractionDigits="2" maxFractionDigits="2" /></span>
        </c:if>
    </div>
</div>

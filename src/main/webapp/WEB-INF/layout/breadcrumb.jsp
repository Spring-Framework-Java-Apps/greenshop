<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="grid_24 ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">&nbsp;&nbsp;<a href="http://shadowfax" class="headerNavigation">Top</a> &raquo; <a href='<c:url value="/"/>' class='headerNavigation'>Catalog</a>
        <c:forEach items="${categoryTree.breadcrumb}" var="breadcrumb">  &raquo; <a href='<c:url value="/category/${breadcrumb.category.id}"/>' class='headerNavigation'>${breadcrumb.name}</a></c:forEach>
        <c:if test="${! empty product}"> &raquo; <a href='<c:url value="/product/${product.productDescription.product.id}"/>' class='headerNavigation'>${product.productDescription.product.model}</a></c:if>
        <c:if test="${! empty specialProducts}"> &raquo; <a href='<c:url value="/specials"/>' class='headerNavigation'>Specials</a></c:if>
        <c:if test="${! empty reviews}"> &raquo; <a href='<c:url value="/reviews"/>' class='headerNavigation'>Reviews</a></c:if>
        <c:if test="${! empty reviewDescription}"> &raquo; <a href='<c:url value="/product/reviews/${reviewDescription.review.product.id}"/>' class='headerNavigation'>Reviews</a></c:if>
        <c:if test="${! empty reviewDescriptions}"> &raquo; <a href='<c:url value="/product/reviews/${product.productDescription.product.id}"/>' class='headerNavigation'>Reviews</a></c:if>
        <c:if test="${! empty shoppingCartView}"> &raquo; <a href='<c:url value="/shoppingCart"/>' class='headerNavigation'>Shopping Cart</a></c:if>
    </div>
</div>
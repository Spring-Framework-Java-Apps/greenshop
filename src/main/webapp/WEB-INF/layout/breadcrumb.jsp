<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="grid_24 ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">&nbsp;&nbsp;<a href="http://shadowfax" class="headerNavigation">Top</a> &raquo; <a href='<c:url value="/"/>' class='headerNavigation'>Catalog</a>
        <c:forEach items="${categoryTree.breadcrumb}" var="breadcrumb">  &raquo; <a href='<c:url value="/category/${breadcrumb.category.id}"/>' class='headerNavigation'>${breadcrumb.name}</a></c:forEach>
        <c:if test="${! empty product}"> &raquo; <a href='<c:url value="/product/${product.product.id}"/>' class='headerNavigation'>${product.product.model}</a></c:if>
    </div>
</div>
<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Categories</div>
    <div class="ui-widget-content infoBoxContents">
        <c:forEach items="${categoryTree.categoriesMenuList}" var="categoryTreeNode">
            <c:forEach begin="0" end="${categoryTreeNode.level}">&nbsp;&nbsp;</c:forEach>
            <a href='<c:url value="/category/${categoryTreeNode.categoryDescription.category.id}"/>'>
                <c:if test="${categoryTreeNode.categoryDescription.category.id == categoryTree.categoryId}">
                    <b></c:if>${categoryTreeNode.categoryDescription.name}
                        <c:if test="${categoryTreeNode.categoryDescription.category.id == categoryTree.categoryId}"></b>
                        </c:if>
                    <c:if test="${categoryTreeNode.hasChildCategories}">-&gt;</c:if>
            </a>&nbsp;(${categoryTreeNode.numberOfProducts})<br />
        </c:forEach>
    </div>
</div>
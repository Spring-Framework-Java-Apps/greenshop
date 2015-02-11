<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<c:forEach var="taxClass" items="${taxClasses.content}">
    <c:if test="${taxClass.id == thisTaxClass.id}">
        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/tax_classes.php?page=1&tID=2&action=edit'">
            <td class="dataTableContent">${taxClass.title}</td>
            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
        </tr>
    </c:if>
    <c:if test="${taxClass.id != thisTaxClass.id}">
        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxClasses/${taxClass.id}"/>'">
            <td class="dataTableContent">${taxClass.title}</td>
            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/taxClasses/${taxClass.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
        </tr>
    </c:if>
</c:forEach>
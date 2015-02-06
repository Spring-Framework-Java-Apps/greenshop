<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<c:forEach var="zone" items="${zones.content}">
    <c:if test="${zone.id == thisZone.id}">
        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=102&action=edit'">
            <td class="dataTableContent">${zone.country.name}</td>
            <td class="dataTableContent">${zone.name}</td>
            <td class="dataTableContent" align="center">${zone.code}</td>
            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
        </tr>
    </c:if>
    <c:if test="${zone.id != thisZone.id}">
        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/zones/${zone.id}?page=${zones.number}"/>'">
            <td class="dataTableContent">${zone.country.name}</td>
            <td class="dataTableContent">${zone.name}</td>
            <td class="dataTableContent" align="center">${zone.code}</td>
            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/zones/${zone.id}?page=${zones.number}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
        </tr>
    </c:if>
</c:forEach>
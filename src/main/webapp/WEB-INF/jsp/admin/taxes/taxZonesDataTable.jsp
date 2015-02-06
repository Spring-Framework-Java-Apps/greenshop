<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<c:forEach var="taxZone" items="${taxZones.content}">
    <c:if test="${taxZone.id == thisTaxZone.id}">
        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZone/${taxZone.id}"/>'">
            <td class="dataTableContent"><a href="<c:url value="/admin/taxZone/${taxZone.id}"/>"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;${taxZone.name}</td>
            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
        </tr>
    </c:if>
    <c:if test="${taxZone.id != thisTaxZone.id}">
        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZones/${taxZone.id}?page=${taxZones.number}"/>'">
            <td class="dataTableContent"><a href="<c:url value="/admin/taxZone/${taxZone.id}"/>"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;${taxZone.name}</td>
            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/taxZones/${taxZone.id}?page=${taxZones.number}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
        </tr>
    </c:if>
</c:forEach>
<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<c:forEach var="country" items="${countries.content}">
    <c:if test="${country.id == thisCountry.id}">
        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/countries/${country.id}/edit?page=${countries.number}"/>'">
            <td class="dataTableContent">${country.name}</td>
            <td class="dataTableContent" align="center" width="40">${country.isoCode2}</td>
            <td class="dataTableContent" align="center" width="40">${country.isoCode3}</td>
            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
        </tr>
    </c:if>
    <c:if test="${country.id != thisCountry.id}">
        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/countries/${country.id}?page=${countries.number}"/>'">
            <td class="dataTableContent">${country.name}</td>
            <td class="dataTableContent" align="center" width="40">${country.isoCode2}</td>
            <td class="dataTableContent" align="center" width="40">${country.isoCode3}</td>
            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/countries/${country.id}?page=${countries.number}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
        </tr>
    </c:if>
</c:forEach>
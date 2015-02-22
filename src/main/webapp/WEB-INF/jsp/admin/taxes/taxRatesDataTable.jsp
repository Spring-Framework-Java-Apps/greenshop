<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<c:forEach var="taxRate" items="${taxRates.content}">
    <c:if test="${taxRate.id == thisTaxRate.id}">
        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxRates/${taxRate.id}/edit?page=${taxRates.number}"/>'">
            <td class="dataTableContent">${taxRate.priority}</td>
            <td class="dataTableContent">${taxRate.taxClass.title}</td>
            <td class="dataTableContent">${taxRate.taxZone.name}</td>
            <td class="dataTableContent"><fmt:formatNumber
                    value="${taxRate.taxRate}"
                    minFractionDigits="2" maxFractionDigits="2" />%</td>
            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
        </tr>
    </c:if>
    <c:if test="${taxRate.id != thisTaxRate.id}">
        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxRates/${taxRate.id}?page=${taxRates.number}"/>'">
            <td class="dataTableContent">${taxRate.priority}</td>
            <td class="dataTableContent">${taxRate.taxClass.title}</td>
            <td class="dataTableContent">${taxRate.taxZone.name}</td>
            <td class="dataTableContent"><fmt:formatNumber
                    value="${taxRate.taxRate}"
                    minFractionDigits="2" maxFractionDigits="2" />%</td>
            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/taxRates/${taxRate.id}?page=${taxRates.number}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
        </tr>
    </c:if>
</c:forEach>
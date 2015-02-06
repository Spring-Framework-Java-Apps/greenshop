<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<tr>
    <td class="smallText" valign="top">Displaying <strong>${taxZones.number*20+1}</strong> to <strong>${taxZones.number*20+countries.numberOfElements}</strong> (of <strong>${taxZones.totalElements}</strong> Tax Zones)</td>
    <td class="smallText" align="right">
        <form name="pages" action="<c:url value="/admin/taxZones"/>" method="get"><c:choose>
        <c:when test="${taxZones.hasPreviousPage()}"><a href="<c:url value="/admin/taxZones?page=${taxZones.previousPageable().pageNumber}"/>" class="splitPageLink">&lt;&lt;</a></c:when>
        <c:otherwise>&lt;&lt;</c:otherwise>
    </c:choose>&nbsp;&nbsp;Page <select name="page" onchange="this.form.submit();">
        <c:forEach begin="0" end="${taxZones.totalPages-1}" varStatus="status">
            <c:choose>
                <c:when test="${status.index == taxZones.number}">
                    <option selected="selected" value="${status.index}">${status.index +1}</option>
                </c:when>
                <c:otherwise>
                    <option value="${status.index}">${status.index +1}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select> of ${taxZones.totalPages}&nbsp;&nbsp;<c:choose>
        <c:when test="${taxZones.hasNextPage()}"><a href="<c:url value="/admin/taxZones?page=${taxZones.nextPageable().pageNumber}"/>" class="splitPageLink">&gt;&gt;</a></c:when>
        <c:otherwise>&gt;&gt;</c:otherwise>
    </c:choose></form>
    </td>
</tr>
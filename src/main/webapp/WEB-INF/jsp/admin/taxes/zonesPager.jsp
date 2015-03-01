<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tr>
    <td class="smallText" valign="top">Displaying <strong>${zones.number*20+1}</strong> to <strong>${zones.number*20+zones.numberOfElements}</strong> (of <strong>${zones.totalElements}</strong> zones)</td>
    <td class="smallText" align="right">
        <form name="pages" action="<c:url value="/admin/zones"/>" method="get"><c:choose>
            <c:when test="${zones.hasPrevious()}"><a href="<c:url value="/admin/zones?page=${zones.previousPageable().pageNumber}"/>" class="splitPageLink">&lt;&lt;</a></c:when>
            <c:otherwise>&lt;&lt;</c:otherwise>
        </c:choose>&nbsp;&nbsp;Page <select name="page" onchange="this.form.submit();">
            <c:forEach begin="0" end="${zones.totalPages-1}" varStatus="status">
                <c:choose>
                    <c:when test="${status.index == zones.number}">
                        <option selected="selected" value="${status.index}">${status.index +1}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${status.index}">${status.index +1}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select> of ${zones.totalPages}&nbsp;&nbsp;<c:choose>
            <c:when test="${zones.hasNext()}"><a href="<c:url value="/admin/zones?page=${zones.nextPageable().pageNumber}"/>" class="splitPageLink">&gt;&gt;</a></c:when>
            <c:otherwise>&gt;&gt;</c:otherwise>
        </c:choose></form>
    </td>
</tr>
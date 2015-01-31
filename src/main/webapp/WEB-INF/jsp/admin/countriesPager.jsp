<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<tr>
    <td class="smallText" valign="top">Displaying <strong>${countries.number*20+1}</strong> to <strong>${countries.number*20+countries.numberOfElements}</strong> (of <strong>${countries.totalElements}</strong> countries)</td>
    <td class="smallText" align="right">
        <form name="pages" action="<c:url value="/admin/countries"/>" method="get"><c:choose>
            <c:when test="${countries.hasPreviousPage()}"><a href="<c:url value="/admin/countries?page=${countries.previousPageable().pageNumber}"/>" class="splitPageLink">&lt;&lt;</a></c:when>
            <c:otherwise>&lt;&lt;</c:otherwise>
        </c:choose>&nbsp;&nbsp;Page <select name="page" onchange="this.form.submit();">
            <c:forEach begin="0" end="${countries.totalPages-1}" varStatus="status">
                <c:choose>
                    <c:when test="${status.index == countries.number}">
                        <option selected="selected" value="${status.index}">${status.index +1}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${status.index}">${status.index +1}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select> of ${countries.totalPages}&nbsp;&nbsp;<c:choose>
            <c:when test="${countries.hasNextPage()}"><a href="<c:url value="/admin/countries?page=${countries.nextPageable().pageNumber}"/>" class="splitPageLink">&gt;&gt;</a></c:when>
            <c:otherwise>&gt;&gt;</c:otherwise>
        </c:choose></form>
    </td>
</tr>
<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Zones</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Country</td>
                        <td class="dataTableHeadingContent">Zones</td>
                        <td class="dataTableHeadingContent" align="center">Code</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
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
                        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/zones/${zone.id}"/>'">
                            <td class="dataTableContent">${zone.country.name}</td>
                            <td class="dataTableContent">${zone.name}</td>
                            <td class="dataTableContent" align="center">${zone.code}</td>
                            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/zones/${zone.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                        </tr>
                    </c:if>
                    </c:forEach>
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>${zones.number*20+1}</strong> to <strong>${zones.number*20+zones.numberOfElements}</strong> (of <strong>${zones.totalElements}</strong> zones)</td>
                                <td class="smallText" align="right">
                                    <form name="pages" action="<c:url value="/admin/zones"/>" method="get"><c:choose>
                                        <c:when test="${zones.hasPreviousPage()}"><a href="<c:url value="/admin/zones?page=${zones.previousPageable().pageNumber}"/>" class="splitPageLink">&lt;&lt;</a></c:when>
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
                                        <c:when test="${zones.hasNextPage()}"><a href="<c:url value="/admin/zones?page=${zones.nextPageable().pageNumber}"/>" class="splitPageLink">&gt;&gt;</a></c:when>
                                        <c:otherwise>&gt;&gt;</c:otherwise>
                                    </c:choose></form>
                                </td>
                            </tr>
                            <tr>
                                <td class="smallText" colspan="2" align="right"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/zones.php?page=1&action=new">New Zone</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisZone.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=102&action=edit">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=102&action=delete">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Zones Name:<br />${thisZone.name} (${thisZone.code})</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Country: ${thisZone.country.name}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
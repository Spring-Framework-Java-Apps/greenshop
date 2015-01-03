<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%">
            <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Specials</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Products</td>
                        <td class="dataTableHeadingContent" align="right">Products Price</td>
                        <td class="dataTableHeadingContent" align="right">Status</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <c:forEach var="special" items="${specials}">
                    <c:if test="${special.special.id == thisSpecial.special.id}">
                        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/specials/${special.productDescription.product.id}"/>'">
                    </c:if>
                    <c:if test="${special.special.id != thisSpecial.special.id}">
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/specials/${special.productDescription.product.id}"/>'">
                    </c:if>
                        <td  class="dataTableContent">${special.productDescription.name}</td>
                        <td  class="dataTableContent" align="right">
                            <span class="oldPrice">$<fmt:formatNumber
                                    value="${special.productDescription.product.price}"
                                    minFractionDigits="2" maxFractionDigits="2" /></span>
                            <span class="specialPrice">$<fmt:formatNumber
                                    value="${special.special.newPrice}"
                                    minFractionDigits="2" maxFractionDigits="2" /></span>
                        </td>
                        <td  class="dataTableContent" align="right">
                            <c:if test="${special.special.status}"><img src="resources/admin/images/icon_status_green.gif" border="0" alt="Active" title="Active" width="10" height="10" />&nbsp;&nbsp;<a href="<c:url value="/admin/specials/setInactive/${special.productDescription.product.id}"/>"><img src="resources/admin/images/icon_status_red_light.gif" border="0" alt="Set Inactive" title="Set Inactive" width="10" height="10" /></a></c:if>
                            <c:if test="${!special.special.status}"><a href="<c:url value="/admin/specials/setActive/${special.productDescription.product.id}"/>"><img src="resources/admin/images/icon_status_green_light.gif" border="0" alt="Set Active" title="Set Active" width="10" height="10" /></a>&nbsp;&nbsp;<img src="resources/admin/images/icon_status_red.gif" border="0" alt="Inactive" title="Inactive" width="10" height="10" /></c:if>
                        </td>
                        <td class="dataTableContent" align="right">
                            <c:if test="${special.special.id == thisSpecial.special.id}"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" /></c:if>
                            <c:if test="${special.special.id != thisSpecial.special.id}">
                            <a href="<c:url value="/admin/specials/${special.productDescription.product.id}"/>">
                                <img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</c:if>
                        </td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4">
                            <table border="0" width="100%" cellpadding="0" cellspacing="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>5</strong> (of <strong>5</strong> products on special)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                            <tr>
                                <td class="smallText" colspan="2" align="right"><span class="tdbLink"><a id="tdb1" href="http://shadowfax/oscommerce2/admin/specials.php?page=1&action=new&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">New Product</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                </td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisSpecial.productDescription.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://shadowfax/oscommerce2/admin/specials.php?page=1&sID=2&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://shadowfax/oscommerce2/admin/specials.php?page=1&sID=2&action=delete&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisSpecial.productDescription.product.dateAdded}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Last Modified: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisSpecial.productDescription.product.lastModified}" /></td>
                        </tr>
                        <tr>
                            <td align="center" class="infoBoxContent"><br /><img src="resources/images/${thisSpecial.productDescription.product.image}" border="0" alt="${thisSpecial.productDescription.name}" title="${thisSpecial.productDescription.name}" width="100" height="80" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Original Price: $<fmt:formatNumber
                                    value="${thisSpecial.productDescription.product.price}"
                                    minFractionDigits="2" maxFractionDigits="2" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">New Price: $<fmt:formatNumber
                                    value="${thisSpecial.special.newPrice}"
                                    minFractionDigits="2" maxFractionDigits="2" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Percentage: ${thisSpecial.percentage}%</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Expires At: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisSpecial.special.expires}" /><strong></strong></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Status Change: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisSpecial.special.statusChanged}" /></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        </td>
    </tr>
</table>
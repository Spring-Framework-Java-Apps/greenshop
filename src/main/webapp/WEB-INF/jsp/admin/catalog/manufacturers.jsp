<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Manufacturers</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Manufacturers</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <c:forEach var="manufacturer" items="${manufacturers}">
                        <c:if test="${manufacturer.id == thisManufacturer.id}">
                            <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/manufacturers/${manufacturer.id}"/>'">
                            <td class="dataTableContent">${manufacturer.name}</td>
                            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                        </c:if>
                        <c:if test="${manufacturer.id != thisManufacturer.id}">
                            <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/manufacturers/${manufacturer.id}"/>'">
                            <td class="dataTableContent">${manufacturer.name}</td>
                            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/manufacturers/${manufacturer.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                        </c:if>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="2"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>10</strong> (of <strong>10</strong> manufacturers)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                        </table></td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2" class="smallText"><span class="tdbLink"><a id="tdb1" href="http://shadowfax/oscommerce2/admin/manufacturers.php?page=1&mID=6&action=new&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Insert</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisManufacturer.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://shadowfax/oscommerce2/admin/manufacturers.php?page=1&mID=6&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://shadowfax/oscommerce2/admin/manufacturers.php?page=1&mID=6&action=delete&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisManufacturer.dateAdded}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br /><img src="resources/images/${thisManufacturer.image}" border="0" alt="${thisManufacturer.name}" title="${thisManufacturer.name}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Products: ${productsOfThisManufacturer}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
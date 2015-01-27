<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Tax Zones</td>
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
                            <td class="dataTableHeadingContent">Tax Zones</td>
                            <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                        </tr>
                        <c:forEach var="taxZone" items="${taxZones}">
                        <c:if test="${taxZone.id == thisTaxZone.id}">
                            <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=2&action=list'">
                                <td class="dataTableContent"><a href="<c:url value="/admin/taxZone/${taxZone.id}"/>"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;${taxZone.name}</td>
                                <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                            </tr>
                        </c:if>
                        <c:if test="${taxZone.id != thisTaxZone.id}">
                            <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZones/${taxZone.id}"/>'">
                                <td class="dataTableContent"><a href="<c:url value="/admin/taxZone/${taxZone.id}"/>"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;${taxZone.name}</td>
                                <td class="dataTableContent" align="right"><a href="<c:url value="/admin/taxZones/${taxZone.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                            </tr>
                        </c:if>
                        </c:forEach>
                        <tr>
                            <td colspan="2"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                                <tr>
                                    <td class="smallText">Displaying <strong>1</strong> to <strong>2</strong> (of <strong>2</strong> tax zones)</td>
                                    <td class="smallText" align="right">Page 1 of 1</td>
                                </tr>
                            </table></td>
                        </tr>
                        <tr>
                            <td class="smallText" align="right" colspan="2"><span class="tdbLink"><a id="tdb1" href="<c:url value="/admin/taxZones/insert"/>">Insert</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                    </table>
                </td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisTaxZone.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/taxZones/edit/${thisTaxZone.id}"/>">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="<c:url value="/admin/taxZones/delete/${thisTaxZone.id}"/>">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="<c:url value="/admin/taxZone/${thisTaxZone.id}"/>">Details</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-info"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Number of Zones: ${numberOfZones}</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisTaxZone.dateAdded}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Last Modified: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisTaxZone.lastModified}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Description:<br />${thisTaxZone.description}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
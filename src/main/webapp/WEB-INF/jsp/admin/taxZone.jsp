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
                            <td class="dataTableHeadingContent">Country</td>
                            <td class="dataTableHeadingContent">Zone</td>
                            <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                        </tr>
                        <c:forEach items="${zones}" var="zone">
                            <c:if test="${zone.zone.id == thisZone.zone.id}">
                                <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>'">
                                    <td class="dataTableContent">${zone.zoneCountry.name}</td>
                                    <td class="dataTableContent">${zone.zone.name}</td>
                                    <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                                </tr>
                            </c:if>
                            <c:if test="${zone.zone.id != thisZone.zone.id}">
                                <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>'">
                                    <td class="dataTableContent">${zone.zoneCountry.name}</td>
                                    <td class="dataTableContent">${zone.zone.name}</td>
                                    <td class="dataTableContent" align="right"><a href="<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.zone.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <td colspan="3"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                                <tr>
                                    <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>2</strong> (of <strong>2</strong> countries)</td>
                                    <td class="smallText" align="right">Page 1 of 1</td>
                                </tr>
                            </table></td>
                        </tr>
                        <tr>
                            <td class="smallText" align="right" colspan="3"><span class="tdbLink"><a id="tdb1" href="<c:url value="/admin/taxZones/${thisTaxZone.id}"/>">Back</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="http://shadowfax/oscommerce2/admin/geo_zones.php?zpage=1&zID=2&action=list&spage=1&sID=2&saction=new&osCAdminID=r9ji9b4276mi3itiavgakf9lb5">Insert</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                    </table>
                </td>
                <c:if test="${zones.size() > 0}">
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisZone.zone.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb3" href="http://shadowfax/oscommerce2/admin/geo_zones.php?zpage=1&zID=2&action=list&spage=1&sID=2&saction=edit&osCAdminID=r9ji9b4276mi3itiavgakf9lb5">Edit</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://shadowfax/oscommerce2/admin/geo_zones.php?zpage=1&zID=2&action=list&spage=1&sID=2&saction=delete&osCAdminID=r9ji9b4276mi3itiavgakf9lb5">Delete</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisZone.dateAdded}" /></td>
                        </tr>
                    </table>
                </td>
                </c:if>
            </tr>
        </table></td>
    </tr>
</table>
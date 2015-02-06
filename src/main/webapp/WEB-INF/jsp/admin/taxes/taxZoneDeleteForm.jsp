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
                        <c:forEach items="${zones}" var="zone">
                            <c:if test="${zone.id == thisZone.id}">
                                <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>'">
                                    <td class="dataTableContent">${zone.zoneCountry.name}</td>
                                    <c:choose>
                                        <c:when test="${zone.zone == null}">
                                            <td class="dataTableContent">All Zones</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="dataTableContent"><c:out value="${zone.zone.name}"/></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                                </tr>
                            </c:if>
                            <c:if test="${zone.id != thisZone.id}">
                                <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>'">
                                    <td class="dataTableContent">${zone.zoneCountry.name}</td>
                                    <c:choose>
                                        <c:when test="${zone.zone == null}">
                                            <td class="dataTableContent">All Zones</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="dataTableContent"><c:out value="${zone.zone.name}"/></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td class="dataTableContent" align="right"><a href="<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <td colspan="3"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                                <tr>
                                    <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>5</strong> (of <strong>5</strong> countries)</td>
                                    <td class="smallText" align="right">Page 1 of 1</td>
                                </tr>
                            </table></td>
                        </tr>
                        <tr>
                            <td class="smallText" align="right" colspan="3"></td>
                        </tr>
                    </table>
                </td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Delete Sub Zone</strong></td>
                        </tr>
                    </table>
                    <form:form method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Are you sure you want to delete this sub zone?</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br /><strong>${thisZone.zoneCountry.name}</strong></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Delete</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${thisZone.id}"/>">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
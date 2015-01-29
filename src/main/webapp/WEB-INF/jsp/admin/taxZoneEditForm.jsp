<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<script type="text/javascript"><!--
function resetZoneSelected(theForm) {
    if (theForm.state.value != '') {
        theForm.zone_id.selectedIndex = '0';
        if (theForm.zone_id.options.length > 0) {
            theForm.state.value = '-- Select Above --';
        }
    }
}

function update_zone(theForm) {
    var NumState = theForm.zone_id.options.length;
    var SelectedCountry = "";

    while(NumState > 0) {
        NumState--;
        theForm.zone_id.options[NumState] = null;
    }

    SelectedCountry = theForm.zone_country_id.options[theForm.zone_country_id.selectedIndex].value;

    <c:forEach items="${zoneMap.keySet()}" var="countryId">
    if (SelectedCountry == "${countryId}") {
        theForm.zone_id.options[0] = new Option("All Zones", "");
        <c:forEach items="${zoneMap.get(countryId)}" var="zone" varStatus="status">
        theForm.zone_id.options[${status.index+1}] = new Option("${zone.name}", "${zone.id}");
        </c:forEach> } else
            </c:forEach> {
        theForm.zone_id.options[0] = new Option("All Zones", "");
    }
}
//--></script>

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
                                    <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>3</strong> (of <strong>3</strong> countries)</td>
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
                            <td class="infoBoxHeading"><strong>Edit Sub Zone</strong></td>
                        </tr>
                    </table>
                    <form:form modelattribute="newSubZoneInfo" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Please make any necessary changes</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Country:<br /><select name="zone_country_id" onchange="update_zone(this.form);">
                                    <option value="">All Countries</option>
                                    <c:forEach items="${countries}" var="country">
                                        <c:choose>
                                            <c:when test="${country.id == thisZone.zoneCountry.id}">
                                                <option selected value="${country.id}">${country.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${country.id}">${country.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Zone:<br /><select name="zone_id">
                                    <option value="">All Zones</option>
                                    <c:if test="${not empty zoneMap.get(thisZone.zoneCountry.id)}">
                                    <c:forEach items="${zoneMap.get(thisZone.zoneCountry.id)}" var="zone">
                                        <c:choose>
                                            <c:when test="${zone.id == thisZone.zone.id}">
                                                <option selected value="${zone.id}">${zone.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${zone.id}">${zone.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    </c:if>
                                </select></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Save</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-disk"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${thisZone.id}"/>">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
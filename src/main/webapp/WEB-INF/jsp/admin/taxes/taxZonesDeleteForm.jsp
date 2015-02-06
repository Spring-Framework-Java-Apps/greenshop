<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Tax Zones</td>
                <td class="pageHeading" align="right"><img src="images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
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
                        <c:import url="taxes/taxZonesDataTable.jsp" />
                        <tr>
                            <td colspan="2"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                                <c:import url="taxes/taxZonesPager.jsp" />
                            </table></td>
                        </tr>
                        <tr>
                            <td class="smallText" align="right" colspan="2"></td>
                        </tr>
                    </table>
                </td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Delete Zone</strong></td>
                        </tr>
                    </table>
                    <form:form commandName="thisTaxZone" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Are you sure you want to delete this zone?</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br /><strong>${thisTaxZone.name}</strong></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Delete</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/taxZones/${thisTaxZone.id}?page=${taxZones.number}"/>">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
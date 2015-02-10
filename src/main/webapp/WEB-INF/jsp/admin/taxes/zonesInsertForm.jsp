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
                    <c:import url="taxes/zonesDataTable.jsp" />
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <c:import url="taxes/zonesPager.jsp" />
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>New Zone</strong></td>
                        </tr>
                    </table>
                    <form:form commandName="thisZone" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Please enter the new zone with its related data</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Zones Name:<br /><form:input path="name"/><form:errors path="name"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Zones Code:<br /><form:input path="code"/><form:errors path="code"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Country:<br /><form:select path="country.id" items="${countries}" itemLabel="name" itemValue="id" /><form:errors path="country.id"/></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Save</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-disk"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/zones?page=${zones.number}"/>">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
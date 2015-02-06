<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Countries</td>
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
                        <td class="dataTableHeadingContent" align="center" colspan="2">ISO Codes</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <c:import url="taxes/countriesDataTable.jsp" />
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <c:import url="taxes/countriesPager.jsp" />
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Edit Country</strong></td>
                        </tr>
                    </table>
                    <form:form commandName="thisCountry" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Please make any necessary changes</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Name:<br /><form:input path="name" /><form:errors path="name"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />ISO Code (2):<br /><form:input path="isoCode2" /><form:errors path="isoCode2"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />ISO Code (3):<br /><form:input path="isoCode3" /><form:errors path="isoCode3"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Address Format:<br /><form:select path="addressFormat.id" items="${addressFormats}" itemLabel="id" itemValue="id" /><form:errors path="addressFormat.id"/></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Save</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-disk"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/countries/${thisCountry.id}?page=${countries.number}"/>">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
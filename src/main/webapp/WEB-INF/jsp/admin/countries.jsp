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
                    <c:import url="countriesDataTable.jsp" />
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <c:import url="countriesPager.jsp" />
                            <tr>
                                <td class="smallText" colspan="2" align="right"><span class="tdbLink"><a id="tdb1" href="<c:url value="/admin/countries/insert?page=${countries.number}"/>">New Country</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisCountry.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/countries/${thisCountry.id}/edit?page=${countries.number}"/>">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="<c:url value="/admin/countries/${thisCountry.id}/delete?page=${countries.number}"/>">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Name:<br />${thisCountry.name}</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />ISO Code (2): ${thisCountry.isoCode2}</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />ISO Code (3): ${thisCountry.isoCode3}</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Address Format: ${thisCountry.addressFormat.id}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
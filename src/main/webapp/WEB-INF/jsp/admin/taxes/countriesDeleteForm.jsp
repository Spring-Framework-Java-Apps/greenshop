<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Countries</td>
                <td class="pageHeading" align="right"><img src="images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
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
                            <td class="infoBoxHeading"><strong>Delete Country</strong></td>
                        </tr>
                    </table>
                    <form name="countries" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Are you sure you want to delete this country?</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br /><strong>${thisCountry.name}</strong></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Delete</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/countries/${thisCountry.id}?page=${countries.number}"/>">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
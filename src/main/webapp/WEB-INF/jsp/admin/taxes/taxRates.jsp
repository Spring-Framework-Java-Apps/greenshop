<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Tax Rates</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Priority</td>
                        <td class="dataTableHeadingContent">Tax Class</td>
                        <td class="dataTableHeadingContent">Zone</td>
                        <td class="dataTableHeadingContent">Tax Rate</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <c:import url="taxes/taxRatesDataTable.jsp" />
                    <tr>
                        <td colspan="5"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <c:import url="taxes/taxRatesPager.jsp"/>
                            <tr>
                                <td class="smallText" colspan="5" align="right"><span class="tdbLink"><a id="tdb1" href="<c:url value="/admin/taxRates/insert"/>">New Tax Rate</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisTaxRate.taxClass.title}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/taxRates/${thisTaxRate.id}/edit?page=${taxRates.number}"/>">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="<c:url value="/admin/taxRates/${thisTaxRate.id}/delete?page=${taxRates.number}"/>">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisTaxRate.dateAdded}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Last Modified: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisTaxRate.lastModified}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Description:<br />${thisTaxRate.description}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
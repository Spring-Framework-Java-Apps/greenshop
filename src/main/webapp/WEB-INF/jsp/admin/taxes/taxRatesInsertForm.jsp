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
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>New Tax Rate</strong></td>
                        </tr>
                    </table>
                    <form:form commandName="thisTaxRate" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Please enter the new tax class with its related data</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Tax Class Title:<br /><form:select style="font-size:10px" path="taxClass.id" items="${taxClasses}" itemLabel="title" itemValue="id" /><form:errors path="taxClass.id"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Zone:<br /><form:select style="font-size:10px" path="taxZone.id" items="${taxZones}" itemLabel="name" itemValue="id" /><form:errors path="taxZone.id"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Tax Rate (%):<br /><form:input path="taxRate"/><form:errors path="taxRate"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Description:<br /><form:input path="description"/><form:errors path="description"/></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Tax rates at the same priority are added, others are compounded.<br /><br />Priority:<br /><form:input path="priority"/><form:errors path="priority"/></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Save</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-disk"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/taxRates?page=${taxRates.number}"/>">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
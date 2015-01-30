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
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>20</strong> (of <strong>239</strong> countries)</td>
                                <td class="smallText" align="right"><form name="pages" action="http://localhost/oscommerce2/admin/countries.php" method="get">&lt;&lt;&nbsp;&nbsp;Page <select name="page" onchange="this.form.submit();"><option value="1" selected="selected">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select> of 12&nbsp;&nbsp;<a href="http://localhost/oscommerce2/admin/countries.php?page=2" class="splitPageLink">&gt;&gt;</a></form></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>New Country</strong></td>
                        </tr>
                    </table>
                    <form:form commandName="thisCountry" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Please enter the new country with its related data</td>
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
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Save</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-disk"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="<c:url value="/admin/countries"/> ">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
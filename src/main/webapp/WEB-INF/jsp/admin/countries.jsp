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
                    <c:forEach var="country" items="${countries}">
                    <c:if test="${country.id == thisCountry.id}">
                        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/countries.php?page=1&cID=1&action=edit'">
                            <td class="dataTableContent">${country.name}</td>
                            <td class="dataTableContent" align="center" width="40">${country.isoCode2}</td>
                            <td class="dataTableContent" align="center" width="40">${country.isoCode3}</td>
                            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                        </tr>
                    </c:if>
                    <c:if test="${country.id != thisCountry.id}">
                        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/countries/${country.id}"/>'">
                            <td class="dataTableContent">${country.name}</td>
                            <td class="dataTableContent" align="center" width="40">${country.isoCode2}</td>
                            <td class="dataTableContent" align="center" width="40">${country.isoCode3}</td>
                            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/countries/${country.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                        </tr>
                    </c:if>
                    </c:forEach>
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>20</strong> (of <strong>239</strong> countries)</td>
                                <td class="smallText" align="right"><form name="pages" action="http://localhost/oscommerce2/admin/countries.php" method="get">&lt;&lt;&nbsp;&nbsp;Page <select name="page" onchange="this.form.submit();"><option value="1" selected="selected">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select> of 12&nbsp;&nbsp;<a href="http://localhost/oscommerce2/admin/countries.php?page=2" class="splitPageLink">&gt;&gt;</a></form></td>
                            </tr>
                            <tr>
                                <td class="smallText" colspan="2" align="right"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/countries.php?page=1&action=new">New Country</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
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
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/countries.php?page=1&cID=1&action=edit">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/countries.php?page=1&cID=1&action=delete">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
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
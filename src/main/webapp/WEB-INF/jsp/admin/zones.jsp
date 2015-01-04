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
                    <c:forEach var="zone" items="${zones}">
                    <c:if test="${zone.id == thisZone.id}">
                        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=102&action=edit'">
                            <td class="dataTableContent">${zone.country.name}</td>
                            <td class="dataTableContent">${zone.name}</td>
                            <td class="dataTableContent" align="center">${zone.code}</td>
                            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                        </tr>
                    </c:if>
                    <c:if test="${zone.id != thisZone.id}">
                        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/zones/${zone.id}"/>'">
                            <td class="dataTableContent">${zone.country.name}</td>
                            <td class="dataTableContent">${zone.name}</td>
                            <td class="dataTableContent" align="center">${zone.code}</td>
                            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/zones/${zone.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                        </tr>
                    </c:if>
                    </c:forEach>
                    <!--
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=102&action=edit'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">Burgenland</td>
                        <td class="dataTableContent" align="center">BL</td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=99'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">KÃ¤rnten</td>
                        <td class="dataTableContent" align="center">KN</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=99"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=96'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">NiederÃ¶sterreich</td>
                        <td class="dataTableContent" align="center">NO</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=96"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=97'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">OberÃ¶sterreich</td>
                        <td class="dataTableContent" align="center">OO</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=97"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=98'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">Salzburg</td>
                        <td class="dataTableContent" align="center">SB</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=98"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=100'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">Steiermark</td>
                        <td class="dataTableContent" align="center">ST</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=100"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=101'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">Tirol</td>
                        <td class="dataTableContent" align="center">TI</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=101"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=103'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">Voralberg</td>
                        <td class="dataTableContent" align="center">VB</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=103"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=95'">
                        <td class="dataTableContent">Austria</td>
                        <td class="dataTableContent">Wien</td>
                        <td class="dataTableContent" align="center">WI</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=95"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=66'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Alberta</td>
                        <td class="dataTableContent" align="center">AB</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=66"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=67'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">British Columbia</td>
                        <td class="dataTableContent" align="center">BC</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=67"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=68'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Manitoba</td>
                        <td class="dataTableContent" align="center">MB</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=68"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=70'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">New Brunswick</td>
                        <td class="dataTableContent" align="center">NB</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=70"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=69'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Newfoundland</td>
                        <td class="dataTableContent" align="center">NF</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=69"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=72'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Northwest Territories</td>
                        <td class="dataTableContent" align="center">NT</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=72"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=71'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Nova Scotia</td>
                        <td class="dataTableContent" align="center">NS</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=71"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=73'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Nunavut</td>
                        <td class="dataTableContent" align="center">NU</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=73"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=74'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Ontario</td>
                        <td class="dataTableContent" align="center">ON</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=74"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=75'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Prince Edward Island</td>
                        <td class="dataTableContent" align="center">PE</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=75"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/zones.php?page=1&cID=76'">
                        <td class="dataTableContent">Canada</td>
                        <td class="dataTableContent">Quebec</td>
                        <td class="dataTableContent" align="center">QC</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=76"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    -->
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>20</strong> (of <strong>181</strong> zones)</td>
                                <td class="smallText" align="right"><form name="pages" action="http://localhost/oscommerce2/admin/zones.php" method="get">&lt;&lt;&nbsp;&nbsp;Page <select name="page" onchange="this.form.submit();"><option value="1" selected="selected">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option></select> of 10&nbsp;&nbsp;<a href="http://localhost/oscommerce2/admin/zones.php?page=2" class="splitPageLink">&gt;&gt;</a></form></td>
                            </tr>
                            <tr>
                                <td class="smallText" colspan="2" align="right"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/zones.php?page=1&action=new">New Zone</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisZone.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=102&action=edit">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/zones.php?page=1&cID=102&action=delete">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Zones Name:<br />${thisZone.name} (${thisZone.code})</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Country: ${thisZone.country.name}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
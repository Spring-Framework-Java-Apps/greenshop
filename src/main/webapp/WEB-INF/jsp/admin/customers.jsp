<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr><form name="search" action="http://localhost/oscommerce2/admin/customers.php" method="get">            <td class="pageHeading">Customers</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="1" height="40" /></td>
                <td class="smallText" align="right">Search: <input type="text" name="search" /></td>
            </form></tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Last Name</td>
                        <td class="dataTableHeadingContent">First Name</td>
                        <td class="dataTableHeadingContent" align="right">Account Created</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/customers.php?page=1&cID=12&action=edit'">
                        <td class="dataTableContent">dasdsdas</td>
                        <td class="dataTableContent">sdsadsa</td>
                        <td class="dataTableContent" align="right">12/16/2014</td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/customers.php?page=1&cID=21'">
                        <td class="dataTableContent">Test</td>
                        <td class="dataTableContent">Java</td>
                        <td class="dataTableContent" align="right">12/22/2014</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/customers.php?page=1&cID=21"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/customers.php?page=1&cID=28'">
                        <td class="dataTableContent">TEST</td>
                        <td class="dataTableContent">PHP</td>
                        <td class="dataTableContent" align="right">12/23/2014</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/customers.php?page=1&cID=28"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/customers.php?page=1&cID=6'">
                        <td class="dataTableContent">Woehlke</td>
                        <td class="dataTableContent">Thomas</td>
                        <td class="dataTableContent" align="right"></td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/customers.php?page=1&cID=6"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>4</strong> (of <strong>4</strong> customers)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>sdsadsa dasdsdas</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/customers.php?page=1&cID=12&action=edit">Edit</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/customers.php?page=1&cID=12&action=confirm">Delete</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/orders.php?cID=12">Orders</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://localhost/oscommerce2/admin/mail.php?customer=test@test.de">Email</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-mail-closed"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Account Created: 12/16/2014</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Last Modified: </td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Last Logon: </td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Number of Logons: 0</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Country: Germany</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Number of Reviews: 0</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
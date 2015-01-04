<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Orders</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="1" height="40" /></td>
                <td align="right"><table border="0" width="100%" cellspacing="0" cellpadding="0">
                    <tr><form name="orders" action="http://localhost/oscommerce2/admin/orders.php" method="get">                <td class="smallText" align="right">Order ID: <input type="text" name="oID" size="12" /><input type="hidden" name="action" value="edit" /></td>
                    </form></tr>
                    <tr><form name="status" action="http://localhost/oscommerce2/admin/orders.php" method="get">                <td class="smallText" align="right">Status: <select name="status" onchange="this.form.submit();"><option value="" selected="selected">All Orders</option><option value="3">Delivered</option><option value="4">PayPal [Transactions]</option><option value="1">Pending</option><option value="2">Processing</option></select></td>
                    </form></tr>
                </table></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Customers</td>
                        <td class="dataTableHeadingContent" align="right">Order Total</td>
                        <td class="dataTableHeadingContent" align="center">Date Purchased</td>
                        <td class="dataTableHeadingContent" align="right">Status</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=edit'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$139.94</td>
                        <td class="dataTableContent" align="center">12/23/2014 12:19:49</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=9'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=9&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$56003.88</td>
                        <td class="dataTableContent" align="center">12/16/2014 09:56:05</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=9"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=8'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=8&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$1494.95</td>
                        <td class="dataTableContent" align="center">12/16/2014 09:51:44</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=8"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=7'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=7&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$75,95</td>
                        <td class="dataTableContent" align="center">12/16/2014 09:48:48</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=7"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=6'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=6&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$5471,88</td>
                        <td class="dataTableContent" align="center">12/16/2014 09:47:57</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=6"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=5'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=5&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$1855.8500000000001</td>
                        <td class="dataTableContent" align="center">12/16/2014 09:19:44</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=5"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=4'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=4&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$139.94</td>
                        <td class="dataTableContent" align="center">12/16/2014 07:15:18</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=4"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=3'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=3&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWoehlke</td>
                        <td class="dataTableContent" align="right">$164.98</td>
                        <td class="dataTableContent" align="center">12/16/2014 01:27:29</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=3"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=2'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=2&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWÃƒÂ¶hlke</td>
                        <td class="dataTableContent" align="right">$159.94</td>
                        <td class="dataTableContent" align="center">12/15/2014 12:40:21</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=2"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=1'">
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=1&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;ThomasWÃƒÂ¶hlke</td>
                        <td class="dataTableContent" align="right">$544.98</td>
                        <td class="dataTableContent" align="center">12/15/2014 12:30:56</td>
                        <td class="dataTableContent" align="right">Pending</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=1"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="5"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>10</strong> (of <strong>10</strong> orders)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>[10]&nbsp;&nbsp;12/23/2014 12:19:49</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=edit">Edit</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=delete">Delete</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/invoice.php?oID=10" target="_blank">Invoice</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://localhost/oscommerce2/admin/packingslip.php?oID=10" target="_blank">Packing Slip</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Created: 12/23/2014</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Payment Method: TODO paymentMethod</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
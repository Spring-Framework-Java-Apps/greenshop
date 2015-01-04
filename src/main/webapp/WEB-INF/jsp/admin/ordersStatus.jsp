<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Orders Status</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Orders Status</td>
                        <td class="dataTableHeadingContent" align="center">Public Status</td>
                        <td class="dataTableHeadingContent" align="center">Downloads Status</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=1&action=edit'">
                        <td class="dataTableContent"><strong>Pending (default)</strong></td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/cross.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=2'">
                        <td class="dataTableContent">Processing</td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=2"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=3'">
                        <td class="dataTableContent">Delivered</td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=3"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=4'">
                        <td class="dataTableContent">PayPal [Transactions]</td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/cross.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/cross.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=4"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>4</strong> (of <strong>4</strong> orders status)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                            <tr>
                                <td class="smallText" colspan="2" align="right"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/orders_status.php?page=1&action=new">Insert</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Pending</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=1&action=edit">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/orders_status.php?page=1&oID=1&action=delete">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br /><img src="resources/includes/languages/english/images/icon.gif" border="0" alt="English" title="English" />&nbsp;Pending</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
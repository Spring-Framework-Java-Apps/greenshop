<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Best Customer Orders-Total</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="2">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">No.</td>
                        <td class="dataTableHeadingContent">Customers</td>
                        <td class="dataTableHeadingContent" align="right">Total Purchased&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/customers.php?search=Woehlke'">
                        <td class="dataTableContent">01.</td>
                        <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/customers.php?search=Woehlke">Thomas Woehlke</a></td>
                        <td class="dataTableContent" align="right">$66,002.29&nbsp;</td>
                    </tr>
                </table></td>
            </tr>
            <tr>
                <td colspan="3"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr>
                        <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>1</strong> (of <strong>1</strong> customers)</td>
                        <td class="smallText" align="right">Page 1 of 1&nbsp;</td>
                    </tr>
                </table></td>
            </tr>
        </table></td>
    </tr>
</table>
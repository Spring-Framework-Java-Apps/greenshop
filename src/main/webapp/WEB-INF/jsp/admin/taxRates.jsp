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
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/tax_rates.php?page=1&tID=1&action=edit'">
                        <td class="dataTableContent">1</td>
                        <td class="dataTableContent">Taxable Goods</td>
                        <td class="dataTableContent">Florida</td>
                        <td class="dataTableContent">7%</td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="5"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>1</strong> (of <strong>1</strong> tax rates)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                            <tr>
                                <td class="smallText" colspan="5" align="right"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/tax_rates.php?page=1&action=new">New Tax Rate</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Taxable Goods</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/tax_rates.php?page=1&tID=1&action=edit">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/tax_rates.php?page=1&tID=1&action=delete">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: 12/15/2014</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Last Modified: 12/15/2014</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Description:<br />FL TAX 7.0%</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
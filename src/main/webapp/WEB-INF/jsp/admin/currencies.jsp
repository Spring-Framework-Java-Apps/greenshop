<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<script type="text/javascript">
    var currency_select = new Array();
    currency_select["JPY"] = new Array("Japanese Yen", "Â¥", "", ".", ",", "2");
    currency_select["GBP"] = new Array("Pounds Sterling", "Â£", "", ".", ",", "2");
    currency_select["CHF"] = new Array("Swiss Franc", "", "CHF", ",", ".", "2");
    currency_select["AUD"] = new Array("Australian Dollar", "$", "", ".", ",", "2");
    currency_select["CAD"] = new Array("Canadian Dollar", "$", "", ".", ",", "2");
    currency_select["SEK"] = new Array("Swedish Krona", "", "kr", ",", ".", "2");
    currency_select["HKD"] = new Array("Hong Kong Dollar", "$", "", ".", ",", "2");
    currency_select["NOK"] = new Array("Norwegian Krone", "kr", "", ",", ".", "2");
    currency_select["NZD"] = new Array("New Zealand Dollar", "$", "", ".", ",", "2");
    currency_select["MXN"] = new Array("Mexican Peso", "$", "", ".", ",", "2");
    currency_select["SGD"] = new Array("Singapore Dollar", "$", "", ".", ",", "2");
    currency_select["BRL"] = new Array("Brazilian Real", "R$", "", ",", ".", "2");
    currency_select["CNY"] = new Array("Chinese RMB", "ï¿¥", "", ".", ",", "2");
    currency_select["CZK"] = new Array("Czech Koruna", "", "KÄ", ",", ".", "2");
    currency_select["DKK"] = new Array("Danish Krone", "", "kr", ",", ".", "2");
    currency_select["HUF"] = new Array("Hungarian Forint", "", "Ft", ".", ",", "2");
    currency_select["ILS"] = new Array("Israeli New Shekel", "â‚ª", "", ".", ",", "2");
    currency_select["INR"] = new Array("Indian Rupee", "Rs.", "", ".", ",", "2");
    currency_select["MYR"] = new Array("Malaysian Ringgit", "RM", "", ".", ",", "2");
    currency_select["PHP"] = new Array("Philippine Peso", "Php", "", ".", ",", "2");
    currency_select["PLN"] = new Array("Polish Zloty", "", "zÅ‚", ",", ".", "2");
    currency_select["THB"] = new Array("Thai Baht", "", "à¸¿", ".", ",", "2");
    currency_select["TWD"] = new Array("Taiwan New Dollar", "NT$", "", ".", ",", "2");

    function updateForm() {
        var cs = document.forms["currencies"].cs[document.forms["currencies"].cs.selectedIndex].value;

        document.forms["currencies"].title.value = currency_select[cs][0];
        document.forms["currencies"].code.value = cs;
        document.forms["currencies"].symbol_left.value = currency_select[cs][1];
        document.forms["currencies"].symbol_right.value = currency_select[cs][2];
        document.forms["currencies"].decimal_point.value = currency_select[cs][3];
        document.forms["currencies"].thousands_point.value = currency_select[cs][4];
        document.forms["currencies"].decimal_places.value = currency_select[cs][5];
        document.forms["currencies"].value.value = 1;
    }
</script>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Currencies</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Currency</td>
                        <td class="dataTableHeadingContent">Code</td>
                        <td class="dataTableHeadingContent" align="right">Value</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/currencies.php?page=1&cID=2&action=edit'">
                        <td class="dataTableContent">Euro</td>
                        <td class="dataTableContent">EUR</td>
                        <td class="dataTableContent" align="right">0.83329999</td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/currencies.php?page=1&cID=1'">
                        <td class="dataTableContent"><strong>U.S. Dollar (default)</strong></td>
                        <td class="dataTableContent">USD</td>
                        <td class="dataTableContent" align="right">1.00000000</td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/currencies.php?page=1&cID=1"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>2</strong> (of <strong>2</strong> currencies)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                            <tr>
                                <td class="smallText"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/currencies.php?page=1&cID=2&action=update">Update Exchange Rate</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-refresh"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                                <td class="smallText" align="right"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/currencies.php?page=1&cID=2&action=new">New Currency</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Euro</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/currencies.php?page=1&cID=2&action=edit">Edit</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://localhost/oscommerce2/admin/currencies.php?page=1&cID=2&action=delete">Delete</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Title: Euro</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Code: EUR</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Symbol Left: </td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Symbol Right: â‚¬</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Decimal Point: .</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Thousands Point: ,</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Decimal Places: 2</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Last Updated: 01/04/2015</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Value: 0.83329999</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Example Output:<br />$30.00 = 25.00â‚¬</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
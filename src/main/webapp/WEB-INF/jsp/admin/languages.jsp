<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Languages</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Language</td>
                        <td class="dataTableHeadingContent">Code</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/languages.php?page=1&lID=1&action=edit'">
                        <td class="dataTableContent"><strong>English (default)</strong></td>
                        <td class="dataTableContent">en</td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="3"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>1</strong> (of <strong>1</strong> languages)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                            <tr>
                                <td class="smallText" align="right" colspan="2"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/languages.php?page=1&lID=1&action=new">New Language</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>English</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/languages.php?page=1&lID=1&action=edit">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/languages.php?page=1&lID=1&action=delete">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://localhost/oscommerce2/admin/define_language.php?lngdir=english">Details</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-info"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Name: English</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Code: en</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br /><img src="resources/includes/languages/english/images/icon.gif" border="0" alt="English" title="English" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Directory:<br />/oscommerce2/includes/languages/<strong>english</strong></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Sort Order: 1</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
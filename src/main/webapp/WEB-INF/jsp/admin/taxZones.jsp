<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Tax Zones</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="dataTableHeadingRow">
                            <td class="dataTableHeadingContent">Tax Zones</td>
                            <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                        </tr>
                        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=1&action=list'">
                            <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=1&action=list"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;Florida</td>
                            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                                <tr>
                                    <td class="smallText">Displaying <strong>1</strong> to <strong>1</strong> (of <strong>1</strong> tax zones)</td>
                                    <td class="smallText" align="right">Page 1 of 1</td>
                                </tr>
                            </table></td>
                        </tr>
                        <tr>
                            <td class="smallText" align="right" colspan="2"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=1&action=new_zone">Insert</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                    </table>
                </td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Florida</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=1&action=edit_zone">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=1&action=delete_zone">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=1&action=list">Details</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-info"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Number of Zones: 1</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: 12/15/2014</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Description:<br />Florida local sales tax zone</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
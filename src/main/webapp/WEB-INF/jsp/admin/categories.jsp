<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Categories / Products</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="1" height="40" /></td>
                <td align="right"><table border="0" width="100%" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="smallText" align="right">
                            <form name="search" action="http://shadowfax/oscommerce2/admin/categories.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1" method="get">Search: <input type="text" name="search" /><input type="hidden" name="osCAdminID" value="i3qmbf2bulfaigi6pvm3i2urp1" /></form>                </td>
                    </tr>
                    <tr>
                        <td class="smallText" align="right">
                            <form name="goto" action="http://shadowfax/oscommerce2/admin/categories.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1" method="get">Go To: <select name="cPath" onchange="this.form.submit();"><option value="0" selected="selected">Top</option><option value="1">Hardware</option><option value="17">&nbsp;&nbsp;&nbsp;CDROM Drives</option><option value="4">&nbsp;&nbsp;&nbsp;Graphics Cards</option><option value="8">&nbsp;&nbsp;&nbsp;Keyboards</option><option value="16">&nbsp;&nbsp;&nbsp;Memory</option><option value="9">&nbsp;&nbsp;&nbsp;Mice</option><option value="6">&nbsp;&nbsp;&nbsp;Monitors</option><option value="5">&nbsp;&nbsp;&nbsp;Printers</option><option value="7">&nbsp;&nbsp;&nbsp;Speakers</option><option value="2">Software</option><option value="19">&nbsp;&nbsp;&nbsp;Action</option><option value="18">&nbsp;&nbsp;&nbsp;Simulation</option><option value="20">&nbsp;&nbsp;&nbsp;Strategy</option><option value="3">DVD Movies</option><option value="10">&nbsp;&nbsp;&nbsp;Action</option><option value="13">&nbsp;&nbsp;&nbsp;Cartoons</option><option value="12">&nbsp;&nbsp;&nbsp;Comedy</option><option value="15">&nbsp;&nbsp;&nbsp;Drama</option><option value="11">&nbsp;&nbsp;&nbsp;Science Fiction</option><option value="14">&nbsp;&nbsp;&nbsp;Thriller</option><option value="21">Gadgets</option></select><input type="hidden" name="osCAdminID" value="i3qmbf2bulfaigi6pvm3i2urp1" /></form>                </td>
                    </tr>
                </table></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Categories / Products</td>
                        <td class="dataTableHeadingContent" align="center">Status</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://shadowfax/oscommerce2/admin/categories.php?cPath=1&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1'">
                        <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/categories.php?cPath=1&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;<strong>Hardware</strong></td>
                        <td class="dataTableContent" align="center">&nbsp;</td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=2&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1'">
                        <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/categories.php?cPath=2&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;<strong>Software</strong></td>
                        <td class="dataTableContent" align="center">&nbsp;</td>
                        <td class="dataTableContent" align="right"><a href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=2&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=3&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1'">
                        <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/categories.php?cPath=3&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;<strong>DVD Movies</strong></td>
                        <td class="dataTableContent" align="center">&nbsp;</td>
                        <td class="dataTableContent" align="right"><a href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=3&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=21&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1'">
                        <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/categories.php?cPath=21&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icons/folder.gif" border="0" alt="Folder" title="Folder" /></a>&nbsp;<strong>Gadgets</strong></td>
                        <td class="dataTableContent" align="center">&nbsp;</td>
                        <td class="dataTableContent" align="right"><a href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=21&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="3"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText">Categories:&nbsp;4<br />Products:&nbsp;0</td>
                                <td align="right" class="smallText"><span class="tdbLink"><a id="tdb1" href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&action=new_category&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">New Category</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&action=new_product&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">New Product</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>&nbsp;</td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Hardware</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb3" href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=1&action=edit_category&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Edit</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=1&action=delete_category&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Delete</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb5" href="http://shadowfax/oscommerce2/admin/categories.php?cPath=&cID=1&action=move_category&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Move</a></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-arrow-4"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: 12/27/2014</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br /><img src="resources/images/category_hardware.gif" border="0" alt="Hardware" title="Hardware" width="57" height="40" /><br />category_hardware.gif</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Subcategories: 8<br />Products: 6</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
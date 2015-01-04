<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Administrators</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="2">
                <tr class="messageStackError">
                    <td class="messageStackError"><img src="resources/admin/images/icons/error.gif" border="0" alt="Error" title="Error" />&nbsp;<strong>Additional Protection With htaccess/htpasswd</strong><p>This osCommerce Online Merchant Administration Tool installation is not additionally secured through htaccess/htpasswd means.</p><p>Enabling the htaccess/htpasswd security layer will automatically store administrator username and passwords in a htpasswd file when updating administrator password records.</p><p><strong>Please note</strong>, if this additional security layer is enabled and you can no longer access the Administration Tool, please make the following changes and consult your hosting provider to enable htaccess/htpasswd protection:</p><p><u><strong>1. Edit this file:</strong></u><br /><br />/opt/local/apache2/htdocs/oscommerce2/admin/.htaccess</p><p>Remove the following lines if they exist:</p><p><i>##### OSCOMMERCE ADMIN PROTECTION - BEGIN #####<br />AuthType Basic<br />AuthName "osCommerce Online Merchant Administration Tool"<br />AuthUserFile /opt/local/apache2/htdocs/oscommerce2/admin/.htpasswd_oscommerce<br />Require valid-user<br />##### OSCOMMERCE ADMIN PROTECTION - END #####</i></p><p><u><strong>2. Delete this file:</strong></u><br /><br />/opt/local/apache2/htdocs/oscommerce2/admin/.htpasswd_oscommerce</p></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Administrators</td>
                        <td class="dataTableHeadingContent" align="center">Secured by htpasswd</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/administrators.php?aID=2&action=edit'">
                        <td class="dataTableContent">admin</td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icon_status_red.gif" border="0" alt="Not Secured" title="Not Secured" width="10" height="10" /></td>
                        <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                    </tr>
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/administrators.php?aID=1'">
                        <td class="dataTableContent">tw</td>
                        <td class="dataTableContent" align="center"><img src="resources/admin/images/icon_status_red.gif" border="0" alt="Not Secured" title="Not Secured" width="10" height="10" /></td>
                        <td class="dataTableContent" align="right"><a href="http://localhost/oscommerce2/admin/administrators.php?aID=1"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="smallText" colspan="3" align="right"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/administrators.php?action=new">Insert</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>admin</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/administrators.php?aID=2&action=edit">Edit</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/administrators.php?aID=2&action=delete">Delete</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
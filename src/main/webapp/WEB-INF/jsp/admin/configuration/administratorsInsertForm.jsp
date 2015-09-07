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
    <!--
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="2">
                <tr class="messageStackError">
                    <td class="messageStackError"><img src="resources/admin/images/icons/error.gif" border="0" alt="Error" title="Error" />&nbsp;<strong>Additional Protection With htaccess/htpasswd</strong><p>This osCommerce Online Merchant Administration Tool installation is not additionally secured through htaccess/htpasswd means.</p><p>Enabling the htaccess/htpasswd security layer will automatically store administrator username and passwords in a htpasswd file when updating administrator password records.</p><p><strong>Please note</strong>, if this additional security layer is enabled and you can no longer access the Administration Tool, please make the following changes and consult your hosting provider to enable htaccess/htpasswd protection:</p><p><u><strong>1. Edit this file:</strong></u><br /><br />/opt/local/apache2/htdocs/oscommerce2/admin/.htaccess</p><p>Remove the following lines if they exist:</p><p><i>##### OSCOMMERCE ADMIN PROTECTION - BEGIN #####<br />AuthType Basic<br />AuthName "osCommerce Online Merchant Administration Tool"<br />AuthUserFile /opt/local/apache2/htdocs/oscommerce2/admin/.htpasswd_oscommerce<br />Require valid-user<br />##### OSCOMMERCE ADMIN PROTECTION - END #####</i></p><p><u><strong>2. Delete this file:</strong></u><br /><br />/opt/local/apache2/htdocs/oscommerce2/admin/.htpasswd_oscommerce</p></td>
                </tr>
            </table>
        </td>
    </tr>
    -->
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Administrators</td>
                        <td class="dataTableHeadingContent" align="center">Secured by htpasswd</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <c:forEach var="administrator" items="${administrators}">
                        <c:if test="${administrator.id == thisAdministrator.id}">
                            <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/administrators/${administrator.id}"/>'">
                                <td class="dataTableContent">${administrator.userName}</td>
                                <td class="dataTableContent" align="center"><img src="resources/admin/images/icon_status_red.gif" border="0" alt="Not Secured" title="Not Secured" width="10" height="10" /></td>
                                <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                            </tr>
                        </c:if>
                        <c:if test="${administrator.id != thisAdministrator.id}">
                            <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/administrators/${administrator.id}"/>'">
                                <td class="dataTableContent">${administrator.userName}</td>
                                <td class="dataTableContent" align="center"><img src="resources/admin/images/icon_status_red.gif" border="0" alt="Not Secured" title="Not Secured" width="10" height="10" /></td>
                                <td class="dataTableContent" align="right"><a href="<c:url value="/admin/administrators/${administrator.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr>
                        <td class="smallText" colspan="3" align="right"><span class="tdbLink"><a id="tdb1" href="<c:url value="/admin/administrators/insert"/>">Insert</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-plus"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>New Administrator</strong></td>
                        </tr>
                    </table>
                    <form:form commandName="thisAdministrator" method="post" autocomplete="off">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td class="infoBoxContent">Please enter the new administrator with its related data</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Username:<br /><form:input path="userName" maxlength="40"/><form:errors path="userName" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />New Password:<br /><form:password path="userPassword" maxlength="40"/><form:errors path="userPassword" /></td>
                        </tr>
                        <tr>
                            <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb2" type="submit">Save</button></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-disk"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb3" href="<c:url value="/admin/administrators"/>">Cancel</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                    </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>
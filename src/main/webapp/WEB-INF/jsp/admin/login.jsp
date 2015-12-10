<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="2" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0" height="40">
            <tr>
                <td class="pageHeading">Administrator Login</td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="2">
                <tr class="infoBoxHeading">
                    <td class="infoBoxHeading"><strong>Administrator Login</strong></td>
                </tr>
            </table>
            <c:url var="loginUrl" value="/admin/j_spring_security_check" />
            <form action="${loginUrl}" method="post">
                <table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr>
                        <td class="infoBoxContent">Username:<br /><input type="text" name="j_username" /></td>
                    </tr>
                    <tr>
                        <td class="infoBoxContent"><br />Password:<br /><input type="password" name="j_password" maxlength="40" /></td>
                    </tr>
                    <tr>
                        <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Login</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-key"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>


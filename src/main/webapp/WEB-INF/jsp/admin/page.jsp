<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="robots" content="noindex,nofollow">
    <title>Greenshop Online Merchant Administration Tool</title>
    <base href="<c:url value="/"/>" />
    <!--[if IE]><script type="text/javascript" src="<c:url value="/resources/ext/flot/excanvas.min.js"/>"></script><![endif]-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/ext/jquery/ui/redmond/jquery-ui-1.8.22.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/ext/jquery/jquery-1.8.0.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/ext/jquery/ui/jquery-ui-1.8.22.min.js"/>"></script>

    <script type="text/javascript">
        // fix jQuery 1.8.0 and jQuery UI 1.8.22 bug with dialog buttons; http://bugs.jqueryui.com/ticket/8484
        if ( $.attrFn ) { $.attrFn.text = true; }
    </script>

    <script type="text/javascript" src="<c:url value="/resources/ext/flot/jquery.flot.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/stylesheet.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/admin/general.js"/>"></script>
</head>
<body>

<c:if test="${not empty param.login_error}">
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr class="messageStackError">
        <td class="messageStackError"><img src="resources/images/icons/error.gif" border="0" alt="Error" title="Error" />&nbsp;Error: Invalid administrator login attempt.</td>
    </tr>
</table>
</c:if>

<table border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr>
        <td colspan="2">
            <a href="<c:url value="/admin/"/>"><img src="resources/images/oscommerce.png" border="0" alt="Greenshop" title="Greenshop" /></a>
        </td>
    </tr>
    <tr class="headerBar">
        <td class="headerBarContent">&nbsp;&nbsp;<a href="<c:url value="/admin/"/>" class="headerLink">Administration</a> &nbsp;|&nbsp; <a href="<c:url value="/"/>" class="headerLink">Online Catalog</a> &nbsp;|&nbsp; <a href="https://github.com/phasenraum2010/greenshop" class="headerLink">Support Site</a></td>
        <sec:authorize access="isAnonymous()">
        <td class="headerBarContent" align="right">&nbsp;&nbsp;</td>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td class="headerBarContent" align="right">Logged in as: admin (<a href='<c:url value="/admin/j_spring_security_logout"/>' class="headerLink">Logoff</a>)&nbsp;&nbsp;</td>
        </sec:authorize>
    </tr>
</table>

<style>
    #contentText {
        margin-left: 0;
    }
</style>

<div>
<tiles:insertAttribute name="adminAppMenu" />
</div>

<div id="contentText">
<tiles:insertAttribute name="bodyContent" />
</div>

<br />
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td align="center" class="smallText">
            osCommerce Online Merchant Copyright &copy; 2010 <a href="http://www.oscommerce.com" target="_blank">osCommerce</a><br />
            osCommerce provides no warranty and is redistributable under the <a href="http://www.fsf.org/licenses/gpl.txt" target="_blank">GNU General Public License</a>
        </td>
    </tr>
    <tr>
        <td><img src="resources/images/pixel_trans.gif" border="0" alt="" width="1" height="5" /></td>
    </tr>
    <tr>
        <td align="center" class="smallText">Powered by <a href="http://www.oscommerce.com" target="_blank">osCommerce</a></td>
    </tr>
</table>

<br />

</body>
</html>
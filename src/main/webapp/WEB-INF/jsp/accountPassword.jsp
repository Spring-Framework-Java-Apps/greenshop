<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>My Password</h1>

<form:form commandName="changePasswordBean" method="post">
<!--  
<form name="account_password" action="http://localhost/oscommerce2/account_password.php" method="post" onsubmit="return check_form(account_password);"><input type="hidden" name="formid" value="0923a4ea590b42438f4ff4a9af74d302" /><input type="hidden" name="action" value="process" />
-->
<div class="contentContainer">
  <div>
    <span class="inputRequirement" style="float: right;">* Required information</span>
    <h2>My Password</h2>
  </div>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="2" cellpadding="2">
      <tr>
        <td class="fieldKey">Current Password:</td>
        <td class="fieldValue"><form:password path="passwordCurrent" maxlength="40" />&nbsp;<span class="inputRequirement">*</span><form:errors path="passwordCurrent"/></td>
      </tr>
      <tr> 
        <td class="fieldKey">New Password:</td>
        <td class="fieldValue"><form:password path="passwordNew" maxlength="40" />&nbsp;<span class="inputRequirement">*</span><form:errors path="passwordNew"/></td>
      </tr>
      <tr> 
        <td class="fieldKey">Password Confirmation:</td>
        <td class="fieldValue"><form:password path="passwordConfirmation" maxlength="40" />&nbsp;<span class="inputRequirement">*</span><form:errors path="passwordConfirmation"/></td>
      </tr>
    </table>
  </div>

  <div class="buttonSet">
    <span class="buttonAction"><span class="tdbLink"><button id="tdb5" type="submit">Continue</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>

    <span class="tdbLink"><a id="tdb6" href='<c:url value="/account" />'>Back</a></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>
</div>

</form:form>